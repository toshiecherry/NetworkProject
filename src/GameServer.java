import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import cards.CardPiles;

public class GameServer {
	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(3000);
			while (true) {
				Socket connection = null;
				CardPiles piles = new CardPiles();
				try {
					connection = server.accept();
					Thread task = new PlayerThread(connection, piles);
					task.start();

				} catch (IOException ex) {

				}
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

}
