package id.ac.its.erza153.fp;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu
{
	public static void main(String[] args) 
	{
				
		String[] options1 = {"Play Game", "Quit Game","Credits"} ;
    	// JOptionPane untuk menu screen
		int input1 = JOptionPane.showOptionDialog(null, 
				"Welcome to Puzzle Game!", 
				"Menu", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, options1[0]) ;
		
		//play game
		if(input1==0) 
		{
			String[] options2 = {"Easy", "Medium", "Hard"} ;
			
			// JOptionPane untuk memilih level
			int input2 = JOptionPane.showOptionDialog(null, 
					"Choose Level", 
					"Puzzle", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]) ;
			
			//set levelnya
			//easy
			int side =9;
			
			//medium
			if(input1==1) {
				side=16;
			}
			//hard
			else if(input1==2) {
				side=25;
			}
	        PuzzleEx puzzle = new PuzzleEx(side);
	        puzzle.setVisible(true);
		}
		
		//quit game
		else if(input1==1) 
		{
			String[] options3 = {"Yes","No"} ;
			
			// JOptionPane untuk memilih level
			int input3 = JOptionPane.showOptionDialog(null, 
					"Choose Level", 
					"Puzzle", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_OPTION, null, options3, options3[0]) ;
			
			//yes
			if(input3==0) {
				System.exit(0);
				
			}
			//else if(input3==1) {
			
			//}
		}	
		//credits game
		else if(input1==2)
			{
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
	}
	

			
			

	
	
