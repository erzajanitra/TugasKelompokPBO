package id.ac.its.erza153.fp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
public class Score {
	
	private String name;
	private Date date;
	private ArrayList<Score> scores;
	
	//save in file
	private static final String scoreFile="C:\\Users\\erzan\\eclipse-workspace\\Final Project Game\\score.txt";
	//serializable
	ObjectOutputStream output = null;
	ObjectInputStream input = null;
	
	public Score() {
		scores=new ArrayList<Score>();
	}
	
	public ArrayList<Score> getScores() {
	    loadScoreFile();
	    sort();
	    return scores;
	}
	
	private void sort() {
	    ScoreCompare sc = new ScoreCompare();
	    Collections.sort(scores, sc);
	}
	
	public void addScore(String name, int score) {
	    loadScoreFile();
	    scores.add(new Score(this.name, this.score));
	    updateScoreFile();
	}
	
	public void loadScoreFile() {
	    try {
	        input = new ObjectInputStream(new FileInputStream(scoreFile));
	        scores = (ArrayList<Score>) input.readObject();
	        
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
	        output = new ObjectOutputStream(new FileOutputStream(scoreFile));
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

	    ArrayList<Score> scores;
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
