package id.ac.its.erza153;


public class Rectangle extends Shape{

	//constructor
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rectangle(double length, double width) {
		super(length, width);
		// TODO Auto-generated constructor stub
	}

	//override method from parent(shape)
	@Override
	public double getLuas() {
		// TODO Auto-generated method stub
		return this.length*this.width;
	}

	@Override
	public double getKeliling() {
		// TODO Auto-generated method stub
		return (2*this.length)+(2*this.width);
	}
	
	
}
