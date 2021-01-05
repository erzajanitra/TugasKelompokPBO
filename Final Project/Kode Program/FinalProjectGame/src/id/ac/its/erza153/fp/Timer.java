package id.ac.its.erza153.fp;

public class Timer extends Time{
	
	//ketika Timer 0.00 akan game over
	protected Runnable callBack;
	
	public Timer(double seconds,Runnable callBack) {
		currentTime=getUpdatesFromSeconds(seconds);
		this.callBack=callBack;
	}

	@Override
	public void Update() {
		if(currentTime>0) {
			currentTime--;
		}
		else if(currentTime==0) {
			callBack.run();
		}
	}

	public int asSeconds() {
		// TODO Auto-generated method stub
		return (int) (currentTime / PuzzleEx.UPDATES_PER_SECOND);
	}
	
	
}
