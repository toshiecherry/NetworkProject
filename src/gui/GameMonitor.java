package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import client.ClientHandler;

public class GameMonitor {
	protected JLabel message;

	public GameMonitor(ClientHandler handler) {
		JFrame frame = new JFrame("Bubblan");
		frame.setName("Bubblan");
		frame.setBounds(500, 100, 450, 300);
		String name = JOptionPane.showInputDialog("Select username");
		if (name != null) {
			handler.setPlayerName(name);
			message = new JLabel("yes");
			ButtonAndMessagePanel bottomPanel = new ButtonAndMessagePanel(this);
			ButtonAndMessagePanel upperPanel = new ButtonAndMessagePanel(this, "Hej");
			frame.add(upperPanel, BorderLayout.NORTH);
			frame.add(bottomPanel, BorderLayout.SOUTH);

			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			frame.setVisible(true);
		}
	}

}
