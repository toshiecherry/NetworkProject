package cards;

import se.lth.cs.ptdc.cardGames.Card;

public class CardPiles {
	private CardPile[] thePiles;

	public CardPiles() {
		thePiles = new CardPile[5];
		thePiles[0] = new CardPile(true);
		for (int i = 1; i < 5; i++) {
			thePiles[i] = new CardPile(); 
		}
	}
	
	public CardPile getPile(int i){
		return thePiles[i];
	}

	public int length(){
		return thePiles.length;
	}
	
	public synchronized Card getStartCards(){
		return thePiles[0].drawCard();
	}
	
}
