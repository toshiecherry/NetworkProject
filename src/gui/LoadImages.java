package gui;

import java.awt.Image;
import java.awt.Toolkit;

public class LoadImages {
	Image[] cards = new Image[53];

	public LoadImages() {

	}

	private void loadCards() {
		System.out.println("Loading cards");

		String pre = "";
		for (int j = 1; j < 5; j++) {
			if (j == 1)
				pre = "s";
			else if (j == 2)
				pre = "h";
			else if (j == 3)
				pre = "c";
			else if (j == 4)
				pre = "d";

			for (int i = 1; i < 14; i++) {
				String card = "pictures/" + pre + i + ".png";
				cards[i + (j - 1) * 13] = Toolkit.getDefaultToolkit().getImage(
						card);
			}
		}
	}
}
