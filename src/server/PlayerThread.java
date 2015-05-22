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
	private GameMailbox box;

	public PlayerThread(Socket connection, CardPiles piles, GameParticipants players, GameMailbox box) {
		this.connection = connection;
		this.piles = piles;
		this.players = players;
		this.box = box;
		amountOfCards = 0;
	}

	@Override
	public void run() {
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			System.out.println("in");
			playerName = in.readLine();
			Player player = new Player(playerName, connection);
			connectedToGame = players.add(player);
			System.out.println(playerName);
			System.out.println(players.getIndex(player));
			while (connectedToGame) {
				System.out.println("Connected");
				playerIndex = players.getIndex(player);
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
				while (gameStarted) {
					String input = in.readLine();
					System.out.println("Input är " + input);
					if (input != null) {
						if (input.charAt(0) == 'D') {
							if (amountOfCards < 5) {
								if (takePile.size() > 0) {
									Card newCard = takePile.drawCard();
									String outString = (newCard.getSuit() + " " + newCard.getRank() + "\n");
									out.write(outString);
									out.flush();
									amountOfCards++;
								} else {
									out.write("EmptyPileError \n");
									out.flush();
								}
							} else {
								out.write("TooManyCardsError \n");
								out.flush();
							}

						} else if (input.charAt(0) == 'T') {
							if (amountOfCards > 4) {
								String c = in.readLine();
								int suit = Integer.parseInt(c.charAt(0) + "");
								int rank = Integer.parseInt(c.substring(2));
								Card newCard = new Card(suit, rank);
								throwPile.addCard(newCard);
								amountOfCards--;
							}

						} else if (input.charAt(0) == 'L') {
							gameStarted = false;
							connectedToGame = false;
							players.removePlayer(player);
							System.out.println("Shuts Down");

						} else if (input.charAt(0) == 'G') {

							box.setMessage("Player: " + playerName + "got Bubblan");

						} else {
							return;
						}

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
