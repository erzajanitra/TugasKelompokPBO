package id.ac.its.erza153.fp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
    
    
   private int getNewHeight(int w, int h) {
	
	    double ratio = DESIRED_WIDTH / (double) w;
	    int newHeight = (int) (h * ratio);
	    return newHeight;
	}


	//constructor PuzzleEx
    //nilai variable NUMBER_OF_BUTTONS berdasarkan level yang dipilih
    public PuzzleEx(int NUMBER_OF_BUTTONS) {
    
    	this.label = new JLabel("Credits");
   		label.setText("Kirana Zea S.M. 05111940000081\nErza Janitradevi N 05111940000153\nRayhan Daffa A 051119400000227");
 		label.setHorizontalTextPosition(SwingConstants.CENTER);
 		label.setVerticalTextPosition(SwingConstants.CENTER);
 		label.setVisible(true);
		this.NUMBER_OF_BUTTONS=NUMBER_OF_BUTTONS;
    	
		initUI();
        
     }

   
    private void initUI() {
    	
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
    	}
    

    //load image
    private BufferedImage loadImage() throws IOException {

        BufferedImage bimg = ImageIO.read(new File("C:\\Users\\ASUS\\Downloads\\FinalProjectGame\\mickeymouse.jpg"));
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
    
    private class ClickAction extends AbstractAction {
    	
    	
        @Override
        public void actionPerformed(ActionEvent e) {

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
    }
    
    
    //checkSolution dengan membandingkan urutan list button dengan potongan puzzle pada panel
    private void checkSolution() {

        List<Point> current = new ArrayList<>();

        for (JComponent btn : buttons) {
            current.add((Point) btn.getClientProperty("position"));
        }

        if (compareList(solution, current)) {
            JOptionPane.showMessageDialog(panel, "Finished",
                    "Congratulation", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static boolean compareList(List ls1, List ls2) {
        
        return ls1.toString().contentEquals(ls2.toString());
    }

    
}


