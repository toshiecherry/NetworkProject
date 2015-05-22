package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import client.CardHand;
import client.ClientSender;

@SuppressWarnings("serial")
public class CardGrid extends JPanel {

	public CardGrid(ImageLabel[][] field, CardHand cardHand, ClientSender sender) {
		setLayout(new GridLayout(1, 5));
		for (int i = 0; i < 5; i++) {
			field[0][i] = new ImageLabel(i, cardHand, sender);
			add(field[0][i]);
		}

	}

}
