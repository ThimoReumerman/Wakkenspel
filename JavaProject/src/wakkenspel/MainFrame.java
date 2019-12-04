package wakkenspel;

import javax.swing.JFrame;

/**
 * The MainFrame class creates the JFrame where all the other panels will be running on
 * @author Thimo Reumerman 97050932
 * @since 4-12-2019 
 * @version 0.4
 */
public class MainFrame extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;

	
	/** The background panel */
	private Background background;
	
	private Header header;
	
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
		header = new Header();
		header.setBounds(0, 0, 800, Header.HEIGHT);
		add(header);
		
		background = new Background();
		background.setBounds(0, 0, 800, 800);
		add(background);
		
		//Make frame visible
		setVisible(true);
	}
	

}
