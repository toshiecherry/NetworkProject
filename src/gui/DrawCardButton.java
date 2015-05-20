package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import se.lth.cs.ptdc.cardGames.Card;

public class DrawCardButton extends JButton implements ActionListener {
	private GameMonitor monitor;
	

	public DrawCardButton(GameMonitor monitor) {
		super("Dra kort");
		this.monitor = monitor;
		addActionListener(this);
		this.setToolTipText("Drar kort");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Kolla om högen inte är tom 
		//Dra kort från rätt hög 
		//Add det kortet till handen 
		if(pile.size() != 0){
			Card card = pile.drawCard();
			hand.addCard(card);
		}
		
	}
}
