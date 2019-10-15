class Circle extends Oval
{
	public Circle(int x, int y, int radius)
	{
		super(x,y,radius,radius);
	}
	public String toString()
	{
		return "Circle: [x:"+getX()+", y:"+getY()+", radius:"+getRadius()+", area:"+getArea()+"]";
	}
}