package id.ac.its.erza153.fp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Time extends JPanel implements ActionListener{
	protected static int currentTime;
	protected static Timer timer;
	private int DESIRED_WIDTH=450 ;
	
	//constructor
	public Time() {
		this.currentTime=0;
		setPreferredSize(new Dimension(DESIRED_WIDTH,40));
		timer=new Timer(1000,this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(PuzzleEx.isInGame()) {
			
			textTime(g);
		}
	
		
	}
	
	 private void textTime(Graphics g) {
	    	
	    	String msg= currentTime/60 + ":" + currentTime % 60;
	    	System.out.println(msg);
	    	Font small = new Font("Helvetica", Font.BOLD, 14);
		    FontMetrics fm = getFontMetrics(small);
		    g.setColor(Color.black);
	        g.setFont(small);
	        g.drawString("Time Elapsed : "+msg, 5,15);
	   
		}

	
	public void Update() {
		currentTime++;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Update();
		repaint();
		
	}
	
}
