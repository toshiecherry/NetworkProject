package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

import se.lth.cs.ptdc.cardGames.Card;

public class ClientSender {
	private Socket connection;

	public ClientSender(Socket socket) {
		connection = socket;

	}

	public Card sendCommand(String command) {
		try {
			Writer out = new OutputStreamWriter(connection.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
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
			Writer out = new OutputStreamWriter(connection.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
			out.write("StartGame");
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
