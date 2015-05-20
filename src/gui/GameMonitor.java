package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.ClientHandler;
import client.GameClient;

public class GameMonitor {

	public GameMonitor(ClientHandler handler) {
		JFrame frame = new JFrame("Bubblan");
		frame.setName("Bubblan");
		frame.setBounds(500, 100, 450, 300);
		String name = JOptionPane.showInputDialog("Ange användarnamn");
		handler.setPlayerName(name);
		ButtonAndMessagePanel bottomPanel = new ButtonAndMessagePanel(this);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

	}

	// public static void errorMessage(String error) {
	// statusLabel.setText(error);
	// }

}
