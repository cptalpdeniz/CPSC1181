import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Shape3 extends Shape2
{
	public Shape3(double x, double y, double r)
	{
		super(x,y,r);
	}

    @Override    
    public void draw(Graphics2D g2)
    {
        // create and draw a square then invoke the super class draw(...)
        // method to draw the rectangle
		g2.setColor(super.getColor());
		var rad = super.getPositionInfo(2);
		Rectangle2D.Double rectangle = new Rectangle2D.Double(super.getPositionInfo(0) - 1.5 * rad, super.getPositionInfo(1) - 1.5 * rad, 3*rad, 3*rad);
		g2.draw(rectangle);
		g2.fill(rectangle);
		super.draw(g2);
    }
}