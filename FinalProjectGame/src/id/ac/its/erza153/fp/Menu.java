package id.ac.its.erza153.fp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Menu extends JFrame{
	
	private String playerName;
	private static int DESIRED_WIDTH=500 ;
	private static Font ft1=new Font("ComicSans",Font.BOLD,30);
	private static Font ft2=new Font("ComicSans",Font.BOLD,20);
	private static Font ft3=new Font("ComicSans",Font.BOLD,15);

	
	public Menu(int num,String player) {
		this.playerName=player;
		initUI(num);
		
		//initLeaderBoard();
	}
	
	
	private void initUI(int num) {
		add(new PuzzleEx(num,playerName),BorderLayout.SOUTH);
		add(new Time(),BorderLayout.CENTER);
		pack();
        setTitle("Puzzle");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.dispose(); 
      
	}

	public static void main(String[] args) {
		//Menu menu=new Menu(9);
		initGame();
	
		

	}
	
	public static void initGame() {
		
		String[] options1 = {"Play Game","High Scores" ,"Quit Game","Credits"} ;
    	// JOptionPane untuk menu screen
		int input1 = JOptionPane.showOptionDialog(null, 
				"Welcome to Puzzle Game!", 
				"Menu", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, options1[0]) ;
		
		//play game
		if(input1==0) {
			playGame();
		}
		else if(input1==1) {
			Score highscore=new Score();
			highscore.getHighscoreString();
		}
		else if(input1==2) {
			quitGame();
		}
		else if(input1==3) {
			creditGame();
		}
	}

	public static void playGame() {
	//input player's name
		JTextField name=new JTextField();
		Object[] fields= {
				"Enter your name ",name
		};
		String player=""; //inisialisasi kosong
		int input=JOptionPane.showConfirmDialog(null, fields, 
				"Player Name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(input==JOptionPane.OK_OPTION) {
			System.out.println(name.getText());
			player=name.getText();
			
		
		}
		if(input==JOptionPane.CANCEL_OPTION) {
			initGame();
		}
		
	//pilihan level
		String[] options2 = {"Easy", "Medium", "Hard"} ;
		
	// JOptionPane untuk memilih level
		int input2 = JOptionPane.showOptionDialog(null, 
				"Choose Level", 
				"Puzzle", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]) ;
		
		//set levelnya
		//easy
		int num=9;
		//medium
		if(input2==1) {
			num=16;
		}
		//hard
		else if(input2==2) {
			num=25;
		}
        Menu puzzle=new Menu(num,player);
        puzzle.setVisible(true);

	}
	
	public static void quitGame() {
	//pilihan Yes untuk keluar game dan pilihan No untuk kembali ke Game
		String[] options3 = {"Yes","No"} ;
		
	// JOptionPane untuk quitGame
		int input3 = JOptionPane.showOptionDialog(null, 
				"Are you sure you want to Quit Game?", 
				"Quit Game", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_OPTION, null, options3, options3[0]) ;
		
		//Yes : keluar game
		if(input3==0) {
			System.exit(0);
			
		}
		//No : kembali ke game
		else if(input3==1) {
			initGame();
		}
	}
	
	public static void creditGame() {
		JFrame window = new JFrame("Credits"); 
		window.add(new JLabel());
		
		//casting Graphics
		Graphics2D g = null;
		draw((Graphics2D)g);
		
		window.pack();
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	
	private static void draw(Graphics2D g) {
		g.setBackground(Color.WHITE);
		
		g.setColor(new Color(98, 95, 145));
		drawCenteredString(g,"Final Project Pemograman Berbasis Objek",ft1,50);
		
		drawCenteredString(g,"Puzzle Game ",ft2,100);
		drawCenteredString(g,"Referensi : http://zetcode.com/javagames/puzzle/ ",ft3,100);
		drawCenteredString(g,"Credit by:",ft2,100);
		drawCenteredString(g,"Kirana Zea S.M. - 05111940000081",ft3,100);
		drawCenteredString(g,"Rayhan Daffa A - 051119400000227",ft3,100);
		drawCenteredString(g,"Rayhan Daffa A - 051119400000227",ft3,100);
		drawCenteredString(g,"Pemograman Berbasis Objek kelas E, Informatika - ITS\\",ft3,100);
		
		
		
	}
	
	public static void drawCenteredString(Graphics g, String text, Font font, int y) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (DESIRED_WIDTH - metrics.stringWidth(text)) / 2;

        g.setFont(font);
        g.drawString(text, x, y);
    }
}