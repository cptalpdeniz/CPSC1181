import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Shape2 extends Shape1
{
	public Shape2(double x, double y, double r)
	{
		super(x,y,r);
	}

	@Override
	public void draw(Graphics2D g2)
	{
		g2.setColor(super.getColor());
		var rad = super.getPositionInfo(2);
		Ellipse2D.Double ellipse = new Ellipse2D.Double(super.getPositionInfo(0) - rad, super.getPositionInfo(1) - 2 * rad, 2*rad, 4*rad);
		g2.draw(ellipse);
		g2.fill(ellipse);
		super.draw(g2);
		
	}
}