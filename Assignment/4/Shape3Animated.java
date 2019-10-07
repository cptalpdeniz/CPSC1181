import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class Shape3Animated extends Shape3
{

	private int direction; // a random direction. 
	private int velocity;  // a random velocity in pixel 
	// Add instance fields that required
	
	public Shape3Animated(double x, double y, double r, int direction, int velocity)
	{
		super(x,y,r);
		this.direction = direction;
		this.velocity = velocity;
	}
	
	// moves the x or y coordinates of the shape based on direction 
	// and velocity
	public void move()
	{  
		switch (direction) 
		{
			case 0: //0 represents UP
				if ((getPositionInfo(1) - 2 * getPositionInfo(2)) - velocity <= 0)
				{
					direction = 1;
					setPositionInfo(1, getPositionInfo(1) + velocity);	
				}
				else
				{
					setPositionInfo(1, getPositionInfo(1) - velocity);	
				}
				break;
			case 1: //1 represents DOWN
				if ((getPositionInfo(1) + 2 * getPositionInfo(2)) + velocity >= 700)
				{
					direction = 0;
					setPositionInfo(1, getPositionInfo(1) - velocity);  
				}
				else
				{
					setPositionInfo(1, getPositionInfo(1) + velocity);
				}
				break;
			case 2: //2 represents LEFT
				if ((getPositionInfo(0) - 2 * getPositionInfo(2)) - velocity <= 0)
				{
					direction = 3;
					setPositionInfo(0, getPositionInfo(0) + velocity);	
				}
				else 
				{
					setPositionInfo(0, getPositionInfo(0) - velocity);	
				}
				break;
			case 3: //3 represents RIGHT
				if ((getPositionInfo(0) + 2 * getPositionInfo(2)) + velocity >= 1000)
				{
					direction = 2;
					setPositionInfo(0, getPositionInfo(0) - velocity);	
				}
				else
				{
					setPositionInfo(0, getPositionInfo(0) + velocity);
				}
				break;
		}
	}

	@Override
	public void draw(Graphics2D g2)
	{
		g2.setColor(super.getColor());
		var rad = super.getPositionInfo(2);
		Rectangle2D.Double rectangle = new Rectangle2D.Double(super.getPositionInfo(0) - 1.5 * rad, super.getPositionInfo(1) - 1.5 * rad, 3*rad, 3*rad);
		g2.draw(rectangle);
		g2.fill(rectangle);
		super.draw(g2);
	}
}