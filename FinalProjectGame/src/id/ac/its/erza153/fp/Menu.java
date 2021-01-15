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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Menu extends JFrame{
	
	private String playerName;
	private static int DESIRED_WIDTH=500 ;
	private static Font ft1=new Font("Montserrat",Font.BOLD,25);
	private static Font ft2=new Font("Montserrat",Font.BOLD,20);
	private static Font ft3=new Font("Montserrat",Font.BOLD,15);

	//constructor Menu 
	public Menu(int num,String player) {
		this.playerName=player;
		initUI(num);
	
	}
	
	//constructor Menu
	public Menu() {
		creditGame();
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
		
		String[] options1 = {"Play Game" ,"Quit Game","Credits"} ;
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
			quitGame();
		}
		else if(input1==2) {
			new Menu();
		}
	}

	//Menampilkan pilihan yang ada ketika memilih play game pada menu
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
		
		//Mengatur nilai num sesuai level yang telah dipilih
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
        //Setelah memilih level, game akan dimulai
        puzzle.setVisible(true);

	}
	
	//Menampilkan pilihan yang ada ketika memilih quit game pada menu
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
	
	//Menampilkan credit game ketika memilih credits pada menu game
	public void creditGame() {
		
		add(new credit());
			
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setVisible(true);
	}

	//Mengatur posisi String yang akan digambar agar terletak ditengah-tengah panel LeaderBoard
	//Terdapat String text pada parameter untuk string yang akan digambar
	//Terdapat Font font pada parameter untuk mengatur font tulisan
	//Terdapat variabel y pada parameter untuk mengatur posisi string pada sumbu y
	public static void drawCenteredString(Graphics g, String text, Font font, int y) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (DESIRED_WIDTH - metrics.stringWidth(text)) / 2;

        g.setFont(font);
        g.drawString(text, x, y);
    }
	
	//Inner class yang merupakan inheritance dari JPanel
	class credit extends JPanel{
		
		//Megatur ukuran panel credits
		public credit() {
			setPreferredSize(new Dimension(DESIRED_WIDTH,450));
		}
		
		//Proses menggambar komponen2 pada panel credits
		@Override
		public void paintComponent(Graphics g) {
			((Graphics2D) g).setBackground(Color.WHITE);
			
			g.setColor(new Color(230, 255, 255));
			drawCenteredString(g,"Final Project",ft1,70);
			drawCenteredString(g,"Pemograman Berbasis Objek",ft1,100);
			drawCenteredString(g,"Puzzle Game ",ft2,150);
		
			g.setColor(new Color(242, 242, 242));
			drawCenteredString(g,"Referensi : http://zetcode.com/javagames/puzzle/ ",ft3,170);
			
			g.setColor(new Color(230, 255, 255));
			drawCenteredString(g,"Credit by:",ft2,220);
			g.setColor(new Color(242, 242, 242));
			drawCenteredString(g,"Kirana Zea S.M. - 05111940000081",ft3,240);
			drawCenteredString(g,"Erza Janitradevi N- 051119400000153",ft3,260);
			drawCenteredString(g,"Rayhan Daffa A - 051119400000227",ft3,280);
			
			g.setColor(new Color(230, 255, 255));
			drawCenteredString(g,"Pemrograman Berbasis Objek Kelas E",ft3,350);
			drawCenteredString(g,"Informatika - ITS",ft3,380);
			
			
			
		}
	}
}