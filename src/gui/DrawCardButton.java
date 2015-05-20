package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
		
	}
}
