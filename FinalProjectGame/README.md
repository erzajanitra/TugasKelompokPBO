# FINAL PROJECT : PUZZLE (Game)

Permainan *Puzzle* mungkin sudah tidak asing kita dengar, kata *puzzle* berasal dari bahasa Inggris yang artinya membuat binggung atau teka teki. Sebuah teka-teki adalah permainan, masalah, atau mainan yang menguji kecerdikan atau pengetahuan seseorang. Permainan *puzzle* ini awalnya dimainkan secara *offline*, namun dapat dilihat dari perkembangan zaman yang dimana semua serba *online* dan dapat dimainkan dimana dan kapanpun tanpa ribet membawa potongan-potongan gambar. Oleh karena itu, Final Project kali ini kami berpikir untuk membuat sebuah aplikasi permainan *puzzle* dengan menggunakan *mouse handling*.  
   ## Fitur - Fitur yang akan diterapkan pada *project*   
 Beberapa fitur yang akan diterapkan pada *project* kali ini adalah: 
- **Title Screen**<br>
**Title Screen** adalah sebuah menu utama yang akan menampilkan nama game, *Puzzle*, pilihan *Start Game* yang akan mengarahkan pemain kepada beberapa pilihan *level* yang terdiri dari **Easy**, **Medium**, dan **Hard** agar pemain dapat bermain sesuai dengan *level* yang diinginkan, dan pilihan *Quit Game* jika pemain ingin keluar dari game tersebut.

- **Choose Difficullity**<br>
*Choose Difficulity* merupakan sebuah fitur dimana pemain memilih *level* yang akan dimainkan. Beberapa pilihan *level* yang ditawarkan antara lain: **Easy**, **Medium**, dan **Hard**. Perbedaan antar level yakni perbedaan potongan *puzzle* atau `NUMBER_OF_BUTTONS_` dan waktu yang diberikan. 

  Potongan *puzzle* yang diberikan meliputi 9 potongan *puzzle* untuk **Easy**, 16 potongan *puzzle* untuk **Medium**, dan 25 potongan *puzzle* untuk *level* **Hard**. Selain itu, untuk waktu yang diberikan tiap *level*nya juga berbeda dan berbagai pilihan waktu untuk tiap *level*nya yakni meliputi 15 *seconds* untuk pilihan **Easy**, 30 *seconds* (**Medium**), dan 45 seconds (**Hard**)
  
- **Penampilan *High Score***<br> 
Dalam fitur penampilan diperlukan class bernama `ScoreInput` dan `ScoreOutput` yang dimana dalam class ini akan mengimplementasikan interface Serializable agar objek pada class tersebut dapat menerima input data dan membaca data dengan menggunakan `ObjectInputStream` dan `ObjectOutputStream`.

- **Halaman Credits**<br>
Pada fitur halaman Credits ini akan menampilkan nama-nama *programmer* dan penjelasan tentang tata cara permainan. Serta, pada fitur halaman Credits juga ditambahkan link http://zetcode.com/javagames/puzzle/ yang dimana link tersebut kami jadikan referensi.

## Penjelasan Class 
Terdapat beberapa *class* yang akan digunakan pada projek pembuatan *game* *puzzle* ini, yaitu antara lain: 
### Menu.java 
Sama dengan namanya class `Menu` ini menyediakan beberapa method yang akan di tampilkan pada jalannya program. Terdapat sebuah constructor bernama Menu yang dimana mempunyai 2 paramater yaitu `int num, String player` yang dimana didalamnya terdapat sebuah inisiasi UI atau `initUI(num)` dan `creditGame()`. Terdapat beberapa method yang akan dijelaskan di bawah ini: 
- **Menu Screen**<br>
Pada method untuk menampilkan Menu Screen menggunakan JOptionPane untuk menampilkan menunya, potongan program dapat dilihat di bawah ini : <br>
`String[] options1 = {"Play Game", "Choose Level", "Quit Game"} ;
     // JOptionPane untuk menu screen
  int input1 = JOptionPane.showOptionDialog(null, 
    "Welcome to Puzzle Game!", 
    "Menu", 
    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]) ;`
    <br>
