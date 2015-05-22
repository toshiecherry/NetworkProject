package gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import client.CardHand;
import client.ClientSender;

@SuppressWarnings("serial")
public class UpperPanel extends JPanel {

	public UpperPanel(GameMonitor monitor, ClientSender sender, CardHand cardHand) {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(new StartGameButton(monitor, sender, cardHand));
		add(new LeaveGameButton(monitor, sender));
	}
}
