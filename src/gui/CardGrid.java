package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CardGrid extends JPanel {

	public CardGrid() {
		setLayout(new GridLayout(1, 5));
		ImageLabel[][] field = new ImageLabel[1][5];
		for (int i = 0; i < 5; i++) {
			field[0][i] = new ImageLabel(i);
			add(field[0][i]);
		}

	}

}