- **Memasukkan Nama Player**<br>
Ketika *player* diminta untuk memasukkan nama, terdapat implementasi dari `import java.awt.JTextField` dan ketika awal akan di inisialisi kosong dengan adanya sebuah String bernama `player = " ";`. Tidak hanya itu, terdapat implementasi dari import `java.awt.JOptionPane` dimana ketika *player*  sudah memasukkan namanya akan meng-klik OK untuk akan diarahkan selanjutnya.
- **Pilihan Level**<br>
Setelah *player* memasukkan namanya, nama tersebut akan di simpan pada sebuah `Score.txt` di dalam class `LeaderBoard` yang akan digunakan untuk menampilkan peringkat 10 teratas. Yang kemudian akan di arahkan untuk memilih *level*, ketika inilah terdapat implementasi JOptionPane. Untuk potongan program-nya dapat di lihat di bawah ini: <br> 
		
	String[] options2 = {"Easy", "Medium", "Hard"} ;
	// JOptionPane untuk memilih level
		int input2 = JOptionPane.showOptionDialog(null, 
				"Choose Level", 
				"Puzzle", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]) ;
		
		//Mengatur nilai num sesuai level yang telah dipilih
		//easy
		int num=9;
		//medium
		if(input2==1) {
			num=16;
		}
		//hard
		else if(input2==2) {
			num=25;
		}
        Menu puzzle=new Menu(num,player);
        //Setelah memilih level, game akan dimulai
        puzzle.setVisible(true);
   `int num` disini menjelaskan bahwa berapa banyak potongan gambar yang di inginkan, terdapat 3 pilihan *level* yang disediakan. Untuk pilihan *level easy* terdapat 9 potongan gambar yang akan disediakan, *level medium* dengan potongan gambar 16 dan untuk pilihan *level hard* disediakan potongan gambar sebanyak 25. Untuk `PuzzleEx puzzle = new PuzzleEx(num)` disini menjelaskan penggambaran berapa banyak `num` atau potongan gambar yang telah di atur sesuai dengan pilihan *level* yang di inginkan oleh *player*. Setelah memilih *level* dengan adanya `puzzle.setVisible(true);` yang artinya *game* akan dimulai jika sudah memilih *level*.
