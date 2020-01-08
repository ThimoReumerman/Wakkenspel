package wakkenspel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/** The ThrowPanel class creates the panel where the user can throw multiple dice
 * @author Thimo Reumerman 97050932 */
public class ThrowPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	/** Color of the GuessPanel */
	private Color color = new Color(0, 0, 0, 90);
	
	/** Label of the icon */
	private JLabel iconLabel;
	/** Label of the title */
	private JLabel title;
	/** Textfield of the amount of dice */
	public JTextField amount;
	/** Button to draw the dice */
	private JButton throwDice;
	
	/** Mainframe of the application */
	MainFrame mainFrame;
	
	/** Draws user input field for dice to throw and a button to throw them
	 * @param _mainFrame Mainframe of the application */
	public ThrowPanel(MainFrame _mainFrame) {
		
		//Set mainframe
		mainFrame = _mainFrame;
		
		//Set color of panel
		setOpaque(true);
		setBackground(color);
		
		//Disable layout
		setLayout(null);

		//Create middle variable
		int middle = 115;
		
		//Set icon label
		ImageIcon icon = new ImageIcon("images/dice.png");
		iconLabel = new JLabel(icon);
		iconLabel.setBounds(middle - icon.getIconWidth() / 2, 22, icon.getIconWidth(), icon.getIconHeight());
		add(iconLabel);
		
		//Set title label
		title = new JLabel("DOBBELSTENEN", SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("TAHOMA", Font.PLAIN, 22));
		int titleWidth = 230;
		title.setBounds(middle - titleWidth / 2, 90, titleWidth, 22);
		add(title);

		//Set amount textfield
		amount = new JTextField("0");
		mainFrame.setDefaultTextField(amount, 30, 126, 50, 22);
		add(amount);

		//Set throw button
		throwDice = new JButton("Werpen");
		mainFrame.setDefaultButton(throwDice, 92, 121, 125, 35);
		add(throwDice);
		throwDice.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(throwDice.isEnabled()) {
			
			//Get number of dice
			int diceNum = mainFrame.parse(amount.getText());
			
			//Throw said amount of dice
			mainFrame.throwDice(diceNum);
		}
		
	}

}
