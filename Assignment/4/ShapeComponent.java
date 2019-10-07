import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.util.Random;
import java.util.ArrayList;

/**
*/
public class ShapeComponent extends JComponent
{  
	public ArrayList<Shape3Animated> shapes; 

	public ShapeComponent()
	{
		Random rand = new Random();
		shapes = new ArrayList<Shape3Animated>();
		for (int i = 0; i < 15 ; i++) 
		{
			var x = rand.nextInt(1000);
			var y = rand.nextInt(700);
			var r = rand.nextInt((29 - 11) + 1) + 11;
			var d = rand.nextInt(4);
			var v = rand.nextInt((9-2) + 1) + 2;
			shapes.add(new Shape3Animated(x,y,r,d,v));
		}
	}

	public void paintComponent(Graphics g)
	{  
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
	
		// Create your test cases here
		// Shape3 test1 = new Shape3(100,100,30);
		// test1.draw(g2);

		// Shape3 test2 = new Shape3(300,300,30);
		// test2.draw(g2);
		for (Shape3Animated shape : shapes) 
		{
			shape.draw(g2);
		}
	}
}
