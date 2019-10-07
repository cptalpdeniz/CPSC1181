import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Shape1 {
	private double x, y, r;
	private Color col;
	// add constructor, and required methods.

	public Shape1(double x, double y, double r)
	{
		this.x = x;
		this.y = y;
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
		Ellipse2D.Double ellipse = new Ellipse2D.Double(x - 2 * r, y - r, 4*r, 2*r);
		g2.draw(ellipse);
		g2.fill(ellipse);
	}

	public double getPositionInfo(int option)
	{
		switch (option)
		{
			case 0:
				return x;
			case 1:
				return y;
			case 2:
				return r;
		}
		return 0;
	}

	public Color getColor()
	{
		return col;
	}

	public void setPositionInfo(int option, double value)
	{
		switch (option)
		{
			case 0: //set x
				x = value;
				break;
			case 1:
				y = value;
				break;
			case 2:
				r = value;
				break;
		}
	}
}