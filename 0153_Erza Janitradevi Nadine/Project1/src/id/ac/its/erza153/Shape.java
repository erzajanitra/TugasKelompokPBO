package id.ac.its.erza153;

public class Shape {
	protected double length;
	protected double width;
	
	public Shape() {
		// TODO Auto-generated constructor stub
	}
	
	public Shape(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getLuas() {
		return 0.0;
	}
	
	public double getKeliling() {
		return 0.0;
	}
	
}
