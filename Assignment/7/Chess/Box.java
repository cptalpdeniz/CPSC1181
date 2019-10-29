/**
* Assignment 7
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Color;

public class Box
{
	private Rectangle2D.Double box;

	public Box(double x, double y, double width)
	{
		box = new Rectangle2D.Double(x,y,width, width);
	}

	public void draw(Graphics2D g2)
	{
		g2.draw(box);
	}

	public Rectangle2D.Double getRectangleBox()
	{
		return box;
	}

	public void fill(Graphics2D g2)
	{
		g2.draw(box);
		g2.setColor(new Color(204,102,0));
		g2.fill(box);
	}
	public void drawSelectedBox(Graphics2D g2, Color color, boolean isSelectedBoxWhite)
	{
		var defaultStroke = g2.getStroke();
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(4));
		g2.draw(new Rectangle2D.Double(box.getX(),box.getY(),box.getWidth(), box.getWidth()));
		g2.setStroke(defaultStroke);
		g2.draw(box);
	}
}