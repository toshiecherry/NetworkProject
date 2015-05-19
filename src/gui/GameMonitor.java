package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameMonitor extends JFrame {
	private static final long serialVersionUID = 1L;

	public GameMonitor() {
		setName("Bubblan");
		setBounds(500, 100, 450, 300);
		JButton[] buttons = new JButton[3];
		buttons[0] = new JButton("Starta spelomgång");
		buttons[1] = new JButton("Dra kort");
		buttons[2] = new JButton("Avsluta spelomgång");
		// ButtonAndMessagePanel panel = new ButtonAndMessagePanel(JButton,
		// messageLabel, actionhandler);
		JPanel bottomPanel = new JPanel();
		// bottomPanel.add(panel, BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	// public static void errorMessage(String error) {
	// statusLabel.setText(error);
	// }

	public static void main(String[] args) {
		GameMonitor monitor = new GameMonitor();
	}
}
