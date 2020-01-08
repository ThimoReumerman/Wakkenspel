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

/** The SolutionPanel class shows the solution and guesses
 * @author Thimo Reumerman 97050932 */
public class SolutionPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	/** Color of the GuessPanel */
	private Color color = new Color(0, 0, 0, 90);
	
	/** Label of the icon */
	private JLabel iconLabel;
	/** Label of the title **/
	private JLabel title;
	/** Button to show solution */
	private JButton show;
	/** Textfield of the wakken */
	private JTextField wakkenTextField;
	/** Label of the wakken */
	private JLabel wakkenLabel;
	/** Textfield of the ijsberen */
	private JTextField ijsberenTextField;
	/** Label of the ijsberen */
	private JLabel ijsberenLabel;
	/** Textfield of the pinguins */
	private JTextField pinguinsTextField;
	/** Label of the pinguins */
	private JLabel pinguinsLabel;
	/** Textfield of the guessed */
	private JTextField guessedTextField;
	/** Label of the guessed */
	private JLabel guessedLabel;
	/** Textfield of the correct guesses */
	private JTextField correctTextField;
	/** Label of the correct guesses */
	private JLabel correctLabel;
	/** Textfield of the wrong guesses */
	private JTextField wrongTextField;
	/** Label of the wrong guesses */
	private JLabel wrongLabel;
	
	/** Mainframe of the application */
	MainFrame mainFrame;
	
	/** Panel that shows the solution and the guesses
	 * @param _mainFrame Mainframe of the application */
	public SolutionPanel(MainFrame _mainFrame) {
		
		//Set mainFrame
		mainFrame = _mainFrame;
		
		//Set color of panel
		setOpaque(true);
		setBackground(color);
		
		//Disable layout
		setLayout(null);
		
		//Set icon label
		int middle = 210 / 2;
		ImageIcon icon = new ImageIcon("images/oplossing.png");
		iconLabel = new JLabel(icon);
		iconLabel.setBounds(middle - icon.getIconWidth() / 2, 5, icon.getIconWidth(), icon.getIconHeight());
		add(iconLabel);

		//Set title label
		title = new JLabel("OPLOSSING", SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("TAHOMA", Font.PLAIN, 22));
		int titleWidth = 150;
		title.setBounds(middle - titleWidth / 2, 76, titleWidth, 22);
		add(title);
		
		//Set show button
		show = new JButton("Laat zien");
		mainFrame.setDefaultButton(show, 30, 105, 150, 35);
		add(show);
		show.addActionListener(this);
		
		//Set wakken textfield
		wakkenTextField = new JTextField("0");
		mainFrame.setDefaultTextField(wakkenTextField, 30, 155, 50, 22);
		wakkenTextField.setEditable(false);
		add(wakkenTextField);
		
		//Set wakken label
		wakkenLabel = new JLabel("Wakken");
		mainFrame.setDefaultLabel(wakkenLabel, 100, 155, 100, 25);
		add(wakkenLabel);
		
		//Set ijsberen textfield
		ijsberenTextField = new JTextField("0");
		mainFrame.setDefaultTextField(ijsberenTextField, 30, 185, 50, 22);
		ijsberenTextField.setEditable(false);
		add(ijsberenTextField);
		
		//Set ijsberen label
		ijsberenLabel = new JLabel("IJsberen");
		mainFrame.setDefaultLabel(ijsberenLabel, 100, 185, 100, 25);
		add(ijsberenLabel);
		
		//Set pinguins textfield
		pinguinsTextField = new JTextField("0");
		mainFrame.setDefaultTextField(pinguinsTextField, 30, 215, 50, 22);
		pinguinsTextField.setEditable(false);
		add(pinguinsTextField);
		
		//Set pinguins label
		pinguinsLabel = new JLabel("Pinguïns");
		mainFrame.setDefaultLabel(pinguinsLabel, 100, 215, 100, 25);
		add(pinguinsLabel);
		
		//Set guesses textfield
		guessedTextField = new JTextField("0");
		mainFrame.setDefaultTextField(guessedTextField, 30, 255, 50, 22);
		guessedTextField.setEditable(false);
		add(guessedTextField);
		
		//Set guesses label
		guessedLabel = new JLabel("Geraden");
		mainFrame.setDefaultLabel(guessedLabel, 100, 255, 100, 25);
		add(guessedLabel);
		
		//Set correct guesses textfield
		correctTextField = new JTextField("0");
		mainFrame.setDefaultTextField(correctTextField, 30, 285, 50, 22);
		correctTextField.setEditable(false);
		add(correctTextField);
		
		//Set correct guesses label
		correctLabel = new JLabel("Goed");
		mainFrame.setDefaultLabel(correctLabel, 100, 285, 100, 25);
		add(correctLabel);
		
		//Set wrong guesses textfield
		wrongTextField = new JTextField("0");
		mainFrame.setDefaultTextField(wrongTextField, 30, 315, 50, 22);
		wrongTextField.setEditable(false);
		add(wrongTextField);
		
		//Set wrong guesses label
		wrongLabel = new JLabel("Fout");
		mainFrame.setDefaultLabel(wrongLabel, 100, 315, 100, 25);
		add(wrongLabel);
	}
	
	/** Fills the solution textfield
	 * @param pinguinsNum Number of pinguins
	 * @param wakkenNum Number of wakken
	 * @param ijsberenNum Number of ijsberen */
	public void setSolution(int pinguinsNum, int wakkenNum, int ijsberenNum) {
		pinguinsTextField.setText(Integer.toString(pinguinsNum));
		wakkenTextField.setText(Integer.toString(wakkenNum));
		ijsberenTextField.setText(Integer.toString(ijsberenNum));
	}
	
	/** Fills the guesses textfield
	 * @param guesses Number of guesses
	 * @param wrong Number of wrong guesses
	 * @param correct Number of correct guesses */
	public void setGuesses(int guesses, int wrong, int correct) {
		guessedTextField.setText(Integer.toString(guesses));
		wrongTextField.setText(Integer.toString(wrong));
		correctTextField.setText(Integer.toString(correct));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(show.isEnabled()) {
			System.out.println("Enabled.");
			mainFrame.showSolution();
		}
	}

}
