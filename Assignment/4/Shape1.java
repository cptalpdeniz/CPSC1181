/**
* Assignment 4
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Shape1 
{
	protected Vector2d position;
	private double r;
	private Color col;

	public Shape1(double x, double y, double r)
	{
		this.position = new Vector2d(x,y);
		this.r = r;
		
		Random rand = new Random();
		var red = rand.nextFloat();
		var green = rand.nextFloat();
		var blue = rand.nextFloat();
		this.col = new Color(red, green, blue);
	}

	public void draw(Graphics2D g2)
	{
		// create a horizontal ellipse and then draw it
		g2.setColor(col);
		Ellipse2D.Double ellipse = new Ellipse2D.Double(position.getPositionInfo(0) - 2 * r, getPositionInfo(1) - r, 4*r, 2*r);
		g2.draw(ellipse);
		g2.fill(ellipse);
	}

	/**
	* Getter for the x, y, r values
	*/
	public double getPositionInfo(int option)
	{
		switch (option)
		{
			case 0:
				return position.getPositionInfo(0);
			case 1:
				return position.getPositionInfo(1);
			case 2:
				return r;
		}
		return 0;
	}

	public Color getColor()
	{
		return col;
	}

	/**
	* Setter for the x, y and r values
	*/
	public void setPositionInfo(int option, double value)
	{
		switch (option)
		{
			case 0: //set x
				position.setPositionInfo(0, value);
				break;
			case 1:
				position.setPositionInfo(1, value);
				break;
			case 2:
				r = value;
				break;
		}
	}
}