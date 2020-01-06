package wakkenspel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

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
	
	/** Dots in the middle of the dice */
	public int wakken = 0;
	/** Dots around the wakken */
	public int ijsberen = 0;
	/** Dots on the other side of the dice */
	public int penguins = 0;
	
	boolean tl, tm, tr, mid, bl, bm, br;
	
	public Dice() {
		int value = (int)(Math.random() * 6) + 1;
		
		switch (value) {
			case 1:
				createDice(false, false, false, true, false, false, false);
				wakken = 1;
				penguins = 6;
				break;
			case 2:
				createDice(true, false, false, false, false, false, true);
				penguins = 5;
				break;
			case 3:
				createDice(true, false, false, true, false, false, true);
				wakken = 1;
				ijsberen = 2;
				penguins = 4;
				break;
			case 4:
				createDice(true, false, true, false, true, false, true);
				penguins = 3;
				break;
			case 5:
				createDice(true, false, true, true, true, false, true);
				wakken = 1;
				ijsberen = 4;
				penguins = 2;
				break;
			case 6:
				createDice(true, true, true, false, true, true, true);
				penguins = 1;
				break;
			default:
				createDice(false, false, false, false, false, false, false);
		}
	}

	public void createDice(boolean _tl, boolean _tm, boolean _tr, boolean _mid, boolean _bl, boolean _bm, boolean _br) {
		setOpaque(true);
		setBackground(new Color(0, 0, 0, 0));
		
		tl = _tl;
		tm = _tm;
		tr = _tr;
		mid = _mid;
		bl = _bl;
		bm = _bm;
		br = _br;
		
		repaint();
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
		
		//Draw dice object
		g2d.setColor(new Color(216, 216, 216));
		g2d.fillRoundRect(1, 1, size - 2, size - 2, 15, 15);
		
		g2d.setColor(new Color(40, 40, 40));
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRoundRect(1, 1, size - 2, size - 2, 15, 15);
		
		
		//Set dot properties
		int step = 20; //Units between dots
		int dotSize = 11;
		
		int dotPosX = 0;
		int dotPosY = 0;
		
		int offset = (int)dotSize / -2;
		
		g2d.setColor(new Color(40, 40, 40));
			
		//Draw selected dots
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