- **Pilihan Quit**<br>
Ketika *player* tidak ingin memainkan *game puzzle* lagi, terdapat pilihan menu Quit Game yang dimana ketika di-klik terdapat dua opsi yaitu antara "Yes" or "No". Pada menu pilihan Quit ini terdapat implementasi JOptionPane untuk memilih antara kedua pilihan tersebut. Jika *player* meng-klik "Yes" maka game akan keluar dengan sendirinya. Sedangkan jika tidak program akan menjalankan sebuah fungsi bernama `initGame()` yang berisi program yang akan menampilkan menu screen awal.
- **Credits Game**<br>
Pada menu Credits Game mengunakan inner class yang merupakan inheritance dari JPanel. Terdapat beberapa cara untuk menggambar atau menampilkan menu Credits Games ini yaitu yang pertama mengatur ukuran panel credit dengan menggunakan `setPreferredSize(new Dimension(DESIRED_WIDTH,450));` yang dimana artinya ukuran panel untuk Credits Games sebesar 450. Selanjutnya, dengan menggunakan `paintComponent` dan menggunakan graphics yang keduanya merupakan hasil implementasi `import java.awt.Graphics` dan `import java.awt.Graphics2D`. Pada proses menggambar komponen-komponen pada panel Credits menggunakan Override, yang dimana artinya proses tersebut menggunakan Static Method. <br> 

		public void creditGame() {
		add(new credit());
			
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setVisible(true);
		}`
   Potongan Program di atas memberikan arti bahwa ketika Menu Credits pada Menu Game di klik maka akan menampilkan Credits Game yang telah di proses sebelumnya. Setelah itu mengatur posisi String yang akan digambar agar di letakkan ditengah-tengah Panel Credits. Terdapat implementasi dari `import java.awt.Graphics` dimana ditunjukkan adanya penamaan paramater pada 	`drawCenteredSwing` dan adanya implementasi dari `import java.awt.Font` dan `import java.awt.FontMetrics` yang dimana di gunakan ketika Parameter Graphics dengan nama graphic mengambil `getFontMetrics` untuk digunakan ketika menampilkan Credits pada Game.
### LeaderBoard.java
Pada class `LeaderBoard` menampilkan peringkat-peringkat hasil *Score* yang berupa lama waktu-nya *player*. Semakin cepat seorang *player* itu menyelesaikan semua potongannya maka akan semakin ataslah posisinya. `LeaderBoard` class ini menggunakan JPanel untuk menampilkan peringkat 10 teratas dari semua *player* yang berhasil menyelesaikan potongan-potongan gambar. Terdapat beberapa method yang ada di class `LeaderBoard` ini, yaitu: 
- **Method untuk meng-setting Panel** <br>
Pada method ini menggunakan sebuah Constructor berupa pemanggilan sebuah fungsi `initUI()` dan penyetingan bahwasanya `highScore = new Score();` dan tentunya sebuah fungsi bernama `initUI();` yang di mana dalam sebuah fungsi tersebut berisi mengatur ukuran panel `LeaderBoard`, warna *Background* dan sebuah method dari JFrame berupa `this.setVisible(true)` untuk menampilkan panel dari `LeaderBoard` itu sendiri. <br> 
- **Method untuk menampilkan komponen-komponen yang akan di tampilkan di Panel** <br>
Komponen-komponen yang dimaksud adalah menampilkan sebuah tulisan berupa tulisan mulai dari nama-nama *player* dan *Score* yang berupa waktu berapa lama seorang *player* itu dapat menyelesaikan potongan-potongan gambar.<br> 
Selanjutnya, terdapat sebuah method `drawCenteredString` yang digunakan untuk menggambar string yang dapat di tampilkan pada panel. Untuk potongan *coding*-an dapat dilihat di bawah ini: <br> 

		g.setBackground(Color.BLACK);
      g.setColor(new Color(230, 255, 255));
		drawCenteredString(g,"Congratulations!",ft1,80);
		
		g.setColor(new Color(242, 242, 242));
		drawCenteredString(g,"You solve the puzzle in "+Time.currentTime+" second",ft2,120);
		
		g.setColor(new Color(230, 255, 255));
		drawCenteredString(g,"High Scores: ",ft2,180);
   Pemanggilan fungsi di atas merupakan implementasi dari import `java.awt.Graphics2D` dan untuk `Time.currentTime` merupakan sebuah  pemanggilan sebuah atribut bernama currentTime yang berasal dari class `Time`. <br>
- **Method untuk mengatur posisi string yang akan digambarkan agar terletak di tengah-tengah panel `LeaderBoard`** <br>
  `public void drawCenteredString(Graphics g, String text, Font font, int y)` <br>
  
  Berdasarkan potongan *coding*-an di atas dapat dijelaskan bahwa terdapat sebuah `String` bernama text pada parameter untuk string-string yang akan digambarkan. Selanjutnya, di paramater terdapat sebuah `Font` bernama font yang berguna untuk mengatur jenis font yang akan di tulis dan yang terakhir terdapat sebuah variabel y untuk mengatur posisi string pada sumbu y. <br>  
### MyButton.java 
Pada class `MyButton` menjelaskan supaya ketika *player* dapat melakukan berbagai action selanjutnya. Dalam class ` MyButton` ini terdapat atribut `lastButton` yang berguna untuk menandakan last button atau bukan. Selain itu, dalam class ini juga terdapat implementasi berupa `MouseAdapter` dan `MouseEvent` yang digunakan untuk memindahkan potongan gambar ke kiri atau ke kanan. 
### PuzzleEx.java 
`PuzzleEx` merupakan sebuah class yang berisi untuk mencetak atau menggambar sebuah *puzzle*  yang menggunakan perpanjangan dari JPanel dan menggunakan implementasi `ActionListener`. Pertama terdapat sebuah constructor `PuzzleEx` yang berisi `NUMBER_OF_BUTTONS` yang merupakan potongan gambar berdasarkan level yang dipilih. Method `initUI()` untuk memotong gambar menjadi potongan *puzzle* berukuran kecil. Pada Panel `PuzzleEx` ini juga menampilkan textTime serta *game*-nya. Implementasi `ActionListener` yaitu berupa class MouseHandler dan menggunakan implementasi MouseListener ketika Mouse tersebut di *click* dan di *press*
### SaveScore.java 
`SaveScore` digunakan untuk menyimpan Score yang telah di lakukan *player* dengan mengimpelmentasikan `Serializable`. getHighScore string digunakan untuk mengreturn nilai array yang nantinya akan di tampilkan pada Panel `LeaderBoard`
### Score.java 

### ScoreCompare.java 

### Time.java 
   

## Class Diagram 
  Class Diagram yang akan kita gunakan sampai saat ini dapat dilihat: 
  ![classdiagram](https://github.com/erzajanitra/TugasKelompokPBO/blob/main/gambar-gambar%20FP/class%20diagram/class%20diagram%20puzzle.mdj)
## Link Video Presentasi 

## Dokumentasi Jalannya Program** <br>
Berikut adalah contoh jalannya program untuk pilihan `Credit Game`:
<img src= "https://github.com/erzajanitra/TugasKelompokPBO/blob/main/gambar-gambar%20FP/menu-credits.gif" width="350" height="300"/>

- **Memainkan Puzzle**<br>
Berikut adalah contoh jalannya program ketika di mainkan: 
<img src= "https://github.com/erzajanitra/TugasKelompokPBO/blob/main/gambar-gambar%20FP/menu-level-puzzle.gif" width="350" height="300"/>

- **Ketika Player Berhasil Menyelesaikan Puzzle**<br>
Berikut adalah contoh jalannya program ketika *Player* dapat menyelesaikan Puzzle: 
<img src= "https://github.com/erzajanitra/TugasKelompokPBO/blob/main/gambar-gambar%20FP/puzzle-leaderboard.gif" width="350" height="300"/>
