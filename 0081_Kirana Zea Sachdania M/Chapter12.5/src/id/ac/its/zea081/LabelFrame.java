package id.ac.its.zea081;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame
{
	private final JLabel label3;
	
	public LabelFrame()
	{
		super("Testing JLabel");
		setLayout(new FlowLayout());
		
		Icon bug = new ImageIcon(getClass().getResource("bug1.jpg"));
		
		label3 = new JLabel();
		label3.setText("NRP dan Nama");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		add(label3);
	}
}
