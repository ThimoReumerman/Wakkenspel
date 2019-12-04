package wakkenspel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Header class draws the header, displaying the game's name and a new game button
 * @author Thimo Reumerman 97050932
 * @since 4-12-2019 
 * @version 0.2
 */
public class Header extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Properties
	/** Color of the header */
	private Color color;
	/** Height of the header */
	public static int HEIGHT = 68;

	private JButton newGameButton;
	
	public Header() {
		
		//Set color of header
		color = new Color(38, 38, 38);
		
		//Disable layout
		setLayout(null);
		
		//Create game name JLabel
		JLabel name = new JLabel("Wakkenspel");
		name.setBounds(61, 17, 200, 37);
		Font font = new Font("Tahoma", Font.PLAIN, 28);
		name.setFont(font);
		name.setForeground(Color.WHITE);
		add(name);
		
		//Create newGame button		
		ImageIcon newGameIcon = new ImageIcon("images/newGame.png");
		newGameButton = new JButton(newGameIcon);
		newGameButton.setBounds(725, 14, 42, 42);
		newGameButton.setContentAreaFilled(false);
	   	newGameButton.setFocusPainted(false);
		newGameButton.setBorderPainted(false);
		add(newGameButton);
		
		newGameButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered (MouseEvent evt) {
				newGameButton.setIcon(new ImageIcon("images/newGameHover.png"));
			}
			
			public void mouseExited (MouseEvent evt) {
				newGameButton.setIcon(new ImageIcon("images/newGame.png"));
			}
		});		
		newGameButton.addActionListener(this);
		
		
	}
	
	public void paintComponent (Graphics g) {
		
		//Set super paint component
		super.paintComponent(g);
		
		//Enable anti aliasing
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Draw header rectangle
		g.setColor(color);
		g.fillRect(0, 0, getWidth(), HEIGHT);
		
		//Draw image
//		g.drawImage(newGameIcon, 732, 0, this);
//		g.drawImage(newGameIcon, 725, 14, 42, 42, this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(newGameButton.isEnabled()) {
			GameManager.newGame();
		}
		
	}
	
	

}
