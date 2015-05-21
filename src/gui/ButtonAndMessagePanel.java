package gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import client.ClientSender;

public class ButtonAndMessagePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public ButtonAndMessagePanel(GameMonitor monitor, ClientSender sender) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new DrawCardButton(monitor, sender));
	}
	

}
