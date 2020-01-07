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

public class SolutionPanel extends JPanel implements ActionListener {

	/** */
	private static final long serialVersionUID = 1L;
	
	/** Color of the GuessPanel */
	private Color color = new Color(0, 0, 0, 90);
	
	/** Label of the icon */
	private JLabel iconLabel;
	/** Label of the title **/
	private JLabel title;
	/** Button to show solution */
	private JButton show;
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
	
	MainFrame mainFrame;
	
	/** Constructor that draws the GuessPanel and its attributes */
	public SolutionPanel(MainFrame _mainFrame) {
		mainFrame = _mainFrame;
		
		//Set color of panel
		setOpaque(true);
		setBackground(color);
		
		//Disable layout
		setLayout(null);
		
		//Create middle variable
		int middle = 210 / 2;
		
		//Set icon label
		ImageIcon icon = new ImageIcon("images/oplossing.png");
		iconLabel = new JLabel(icon);
		iconLabel.setBounds(middle - icon.getIconWidth() / 2, 5, icon.getIconWidth(), icon.getIconHeight());
		add(iconLabel);

		//Set title label
		title = new JLabel("OPLOSSING", SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("TAHOMA", Font.PLAIN, 22));
		int titleWidth = 150;
		title.setBounds(middle - titleWidth / 2, 76, titleWidth, 22);
		add(title);
		
		//Set show button
		show = new JButton("Laat zien");
		show.setForeground(Color.WHITE);
		show.setBackground(new Color(8, 53, 20));
		show.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		show.setBorderPainted(false);
		show.setFocusPainted(false);
		show.setBounds(30, 105, 150, 35);
		add(show);
		show.addActionListener(this);
		
		//Set wakken textfield
		wakken = new JTextField("0");
		wakken.setHorizontalAlignment(SwingConstants.RIGHT);
		wakken.setForeground(Color.WHITE);
		wakken.setBackground(new Color(27, 172, 66));
		wakken.setFont(new Font("TAHOMA", Font.PLAIN, 17));
		wakken.setBorder(BorderFactory.createEmptyBorder());
		wakken.setBounds(30, 155, 50, 22);
		wakken.setEditable(false);
		add(wakken);
		
		//Set wakken label
		wakkenLabel = new JLabel("Wakken");
		wakkenLabel.setForeground(Color.WHITE);
		wakkenLabel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		wakkenLabel.setBounds(100, 155, 100, 25);
		add(wakkenLabel);
		
		//Set ijsberen textfield
		ijsberen = new JTextField("0");
		ijsberen.setHorizontalAlignment(SwingConstants.RIGHT);
		ijsberen.setForeground(Color.WHITE);
		ijsberen.setBackground(new Color(27, 172, 66));
		ijsberen.setFont(new Font("TAHOMA", Font.PLAIN, 17));
		ijsberen.setBorder(BorderFactory.createEmptyBorder());
		ijsberen.setBounds(30, 185, 50, 22);
		ijsberen.setEditable(false);
		add(ijsberen);
		
		//Set ijsberen label
		ijsberenLabel = new JLabel("IJsberen");
		ijsberenLabel.setForeground(Color.WHITE);
		ijsberenLabel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		ijsberenLabel.setBounds(100, 185, 100, 25);
		add(ijsberenLabel);
		
		//Set pinguins textfield
		pinguins = new JTextField("0");
		pinguins.setHorizontalAlignment(SwingConstants.RIGHT);
		pinguins.setForeground(Color.WHITE);
		pinguins.setBackground(new Color(27, 172, 66));
		pinguins.setFont(new Font("TAHOMA", Font.PLAIN, 17));
		pinguins.setBorder(BorderFactory.createEmptyBorder());
		pinguins.setBounds(30, 215, 50, 22);
		pinguins.setEditable(false);
		add(pinguins);
		
		//Set ijsberen label
		pinguinsLabel = new JLabel("Pingu�ns");
		pinguinsLabel.setForeground(Color.WHITE);
		pinguinsLabel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
		pinguinsLabel.setBounds(100, 215, 100, 25);
		add(pinguinsLabel);
		
		
	}
	
	public void setSolution(int pinguinsNum, int wakkenNum, int ijsberenNum) {
		
		pinguins.setText(Integer.toString(pinguinsNum));
		wakken.setText(Integer.toString(wakkenNum));
		ijsberen.setText(Integer.toString(ijsberenNum));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(show.isEnabled()) {
			System.out.println("Enabled.");
			mainFrame.showSolution();
		}
		
	}
	
	

}