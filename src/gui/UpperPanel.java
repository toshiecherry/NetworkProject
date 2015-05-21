package gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import client.ClientSender;

public class UpperPanel extends JPanel {

	public UpperPanel(GameMonitor monitor, ClientSender sender) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new StartGameButton(monitor, sender));
		add(new LeaveGameButton(monitor, sender));
	}
}
