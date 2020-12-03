package id.ac.its.erza153;

import javax.swing.JFrame; //basic window features
import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JLabel; // displays text and images
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; //load images

public class LabelFrame extends JFrame {

	private final JLabel label1; 
	
	public LabelFrame() {
		
		super("Testing JLabel");
		setLayout(new FlowLayout()); //set frame layout
		
		
		Icon bug = new ImageIcon(getClass().getResource("me.png"));
		
		//JLabel constructor no arguments
		label1 = new JLabel(); // JLabel constructor no arguments
		label1.setText("Erza Janitradevi Nadine 05111940000153");
		label1.setIcon(bug); // add icon to JLabel
		
		//set position
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setVerticalTextPosition(SwingConstants.BOTTOM);
		label1.setToolTipText("Photo");
		add(label1);
		
		
	}





}
