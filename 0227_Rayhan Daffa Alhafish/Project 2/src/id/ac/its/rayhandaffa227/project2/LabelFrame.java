package id.ac.its.rayhandaffa227.project2;

import java.awt.FlowLayout;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants; 
import javax.swing.Icon;
import javax.swing.ImageIcon; 

public class LabelFrame extends JFrame
{
	private final JLabel labelA; 
	private final JLabel labelB; 
	
	public LabelFrame()
	{
		super("Testing JLabel");
		setLayout(new FlowLayout());
		
		labelA = new JLabel("05111940000227");
		labelA.setToolTipText("NRP");
		add(labelA);
		
		Icon foto = new ImageIcon(getClass().getResource("patrick.jpg"));
		
		labelB = new JLabel();
		labelB.setText("Rayhan Daffa Alhafish");
		labelB.setIcon(foto);
		labelB.setHorizontalTextPosition(SwingConstants.CENTER);
		labelB.setVerticalTextPosition(SwingConstants.BOTTOM);
		labelB.setToolTipText("Nama dan Foto");
		add(labelB);
		
		
	}
}
