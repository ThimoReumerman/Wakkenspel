package wakkenspel;

/**
 * The GameManager class manages the game.
 * @author Thimo Reumerman 97050932
 * @since 4-12-2019 
 * @version 0.1
 */
public class GameManager {
	MainFrame mainFrame;
	
	public GameManager(MainFrame _mainFrame) {
		mainFrame = _mainFrame;
	}
	
	/** Create a new game */
	public void newGame() {
		System.out.println("Starting new game");
		mainFrame.dicePanel.throwDice();
	
	}
}
