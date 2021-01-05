package id.ac.its.erza153.fp;

import java.io.Serializable;

public class SaveScore implements Serializable{
	private int score;
	private String name;
	
	public SaveScore(String name,int score) {
		this.score=score;
		this.name=name;
	}
	public int getScore() {
		return score;
	}
	public String getName() {
		return name;
	}
	
	
}
