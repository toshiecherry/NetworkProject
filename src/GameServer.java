import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cards.CardPiles;

public class GameServer {
	public final static int THREAD_COUNT = 4;
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
		ServerSocket server;
		try {
			server = new ServerSocket(3000);
			while (true) {
				Socket connection = null;
				CardPiles piles = new CardPiles();
				try {
					connection = server.accept();
					Runnable task = new PlayerThread(connection, piles);
					pool.submit(task);

				} catch (IOException ex) {

				}
			}
			
		} catch (IOException ex) {
			System.err.println(ex);
		}
		pool.shutdown();
	}
	
}
