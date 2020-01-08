package wakkenspel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/** The MainFrame class creates the JFrame where all the other panels will be running on
 * @author Thimo Reumerman 97050932 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/** The background panel */
	public Background background;
	/** The header panel */
	public Header header;
	/** The dice panel */
	public DicePanel dicePanel;
	/** The guess panel */
	public GuessPanel guessPanel;
	/** The throw panel */
	public ThrowPanel throwPanel;
	/** The solution panel */
	public SolutionPanel solutionPanel;
	/** The tips panel */
	public TipsPanel tipsPanel;
	
	/** Creates main JFrame and adds all the panels */
	public MainFrame() {

		//Set frame name
		super(Application.title);
		
		//Set the Mainframe properties
		setSize(800, 800);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Disable layout
		setLayout(null);
		
		//Add header panel
		header = new Header(this);
		header.setBounds(0, 0, 800, Header.HEIGHT);
		add(header);
		
		//Add dice panel
		dicePanel = new DicePanel(716, 250);
		dicePanel.setBounds(42, 100, 716, 250);
		add(dicePanel);
		
		//Add guess panel
		guessPanel = new GuessPanel(this);
		guessPanel.setBounds(42, 425, GuessPanel.WIDTH, GuessPanel.HEIGHT);
		add(guessPanel);
		
		//Add throw panel
		throwPanel = new ThrowPanel(this);
		throwPanel.setBounds(285, 380, 230, 170);
		add(throwPanel);
		
		//Add solution panel
		solutionPanel = new SolutionPanel(this);
		solutionPanel.setBounds(548, 375, 210, 355);
		add(solutionPanel);
		
		//Add tips panel
		tipsPanel = new TipsPanel(this);
		tipsPanel.setBounds(275, 560, 250, 195);
		add(tipsPanel);
		
		//Add background panel
		background = new Background();
		background.setBounds(0, 0, 800, 800);
		add(background);

		//Make frame visible
		setVisible(true);
	}
	
	/** Creates a new game. Resets all variables */	
	public void newGame() {
		
		//Reset guess variables
		guessPanel.ijsberen.setText("0");
		guessPanel.pinguins.setText("0");
		guessPanel.wakken.setText("0");
		
		//Reset solution variables
		solutionPanel.setSolution(0, 0, 0);
		//Reset guesses variables
		solutionPanel.setGuesses(0, 0, 0);
		
		//Reset throw variables
		throwPanel.amount.setText("0");
		
		//Make every current dice invisible
		for(Dice dice : dicePanel.diceArray) {
			dice.setVisible(false);
		}
		
		//Clear the dice in the dice aray
		dicePanel.diceArray.clear();
		
		//Reset tips panel
		tipsPanel.tip.setText(" Veel success!");
	}
	
	/** Amount of dice throws */
	int thrown = 0;

	/** Throws the dice
	 * @param num Number of dice to throw */
	public void throwDice(int num) {
		
		//Check if number is valid
		if (num >= 3 && num <= 12) {
			
			//Throw and draw the dice (twice because JSwing doesn't register first call
			dicePanel.throwDice(num);
			dicePanel.throwDice(num);
			
			//Add a throw
			thrown++;		
		} else {
			
			//Show error tip
			showTip("Je moet tussen de 3 en 12 dobbelstenen werpen!");
		}
	}
	
	/** Shows a tip
	 * @param tip Text to show */
	public void showTip (String tip) {
		tipsPanel.changeTip(tip);
	}
	
	/** Amount of guesses */
	int guesses = 0;
	/** Amount of wrong guesses */
	int wrong = 0;
	/** Amount of correct guesses */
	int correct = 0;
	
	/** Manage the guesses
	 * @param wakken Amount of wakken the user has guessed
	 * @param ijsberen Amount of ijsberen the user has guessed
	 * @param pinguins Amount of pinguins the user has guessed */
	public void manageGuess(int wakken, int ijsberen, int pinguins) {
		
		//Create solution variables
		int pinguinsSol = 0;
		int wakkenSol = 0;
		int ijsberenSol = 0;
		
		//Get solution
		for (Dice dice : dicePanel.diceArray) {
			pinguinsSol += dice.pinguins;
			wakkenSol += dice.wakken;
			ijsberenSol += dice.ijsberen;
		}
		
		//Check if the guesses are correct
		boolean isCorrect = true;
		
		if (pinguins != pinguinsSol) {
			guessPanel.pinguins.setBackground(guessPanel.wrongGuessColor);
			isCorrect = false;
		}
		if (wakken != wakkenSol) {
			guessPanel.wakken.setBackground(guessPanel.wrongGuessColor);
			isCorrect = false;
		}
		if (ijsberen != ijsberenSol) {
			guessPanel.ijsberen.setBackground(guessPanel.wrongGuessColor);
			isCorrect = false;
		}
		
		//Check if dice have been thrown
		if(dicePanel.diceArray.size() != 0) {
			//Add a guess to the guesses
			guesses++;
			
			//Add a correct or wrong guess
			if(isCorrect) {
				correct++;
			} else {
				wrong++;
				if (wrong > 2) {
					showTip ("IJsberen staan om wakken heen voor de vissen. Pinguins leven op de zuidpool.");
				}
			}
			
			//Fill the guesses textfield		
			solutionPanel.setGuesses(guesses, wrong, correct);
		} else {
			
			//Show error message
			showTip ("Je hebt nog geen dobbelstenen gegooid?");
		}
		
	}
	
	/** Sets the default text field
	 * @param textField JTextField to manipulate
	 * @param x Position on the x axis
	 * @param y Position on the y axis
	 * @param width Width of the JTextField
	 * @param height Height of the JTextField */
	public void setDefaultTextField (JTextField textField, int x, int y, int width, int height) {
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(27, 172, 66));
		textField.setFont(new Font("TAHOMA", Font.PLAIN, 17));
		textField.setBorder(BorderFactory.createEmptyBorder());
		textField.setBounds(x, y, width, height);
	}
	
	/** Sets the default button
	 * @param button JButton to manipulate
	 * @param x Position on the x axis
	 * @param y Position on the y axis
	 * @param width Width of the JButton
	 * @param height Height of the JButton */
	public void setDefaultButton (JButton button, int x, int y, int width, int height) {
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(8, 53, 20));
		button.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setBounds(x, y, width, height);
	}
	
	/** Sets the default label
	 * @param label JLabel to manipulate
	 * @param x Position on the x axis
	 * @param y Position on the y axis
	 * @param width Width of the JLabel
	 * @param height Height of the JLabel */
	public void setDefaultLabel (JLabel label, int x, int y, int width, int height) {
		label.setForeground(Color.WHITE);
		label.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		label.setBounds(x, y, width, height);
	}
	
	/** Shows the solution */	
	public void showSolution() {
		
		//Creates solution variables
		int pinguins = 0;
		int wakken = 0;
		int ijsberen = 0;
		
		//Get solution
		for (Dice dice : dicePanel.diceArray) {
			pinguins += dice.pinguins;
			wakken += dice.wakken;
			ijsberen += dice.ijsberen;
		}
		
		//Fill solution textfields
		solutionPanel.setSolution(pinguins, wakken, ijsberen);
	}
	
	/** Parse an int from string
	 * @param value String to parse
	 * @return If a number, return parsed value of int<br>If not a number, return 0 */
	public int parse (String value) {
		
		//Check if the user input is a number
		try {
			int i = Integer.parseInt(value);
			return i;
		} catch (NumberFormatException e) {
			showTip("Je mag alleen nummers invoeren!");
			return 0;
		}
	}
}
