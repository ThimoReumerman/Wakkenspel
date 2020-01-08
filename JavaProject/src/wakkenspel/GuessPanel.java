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

/** The GuessPanel class draws the guess textfields
 * @author Thimo Reumerman 97050932 */
public class GuessPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	/** Width of the GuessPanel */
	public static int WIDTH = 210;
	/** Height of the GuessPanel */
	public static int HEIGHT = 275;
	
	/** Color of the GuessPanel */
	private Color color = new Color(0, 0, 0, 90);
	public Color textfieldColor = new Color(27, 172, 66);
	public Color wrongGuessColor = new Color (172, 41, 27);
	
	/** Label of the icon */
	private JLabel iconLabel;
	/** Label of the title **/
	private JLabel title;
	/** Textfield of the wakken */
	public JTextField wakken;
	/** Label of the wakken */
	private JLabel wakkenLabel;
	/** Textfield of the ijsberen */
	public JTextField ijsberen;
	/** Label of the ijsberen */
	private JLabel ijsberenLabel;
	/** Textfield of the pinguins */
	public JTextField pinguins;
	/** Label of the pinguins */
	private JLabel pinguinsLabel;
	/** Button to check the values of the guessed variables */
	private JButton check;
	
	/** MainFrame of the application */
	MainFrame mainFrame;
	
	/** Panel that has user input for the guesses
	 * @param _mainFrame Mainframe of the application */
	public GuessPanel(MainFrame _mainFrame) {
		
		//Set mainframe
		mainFrame = _mainFrame;
		
		//Set color of panel
		setOpaque(true);
		setBackground(color);
		
		//Disable layout
		setLayout(null);
		
		//Create middle variable
		int middle = WIDTH / 2;
		
		//Set icon label
		ImageIcon icon = new ImageIcon("images/questionmark.png");
		iconLabel = new JLabel(icon);
		iconLabel.setBounds(middle - icon.getIconWidth() / 2, 22, icon.getIconWidth(), icon.getIconHeight());
		add(iconLabel);

		//Set title label
		title = new JLabel("RADEN", SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("TAHOMA", Font.PLAIN, 22));
		int titleWidth = 150;
		title.setBounds(middle - titleWidth / 2, 80, titleWidth, 22);
		add(title);
		
		//Set wakken textfield
		wakken = new JTextField("0");
		mainFrame.setDefaultTextField(wakken, 30, 120, 50, 22);
		add(wakken);
		
		//Set wakken label
		wakkenLabel = new JLabel("Wakken");
		mainFrame.setDefaultLabel(wakkenLabel, 100, 120, 100, 25);
		add(wakkenLabel);
		
		//Set ijsberen textfield
		ijsberen = new JTextField("0");
		mainFrame.setDefaultTextField(ijsberen, 30, 150, 50, 22);
		add(ijsberen);
		
		//Set ijsberen label
		ijsberenLabel = new JLabel("IJsberen");
		mainFrame.setDefaultLabel(ijsberenLabel, 100, 150, 100, 25);
		add(ijsberenLabel);
		
		//Set pinguins textfield
		pinguins = new JTextField("0");
		mainFrame.setDefaultTextField(pinguins, 30, 180, 50, 22);
		add(pinguins);
		
		//Set pinguins label
		pinguinsLabel = new JLabel("Pinguïns");
		mainFrame.setDefaultLabel(pinguinsLabel, 100, 180, 100, 25);
		add(pinguinsLabel);
		
		//Set check button
		check = new JButton("Controleren");
		mainFrame.setDefaultButton(check, middle - 140 / 2, 220, 140, 35);
		add(check);
		check.addActionListener(this);
	}
	
	/** Check for check button click and check the entered values*/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(check.isEnabled()) {	
			
			//Reset textfield background
			wakken.setBackground(textfieldColor);
			ijsberen.setBackground(textfieldColor);
			pinguins.setBackground(textfieldColor);
			
			//Parse user input
			int wakkenNum = mainFrame.parse(wakken.getText());
			int ijsberenNum = mainFrame.parse(ijsberen.getText());
			int pinguinsNum = mainFrame.parse(pinguins.getText());
			
			//Manage the guess
			mainFrame.manageGuess(wakkenNum, ijsberenNum, pinguinsNum);
		}
	}
}
