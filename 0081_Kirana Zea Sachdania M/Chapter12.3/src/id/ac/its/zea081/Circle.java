package id.ac.its.zea081;

public class Circle extends Shape
{
	@Override
	public double getArea(double radius)
	{
		return radius * radius * 3.14;
	}
	
	@Override
	public double getPerimeter(double radius)
	{
		return radius * 2 * 3.14;
	}
}
