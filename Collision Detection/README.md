# Tugas Kelompok PBO - Collision Detection

Contributor : 
  1. Kirana Zea Sachdania Mays - 081
  2. Erza Janitradevi - 153
  3. Rayhan Daffa Alhafish - 227 
  
# APLIKASI COLLISION DETECTION 
Banyak aplikasi games yang menggunakan atau yang meng-handle collision, terutama permainan arkade. Permainan arkade sendiri adalah sebuah mesin permainan hiburan yang dioperasikan dengan koin yang terpasang di tempat-tempat bisnis, dan pusat permainan hiburan. Bentuk kebanyakan permainan arkade adalah permainan video, mesin pinbol, dan lainnya. 

Karakteristik dari games yang berdimensi 2D yaitu terdapatnya program yang berisi objek - objek yang bergerak. Objek - objek tersebut dapat bertumbukan (collision) satu sama lain. Oleh karena itu, untuk dapat menangani collision yang berlebihan maka diperlukannya sebuah cara dengan menggunakan Collision Detection. 

## Cara Kerja Program 
Berdasarkan karakteristik dari games berdimensi 2D, terdapat sebuah class yang bertugas mengenkapsulasi objek - objek yang dapat bergerak di suatu game. Objek - objek yang bergerak tersebut adalah Alien, Spaceship, dan Missile. Kemudian, objek - objek tersebut akan di inisialisasi pada saat objek Board dibuat dan akan objek - objek tersebut dipakai saat game dijalankan. 

### Sprite 
Class Sprite merupakan sebuah class yang bertugas untuk mengenkapsulasi objek - objek yang dapat bergerak di suatu game. Pada class ini, terdapat bebrpa methode yang akan digunakan pada class lainya. Method - method teresebut antara lain : 
  1.  Constructor yang akan menginisialisasi koordinat x, y dan variable visible
  2.  Method - method yang digunakan untuk mendapatkan gambar, dan dimensi. Dimensi disini yaitu       height and width pada gambar tersebut
  3.  Getter dan setter untuk variabel dalam class
  4.  Methode yang bertugas untuk mengatur visibiltas
  5.  Methode Bounding:
          
      Methode ini akan membuat Rectangle baru menggunakan koordinat dan ukuran yang telah             didapatkan dengan kata lain semua objek dianggap Rectangle
      
       <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/sprite%20bounding.jpg"/>
      

### Alien 
Class Alien ini merupakan extends dari class Sprite yang dimana class Alien ini termasuk inheritance dari superclass Sprite. Berikut Method - method yang terdapat dalam class Alien: 
  1.  Constructor untuk menginisialisasi koordinat dan gambar Alien. Untuk mendapatkan gambar         alien nya itu sudah terdapat pada bagian superclass Sprite.
  2.  Methode untuk bergeraknya sebuah objek Alien: 
  
      <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/alien%20move.jpg"/>
      
      Alien bergerak ke kiri, jika sebuah objek Alien itu keluar dari window sebelah kiri (x<0) maka objek Alien tersebut akal muncul kembali ke posisi awal (intial_x)
   
### Missile 
Method - method dalam class : 
  1.  Constructor untuk menginisialisasi objek 
  2.  Method agar objek dapat bergerak : 
   <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/missile%20methode.jpg"/>
   
   Karena Missile bergerak ke arah kanan, maka untuk menggeser posisi Missile dengan menggunakan koordinat objek yang kemudian ditambah dengan kecepatan objek Missile. Missile akan menghilang ketika Misille melebihi lebar board
   
### Spaceship
Method - method yang terdapat dalam class : 
  1.  Constructor untuk menginisialisasi objek
  2.  Method untuk menginisialisi Spaceship itu sendiri dan objek Missile juga dibuat list             karena Missile dan Spaceship akan berjalan bersama. 
  3.  Method untuk mendapatkan Missile 
  
      <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/spaceship%20miselle%20caranya.jpg"/>
      
  4.  Method agar objek dapat bergerak 
  
      <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/spaceship%20move.jpg"/>
  
      Sebuah objek akan bergerak mengikuti perintah keyboard, maka untuk menggeser posisi koordinat dari objek maka objek tersebut ditambah dengan perpindahan objek Spaceship (dx,dy). Ketika objek sudah berada di paling kiri maka posisi tersebut di sama dengankan 1
   
  5.  Method yang digunakan untuk mengambil key yang diperintahkan pada keyboard
      Terdapat dua kondisi yaitu dimana keyboard melakukan perintah menekan sesuatu (kiri, kanan,       space, atas, dan bawah) dan kondisi dimana keyboard itu dilepas. Ketika keyboard                 memerintahkan sesuatu maka,
      
      <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/spaceship%20key.jpg"/>
      
      Pada kondisi kedua, maka diperlukannya sebuah method untuk mengembalikan status perpindahan       key
      
       <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/spaceship%20kalo%20dilepas.jpg"/> 
       
      Ketika key dilepas maka delta x dan delta y diset kembali menjadi 0 sesuai dengan key yang       telah telah dilepas
      
  6.   Method unruk menembakkan Missile
### Board
Method - method dalam class : 
  1.  Constructor yang menginisialisasi window Board dari method lain
  
       <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/board%20inisialisasi.jpg"/> 
       
  2.  Method yang akan dipanggil di constructor
  3.  Method - method untuk menggambar GUI objek Spaceship, Missile, Alien, dan menulis status         jumlah Alien.
  4.  Method untuk menggambar GUI saat permainan selesai 
  
      <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/board%20game%20over.jpg"/> 
      
  5.  Method untuk memperbarui posisi Spaceship dengan cara memanggil methode move
  6.  Method untuk memperbaru posisi Missile, dengan cara membuat objek Missile dan meng-loop         sesuai dengan banyaknya missile untuk memanggilmethode move atau remove
  7.  Method untuk memperbarui posisi Alien. Sekaligus mengecek apakah objek masih ada atau           tidak untuk menentukan selesainya permainan. Methode lain dapat digunakan yaitu dengan           meng-loop untuk memanggil method move atau remove
  8.  Method untuk mengecek apakah objek bertabrakan atau tidak
      
        <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/board%20cek%20tabrakan.jpg"/> 
        
  9. Terdapat class baru yang bersifat private yang dapat membaca keyboard apabila keyboard          dilepas ataupun ditekan
       
  
### CollisionEx
Method - method yang digunakan pada class ini antara lain : 
  1.   Constructor yang akan memanggil insisialisi UI 
  2.   Methode untuk menginisialisasi UI, yang dimana akan secara langhsung membuat objek Board          baru
  
       <img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/collisionex.jpg"/> 
      
  3.   Class main yang akan menjalankan sesuai eventnya dan akan menginisialisasi permainan  

## CLass Diagram 
![classdiagram](https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/class%20diagramcollision%20detection.jpg)

## Jalannya Program 
Berikut adalah contoh jalannya program:

<img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/ezgif.com-gif-maker%20(1).gif" width="400" height="350"/>

Berikut adalah tampilan jika pemain tidak berhasil dalam permainan dan kita permainan selesai: 

<img src="https://github.com/erzajanitra/CollisionDetection/blob/master/gambar2%20buat%20PBO%20-%20COLLISON/spaceship1.gif" width="400" height="350"/>
