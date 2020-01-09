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

/** The Header class draws the game's name and a newGame button
 * @author Thimo Reumerman 97050932 */
public class Header extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	/** Color of the header */
	private Color color;
	/** Height of the header */
	public static int HEIGHT = 68;

	/** Button to start new game */
	private JButton newGameButton;
	/** Name of the game */
	private JLabel name;
	
	/** Mainframe of the application */
	MainFrame mainFrame;
	
	/** Draws the games name and a newGame button
	 * @param _mainFrame Mainframe of the application */
	public Header(MainFrame _mainFrame) {
		
		//Set mainframe
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
			
			//Set icon when mouse hovers over newGame button
			public void mouseEntered (MouseEvent evt) {
				newGameButton.setIcon(new ImageIcon("images/newGameHover.png"));
			}
			
			//Set icon when mouse doesn't hover over newGame button
			public void mouseExited (MouseEvent evt) {
				newGameButton.setIcon(new ImageIcon("images/newGame.png"));
			}
		});
		
		//Add action listener to button
		newGameButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(newGameButton.isEnabled()) {
			
			//Create a new game
			mainFrame.newGame();
		}
	}
}
