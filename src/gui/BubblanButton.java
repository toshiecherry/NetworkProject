package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.CardHand;
import client.ClientSender;

public class BubblanButton extends JButton implements ActionListener {
	private GameMonitor monitor;
	private ClientSender sender;
	private CardHand hand;

	public BubblanButton(GameMonitor monitor, ClientSender sender, CardHand hand) {
		super("Got bubblan");
		this.monitor = monitor;
		this.sender = sender;
		this.hand = hand;
		addActionListener(this);
		this.setToolTipText("If you or any other player got bubblan");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (hand.bubblanHand()) { // eller om n�n annan tryckt bubblan
			sender.sendCommand("GotBubblan");
		}
	}
}
