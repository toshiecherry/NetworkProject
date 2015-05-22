package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.ClientSender;

@SuppressWarnings("serial")
public class LeaveGameButton extends JButton implements ActionListener {
	private GameMonitor monitor;

	public LeaveGameButton(GameMonitor monitor, ClientSender sender) {
		super("Lämna spelomgång");
		this.monitor = monitor;
		addActionListener(this);
		this.setToolTipText("Lämnar spelomgången");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		monitor.errorMessage(" ");

	}
}
