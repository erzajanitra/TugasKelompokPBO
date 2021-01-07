package id.ac.its.erza153.fp;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Menu extends JFrame{
	
	public Menu(int num) {
		initUI(num);
		
	}
	
	
	private void initUI(int num) {
		add(new PuzzleEx(num),BorderLayout.SOUTH);
		add(new Time(),BorderLayout.CENTER);
		pack();
        setTitle("Puzzle");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public static void main(String[] args) {
		Menu menu=new Menu(9);
		menu.initGame();
		

	}
	
	public void initGame() {
		
		String[] options1 = {"Play Game","High Scores" ,"Quit Game","Credits"} ;
    	// JOptionPane untuk menu screen
		int input1 = JOptionPane.showOptionDialog(null, 
				"Welcome to Puzzle Game!", 
				"Menu", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, options1[0]) ;
		
		//play game
		if(input1==0) {
			this.playGame();
		}
		else if(input1==1) {
			Score highscore=new Score();
			highscore.getHighscoreString();
		}
		else if(input1==2) {
			this.quitGame();
		}
		else if(input1==3) {
			this.creditGame();
		}
	}

	public void playGame() {
	//input player's name
		JTextField name=new JTextField();
		Object[] fields= {
				"Enter your name ",name
		};
		
		int input=JOptionPane.showConfirmDialog(null, fields, 
				"Player Name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(input==JOptionPane.OK_OPTION) {
			String player=name.getText();
			SaveScore pscore=new SaveScore(player, 0);
		
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
        Menu puzzle=new Menu(num);
        puzzle.setVisible(true);

	}
	
	public void quitGame() {
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
			this.initGame();
		}
	}
	
	public void creditGame() {
		JFrame window = new JFrame("Credits"); 
		   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   window.setLayout(new BorderLayout());
		   window.add(new JLabel(
				   "<html>Final Project Pemograman Berbasis Objek<br>" 
				+ "<br> Puzzle Game "
				+ "<br> merupakan pengembangan dari http://zetcode.com/javagames/puzzle/ yang merupakan referensi kami<br> "
				+ "<br> Credit by:  "
				+ "<br>Kirana Zea S.M. - 05111940000081"
		   		+ "<br>Erza Janitradevi N - 05111940000153"
		   		+ "<br>Rayhan Daffa A - 051119400000227<br>"
		   		+ "<br>Pemograman Berbasis Objek kelas E"
		   		+ "<br>Informatika - ITS"), 
				   BorderLayout.CENTER,
				   SwingConstants.CENTER);
		   window.pack();
		   window.setVisible(true);
		   window.setLocationRelativeTo(null);
		   window.setSize(350, 300);
	}
	
}