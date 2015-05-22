package gui;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import client.CardHand;
import client.ClientHandler;
import client.ClientSender;

public class GameMonitor {
	private static ButtonAndMessagePanel bottomPanel;

	public GameMonitor(ClientHandler handler, Socket socket) {
		JFrame frame = new JFrame("Bubblan The Game");
		frame.setName("Bubblan The Game");
		frame.setBounds(500, 100, 450, 300);
		String name = JOptionPane.showInputDialog("Select username");
		if (name != null) {
			ClientSender sender = new ClientSender(socket, name);
			ImageLabel[][] field = new ImageLabel[1][5];
			CardHand cardHand = new CardHand(field);
			bottomPanel = new ButtonAndMessagePanel(this, sender, cardHand);
			UpperPanel upperPanel = new UpperPanel(this, sender, cardHand);
			CardGrid middlePanel = new CardGrid(field, cardHand, sender);
			frame.setLayout(new BorderLayout());
			frame.add(upperPanel, BorderLayout.NORTH);
			frame.add(bottomPanel, BorderLayout.SOUTH);
			frame.add(middlePanel, BorderLayout.CENTER);

			frame.pack();
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.setResizable(false);
			frame.setVisible(true);
		}
	}

	public void errorMessage(String error) {
		bottomPanel.setText(error);
	}

}
