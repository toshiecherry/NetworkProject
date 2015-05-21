package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

}
