package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.GameClient;
import server.PlayerThread;

public class GameMonitor {

	public GameMonitor(GameClient client) {
		JFrame frame = new JFrame("Bubblan");
		frame.setName("Bubblan");
		frame.setBounds(500, 100, 450, 300);
		String name = JOptionPane.showInputDialog("Ange användarnamn");
		
//		thread.setPlayerName(name);
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
