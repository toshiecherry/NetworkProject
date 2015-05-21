package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

import cards.CardPile;
import cards.CardPiles;
import client.CardHand;
import gui.GameMonitor;
import se.lth.cs.ptdc.cardGames.Card;

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

	public PlayerThread(Socket connection, CardPiles piles, GameParticipants players) {
		this.connection = connection;
		this.piles = piles;
		this.players = players;
	}

	@Override
	public void run() {

		try {
			Writer out = new OutputStreamWriter(connection.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			connectedToGame = true;

			while (connectedToGame) {
				if (players.add(playerName) == true) {
					int playerIndex = players.getIndex(playerName);
					takePile = piles.getPile(playerIndex);
					if (piles.length() < playerIndex) {
						throwPile = piles.getPile(playerIndex + 1);
					} else {
						throwPile = piles.getPile(0);
					}

					gameStarted = true;
					for (int i = 0; i < 4; i++) {
						hand.addCard(piles.getStartCards()); // delar ut fyra
																// kort till
																// tråden.
																// Metoden är
																// synchronized.
					}

					while (gameStarted) {
						int command = 0;
						int index = 0; // Vilket kort man ska ta bort
						String input = in.readLine();
						if (input.equals("cardDrawn")) { // När man tar upp kort
							if (takePile.size() > 0) {
								hand.addCard(takePile.drawCard());
							}
						} else if (input.equals("throwCard")) {

						} else if (input.equals("leaveGame")) {

						} else if (input.equals("gotBubblan")) {

						}

						switch (command) { // Göra om detta med actionListener
						// case 0:
						// if (takePile.size() > 0) {
						// hand.addCard(takePile.drawCard());
						// }
						// break;
						case 1: // När man slänger kort
							Card trashCard = hand.removeCard(index);
							if (trashCard != null) {
								throwPile.addCard(trashCard);
							}
							break;
						case 2: // Alltså när man får bubblan. Hur kollar man
								// att alla tryckt bubblan?
							completeHand = true;
							break;
						case 3: // Vid leave game
							players.removePlayer(playerName); // hitta namnet
																// hur?
							for (int i = 0; i < throwPile.size(); i++) {
								takePile.addCard(throwPile.drawCard());
							}
							// throwPile.delete();
							// typ?
						}

						// Kan k�ra syso hand tills vi har gui?
						// actionlistener?

					}
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

	public void setPlayerName(String name) {
		playerName = name;
	}

}
