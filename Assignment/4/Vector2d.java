/**
* Assignment 4
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/

	/**
	* 
	*/
public class Vector2d 
{
	/**
	* Vector2d class represents the 2-directional Vector 
	* @param x represents x value of the vector [private]
	* @param y represents the y value of the vector [private]
	*/
	private double x;
	private double y;

	
	/**
	* Default constructor for Vector 2D
	*/
	public Vector2d(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	* Getter for the x and y values
	*/
	public double getPositionInfo(int option)
	{
		switch (option)
		{
			case 0:
				return x;
			case 1:
				return y;
		}
		return 0;
	}

	/**
	* Setter for the x, y values
	*/
	public void setPositionInfo(int option, double value)
	{
		switch (option)
		{
			case 0:
				x = value;
				break;
			case 1:
				y = value;
				break;
		}
	}

	/**
	* set() method for setting both x and y at the same time
	*/
	public void set(double x, double y)
	{
		this.x = x;
		this.y = y;
	}


	/**
	* Dot product calculation
	*/
	public double dot(Vector2d v2)
	{
		return x * v2.getPositionInfo(0) + y * v2.getPositionInfo(1);
	}

	
	/**
	* @return length of the Vector
	*/
	public double getLength()
	{
		return (double)Math.sqrt(x * x + y * y);
	}

	
	/**
	* @return distance between 2 vectors
	*/
	public double getDistance(Vector2d v2)
	{
		return (double) Math.sqrt((v2.getPositionInfo(0) - x) * (v2.getPositionInfo(0) - x) + (v2.getPositionInfo(1) - y) * (v2.getPositionInfo(1) - getPositionInfo(1)));
	}


	
	/**
	* @return sum of 2 Vectors
	*/
	public Vector2d add(Vector2d v2)
	{
		Vector2d result = new Vector2d(0,0);
		result.setPositionInfo(0, x + v2.getPositionInfo(0));
		result.setPositionInfo(1, getPositionInfo(1) + v2.getPositionInfo(1));
		return result;
	}

	
	/**
	* @return subtracts the given vector from "this"
	*/
	public Vector2d subtract(Vector2d v2)
	{
		Vector2d result = new Vector2d(0, 0);
		result.setPositionInfo(0, this.x - v2.getPositionInfo(0));
		result.setPositionInfo(1, this.getPositionInfo(1) - v2.getPositionInfo(1));
		return result;
	}

	
	/**
	* @return multiplies two vectors
	*/
	public Vector2d multiply(double scaleFactor)
	{
		Vector2d result = new Vector2d(0, 0);
		result.setPositionInfo(0, this.x * scaleFactor);
		result.setPositionInfo(1, this.getPositionInfo(1) * scaleFactor);
		return result;
	}

	
	/**
	* Changes the vector into a unit vector
	*/
	public Vector2d normalize()
	{
		double len = getLength();
		if (len != 0.0f)
		{
			this.setPositionInfo(0, this.x / len);
			this.setPositionInfo(1, this.getPositionInfo(1) / len);
		}
		else
		{
			this.setPositionInfo(0, 0.0f);
			this.setPositionInfo(1, 0.0f);
		}

		return this;
	}

	
	/**
	* @return Returns the vector as a string
	*/
	public String toString()
	{
		return "X: " + getPositionInfo(0) + " Y: " + getPositionInfo(1);
	}
}