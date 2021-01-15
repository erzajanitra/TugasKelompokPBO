package id.ac.its.erza153.fp;

import java.util.Comparator;

public class ScoreCompare implements Comparator<SaveScore>{
	
	//membandingkan score pemain untuk mengurutkan high score
	public int compare(SaveScore score1,SaveScore score2) {
		
		int sc1=score1.getScore();
		int sc2=score2.getScore();
		
		if (sc1 > sc2){
	        return -1;                   // -1 means first score is bigger then second score
	    }else if (sc1 < sc2){
	        return +1;                   // +1 means that score is lower
	    }else{
	        return 0;                     // 0 means score is equal
	    }
	}

	
}
