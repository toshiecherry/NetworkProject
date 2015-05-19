package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameMonitor {
	private static final long serialVersionUID = 1L;

	public GameMonitor() {
		JFrame frame = new JFrame("Bubblan");
		frame.setName("Bubblan");
		frame.setBounds(500, 100, 450, 300);
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

	public static void main(String[] args) {
		GameMonitor monitor = new GameMonitor();
	}
}
