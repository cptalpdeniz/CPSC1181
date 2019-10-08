public class Vector2d 
{
	private double x;
	private double y;

	public Vector2d(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

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

	public void set(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double dot(Vector2d v2)
	{
		return x * v2.getPositionInfo(0) + y * v2.getPositionInfo(1);
	}

	public double getLength()
	{
		return (double)Math.sqrt(x * x + y * y);
	}

	public double getDistance(Vector2d v2)
	{
		return (double) Math.sqrt((v2.getPositionInfo(0) - x) * (v2.getPositionInfo(0) - x) + (v2.getPositionInfo(1) - y) * (v2.getPositionInfo(1) - getPositionInfo(1)));
	}


	public Vector2d add(Vector2d v2)
	{
		Vector2d result = new Vector2d(0,0);
		result.setPositionInfo(0, x + v2.getPositionInfo(0));
		result.setPositionInfo(1, getPositionInfo(1) + v2.getPositionInfo(1));
		return result;
	}

	public Vector2d subtract(Vector2d v2)
	{
		Vector2d result = new Vector2d(0, 0);
		result.setPositionInfo(0, this.x - v2.getPositionInfo(0));
		result.setPositionInfo(1, this.getPositionInfo(1) - v2.getPositionInfo(1));
		return result;
	}

	public Vector2d multiply(double scaleFactor)
	{
		Vector2d result = new Vector2d(0, 0);
		result.setPositionInfo(0, this.x * scaleFactor);
		result.setPositionInfo(1, this.getPositionInfo(1) * scaleFactor);
		return result;
	}

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

	public String toString()
	{
		return "X: " + x + " Y: " + getPositionInfo(1);
	}


}
