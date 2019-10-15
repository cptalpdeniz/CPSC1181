abstract class GeometricShape
{
	private int x; 
	private int y; 
	public GeometricShape(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	abstract public double getArea();
	abstract public String toString();
}