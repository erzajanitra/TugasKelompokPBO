package id.ac.its.erza153.collision;

public class Alien extends Sprite {
	
	//posisi mula2 alien
	private final int INITIAL_X = 400;

    public Alien(int x, int y) {
        super(x, y);

        initAlien();
    }

    private void initAlien() {

        loadImage("ufo.png");
        getImageDimensions();
    }
    
    //alien return to the screen on the right side after they disappeared on the left
    public void move() {
    	
    	//jika alien keluar window sebelah kiri, maka akan muncul lagi di sebelah kana
        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 2; //perpindahan alien
    }
}
