package gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class UpperPanel extends JPanel {

	public UpperPanel(GameMonitor monitor){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new StartGameButton(monitor));
		add(new LeaveGameButton(monitor));
	}
}
