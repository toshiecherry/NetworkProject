package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CardString extends JTextField implements ActionListener {
	private int cardIndex;

	public CardString(int cardIndex) {
		this.cardIndex = cardIndex;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Kort nummer " + cardIndex);

	}

}
