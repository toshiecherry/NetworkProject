package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

import se.lth.cs.ptdc.cardGames.Card;

public class ClientSender {
	private Socket connection;
	private OutputStreamWriter out;
	private ObjectInputStream in;

	public ClientSender(Socket socket, ClientHandler handler) {
		connection = socket;
		try {
			out = new OutputStreamWriter(connection.getOutputStream());
			in = new ObjectInputStream(connection.getInputStream());
			out.write(handler.getPlayerName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public Card sendCommand(String command) {
		try {
			
			out.write(command);
			out.flush();
			try {
				Card read = (Card) in.readObject();
				return read;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Card[] startGame() {
		try {
			System.out.println("hej");
			out.write("StartGame");
			System.out.println("yes");
			out.flush();
			Card[] read = (Card[]) in.readObject();
			return read;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

}
