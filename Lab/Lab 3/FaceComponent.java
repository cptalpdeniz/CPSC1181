import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
   A component that draws two rectangles.
*/
public class FaceComponent extends JComponent
{  	
    Face c1,c2, c3;
	public FaceComponent()
	{	
		c1 = new Face(100,100,50);
		c2 = new Face(80,80,6);
		c3 = new Face(120,80,6);
		
	}	
	public void paintComponent(Graphics g)
	{  
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
	
		// draw circles
		c1.draw(g2, new Color(255, 255, 0));
		c2.draw(g2, new Color(0, 0, 0));
		c3.draw(g2, new Color(0, 0, 0));
	  
	}
	
}
