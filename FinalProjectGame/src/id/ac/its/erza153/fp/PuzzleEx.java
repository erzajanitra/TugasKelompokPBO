package id.ac.its.erza153.fp;

import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Math;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class PuzzleEx extends JPanel implements ActionListener{
	
	public static final double UPDATES_PER_SECOND = 0;
	private final JLabel label;
    private BufferedImage source;
    private BufferedImage resized;    
    private Image image;
    private MyButton lastButton;
    private int width, height;   
     
    //List button dan solution
    private List<MyButton> buttons;
    private List<Point> solution;

    //Jumlah potongan puzzle sebagai buttons
    private int NUMBER_OF_BUTTONS ;
    
    //Ukuran window puzzle
    private int DESIRED_WIDTH=450 ;
    
    //Menghitung waktu pemain 
    private Timer gameTimer;
    private int second;
    
    //score dan playerName untuk ditampilkan pada LeaderBoard
    private int score;
    private String playerName;
    
    //Menandai apakah game sudah dimulai atau belum
    private static boolean inGame;
    
   
    
   //Constructor PuzzleEx
   //Nilai variable NUMBER_OF_BUTTONS berdasarkan level yang dipilih
    public PuzzleEx(int NUMBER_OF_BUTTONS,String playerName) {
    
		this.NUMBER_OF_BUTTONS=NUMBER_OF_BUTTONS;
		this.label = new JLabel();
		this.playerName=playerName;
		second=0;
		initUI();
        
     }

    //Method initUI untuk memotong gambar menjadi potongan puzzle berukuran kecil
    private void initUI() {
    	
    	//Game sedang berjalan
    	setInGame(true);
    	
    	int side= (int) Math.sqrt(NUMBER_OF_BUTTONS);
        solution = new ArrayList<>();
               
        //Jumlah potongan puzzle
        for(int i=0;i<side;i++) {
        	for(int j=0;j<side;j++) {
        		solution.add(new Point(i,j));
        	}
        }
      
        buttons = new ArrayList<>();

        //Ukuran potongan puzzle
        this.setBorder(BorderFactory.createLineBorder(Color.gray));
        this.setLayout(new GridLayout(side, side, 0, 0));

        try {
            source = loadImage();
            //getNewHeight untuk menjaga image's ratio
            int h = getNewHeight(source.getWidth(), source.getHeight());
            resized = resizeImage(source, DESIRED_WIDTH, h,
                    BufferedImage.TYPE_INT_ARGB);

        } catch (IOException ex) {
            Logger.getLogger(PuzzleEx.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        width = resized.getWidth(null);
        height = resized.getHeight(null);

     
        //membagi image menjadi potongan puzzle berupa button
        for (int i = 0; i < side; i++) {

            for (int j = 0; j < side; j++) {

                image = createImage(new FilteredImageSource(resized.getSource(),
                        new CropImageFilter(j * width / side, i * height / side,
                                (width / side), height / side)));
                
                MyButton button = new MyButton(image);
                button.putClientProperty("position", new Point(i, j));
                
                //last button dikosongi
                if (i == side-1 && j == side-1) {
                	try {
						BufferedImage bimg = loadBlankImage();
				        resized = resizeImage(bimg, width/side, height/side,
				                    BufferedImage.TYPE_INT_ARGB);
						lastButton = new MyButton(resized);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	lastButton.setLastButton();
                    lastButton.putClientProperty("position", new Point(i, j));
                } else {
                    buttons.add(button);
                }
            }
        }
        
        //Shuffle elemen button secara random, kecuali pada last button
        Collections.shuffle(buttons);
        buttons.add(lastButton);
        
        //Semua komponen button diletakkan pada panel puzzle
        for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {

            MyButton btn = buttons.get(i);
            this.add(btn);
            btn.setBorder(BorderFactory.createLineBorder(Color.gray));
            btn.addMouseListener(new MouseHandler());
        }

               
        
        //Timer untuk game akan dimulai ketika pemain memulai game
        gameTimer=new Timer(100,this);
        gameTimer.start();
    	}
    
    //Mendapatkan ukuran gambar
    private int getNewHeight(int w, int h) {

        double ratio = DESIRED_WIDTH / (double) w;
        int newHeight = (int) (h * ratio);
        return newHeight;
    }
    
    //Load image puzzle dari file directory
    private BufferedImage loadImage() throws IOException {

        BufferedImage bimg = ImageIO.read(new File("C:/Users/erzan/eclipse-workspace/FinalProjectGame/mickeymouse.jpg"));

        return bimg;
    }
    
    //Load image untuk bagian kosong puzzle dari file directory
    private BufferedImage loadBlankImage() throws IOException {

        BufferedImage bimg = ImageIO.read(new File("C:/Users/erzan/eclipse-workspace/FinalProjectGame/blank.jpg"));

        return bimg;
    }
    
    //resizeImage untuk menjaga rasio gambar puzzle
    private BufferedImage resizeImage(BufferedImage originalImage, int width,
            int height, int type) throws IOException {

        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
                 	
        g.dispose();

        return resizedImage;
    }
    
    //Menampilkan textTime ketika permainan sedang berjalan
    @Override
    public void paintComponent(Graphics g) {
    	 super.paintComponents(g);
    	 if(isInGame()) {
    		 textTime(g);
    	  	    		 
    	 }
    	 else {
    		 lose(g);
    	 }
    		 
    }
    
    //textTime menampilkan waktu yang sedang berjalan selama permainan berlangsung
    private void textTime(Graphics g) {
    	
    	String msg= second/60 + ":" + second % 60;
    	Font small = new Font("Helvetica", Font.BOLD, 14);
	    FontMetrics fm = getFontMetrics(small);
	    g.setColor(Color.black);
        g.setFont(small);
        g.drawString(msg, (DESIRED_WIDTH - fm.stringWidth(msg)) / 2,
                100);
    	
		
	}
	
        
    //checkSolution dengan membandingkan urutan list button yang berisi urutan puzzle yang benar dengan potongan puzzle pada panel
    private void checkSolution() {

        List<Point> current = new ArrayList<>();

        for (JComponent btn : buttons) {
            current.add((Point) btn.getClientProperty("position"));
        }

        if (compareList(solution, current)) {
        	applyToScore(second *100);
        	//ketika sudah GameOver
        	setInGame(false);
        	Time.timer.stop(); //tampilan waktu
        	gameTimer.stop(); //ketika game sudah selesai timer akan berhenti
        }
    }

    //Menghitung score pemain
    public void applyToScore(int total) {
		score+=total;
	}
    
    //getter score
	public int getScore() {
		return score;
	}

	
	//compare solution
	public static boolean compareList(List ls1, List ls2) {
        
        return ls1.toString().contentEquals(ls2.toString());
    }

    
	//Menampilkan waktu selesai permainan, score pemain, dan high score
	private void lose(Graphics g) {
		List<Point> current = new ArrayList<>();
		
		for (JComponent btn : buttons) {
            current.add((Point) btn.getClientProperty("position"));
        }
		
		if (compareList(solution, current)) {
			System.out.println("cek");
			
			this.setVisible(false);
			System.out.println(playerName);
			Score highScore=new Score();
			highScore.addScore(playerName, Time.currentTime * 100);
			
			//JFrame untuk menampilkan waktu selesai permainan, score pemain, dan high score
			JFrame frame=new JFrame();
			frame.add(new LeaderBoard());
			frame.pack();
			frame.setTitle("High Score");
			frame.setBackground(Color.BLACK);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
        }
	
	}


	public Timer getGameTimer() {
		return gameTimer;
	}


	private void gameOver() {
		setInGame(false);
	}

	//Second pada Timer akan terus bertambah dan terus ditampilkan selama game berlangsung
	@Override
	public void actionPerformed(ActionEvent e) {
		second++;
		checkSolution();
		repaint();
		
	}

	//Mengacak posisi button puzzle
	private void checkButton(MouseEvent e) {

        int lidx = 0;
        
        for (MyButton button : buttons) {
            if (button.isLastButton()) {
                lidx = buttons.indexOf(button);
            }
        }

        JButton button = (JButton) e.getSource();
        int bidx = buttons.indexOf(button);

        if ((bidx - 1 == lidx) || (bidx + 1 == lidx)
                || (bidx - 3 == lidx) || (bidx + 3 == lidx)) {
            Collections.swap(buttons, bidx, lidx);
            updateButtons();
        }
             
    }
	
	//Memetakan list button ke potongan puzzle pada panel
    private void updateButtons() {

    	this.removeAll();

         for (JComponent btn : buttons) {

        	 this.add(btn);
         }
         
         //jika ada posisi puzzle yg berubah
         this.validate();
     }
    
    public static boolean isInGame() {
		return inGame;
	}


	public static void setInGame(boolean inGame) {
		PuzzleEx.inGame = inGame;
	}

	private class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			checkButton(e);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}


