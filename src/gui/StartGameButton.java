package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StartGameButton extends JButton implements ActionListener {
	private GameMonitor monitor;

	public StartGameButton(GameMonitor monitor) {
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
