/**
* Assignment 5
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
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