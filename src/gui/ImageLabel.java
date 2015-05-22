package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JLabel;

import client.CardHand;
import client.ClientSender;

@SuppressWarnings("serial")
public class ImageLabel extends JLabel {
	private int labelIndex;
	private CardHand hand;
	private ClientSender sender;
	private int suitNumber;

	public ImageLabel(int i, CardHand cardHand, ClientSender sender) {
		this.sender = sender;
		hand = cardHand;
		labelIndex = i;
		try {
			BufferedImage myPicture = ImageIO.read(new File("pictures/b1.png"));
			setIcon(new ImageIcon(myPicture));
			addMouseListener(new ClickListener(this));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setImage(String card) {
		BufferedImage picture = null;
		StringBuilder sb = new StringBuilder();
		sb.append("pictures/");
		int suitNumber = Integer.parseInt(card.charAt(0) + "");
		String s = getSuit(suitNumber);
		sb.append(s);
		sb.append(Integer.parseInt(card.substring(2)));
		sb.append(".png");
		try {
			picture = ImageIO.read(new File(sb.toString()));
			setIcon(new ImageIcon(picture));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String getSuit(int suitNumb) {
		System.out.println("SuitNumber är " + suitNumb);
		if (suitNumb == 1) {
			return "s";
		} else if (suitNumb == 2) {
			return "h";
		} else if (suitNumb == 3) {
			return "d";
		} else if (suitNumb == 4) {
			return "c";
		} else {
			return "b";
		}

	}

	private class ClickListener extends MouseAdapter {
		ImageLabel imageLabel;

		public ClickListener(ImageLabel imageLabel) {
			this.imageLabel = imageLabel;
		}

		public void mouseClicked(MouseEvent event) {
			if (suitNumber < 5) {
				String throwCard = hand.removeCard(labelIndex);
				sender.throwCard(throwCard);
			}

		}
	}
}
