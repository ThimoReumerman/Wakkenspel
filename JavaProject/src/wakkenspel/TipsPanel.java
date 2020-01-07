package wakkenspel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class TipsPanel extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;
	
	/** Color of the TipsPanel */
	private Color color = new Color(0, 0, 0, 90);
	
	/** Label of the icon */
	private JLabel iconLabel;
	/** Label of the title **/
	private JLabel title;
	
	public JTextArea tip;
	MainFrame mainFrame;

	public TipsPanel(MainFrame _mainFrame) {
		
		//Set color of panel
		setOpaque(false);
		setLayout(null);
		
		mainFrame = _mainFrame;
		
		//Disable layout

		//Create middle variable
		int middle = 122;
		
		//Set icon label
		ImageIcon icon = new ImageIcon("images/tips.png");
		iconLabel = new JLabel(icon);
		iconLabel.setBounds(middle - icon.getIconWidth() / 2, 15, icon.getIconWidth(), icon.getIconHeight());
		add(iconLabel);
		
		//Set title label
		title = new JLabel("TIPS", SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("TAHOMA", Font.PLAIN, 22));
		int titleWidth = 275;
		title.setBounds(middle - titleWidth / 2, 75, titleWidth, 22);
		add(title);
		
		//Set tip textfield

		tip = new JTextArea(" Veel success!");
		tip.setLineWrap(true);
		tip.setForeground(Color.WHITE);
		tip.setBackground(new Color(27, 172, 66));
		tip.setFont(new Font("TAHOMA", Font.PLAIN, 15));
		tip.setBorder(BorderFactory.createEmptyBorder());
		tip.setBounds(30, 110, 190, 70);
		tip.setEditable(false);
		add(tip);
	}
	
	public void paintComponent(Graphics g) {
		//Set super paint component
		super.paintComponent(g);
		
		//Enable anti aliasing
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(color);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public void changeTip (String tipText) {
		tip.setText(" " + tipText);
	}
}
