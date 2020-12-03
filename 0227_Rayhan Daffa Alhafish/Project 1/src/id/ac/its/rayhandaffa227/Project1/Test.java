package id.ac.its.rayhandaffa227.Project1;

import javax.swing.JOptionPane;
public class Test {

	public static void main(String[] args) {
		String input; 
		
		Square persegi = new Square();
		
		//input sidenya 
		input = JOptionPane.showInputDialog("Masukkan Sisinya");
		
		//convert Strings input to double 
		persegi.side = Double.parseDouble(input);
		
		//display output 
		JOptionPane.showMessageDialog(null, "Luas Persegi" +persegi.getLuas(), null, JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Keliling Persegi" +persegi.getKeliling(), null, JOptionPane.PLAIN_MESSAGE);
		
	}

}
