package gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ButtonAndMessagePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public ButtonAndMessagePanel(GameMonitor monitor) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new DrawCardButton(monitor));
	}
	

}
