/**
* Assignment 5
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
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