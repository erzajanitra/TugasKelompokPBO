package id.ac.its.erza153.fp;

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



public class PuzzleEx extends JFrame{
	public static final double UPDATES_PER_SECOND = 0;
	private JPanel panel;
	private final JLabel label;
    private BufferedImage source;
    private BufferedImage resized;    
    private Image image;
    private MyButton lastButton;
    private int width, height;   
     
    private List<MyButton> buttons;
    private List<Point> solution;

    //jumlah potongan puzzle
    private int NUMBER_OF_BUTTONS ;
    //ukuran window puzzle
    private int DESIRED_WIDTH=450 ;
    //gameTime
    private Timer gameTimer;
    //score
    private int score;
    //apakah game berjalan
    private boolean inGame;
   
    
   //constructor PuzzleEx
    //nilai variable NUMBER_OF_BUTTONS berdasarkan level yang dipilih
    public PuzzleEx(int NUMBER_OF_BUTTONS) {
    
		this.NUMBER_OF_BUTTONS=NUMBER_OF_BUTTONS;
		this.label = new JLabel();

		initUI();
        
     }

   
    private void initUI() {
    	
    	inGame=true;
    	int side= (int) Math.sqrt(NUMBER_OF_BUTTONS);
        solution = new ArrayList<>();
    
        
        //jumlah kotak
        for(int i=0;i<side;i++) {
        	for(int j=0;j<side;j++) {
        		solution.add(new Point(i,j));
        	}
        }
      
        buttons = new ArrayList<>();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel.setLayout(new GridLayout(side, side, 0, 0));

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

        add(panel, BorderLayout.CENTER);

        //membagi image menjadi kotak2 button
        for (int i = 0; i < side; i++) {

            for (int j = 0; j < side; j++) {

                image = createImage(new FilteredImageSource(resized.getSource(),
                        new CropImageFilter(j * width / side, i * height / side,
                                (width / side), height / side)));
                
                MyButton button = new MyButton(image);
                button.putClientProperty("position", new Point(i, j));
                
                //last button dikosongi
                if (i == side-1 && j == side-1) {
                    lastButton = new MyButton();
                    lastButton.setBorderPainted(false);
                    lastButton.setContentAreaFilled(false);
                    lastButton.setLastButton();
                    lastButton.putClientProperty("position", new Point(i, j));
                } else {
                    buttons.add(button);
                }
            }
        }
        
        //shuffle elemen button secara random, kecuali last button
        Collections.shuffle(buttons);
        buttons.add(lastButton);
        
        //semua komponen button diletakkan pada panel puzzle
        for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {

            MyButton btn = buttons.get(i);
            panel.add(btn);
            btn.setBorder(BorderFactory.createLineBorder(Color.gray));
            btn.addActionListener(new ClickAction());
        }

        pack();
        setTitle("Puzzle");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //waktu game
        gameTimer=new Timer(120,this::lose);
     
    	}
    

    private int getNewHeight(int w, int h) {

        double ratio = DESIRED_WIDTH / (double) w;
        int newHeight = (int) (h * ratio);
        return newHeight;
    }
    
    //load image
    private BufferedImage loadImage() throws IOException {

        BufferedImage bimg = ImageIO.read(new File("C:/Users/erzan/eclipse-workspace/FinalProjectGame/photo.jpg"));

        return bimg;
    }
    
    //resize image untuk menjaga rasio image
    private BufferedImage resizeImage(BufferedImage originalImage, int width,
            int height, int type) throws IOException {

        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
                 	
        g.dispose();

        return resizedImage;
    }
    
    public void paintComponent(Graphics g) {
    	 super.paintComponents(g);
    	 if(inGame) {
    		 initUI();
    		 
    	 }
    	 else {
    		 lose(g);
    	 }
    		 
    }
   
      public void actionPerformed(ActionEvent e) {
        	inGame=true;
        	checkButton(e);
        	checkSolution();
        	
        }
    	
    
      private void checkButton(ActionEvent e) {

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

       //memetakan list button ke potongan puzzle pada panel
       private void updateButtons() {

            panel.removeAll();

            for (JComponent btn : buttons) {

                panel.add(btn);
            }
            
            //jika ada posisi puzzle yg berubah
            panel.validate();
        }
    
    
    
    //checkSolution dengan membandingkan urutan list button dengan potongan puzzle pada panel
    private void checkSolution() {

        List<Point> current = new ArrayList<>();

        for (JComponent btn : buttons) {
            current.add((Point) btn.getClientProperty("position"));
        }

        if (compareList(solution, current)) {
        	applyToScore(gameTimer.asSeconds()*100);
            JOptionPane.showMessageDialog(panel, "Finished",
                    "Congratulation", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //score
    public void applyToScore(int total) {
		score+=total;
	}
    

	public int getScore() {
		return score;
	}

	
	//compare solution
	public static boolean compareList(List ls1, List ls2) {
        
        return ls1.toString().contentEquals(ls2.toString());
    }

    
    //ketika melewati waktu yang telah ditentukan akan kalah
	private void lose(Graphics g) {
		List<Point> current = new ArrayList<>();
				
		if (compareList(solution, current)) {
			//tampilan game over
			String msg="Game Over";
			Font small = new Font("Helvetica", Font.BOLD, 14);
		    FontMetrics fm = getFontMetrics(small);
		    g.setColor(Color.white);
	        g.setFont(small);
	        g.drawString(msg, (DESIRED_WIDTH - fm.stringWidth(msg)) / 2,
	                DESIRED_WIDTH / 2);
	        
        }
	}


	public Timer getGameTimer() {
		return gameTimer;
	}

    
}


