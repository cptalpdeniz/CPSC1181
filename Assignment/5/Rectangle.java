/**
* Assignment 5
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
class Rectangle extends GeometricShape
{
	private int w;
	private int h;
	public Rectangle(int x, int y, int w, int h)
	{
		super(x,y);
		this.w=w;
		this.h=h;
	}
	final public int getW()
	{
		return w;
	}
	final public int getH()
	{
		return h;
	}
	final public void setW(int w)
	{
		this.w = w;
	}
	final public void setH(int h)
	{
		this.h = h;
	}
	public double getArea()
	{
		return Math.round(w*h);
	}
	public String toString()
	{
		return "Rectangle [x:"+getX()+", y:"+getY()+", width:"+w+", height:"+h+", area:"+getArea()+"]";
	}
	public int getWidth()
	{
		return w;
	}
}