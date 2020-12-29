# APLIKASI COLLISION DETECTION WITH MOUSE
Berdasarkan karakteristik *games* berdimensi 2D, untuk menangani *collision* yang berlebihan maka 
diperlukannya *event handling*. Kata *event* disini berarti suatu peristiwa yang 
dipicu oleh pengguna pasa suatu komponen GUI. Contoh *event handling* disini yaitu: 
- **Keyboard Handling**<br>
   Penyelesaian suatu *event* menggunakan *keyboard handling* ini digunakan pada aplikasi Space 
   Invader pada tugas sebelumnya. Untuk dapat melihat detailnya dapat dilihat pada link berikut: <br> 
   [Collision Detection](https://github.com/erzajanitra/CollisionDetection)
- **Mouse Handling**<br> 
   Berdasarkan link di atas, terdapat beberapa modifikasi agar dapat digunakan menggunakan *mouse handling*. 
   *Mouse Handling* sendiri merupakan sebuah metode dengan menggunakan *mouse* sebagai alat gerak pada 
   sebuah *event* yang diberikan oleh pengguna. Penjelasan cara kerja program dengan menggunakan *mouse
   handling* dapat dilihat di bawah ini. 

## Cara Kerja Program
### Board 
Pada *class* Board terdapat beberapa method yang diubah seperti: <br>
* Method ``initBoard``<br>
  Method ini bertugas untuk menginisialisasi Board Windows. Pada method ini terdapat beberapa modifikasi pada bagian: 
  ```mouse handler
        MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
		//hideCursor agar ketika program di run, cursor mouse tidak terlihat
		this.hideCursor();
  ```
  Perubahan dapat dilihat pada bagian `MouseHandler` dan `hideCursor` yang menggantikan fungsi    `add(KeyListener)` dan `setFocusable` pada applikasi *Collision Detection* sebelumnya. Selanjutnya, membuat objek `MouseHandler` yang kemudian akan digunakan juga untuk menambah `MouseListener`.

* Method ``hideCursor``<br> 
  Method ini berfungsi untuk menghilangkan *cursor* saat permainan berlangsung. <br> 
   ```hide
  public void hideCursor() {
	BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		cursorImg, new Point(0, 0), "blank cursor");
	this.setCursor(blankCursor);
  }
  ```
  Dengan menggunakan method ini, akan dibentuk suatu *blank cursor* sehingga pemain tidak akan terganggu dengan adanya *cursor* bawaan dari *mouse* ketika bermain. Untuk melakukan ini memanfaatkan method ``BufferedImage``. 
  
* *class* ``TAdapter`` dihapus, kemudian digantikan dengan membuat internal class ``MouseHandler``<br>
  Fungsi internal class ini yaitu dapat digunakan untuk membaca *mouse event*.
  ```internal class MouseHandler
  private class MouseHandler implements MouseListener, MouseMotionListener {

	@Override//bergerak mengikuti cursor ketika mouse ditahan
	public void mouseDragged(MouseEvent e) {
		spaceship.x = e.getX() ;
		spaceship.y = e.getY() ;
		
	}

	@Override //bergerak mengikuti cursor
	public void mouseMoved(MouseEvent e) {
		spaceship.x = e.getX() ;
		spaceship.y = e.getY() ;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
	
	@Override //ketika mouse ditekan sekali akan mengeluarkan missile
	public void mousePressed(MouseEvent e) {
		spaceship.fire();
		
	}
  ```
  Perbedaan *class* di atas (dengan menggunakan *Mouse Handling*) dengan *class* pada Aplikasi yang menggunkan *Keyboard Handling* adalah jika pada *Keyboard Handling* menggeser koordinar dari objek tidak dilakukannya perhitungan melalui perubahan (dx/dy) dengan menggunakan method ``KeyPressed``. Sedangkan, pada *Mouse Handling* dapat langsung mengambil koordinat x dan y dari *mouse* (seperti apa yang di gambarkan pada method ``MouseMoved`` dan ``MouseDragged``).<br>
  
  Apabila kursor atau *mouse* mengarahkan keluar dari *Board* maka *spaceship* tidak akan muncul tetapi akan berhenti pada berbatasan jendela. Dan ketika *mouse* meng-*click* (``MousePressed``) maka *spaceship* akan menembakan peluru. <br>

## Spaceship
Karena pada bagian *class* `Board` tidak dilakukannya perhitungan yang dilihat dari perubahan (dx/dy), maka pada *class* `Spaceship` ini terjadinya penghapusan variabel dx dan variabel dy karena dianggap tidak digunakan lagi. <br> 

# Class Diagram 
![classdiagram](https://github.com/erzajanitra/Collision-Detection-with-Mouse/blob/master/gambar/collision%20detection%20mouse.jpg)

# Jalannya Program 
Jalannya Program dengan menggunakan *Mouse Handling* dapat dilihat pada link berikut: 
[Jalannya Program MouseHandling](https://youtu.be/z2Ek4W9zPAU)
