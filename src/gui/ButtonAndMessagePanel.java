package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import client.CardHand;
import client.ClientSender;

public class ButtonAndMessagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel messageLabel;
//	private JLabel messageLabel2;

	public ButtonAndMessagePanel(GameMonitor monitor, ClientSender sender, CardHand cardHand) {
		setLayout(new BorderLayout()); 
		messageLabel = new JLabel("       ");
//		messageLabel2 = new JLabel("       ");
		add(new DrawCardButton(monitor, sender, cardHand),BorderLayout.WEST);
		add(new BubblanButton(monitor, sender, cardHand), BorderLayout.EAST);
		add(messageLabel, BorderLayout.SOUTH);
//		add(messageLabel2, BorderLayout.NORTH);
	}

	public void setText(String error) {
		messageLabel.setText(error);

	}
//	public void setText2(String error) {
//		messageLabel2.setText(error);
//
//	}
	

}
