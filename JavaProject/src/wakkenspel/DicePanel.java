package wakkenspel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

/** The DicePanel draws the thrown (or empty) dice
 * @author Thimo Reumerman 97050932 */
public class DicePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/** Color of the panel */
	private Color color = new Color(0, 0, 0, 90);
	/** Color of the empty dice border */
	private Color emptyDiceColor = new Color(255, 255, 255, 60);
	/** Size of the dice border */
	private int borderSize = 2;
	/** Pixels between different dice */
	private int diceStep = 25;
	/** Middle of the panel on the x axis */
	int xMid;
	/** Middle of the panel on the y axis */
	int yMid;
	/** Array of dice currently on the screen */
	public ArrayList<Dice> diceArray = new ArrayList<Dice>();
	
	/** Draws the dice panel 
	 * @param width Width of the panel
	 * @param height Height of the panel */
	public DicePanel(int width, int height) {
		
		//Set color of panel
		setOpaque(false);
		setLayout(null);
		
		//Create dice grid
		xMid = width / 2; //Center of horizontal axis
		yMid = height / 2; //Center of vertical axis

	}
	
	/** Creates a grid and places the thrown dice on it
	 * @param toThrow Amount of dice to throw */	
	public void throwDice(int toThrow) {
		
		//Reset dice grid
		diceArray.forEach((n) -> n.setVisible(false));
		diceArray.clear();
		
		//Set dice bounds
		int diceBoundsX = Dice.size * 6 + diceStep * 5; //Bounds on the horizontal axis
		int diceBoundsY = Dice.size * 2 + diceStep; //Bounds on the vertical axis
		
		//Set index of dice in loop
		int index = 0; //Index of dice
		
		//Loop through the dice to create the grid
		for(int row = 0; row < 2; row++) { //Loop thorugh the rows
			for (int col = 0; col < 6; col++) { //Loop through the colums
				
				if (index < toThrow) {
					//Set positions
					int x = xMid - diceBoundsX / 2 + (Dice.size + diceStep) * col;
					int y = yMid - diceBoundsY / 2 + (Dice.size + diceStep) * row;
					
					//Creates and places dice on the grid
					Dice dice = new Dice();
					dice.setBounds(x, y, Dice.size, Dice.size);
					dice.setVisible(true);
					add(dice);
					
					//Add dice to array					
					diceArray.add(dice);
					
					//Sets the current index
					index++;			
				} else {
					break;
				}
			}
		}
	}
	
	/** Creates a grid for the dice and calls the dice draw function
	 * @see Dice */	
	public void paintComponent (Graphics g) {
		
		//Set super paint component
		super.paintComponent(g);
		
		//Enable anti aliasing
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Set panel background
		g2d.setColor(color);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		//Create dice grid
		int xMid = getWidth() / 2; //Center of horizontal axis
		int yMid = getHeight() / 2; //Center of vertical axis
		
		//Set bounds of dice
		int diceBoundsX = Dice.size * 6 + diceStep * 5; //Bounds on the horizontal axis
		int diceBoundsY = Dice.size * 2 + diceStep; //Bounds on the vertical axis
		
		//Loop through the dice to create the grid
		for(int row = 0; row < 2; row++) { //Loop thorugh the rows
			for (int col = 0; col < 6; col++) { //Loop through the colums
				
				//Sets position to draw the empty dice on
				int x = xMid - diceBoundsX / 2 + (Dice.size + diceStep) * col;
				int y = yMid - diceBoundsY / 2 + (Dice.size + diceStep) * row;
				
				//Draws empty dice
				g2d.setColor(emptyDiceColor);
				g2d.setStroke(new BasicStroke(borderSize));
				g2d.drawRoundRect(x, y, Dice.size, Dice.size, Dice.arc, Dice.arc);
			}
		}
	}
}
