package id.ac.its.erza153;

import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		String rectangle;
			
		Rectangle rect=new Rectangle();
		
		//input length
		rectangle=JOptionPane.showInputDialog("Enter Length");
		//convert string to double
		rect.length=Double.parseDouble(rectangle);
		
		//input width
		rectangle=JOptionPane.showInputDialog("Enter Width");
		//convert string to double
		rect.width=Double.parseDouble(rectangle);
		
				
		//display area and perimeter of rectangle
		JOptionPane.showMessageDialog(null, "Area of Rectangle" +rect.getLuas()+ 
				"\nPerimeter of Rectangle" +rect.getKeliling(),
				"Area and Perimeter of Rectangle", JOptionPane.PLAIN_MESSAGE);
		
	}

}
