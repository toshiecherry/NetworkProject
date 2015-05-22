package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLabel implements ActionListener {

	public ImageLabel() {
		try {
			BufferedImage myPicture = ImageIO.read(new File("picture/b1.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
