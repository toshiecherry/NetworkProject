package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadImages {
	private Image[] cards;

	public LoadImages() {
		// cards = loadCards();
	}

	public void setImage(String card) {
		JFrame frame = new JFrame();
		JPanel p = new JPanel();
		BufferedImage myPicture = null;
		int rank = Integer.parseInt(card.substring(2));
		int suit = card.charAt(0);
		String picture = "pictures/" + suit + rank + ".png";
		try {
			myPicture = ImageIO.read(new File(picture));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		p.add(picLabel);
		frame.add(p);
		frame.pack();
		frame.setVisible(true);

		picLabel.setIcon(new ImageIcon(picture));
	}

	// private Image[] loadCards() {
	// System.out.println("Loading cards");
	//
	// String pre = "";
	// for (int j = 1; j < 5; j++) {
	// if (j == 1)
	// pre = "s";
	// else if (j == 2)
	// pre = "h";
	// else if (j == 3)
	// pre = "c";
	// else if (j == 4)
	// pre = "d";
	//
	// for (int i = 1; i < 14; i++) {
	// String card = "pictures/" + pre + i + ".png";
	// cards[i + (j - 1) * 13] = Toolkit.getDefaultToolkit().getImage(
	// card);
	// }
	// }
	// return cards;
	// }

	// public Image connectCardImage(String card) {
	// int rank = Integer.parseInt(card.substring(2));
	// int suit = card.charAt(0);
	// return cards[rank + (suit - 1) * 13];
	// }
}
