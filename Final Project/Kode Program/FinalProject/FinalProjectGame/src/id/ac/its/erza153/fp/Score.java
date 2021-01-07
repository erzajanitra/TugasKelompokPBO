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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JPanel;
public class Score extends JPanel implements SaveScore{
	
	private String name;
	private Date date;
	private ArrayList<SaveScore> scores;
	
	//save in file
	private static Formatter scoreFile;
	//serializable
	ObjectOutputStream output = null;
	ObjectInputStream input = null;
	
	public Score() {
		scores=this.scores;
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
	    	scoreFile = new Formatter("C:\\Users\\erzan\\eclipse-workspace\\Final Project Game\\score.txt");
	        scores = (ArrayList<SaveScore>) scoreFile.readObject();
	        
	    } catch (FileNotFoundException e) {
	        System.out.println("File Not Found " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("IO Error " + e.getMessage());
	    } catch (ClassNotFoundException e) {
	        System.out.println("Class Not Found " + e.getMessage());
	    } 
	}
	
	public void updateScoreFile() {
	    try {
	    	scoreFile = new Formatter("C:\\Users\\erzan\\eclipse-workspace\\Final Project Game\\score.txt");
	        output.writeObject(scores);
	    } catch (FileNotFoundException e) {
	        System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
	    } catch (IOException e) {
	        System.out.println("[Update] IO Error: " + e.getMessage());
	    } 
	    
	}
	public String getHighscoreString() {
	    String highscoreString = "";
	       int max = 10;

	    ArrayList<SaveScore> scores;
	    scores = getScores();

	    int i = 0;
	    int x = scores.size();
	    if (x > max) {
	        x = max;
	    }
	    while (i < x) {
	        highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
	        i++;
	    }
	    return highscoreString;
	}
	
	
}
