package id.ac.its.erza153.fp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LeaderBoard extends JPanel{
	
	private Score highScore;
	
	private int DESIRED_WIDTH=500 ;
	private static Font ft1=new Font("ComicSans",Font.BOLD,30);
	private static Font ft2=new Font("ComicSans",Font.BOLD,20);
	private static Font ft3=new Font("ComicSans",Font.BOLD,15);
	
	public LeaderBoard() {
		highScore=new Score();
		initUI();
	}
	
	public void initUI() {
//			
//		this.add(new JLabel("<html>Congratulations<br>" +"<br> You solve the puzzle in "+Time.currentTime+" second<br>"+""+
//				"<br>High Scores<br>" + highScore.getHighscoreString()), 
//				   BorderLayout.CENTER,
//				   SwingConstants.CENTER);
//		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		setPreferredSize(new Dimension(DESIRED_WIDTH,450));
		this.setVisible(true);
		
       
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw((Graphics2D)g);
	}

	private void draw(Graphics2D g) {
		g.setBackground(Color.WHITE);
		g.setColor(new Color(98, 95, 145));
		g.setFont(new Font("ComicSans",Font.BOLD,30));
		drawCenteredString(g,"Congratulations",ft1,50);
		
		g.setColor(new Color(76, 75, 93));
		drawCenteredString(g,"You solve the puzzle in "+Time.currentTime+" second",ft2,150);
				
		//high Score
		
		int i = 0,max=10;
        int a = highScore.getHighscoreString().size();
        if (a > max) {
        	a = max;
        }
        while (i < 10) {
        		String scores = (i + 1) + "." + highScore.getHighscoreString().get(i).getName() + " " + highScore.getHighscoreString().get(i).getScore();
        		int y=200;
        		g.setColor(new Color(76, 75, 93));
        		drawCenteredString(g,"High Scores"+ scores,ft3,y);
        		i++;
        		y+=20;
        	}
        
        
        }
		
	
	

	//supaya String terletak ditengah-tengah JPanel
	public void drawCenteredString(Graphics g, String text, Font font, int y) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (DESIRED_WIDTH - metrics.stringWidth(text)) / 2;
        g.setFont(font);
        g.drawString(text, x, y);
    }
	
	
}
