package id.ac.its.erza153.fp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JPanel;

public class SaveScore extends JPanel implements Serializable, ActionListener{
	private int score;
	private String name;
	private int DESIRED_WIDTH=450 ;
	
	public SaveScore(String name,int score) {
		this.score=score;
		this.name=name;
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(PuzzleEx.isInGame()) {
			textScore(g);
		}
	
	}
	
	//me
	private void textScore(Graphics g) {
    	
    	String player= "Player : "+this.name;
    	System.out.println(player);
    	Font small = new Font("Helvetica", Font.BOLD, 14);
	    FontMetrics fm2 = getFontMetrics(small);
	    g.setColor(Color.black);
        g.setFont(small);
        g.drawString(player, 200,250);
    	
	}
	
	public void puzzleScore() {
		Time stop=new Time();
		this.score= stop.currentTime *20;
	}
	
	public int getScore() {
		return score;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		repaint();
		
	}
}
