package gui;

import java.awt.BorderLayout;
import java.net.Socket;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.CardHand;
import client.ClientSender;

public class GameMonitor {
	private static ButtonAndMessagePanel bottomPanel;
	private static UpperPanel upperPanel;

	public GameMonitor(Socket socket) {
		JFrame frame = new JFrame("Bubblan The Game");
		frame.setName("Bubblan The Game");
		frame.setBounds(500, 100, 450, 300);
		frame.setLocale(Locale.ENGLISH);
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
	
//	public void errorMessageServer(String error){
//		upperPanel.setText(error);
//	}

}
