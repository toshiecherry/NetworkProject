package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import client.CardString;

@SuppressWarnings("serial")
public class CardGrid extends JPanel {

	public CardGrid(int rows, int columns, CardString[][] field) {
		super(new GridLayout(rows, columns));
		for (int i = 0; i < columns; i++) {
			field[0][i] = new CardString(i);
			add(field[0][i]);
		}

	}

}
