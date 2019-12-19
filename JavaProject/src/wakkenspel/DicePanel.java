package wakkenspel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * The DicePanel class draws the thrown (or empty) dice
 * @author Thimo Reumerman 97050932
 * @since 5-12-2019 
 * @version 0.1
 */
public class DicePanel extends JPanel {
	/** */
	private static final long serialVersionUID = 1L;
	
	/** Color of the panel */
	private Color color = new Color(0, 0, 0, 90);
	/** Color of the empty dice border */
	private Color emptyDiceColor = new Color(255, 255, 255, 60);
	/** Size of the dice border */
	private int borderSize = 2;
	/** Pixels between different dice */
	private int diceStep = 25;
	int xMid;
	int yMid;
	
	
	
	/** Constructor of the Dice Panel. Sets opacity and background color */
	public DicePanel(int width, int height) {
		
		//Set color of panel
		setOpaque(true);
		setBackground(color);
		setLayout(null);
		
		//Create dice grid
		xMid = width / 2; //Center of horizontal axis
		yMid = height / 2; //Center of vertical axis
		
		System.out.println("W: " + xMid + "H: " + yMid);
		
		throwDice();
	}
	
	/** Throw the dice */	
	public void throwDice() {
		int diceBoundsX = Dice.size * 6 + diceStep * 5; //Bounds on the horizontal axis
		int diceBoundsY = Dice.size * 2 + diceStep; //Bounds on the vertical axis
		int toThrow = 4; //Amount of dice to throw
		int index = 0; //Index of dice
		
		//Loop through the dice to create the grid
		for(int row = 0; row < 2; row++) { //Loop thorugh the rows
			for (int col = 0; col < 6; col++) { //Loop through the colums
				
				if (index < toThrow) {
					//Set positions
					int x = xMid - diceBoundsX / 2 + (Dice.size + diceStep) * col;
					int y = yMid - diceBoundsY / 2 + (Dice.size + diceStep) * row;
					
					System.out.println("Dice " + index + "| " +  x + " " + y + " " + Dice.size + " " + Dice.size);
					
					Dice dice = new Dice();
					dice.setBounds(x, y, Dice.size, Dice.size);
					dice.setVisible(true);
					add(dice);
					
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
		
		System.out.println("Drawing dicePanel");
		
		//Enable anti aliasing
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Create dice grid
		int xMid = getWidth() / 2; //Center of horizontal axis
		int yMid = getHeight() / 2; //Center of vertical axis
		
		int diceBoundsX = Dice.size * 6 + diceStep * 5; //Bounds on the horizontal axis
		int diceBoundsY = Dice.size * 2 + diceStep; //Bounds on the vertical axis
		
		//Loop through the dice to create the grid
		for(int row = 0; row < 2; row++) { //Loop thorugh the rows
			for (int col = 0; col < 6; col++) { //Loop through the colums
				
				//Set positions
				int x = xMid - diceBoundsX / 2 + (Dice.size + diceStep) * col;
				int y = yMid - diceBoundsY / 2 + (Dice.size + diceStep) * row;
				
				//Draw empty dice
				g2d.setColor(emptyDiceColor);
				g2d.setStroke(new BasicStroke(borderSize));
				g2d.drawRoundRect(x, y, Dice.size, Dice.size, Dice.arc, Dice.arc);
			}
		}
	}
}
