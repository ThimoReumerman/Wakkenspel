package wakkenspel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ThrowPanel extends JPanel implements ActionListener {
	
	/**	 */
	private static final long serialVersionUID = 1L;
	
	/** Color of the GuessPanel */
	private Color color = new Color(0, 0, 0, 90);
	
	/** Label of the icon */
	private JLabel iconLabel;
	/** Label of the title */
	private JLabel title;
	/** Textfield of the amount of dice */
	private JTextField amount;
	/** Button to draw the dice */
	private JButton throwDice;
	
	MainFrame mainFrame;

	public ThrowPanel(MainFrame _mainFrame) {
		
		//Set color of panel
		setOpaque(true);
		setBackground(color);
		
		mainFrame = _mainFrame;
		
		//Disable layout
		setLayout(null);

		//Create middle variable
		int middle = 115;
		
		//Set icon label
		ImageIcon icon = new ImageIcon("images/dice.png");
		iconLabel = new JLabel(icon);
		iconLabel.setBounds(middle - icon.getIconWidth() / 2, 22, icon.getIconWidth(), icon.getIconHeight());
		add(iconLabel);
		
		//Set title label
		title = new JLabel("DOBBELSTENEN", SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("TAHOMA", Font.PLAIN, 22));
		int titleWidth = 230;
		title.setBounds(middle - titleWidth / 2, 90, titleWidth, 22);
		add(title);
		

		//Set amount textfield
		amount = new JTextField("0");
		amount.setHorizontalAlignment(SwingConstants.RIGHT);
		amount.setForeground(Color.WHITE);
		amount.setBackground(new Color(27, 172, 66));
		amount.setFont(new Font("TAHOMA", Font.PLAIN, 17));
		amount.setBorder(BorderFactory.createEmptyBorder());
		amount.setBounds(30, 126, 50, 22);
		add(amount);
		

		//Set throw button
		throwDice = new JButton("Werpen");
		throwDice.setForeground(Color.WHITE);
		throwDice.setBackground(new Color(8, 53, 20));
		throwDice.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		throwDice.setBorderPainted(false);
		throwDice.setFocusPainted(false);
		throwDice.setBounds(92, 121, 125, 35);
		add(throwDice);
		throwDice.addActionListener(this);
	}
	
	private int parse (String value) {
		try {
			int i = Integer.parseInt(value);
			return i;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(throwDice.isEnabled()) {
			int diceNum = parse(amount.getText());
			
			mainFrame.throwDice(diceNum);
		}
		
	}

}
