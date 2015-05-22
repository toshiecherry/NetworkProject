package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ImageLabel extends JLabel implements ActionListener {
	private int labelIndex;

	public ImageLabel(int i) {
		labelIndex = i;
		try {
			BufferedImage myPicture = ImageIO.read(new File("pictures/b1.png"));
			setIcon(new ImageIcon(myPicture));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
