package wakkenspel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * The Dice class draws the empty dice
 * @author Thimo Reumerman 97050932
 * @since 5-12-2019 
 * @version 0.1
 */
public class Dice extends JPanel {
	/** */
	private static final long serialVersionUID = 1L;
	
	/** Size of the dice */
	public static int size = 80;
	/** Arc of the dice */
	public static int arc = 10;
	/** Size of the dice border */
	private int borderSize = 2;
	/** Color of the empty dice border */
	public static Color emptyDiceColor = new Color(255, 255, 255, 60);
	
	/** Constructor of Dice creates a new Dice */
	public Dice() {
		
	}
	
	/** Constructor of dice that checks if the dice is empty
	 * @param isEmpty Dice is empty
	 * @param x Position on x axis to draw the dice
	 * @param y Position on y axis to draw the dice
	 * @param g2d Graphics2D to draw the dice with */
	public Dice(boolean isEmpty, int x, int y, Graphics2D g2d) {
		
		if(isEmpty) {
			drawEmptyDice(x, y, g2d);
			
		}
	}
	
	/** Draws an empty dice
	 * @param x Position on x axis to draw the dice
	 * @param y Position on y axis to draw the dice
	 * @param g2d Graphics2D to draw the dice with */
	public void drawEmptyDice(int x, int y, Graphics2D g2d) {
		
		//Set super paint component
		super.paintComponent(g2d);
		
		//Draw dice
		g2d.setColor(emptyDiceColor);
		g2d.setStroke(new BasicStroke(borderSize));
		g2d.drawRoundRect(x, y, size, size, arc, arc);
		
	}
	
	
	

}
