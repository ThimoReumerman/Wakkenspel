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
	
	GameManager manager;
	
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
		
		throwPanel = new ThrowPanel();
		int tPX = (800-230) / 2;
		throwPanel.setBounds(tPX, 380, 230, 170);
		add(throwPanel);
		
		background = new Background();
		background.setBounds(0, 0, 800, 800);
		add(background);

		//Make frame visible
		setVisible(true);
	}
	

}
