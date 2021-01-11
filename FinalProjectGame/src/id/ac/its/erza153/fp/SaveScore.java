package id.ac.its.erza153.fp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JPanel;

public class SaveScore extends JPanel implements Serializable{
	
	private int score;
	private String name;
	private int DESIRED_WIDTH=450 ;
	
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
