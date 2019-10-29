/**
* Assignment 7
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
public class Circle
{
	private int x;
	private int y;
	private int radius;

	public Circle(int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public int get(int option)
	{
		switch (option)
		{
			case 0:
				return this.x;
			case 1:
				return this.y;
			case 2:
				return this.radius;
		}
		return 0;
	}

	public void set(int option, int value)
	{
		switch (option)
		{
			case 0: //set x
				this.x = value;
				break;
			case 1:
				this.y = value;
				break;
			case 2:
				this.radius = value;
				break;
		}
	}
}