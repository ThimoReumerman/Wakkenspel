package wakkenspel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Background class draws a background image
 * @author Thimo Reumerman 97050932
 * @since 4-12-2019 
 * @version 0.1
 */
public class Background extends JPanel {
	
	/** Serial version UID of JPanel */
	private static final long serialVersionUID = 1L;
	
	/** Image to draw background with */
	private Image backgroundImage;

	/**
	 * Draw panel with background image
	 * @see JPanel
	 * @see Image
	 */
	public Background() {
		
		//Try to set background image
		try {
			
			//Set background image to the Background.png file
			backgroundImage = ImageIO.read(new File("images/Background.png"));
		} catch (IOException e) {
			
			//Print default error message
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backgroundImage, 0, 0, this);
		
		System.out.println("Background painting...");
	}
}
