package id.ac.its.erza153.fp;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JPanel;
public class Score extends JPanel {
	
	private String name;
	private Date date;
	private ArrayList<SaveScore> scores;
	
	//save in file
	private static Formatter scoreFile;
	//serializable
	ObjectOutputStream output = null;
	ObjectInputStream input = null;
	
	public Score() {
		
		scores=new ArrayList<SaveScore>();
	}
	
	public ArrayList<SaveScore> getScores() {
	    loadScoreFile();
	    sort();
	    return scores;
	}
	
	private void sort() {
	    ScoreCompare sc = new ScoreCompare();
	    Collections.sort(scores, sc);
	}
	
	//menyimpan player's name dan score
	public void addScore(String name, int score) {
	    loadScoreFile();
		scores.add(new SaveScore(name, score));
	    updateScoreFile();
	}
	

	public void loadScoreFile() {
	    try {
	    	input = new ObjectInputStream(
	    			Files.newInputStream(Paths.get("C:\\Users\\erzan\\eclipse-workspace\\FinalProjectGame\\score.txt")));
	        scores = (ArrayList<SaveScore>) input.readObject();
	        
	    } catch (FileNotFoundException e) {
	        System.out.println("File Not Found " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("IO Error " + e.getMessage());
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        System.out.println("Class Not Found " + e.getMessage());
	    } 
	}
	
	public void updateScoreFile() {
	    try {
	    	output = new ObjectOutputStream(
	    			Files.newOutputStream(Paths.get("C:\\Users\\erzan\\eclipse-workspace\\FinalProjectGame\\score.txt")));
	        output.writeObject(scores);
	    } catch (FileNotFoundException e) {
	        System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
	    } catch (IOException e) {
	        System.out.println("[Update] IO Error: " + e.getMessage());
	        e.printStackTrace();
	    } 
	    
	}
	public ArrayList<SaveScore> getHighscoreString() {
	    	       
	    ArrayList<SaveScore> scores;
	    scores = getScores();

	   
	    return scores;
	}
	
	
}
