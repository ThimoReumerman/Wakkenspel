package wakkenspel;

import javax.swing.JFrame;

/**
 * The MainFrame class creates the JFrame where all the other panels will be running on
 * @author Thimo Reumerman 97050932
 * @since 4-12-2019 
 * @version 0.3
 */
public class MainFrame extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	
	/** The background panel */
	private Background background;
	
	/**
	 * Creates main JFrame and adds all the panels
	 * @see JFrame
	 */
	public MainFrame() {
		
		//Set frame name
		super("Wakkenspel");
		
		//Set the Mainframe properties
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add panels
		background = new Background();
		add(background);
		
		//Make frame visible
		setVisible(true);
	}
	

}
