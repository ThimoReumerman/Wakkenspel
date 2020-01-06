package wakkenspel;

import javax.swing.SwingUtilities;

/**
 * The only function of the Application class is to enable the MainFrame
 * @author Thimo Reumerman 97050932
 * @since 4-12-2019 
 * @version 0.2
 */
public class Application {
	
	/** The title of the application */
	public static String title = "Wakkenspel";
	
	/**
	 * Calls the MainFrame
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable () {
			public void run() {
				MainFrame mainFrame = new MainFrame();
			}
		});
		
	}

}
