package cards;
import java.util.Random;
import se.lth.cs.ptdc.cardGames.Card;

public class CardDeck {
	private Card[] cards;
	private int current;
	private static Random rand = new Random();

	public CardDeck() {
		cards = new Card[52];
		current = 0;
		int n = 0;
		for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[n] = new Card(suit, rank);
				n++;
			}
		}
	}

	public void shuffle() {
		for (int i = cards.length - 1; i >= 0; i--) {
			int nbr = rand.nextInt(i + 1);
			Card temp = cards[i];
			cards[i] = cards[nbr];
			cards[nbr] = temp;
		}
		current = 0;
	}

	public boolean moreCards() {
		boolean moreCards = true;
		if (current >= cards.length) {
			moreCards = false;
		}
		return moreCards;
	}

	public Card getCard() {
		if (moreCards() == true) {
			Card card = cards[current];
			current++;
			return card;
		}
		return null;
	}
}
