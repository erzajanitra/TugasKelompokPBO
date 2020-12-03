package id.ac.its.zea081;

import javax.swing.JOptionPane;

public class Addition 
{
	public static void main(String [] args)
	{
		Circle c1 = new Circle();
		String firstNumber = JOptionPane.showInputDialog("Enter radius");
		
		double r1 = Double.parseDouble(firstNumber);
		
		JOptionPane.showMessageDialog(null, "The area is " + c1.getArea(r1) + "\nand the perimeter is " + c1.getPerimeter(r1), "Area and Perimeter of Circle", JOptionPane.PLAIN_MESSAGE);
	}
}
