package cards;

public class CardPiles {
	private CardPile[] thePiles;

	public CardPiles() {
		thePiles = new CardPile[5];
		thePiles[0] = new CardPile(true);
		for (int i = 1; i < 5; i++) {
			thePiles[i] = new CardPile(); 
		}
	}

	
}
