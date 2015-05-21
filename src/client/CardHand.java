package client;

import se.lth.cs.ptdc.cardGames.Card;

/*
 * Kort på handen.
 */
public class CardHand {
	private Card[] cards;
	private int amountOfCards;

	/*
	 * Skapar en hand med 0 antal kort.
	 */
	public CardHand() {
		cards = new Card[5];
		amountOfCards = 0;
	}

	/*
	 * Lägger till kort till handen. Undersöker hur många kort man har på
	 * handen, om det är 5 st lägger man ej till ett kort.
	 * 
	 * @param Card newCard
	 * 
	 * @return boolean
	 */
	public boolean addCard(Card newCard) {
		if (amountOfCards < 5) {
			cards[amountOfCards] = newCard;
			amountOfCards++;
			return true;
		}
		return false;

	}

	/*
	 * Tar bort kort från handen. Tar ej bort ett kort ifall det endast finns 4
	 * kort på handen, retunerar då null.
	 * 
	 * @param int cardIndex
	 * 
	 * @return Card kortet som man tagit bort ur handen
	 */
	public Card removeCard(int cardIndex) {
		if (amountOfCards > 4) {
			Card drawn = cards[cardIndex];
			cards[cardIndex] = null;
			return drawn;
		}
		return null;
	}

	public void newGameHand() {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = null;
		}
		amountOfCards = 0;
	}

	/*
	 * To check if a player has bubblan
	 */
	public boolean bubblanHand() {
		if (amountOfCards == 4) {
			boolean card01 = false;
			boolean card12 = false;
			boolean card23 = false;

			if (cards[0].getRank() == cards[1].getRank()) {
				card01 = true;
			}
			if (cards[1].getRank() == cards[2].getRank()) {
				card12 = true;
			}
			if (cards[2].getRank() == cards[3].getRank()) {
				card23 = true;
			}

			if (card01 == true && card12 == true && card23 == true) {
				return true;
			}

		}
		return false;
	}

}
