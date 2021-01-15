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
	
	private int DESIRED_WIDTH=500;
	private static Font ft1=new Font("Montserrat",Font.BOLD,30);
	private static Font ft2=new Font("Montserrat",Font.BOLD,20);
	private static Font ft3=new Font("Montserrat",Font.BOLD,15);
	
	//constructor LeaderBoard
	public LeaderBoard() {
		highScore=new Score();
		initUI();
	}
	
	//Mengatur ukuran panel LeaderBoard, warna background, dan setVisible(true) untuk menampilkan panel
	public void initUI() {

		setPreferredSize(new Dimension(DESIRED_WIDTH,450));
		setBackground(Color.BLACK);
		this.setVisible(true);
		
       
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw((Graphics2D)g);
	}

	//Proses menampilkan komponen2 pada panel LeaderBoard
	//Mengatur warna tulisan
	//Memanggil method drawCenteredString untuk menggambar string
	private void draw(Graphics2D g) {
		g.setBackground(Color.BLACK);
		
		g.setColor(new Color(230, 255, 255));
		drawCenteredString(g,"Congratulations!",ft1,80);
		
		g.setColor(new Color(242, 242, 242));
		drawCenteredString(g,"You solve the puzzle in "+Time.currentTime+" second",ft2,120);
		
		g.setColor(new Color(230, 255, 255));
		drawCenteredString(g,"High Scores: ",ft2,180);
				
		//high Score
		int i = 0,max=10;
		int y=210;
        int a = highScore.getHighscoreString().size();
        if (a > max) {
        	a = max;
        }
        while (i < a) {
        		String scores = (i + 1) + "." + highScore.getHighscoreString().get(i).getName() + " " + highScore.getHighscoreString().get(i).getScore();
        		
        		g.setColor(new Color(242, 242, 242));
        		drawCenteredString(g,scores,ft3,y);
        		i++;
        		y+=20;
        	}
        
        
        }
		

	//Mengatur posisi String yang akan digambar agar terletak ditengah-tengah panel LeaderBoard
	//Terdapat String text pada parameter untuk string yang akan digambar
	//Terdapat Font font pada parameter untuk mengatur font tulisan
	//Terdapat variabel y pada parameter untuk mengatur posisi string pada sumbu y
	public void drawCenteredString(Graphics g, String text, Font font, int y) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (DESIRED_WIDTH - metrics.stringWidth(text)) / 2;
        g.setFont(font);
        g.drawString(text, x, y);
    }
	
	
}
