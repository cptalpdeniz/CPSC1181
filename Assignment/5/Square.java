class Square extends Rectangle
{
	public Square(int x, int y, int w)
	{
		super(x,y,w,w);
	}
	
	public String toString()
	{
		return "Square: [x:"+getX()+", y:"+getY()+", length:"+getWidth()+", area:"+getArea()+"]";
	}
}