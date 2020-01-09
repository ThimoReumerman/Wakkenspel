package wakkenspel;

import javax.swing.SwingUtilities;

/** The Application class creates the mainFrame
 * @author Thimo Reumerman 97050932 */
public class Application {
	
	/** The title of the application */
	public static String title = "Wakkenspel";
	
	/** Calls the MainFrame */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable () {
			public void run() {
				MainFrame mainFrame = new MainFrame();
			}
		});	
	}
}
