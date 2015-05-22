package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import se.lth.cs.ptdc.cardGames.Card;
import cards.CardPile;
import cards.CardPiles;

public class PlayerThread implements Runnable {
	private Socket connection;
	private boolean connectedToGame;
	private CardPiles piles;
	private CardPile takePile;
	private CardPile throwPile;
	private GameParticipants players;
	private String playerName;
	private boolean gameStarted;
	private boolean completeHand;
	private int playerIndex;
	private int amountOfCards;

	public PlayerThread(Socket connection, CardPiles piles, GameParticipants players) {
		this.connection = connection;
		this.piles = piles;
		this.players = players;
		amountOfCards = 0;
	}

	@Override
	public void run() {
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			System.out.println("in");
			playerName = in.readLine();
			connectedToGame = players.add(playerName);
			System.out.println(playerName);
			System.out.println(players.getIndex(playerName));
			while (connectedToGame) {
				System.out.println("Connected");
				playerIndex = players.getIndex(playerName);
				takePile = piles.getPile(playerIndex);
				if (piles.length() < playerIndex) {
					throwPile = piles.getPile(playerIndex + 1);
				} else {
					throwPile = piles.getPile(0);
				}
				String inputStart = in.readLine();
				System.out.println(inputStart);
				Card card = null;
				gameStarted = true;
				for (int i = 0; i < 4; i++) {
					card = piles.getStartCards();
					String outString = (card.getSuit() + " " + card.getRank() + "\n");
					System.out.println(outString);
					out.write(outString);
					out.flush();
					amountOfCards++;
				}
				System.out.println("Går in i spelet");
				while (gameStarted) {
					String input = in.readLine();
					System.out.println("Input är " + input);
					if (input.charAt(0) == 'D') {
						if (amountOfCards < 5) {
							System.out.println("Drar kort");
							if (takePile.size() > 0) {
								Card newCard = takePile.drawCard();
								String outString = (newCard.getSuit() + " " + newCard.getRank() + "\n");
								System.out.println("Nya kortet är: " + outString);
								out.write(outString);
								out.flush();
								amountOfCards++;
							} else {
								out.write("EmptyPileError \n");
								out.flush();
							}
						} else {
							System.out.println("FEL");
							out.write("TooManyCardsError \n");
							System.out.println("FEL2");
							out.flush();
						}

					} else if (input.charAt(0) == 'T') {
						// throwPile.addCard();
						amountOfCards--;

					} else if (input.charAt(0) == 'L') {
						gameStarted = false;
						connectedToGame = false;
						players.removePlayer(playerName);

					} else if (input.charAt(0) == 'G') {
						
						
						// L�gg till en ruta med en counter
						// ++ p� sagda counter

					} else {
						return;
					}

				}

			}
			connection.close();

		} catch (IOException e) {

		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
