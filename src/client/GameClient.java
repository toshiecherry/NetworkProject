package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import cards.CardHand;
import gui.GameMonitor;

public class GameClient {
	private static final String HOST_NAME = "localhost";
	private String playerName;

	public static void main(String[] args) {
		ClientHandler handler = new ClientHandler();
		GameMonitor gameMonitor = new GameMonitor(handler);
		
		try {
			Socket socket = new Socket(HOST_NAME, 3000);
			CardHand hand = new CardHand();
			
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
