package wakkenspel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * The Header class draws the header, displaying the game's name and a new game button
 * @author Thimo Reumerman 97050932
 * @since 4-12-2019 
 * @version 0.3
 */
public class Header extends JPanel implements ActionListener {
	/** */
	private static final long serialVersionUID = 1L;
	
	//Properties
	/** Color of the header */
	private Color color;
	/** Height of the header */
	public static int HEIGHT = 68;

	//Swing
	/** Button to start new game
	 * @see GameManager.newGame */
	private JButton newGameButton;
	/** Name of the game */
	private JLabel name;
	/** GameManager */
	MainFrame mainFrame;
	
	/** Constructor of header draws the games name and the newGame button */
	public Header(MainFrame _mainFrame) {
		
		mainFrame = _mainFrame;
		
		//Set color of header
		color = new Color(38, 38, 38);
		setBackground(color);
		
		//Disable layout
		setLayout(null);
		
		//Create game name JLabel
		name = new JLabel("Wakkenspel");
		name.setBounds(61, 3, 200, 60);
		name.setFont(new Font("Tahoma", Font.PLAIN, 35));
		name.setForeground(Color.WHITE);
		add(name);
		
		
		//Create newGame button		
		ImageIcon newGameIcon = new ImageIcon("images/newGame.png");
		newGameButton = new JButton(newGameIcon);
		newGameButton.setBounds(720, 9, 50, 50);
		newGameButton.setContentAreaFilled(false);
	   	newGameButton.setFocusPainted(false);
		newGameButton.setBorderPainted(false);
		add(newGameButton);
		
		//Add mouse listener for effect on hover
		newGameButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered (MouseEvent evt) {
				newGameButton.setIcon(new ImageIcon("images/newGameHover.png"));
			}
			
			public void mouseExited (MouseEvent evt) {
				newGameButton.setIcon(new ImageIcon("images/newGame.png"));
			}
		});
		
		//Add action listener to button
		newGameButton.addActionListener(this);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(newGameButton.isEnabled()) {

			mainFrame.newGame();
		}
		
	}
	
	

}
