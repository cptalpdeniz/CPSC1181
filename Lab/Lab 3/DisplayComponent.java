import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   A component that draws two rectangles.
*/
public class DisplayComponent extends JComponent
{  
	public void paintComponent(Graphics g)
	{  
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		
		// Create an instance of TestShape and invoke its draw method
		TestShape test = new TestShape();
		test.changeBackground(g2);
		test.draw(g2);
		test.clearAll(g2, getWidth(), getHeight());
	  
	}
}
