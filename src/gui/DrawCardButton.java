package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.CardHand;
import client.ClientSender;

@SuppressWarnings("serial")
public class DrawCardButton extends JButton implements ActionListener {
	private GameMonitor monitor;
	private ClientSender sender;
	private CardHand hand;

	public DrawCardButton(GameMonitor monitor, ClientSender sender, CardHand cardHand) {
		super("Draw Card");
		this.monitor = monitor;
		this.sender = sender;
		hand = cardHand;
		addActionListener(this);
		this.setToolTipText("Draws a card");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String newCard = sender.drawCard();
		if (newCard == null) {
			monitor.errorMessage("Null Error");
		} else if (newCard.charAt(0) == 'E') {
			monitor.errorMessage("Pile is empty");
		} else if (newCard.charAt(0) == 'T') {
			monitor.errorMessage("Too many cards on your hand");
		} else {
			hand.addCard(newCard);
			monitor.errorMessage(" ");

		}
	}
}
