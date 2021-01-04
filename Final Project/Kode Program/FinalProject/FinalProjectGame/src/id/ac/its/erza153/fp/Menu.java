package id.ac.its.erza153.fp;

import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) {
		
		String[] options1 = {"Play Game", "Quit Game"} ;
    	// JOptionPane untuk menu screen
		int input1 = JOptionPane.showOptionDialog(null, 
				"Welcome to Puzzle Game!", 
				"Menu", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, options1[0]) ;
		
		//play game
		if(input1==0) {
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
			if(input1==1) {
				num=16;
			}
			//hard
			else if(input1==2) {
				num=25;
			}
	        PuzzleEx puzzle = new PuzzleEx(num);
	        puzzle.setVisible(true);
		}
		
		//quit game
		else if(input1==1) {
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

	}

}
