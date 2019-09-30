import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;


public class TestShape
{
	public void draw(Graphics2D g2)
	{
		Ellipse2D.Double e = new Ellipse2D.Double(100,100,80,60);
		g2.setColor(Color.YELLOW);
		g2.setStroke(new BasicStroke(12));
		g2.draw(e);
		g2.setColor(Color.BLUE);
		g2.fill(e);
		g2.drawString("Tutorial #3", 50,50);
	}
	public void changeBackground(Graphics2D g2)
	{
		g2.setBackground(new Color(160, 160, 160));
		g2.clearRect(50, 50, 100, 100); 
	}
	public void clearAll(Graphics2D g2, int width, int height)
	{
		g2.clearRect(0, 0, width, height);
		g2.setBackground(new Color(160, 160, 160));

	}
}	