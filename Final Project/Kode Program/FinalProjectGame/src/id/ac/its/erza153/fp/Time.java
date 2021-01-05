package id.ac.its.erza153.fp;

public class Time {
	protected int currentTime;
	
	//constructor
	public Time() {
		this.currentTime=0;
	}
	
	//update time
	public int getUpdatesFromSeconds(double seconds) {
		return (int) Math.round(seconds*PuzzleEx.UPDATES_PER_SECOND);
	}
	
	public void Update() {
		currentTime++;
	}
	
	//menampilkan string time
	public String getTime() {
		StringBuilder strBld=new StringBuilder();
		
		int minutes=(int) (currentTime / PuzzleEx.UPDATES_PER_SECOND/60);
		int seconds=(int) (currentTime / PuzzleEx.UPDATES_PER_SECOND%60);
	
		if(minutes<10) {
			strBld.append(0);
		}
		strBld.append(minutes);
		strBld.append(":");
		
		if(seconds<10) {
			strBld.append(0);
		}
		strBld.append(seconds);
		return strBld.toString();
	
	
	}
	
	public boolean secondsDividable(double seconds) {
		return currentTime % getUpdatesFromSeconds(seconds) ==0;
	}
	
}
