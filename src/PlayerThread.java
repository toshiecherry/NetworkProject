import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

import cards.CardPile;
import cards.CardPiles;

public class PlayerThread extends Thread {
	private Socket connection;
	private boolean moreRequests;
	private CardPiles piles;
	private CardPile takePile;
	private CardPile throwPile;
	private GameParticipants player;
	private boolean gameStarted;

	public PlayerThread(Socket connection, CardPiles piles) {
		this.connection = connection;
		this.piles = piles;
	}

	@Override
	public void run() {
		try {
			// System.out.println(connection.getInetAddress());
			Writer out = new OutputStreamWriter(connection.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			moreRequests = true;
			while (moreRequests) {
				String input = in.readLine();
				// Eller hur man nu kan läsa av namnet på spelaren på ett snyggt
				// sätt
				int i = player.getIndex(input);
				takePile = piles.getPile(i);
				if (piles.length() < i) {
					throwPile = piles.getPile(i + 1);
				} else {
					throwPile = piles.getPile(0);
				}
				
				gameStarted = true;
				while (gameStarted){
					//Dra kort
					//Kolla hur många kort som finns på handen
					//If(takepile != empty)
					//takePile.drawCard()
					//hand.add(card)
					
					//Släng kort 
					//Kolla hur många kort som finns på handen 
					//throwPile.add(card) 
					//Hand.remove(card)
					
					//Kan köra syso hand tills vi har gui? 
					//actionlistener? 
					
					
				}
				
				

			}
			connection.close();

		} catch (IOException e) {

		} finally {
			try {
				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
