package wakkenspel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Background class draws a background image
 * @author Thimo Reumerman 97050932
 * @since 4-12-2019 
 * @version 0.2
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
			backgroundImage = ImageIO.read(new File("images/background.png"));
		} catch (IOException e) {
			
			//Print default error message
			e.printStackTrace();
		}

	}
	
	public void paintComponent(Graphics g) {
		
		//Set super paint component
		super.paintComponent(g);
		
		//Enable anti aliasing
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//Draw background image
		g.drawImage(backgroundImage, 0, 0, this);		
	}
}
