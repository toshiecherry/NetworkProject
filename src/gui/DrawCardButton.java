package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.CardHand;
import client.ClientSender;
import se.lth.cs.ptdc.cardGames.Card;

public class DrawCardButton extends JButton implements ActionListener {
	private GameMonitor monitor;
	private ClientSender sender;
	private CardHand hand;

	public DrawCardButton(GameMonitor monitor, ClientSender sender, CardHand cardHand) {
		super("Dra kort");
		this.monitor = monitor;
		this.sender = sender;
		hand = cardHand;
		addActionListener(this);
		this.setToolTipText("Drar kort");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Card newCard = sender.sendCommand("DrawCard");
		if (newCard != null) {
			hand.addCard(newCard);
		} else {
			
		}
	}
}
