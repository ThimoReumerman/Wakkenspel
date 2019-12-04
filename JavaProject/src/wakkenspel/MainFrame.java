package wakkenspel;

import javax.swing.JFrame;

/**
 * The MainFrame class creates the JFrame where all the other panels will be running on
 * @author Thimo Reumerman 97050932
 * @since 4-12-2019 
 * @version 0.2
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MainFrame() {
		
		//Set frame name
		super("Wakkenspel");
		
		//Set the Mainframe properties
		setLayout(null);
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Make frame visible
		setVisible(true);
	}
	

}
