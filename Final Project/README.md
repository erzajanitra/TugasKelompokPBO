# FINAL PROJECT : PUZZLE (Game)

Permainan *Puzzle* mungkin sudah tidak asing kita dengar, kata *puzzle* berasal dari bahasa Inggris yang artinya membuat binggung atau teka teki. Sebuah teka-teki adalah permainan, masalah, atau mainan yang menguji kecerdikan atau pengetahuan seseorang. Permainan *puzzle* ini awalnya dimainkan secara *offline*, namun dapat dilihat dari perkembangan zaman yang dimana semua serba *online* dan dapat dimainkan dimana dan kapanpun tanpa ribet membawa potongan-potongan gambar. Oleh karena itu, Final Project kali ini kami berpikir untuk membuat sebuah aplikasi permainan *puzzle* dengan menggunakan *mouse handling*.  
   
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

# Class Diagram 
  Class Diagram yang akan kita gunakan sampai saat ini dapat dilihat: 
  ![classdiagram](https://github.com/rayhandaffa/FinalProject/blob/main/class%20diagram/class%20diagram%20game.jpg)
