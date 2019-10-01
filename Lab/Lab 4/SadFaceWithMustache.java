import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;

public class SadFaceWithMustache extends Face
{ 
	public SadFaceWithMustache(int x, int y, int radius)
	{
		super(x,y,radius);
	}
	
	public void draw(Graphics2D graphics)
	{
		int r = getRadius();
		double start = 0;
		double extent = 180;
		super.draw(graphics);
		// draw happy mouth below:
		graphics.setColor(Color.RED);
		graphics.setStroke(new BasicStroke(r/40));
		Arc2D.Double arc = new Arc2D.Double(getX()-r/2, getY()+r/2, r, r/4,start , extent, Arc2D.OPEN);
		graphics.draw(arc);
		graphics.setColor(Color.BLACK);
		graphics.setStroke(new BasicStroke(r/12));
		graphics.draw(new Line2D.Double(getX() - r / 2, getY()+r/2 - (r/12), getX()+r/2, getY()+r/2 - (r/12)));
		
	}
}