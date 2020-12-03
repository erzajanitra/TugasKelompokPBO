package id.ac.its.rayhandaffa227.Project1;

public class Square extends Shape
{
	public Square()
	{
		super();
		
	}
	
	@Override 
	public double getLuas()
	{
		return this.side*this.side;
	}
	
	@Override 
	public double getKeliling()
	{
		return (2*this.side)+(2*this.side);
	}
}

