package wakkenspel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThrowPanel extends JPanel implements ActionListener {
	
	/**	 */
	private static final long serialVersionUID = 1L;
	
	/** Color of the GuessPanel */
	private Color color = new Color(0, 0, 0, 90);
	
	private JLabel iconLabel;

	public ThrowPanel() {
		
		//Set color of panel
		setOpaque(true);
		setBackground(color);
		
		//Disable layout
		setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
