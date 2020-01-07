package wakkenspel;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * The MainFrame class creates the JFrame where all the other panels will be running on
 * @author Thimo Reumerman 97050932
 * @since 4-12-2019 
 * @version 0.5
 */
public class MainFrame extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;

	
	/** The background panel */
	public Background background;
	
	public Header header;
	
	public DicePanel dicePanel;
	
	public GuessPanel guessPanel;
	
	public ThrowPanel throwPanel;
	
	public SolutionPanel solutionPanel;
	
	public TipsPanel tipsPanel;
	
	/**
	 * Creates main JFrame and adds all the panels
	 * @see JFrame
	 */
	public MainFrame() {
	

		//Set frame name
		super(Application.title);
		
		//Set the Mainframe properties
		setSize(800, 800);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Disable layout
		setLayout(null);
		
		//Add panels
		header = new Header(this);
		header.setBounds(0, 0, 800, Header.HEIGHT);
		add(header);
		
		int dPX = (800-716) / 2;
		dicePanel = new DicePanel(716, 250);
		dicePanel.setBounds(dPX, 100, 716, 250);
		add(dicePanel);
		
		guessPanel = new GuessPanel(this);
		guessPanel.setBounds(dPX, 425, GuessPanel.WIDTH, GuessPanel.HEIGHT);
		add(guessPanel);
		
		throwPanel = new ThrowPanel(this);
		int tPX = (800-230) / 2;
		throwPanel.setBounds(tPX, 380, 230, 170);
		add(throwPanel);
		
		solutionPanel = new SolutionPanel(this);
		solutionPanel.setBounds(548, 375, 210, 355);
		add(solutionPanel);
		
		tipsPanel = new TipsPanel(this);
		tipsPanel.setBounds(275, 560, 250, 195);
		add(tipsPanel);
		
		background = new Background();
		background.setBounds(0, 0, 800, 800);
		add(background);

		//Make frame visible
		setVisible(true);
	}
	
	public void newGame() {
		guessPanel.ijsberen.setText("0");
		guessPanel.pinguins.setText("0");
		guessPanel.wakken.setText("0");
		
		solutionPanel.setSolution(0, 0, 0);
		solutionPanel.setGuesses(0, 0, 0);
		
		throwPanel.amount.setText("0");
		
		for(Dice dice : dicePanel.diceArray) {
			dice.setVisible(false);
		}
		
		tipsPanel.tip.setText(" Veel success!");
		
		dicePanel.diceArray.clear();
	}
	
	int thrown = 0;

	public void throwDice(int num) {
		
		if (num >= 3 && num <= 12) {
			System.out.println("Throwing " + num + " dice.");
			dicePanel.throwDice(num);
			dicePanel.throwDice(num);
			thrown += 1;		
		} else {
			showTip("Je moet tussen de 3 en 12 dobbelstenen werpen!");
		}
	}
	
	public void showTip (String tip) {
		tipsPanel.changeTip(tip);
	}
	
	public void getSolution () {
		
	}
	
	int guesses = 0;
	int wrong = 0;
	int correct = 0;
	public void manageGuess(int wakken, int ijsberen, int pinguins) {
		int pinguinsSol = 0;
		int wakkenSol = 0;
		int ijsberenSol = 0;
		
		System.out.println("Showing solution...");
		for (Dice dice : dicePanel.diceArray) {
			pinguinsSol += dice.pinguins;
			wakkenSol += dice.wakken;
			ijsberenSol += dice.ijsberen;
		}
		
		boolean isCorrect = true;
		
		if(pinguins != pinguinsSol || wakken != wakkenSol || ijsberen != ijsberenSol) {
			isCorrect = false;
		}
		
		guesses++;
		if(isCorrect) {
			correct++;
		} else {
			wrong++;
		}
		
		solutionPanel.setGuesses(guesses, wrong, correct);
	}
	
	public void showSolution() {
		int pinguins = 0;
		int wakken = 0;
		int ijsberen = 0;
		
		System.out.println("Showing solution...");
		for (Dice dice : dicePanel.diceArray) {
			pinguins += dice.pinguins;
			wakken += dice.wakken;
			ijsberen += dice.ijsberen;
		}
		
		solutionPanel.setSolution(pinguins, wakken, ijsberen);
	}
	

}
