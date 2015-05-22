package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import client.CardHand;
import client.ClientSender;

@SuppressWarnings("serial")
public class UpperPanel extends JPanel {
//	private JLabel messageLabel;

	public UpperPanel(GameMonitor monitor, ClientSender sender, CardHand cardHand) {
		setLayout(new BorderLayout());
//		messageLabel = new JLabel("        ");
//		add(messageLabel, BorderLayout.NORTH);
		add(new StartGameButton(monitor, sender, cardHand), BorderLayout.WEST);
		add(new LeaveGameButton(monitor, sender), BorderLayout.EAST);
	}
	
//	public void setText(String error) {
//		messageLabel.setText(error);
//
//	}
}
