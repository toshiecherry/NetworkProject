package gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonAndMessagePanel extends JPanel {
	private static final long serialVersionUID = 1L;

public ButtonAndMessagePanel(JButton[] buttons, JLabel messageLine,
		ActionListener actHand) {
	setLayout(new GridLayout(2, 1));

	JPanel buttonPanel = new JPanel();
	for (int i = 0; i < buttons.length; i++) {
		buttonPanel.add(buttons[i]);
	}
	add(buttonPanel);

	add(messageLine);

	for (int i = 0; i < buttons.length; i++) {
		buttons[i].addActionListener(actHand);
	}
}
}
