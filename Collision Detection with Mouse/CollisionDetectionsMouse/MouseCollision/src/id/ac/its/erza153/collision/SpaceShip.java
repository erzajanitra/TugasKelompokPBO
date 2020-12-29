package id.ac.its.erza153.collision;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite {

    //menggunakan List untuk menyimpan banyak objek missile
    private List<Missile> missiles;
    
	public SpaceShip(int x, int y) {
		super(x, y);
		initCraft();
	}
	
	//inisialisasi SpaceShip
	private void initCraft() {
        
        missiles = new ArrayList<>();
        loadImage("spaceship.png");
        getImageDimensions();
    }
	
    public void move() {

        //ketika spaceship berada di paling kiri
        if (x < 1) {
            x = 1;
        }
        //ketika spaceship berada di paling atas
        if (y < 1) {
            y = 1;
        }
        //ketika spaceship berada di paling bawah
        if(x>370) {
        	x=370;
        }
        //ketika spaceship berada di paling kanan
        if(y>270) {
        	y=270;
        }
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    
    //posisi missile ketika ditembakkan
    public void fire() {
        missiles.add(new Missile(x + width, y + height / 4));
    }
    
   
}
