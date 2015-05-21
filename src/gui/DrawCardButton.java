package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.ClientSender;

public class DrawCardButton extends JButton implements ActionListener {
	private GameMonitor monitor;
	private ClientSender sender;

	public DrawCardButton(GameMonitor monitor, ClientSender sender) {
		super("Dra kort");
		this.monitor = monitor;
		this.sender = sender;
		addActionListener(this);
		this.setToolTipText("Drar kort");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sender.sendCommand("DrawCard");
	}
}
