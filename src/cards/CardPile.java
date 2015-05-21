package cards;

import java.util.ArrayList;

import se.lth.cs.ptdc.cardGames.Card;

public class CardPile {
	private ArrayList<Card> pile;

	public CardPile() {
		pile = new ArrayList<Card>();
	}

	public CardPile(boolean player1) {
		pile = new ArrayList<Card>();
		createNewDeck();
	}

	/*
	 * Lägger till kortet i slutet av högen
	 * 
	 * @param Card card
	 */
	public void addCard(Card card) {
		pile.add(card);
	}

	/*
	 * Tar kortet i början av högen
	 * 
	 * @return Card retunerar det kort man dragit
	 */
	public synchronized Card drawCard() {
		return pile.remove(0);
	}

	public synchronized int size() {
		return pile.size();
	}

	private void createNewDeck() {
		CardDeck deck = new CardDeck();
		deck.shuffle();
		for (int i = 0; i < 52; i++) {
			pile.add(deck.getCard());
		}

	}
}
