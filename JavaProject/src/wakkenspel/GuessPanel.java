package wakkenspel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The GuessPanel class creates the guess panel
 * @author Thimo Reumerman 97050932
 * @since 5-12-2019 
 * @version 0.1
 */
public class GuessPanel extends JPanel implements ActionListener {
	/** */
	private static final long serialVersionUID = 1L;
	
	/** Width of the GuessPanel */
	public static int WIDTH = 210;
	/** Height of the GuessPanel */
	public static int HEIGHT = 275;
	
	/** Color of the GuessPanel */
	private Color color = new Color(0, 0, 0, 90);
	
	/** Label of the icon */
	private JLabel iconLabel;
	/** Label of the title **/
	private JLabel title;
	/** Textfield of the wakken */
	private JTextField wakken;
	/** Label of the wakken */
	private JLabel wakkenLabel;
	/** Textfield of the ijsberen */
	private JTextField ijsberen;
	/** Label of the ijsberen */
	private JLabel ijsberenLabel;
	/** Textfield of the pinguins */
	private JTextField pinguins;
	/** Label of the pinguins */
	private JLabel pinguinsLabel;
	/** Button to check the values of the guessed variables */
	private JButton check;
	
	MainFrame mainFrame;
	
	/** Constructor that draws the GuessPanel and its attributes */
	public GuessPanel(MainFrame _mainFrame) {
		mainFrame = _mainFrame;
		
		//Set color of panel
		setOpaque(true);
		setBackground(color);
		
		//Disable layout
		setLayout(null);
		
		//Create middle variable
		int middle = WIDTH / 2;
		
		//Set icon label
		ImageIcon icon = new ImageIcon("images/questionmark.png");
		iconLabel = new JLabel(icon);
		iconLabel.setBounds(middle - icon.getIconWidth() / 2, 22, icon.getIconWidth(), icon.getIconHeight());
		add(iconLabel);

		//Set title label
		title = new JLabel("RADEN", SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("TAHOMA", Font.PLAIN, 22));
		int titleWidth = 150;
		title.setBounds(middle - titleWidth / 2, 80, titleWidth, 22);
		add(title);
		
		//Set wakken textfield
		wakken = new JTextField("0");
		wakken.setHorizontalAlignment(SwingConstants.RIGHT);
		wakken.setForeground(Color.WHITE);
		wakken.setBackground(new Color(27, 172, 66));
		wakken.setFont(new Font("TAHOMA", Font.PLAIN, 17));
		wakken.setBorder(BorderFactory.createEmptyBorder());
		wakken.setBounds(30, 120, 50, 22);
		add(wakken);
		
		//Set wakken label
		wakkenLabel = new JLabel("Wakken");
		wakkenLabel.setForeground(Color.WHITE);
		wakkenLabel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		wakkenLabel.setBounds(100, 120, 100, 25);
		add(wakkenLabel);
		
		//Set ijsberen textfield
		ijsberen = new JTextField("0");
		ijsberen.setHorizontalAlignment(SwingConstants.RIGHT);
		ijsberen.setForeground(Color.WHITE);
		ijsberen.setBackground(new Color(27, 172, 66));
		ijsberen.setFont(new Font("TAHOMA", Font.PLAIN, 17));
		ijsberen.setBorder(BorderFactory.createEmptyBorder());
		ijsberen.setBounds(30, 150, 50, 22);
		add(ijsberen);
		
		//Set ijsberen label
		ijsberenLabel = new JLabel("IJsberen");
		ijsberenLabel.setForeground(Color.WHITE);
		ijsberenLabel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		ijsberenLabel.setBounds(100, 150, 100, 25);
		add(ijsberenLabel);
		
		//Set pinguins textfield
		pinguins = new JTextField("0");
		pinguins.setHorizontalAlignment(SwingConstants.RIGHT);
		pinguins.setForeground(Color.WHITE);
		pinguins.setBackground(new Color(27, 172, 66));
		pinguins.setFont(new Font("TAHOMA", Font.PLAIN, 17));
		pinguins.setBorder(BorderFactory.createEmptyBorder());
		pinguins.setBounds(30, 180, 50, 22);
		add(pinguins);
		
		//Set ijsberen label
		pinguinsLabel = new JLabel("Pinguïns");
		pinguinsLabel.setForeground(Color.WHITE);
		pinguinsLabel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		pinguinsLabel.setBounds(100, 180, 100, 25);
		add(pinguinsLabel);
		
		//Set check button
		check = new JButton("Controleren");
		check.setForeground(Color.WHITE);
		check.setBackground(new Color(8, 53, 20));
		check.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		check.setBorderPainted(false);
		check.setFocusPainted(false);
		check.setBounds(middle - 140 / 2, 220, 140, 35);
		add(check);
		check.addActionListener(this);
		
		
	}
	
	/** Parse an int from string
	 * 
	 * @param value String to parse
	 * @return If a number, return parsed value of int<br>If not a number, return 0
	 */
	private int parse (String value) {
		try {
			int i = Integer.parseInt(value);
			return i;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	/** Check for check button click and check the entered values*/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(check.isEnabled()) {			
			int wakkenNum = parse(wakken.getText());
			int ijsberenNum = parse(ijsberen.getText());
			int pinguinsNum = parse(pinguins.getText());
			
			System.out.println("Wakken: " + wakkenNum);
			System.out.println("IJsberen: " + ijsberenNum);
			System.out.println("Pinguins: " + pinguinsNum);
		}
		
	}

}
