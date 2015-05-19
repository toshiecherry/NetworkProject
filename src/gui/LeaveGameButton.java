package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LeaveGameButton extends JButton implements ActionListener {
	private GameMonitor monitor;

	public LeaveGameButton(GameMonitor monitor) {
		super("Lämna spelomgång");
		this.monitor = monitor;
		addActionListener(this);
		this.setToolTipText("Lämnar spelomgången");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
