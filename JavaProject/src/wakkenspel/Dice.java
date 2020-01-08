package wakkenspel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/** The Dice class contains variables for the dice and draws the dice itself
 * @author Thimo Reumerman 97050932 */
public class Dice extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/** Size of the dice */
	public static int size = 80;
	/** Arc of the dice */
	public static int arc = 10;
	
	/** Dots in the middle of the dice */
	public int wakken = 0;
	/** Dots around the wakken */
	public int ijsberen = 0;
	/** Dots on the other side of the dice */
	public int pinguins = 0;
	
	/** Top left dot on dice */
	boolean tl;
	/** Top middle dot on dice */
	boolean tm;
	/** Top right dot on dice */
	boolean tr;
	/** Middle dot on dice */
	boolean mid;
	/** Bottom left dot on dice */
	boolean bl;
	/** Bottom middle dot on dice */
	boolean bm;
	/** Bottom right dot on dice */
	boolean br;
	
	/** Throws a dice and stores its variables */	
	public Dice() {
		
		//Get random dice value
		int value = (int)(Math.random() * 6) + 1;
		
		//Set correct parameters based on the value thrown
		switch (value) {
			case 1:
				createDice(false, false, false, true, false, false, false);
				wakken = 1;
				pinguins = 6;
				break;
			case 2:
				createDice(true, false, false, false, false, false, true);
				pinguins = 5;
				break;
			case 3:
				createDice(true, false, false, true, false, false, true);
				wakken = 1;
				ijsberen = 2;
				pinguins = 4;
				break;
			case 4:
				createDice(true, false, true, false, true, false, true);
				pinguins = 3;
				break;
			case 5:
				createDice(true, false, true, true, true, false, true);
				wakken = 1;
				ijsberen = 4;
				pinguins = 2;
				break;
			case 6:
				createDice(true, true, true, false, true, true, true);
				pinguins = 1;
				break;
			default:
				createDice(false, false, false, false, false, false, false);
		}
	}
	
	/** Draws the dice
	 * @param _tl Draw a dot on the top left of the dice
	 * @param _tm Draw a dot on the top middle of the dice
	 * @param _tr Draw a dot on the top right of the dice
	 * @param _mid Draw a dot on the middle of the dice
	 * @param _bl Draw a dot on the bottom left of the dice
	 * @param _bm Draw a dot on the bottom middle of the dice
	 * @param _br Draw a dot on the bottom right of the dice */
	public void createDice(boolean _tl, boolean _tm, boolean _tr, boolean _mid, boolean _bl, boolean _bm, boolean _br) {
		
		//Get rid of background
		setOpaque(false);
		
		//Set dots to draw
		tl = _tl;
		tm = _tm;
		tr = _tr;
		mid = _mid;
		bl = _bl;
		bm = _bm;
		br = _br;
		
		//Paint the dice
		revalidate();
	}
	
	public void paintComponent (Graphics g) {
		
		//Set super paint component
		super.paintComponent(g);
		
		//Disable built-in layout manager
		setLayout(null);
		
		//Enable Anti-Aliasing
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Set dice properties
		int middle = size / 2;
		
		//Fill dice with color
		g2d.setColor(new Color(216, 216, 216));
		g2d.fillRoundRect(1, 1, size - 2, size - 2, 15, 15);
		
		//Add border to dice
		g2d.setColor(new Color(40, 40, 40));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRoundRect(1, 1, size - 2, size - 2, 15, 15);
		
		//Set dot properties
		int step = 20; //Units between dots
		int dotSize = 11; //Size of the dots
		int dotPosX = 0; //Position of dot on x axis
		int dotPosY = 0; //Position of dot on y axis
		
		//Offset of dots		
		int offset = (int)dotSize / -2;
		
		//Color of dots
		g2d.setColor(new Color(40, 40, 40));
			
		//Draw selected dots on correct position
		if(tl) {
			dotPosX = middle - step + offset;
			dotPosY = middle - step + offset;
			
			g2d.fillOval(dotPosX, dotPosY, dotSize, dotSize);
		}
		if(tm) {
			dotPosX = middle + offset;
			dotPosY = middle - step + offset;

			g2d.fillOval(dotPosX, dotPosY, dotSize, dotSize);
		}
		if(tr) {
			dotPosX = middle + step + offset;
			dotPosY = middle - step + offset;

			g2d.fillOval(dotPosX, dotPosY, dotSize, dotSize);
		}
		if(mid) {
			dotPosX = middle + offset;
			dotPosY = middle + offset;

			g2d.fillOval(dotPosX, dotPosY, dotSize, dotSize);
		}
		if(bl) {
			dotPosX = middle - step + offset;
			dotPosY = middle + step + offset;
			
			g2d.fillOval(dotPosX, dotPosY, dotSize, dotSize);
		}
		if(bm) {
			dotPosX = middle + offset;
			dotPosY = middle + step + offset;

			g2d.fillOval(dotPosX, dotPosY, dotSize, dotSize);
		}
		if(br) {
			dotPosX = middle + step + offset;
			dotPosY = middle + step + offset;

			g2d.fillOval(dotPosX, dotPosY, dotSize, dotSize);
		}
	}
}
