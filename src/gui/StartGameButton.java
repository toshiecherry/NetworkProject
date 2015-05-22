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
		super("Start Game");
		this.monitor = monitor;
		this.sender = sender;
		this.cardHand = cardHand;
		addActionListener(this);
		this.setToolTipText("Starts the Game");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] cards = sender.startGame();
		if (cards != null) {
			for (int i = 0; i < 4; i++) {
				cardHand.addCard(cards[i]);
				monitor.errorMessage(" ");
			}
		} else {
			monitor.errorMessage("The game has already started");
		}

	}

}
