package id.ac.its.erza153.fp;

import javax.swing.JOptionPane;

public class Game implements Runnable {

	@Override
	public void run() {
		String[] options1 = {"Play Game", "Choose Level", "Quit Game"} ;
    	// JOptionPane untuk menu screen
		int input1 = JOptionPane.showOptionDialog(null, 
				"Welcome to Puzzle Game!", 
				"Menu", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]) ;
		
		//pilihan menu
		
    	
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
	
}

	

