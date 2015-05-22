package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import client.CardHand;
import client.ClientSender;

@SuppressWarnings("serial")
public class UpperPanel extends JPanel {

	public UpperPanel(GameMonitor monitor, ClientSender sender, CardHand cardHand) {
		setLayout(new BorderLayout());
		add(new StartGameButton(monitor, sender, cardHand), BorderLayout.WEST);
		add(new LeaveGameButton(monitor, sender), BorderLayout.EAST);
	}
}
