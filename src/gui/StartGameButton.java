package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.CardHand;
import client.ClientSender;
import se.lth.cs.ptdc.cardGames.Card;

@SuppressWarnings("serial")
public class StartGameButton extends JButton implements ActionListener {
	private GameMonitor monitor;
	private ClientSender sender;
	private CardHand cardHand;

	public StartGameButton(GameMonitor monitor, ClientSender sender, CardHand cardHand) {
		super("Starta spel");
		this.monitor = monitor;
		this.sender = sender;
		this.cardHand = cardHand;
		addActionListener(this);
		this.setToolTipText("Startar spelomgång");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Card[] cards = sender.startGame();
		if (cards[0] != null) {
			for (int i = 0; i < 4; i++) {
				cardHand.addCard(cards[i]);
			}
		} else {
			monitor.errorMessage("The startpile is not working");
		}

	}

}
