package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.ClientSender;

public class StartGameButton extends JButton implements ActionListener {
	private GameMonitor monitor;

	public StartGameButton(GameMonitor monitor, ClientSender sender) {
		super("Starta spel");
		this.monitor = monitor;
		addActionListener(this);
		this.setToolTipText("Startar spelomgång");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
