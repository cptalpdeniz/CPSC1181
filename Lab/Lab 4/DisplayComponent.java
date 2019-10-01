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

	// Create an instance of Face and invoke its draw method
		Face face1 = new Face(100,100,50);
		face1.draw(g2);
		HappyFace happyFace1 = new HappyFace(250, 250, 120);
		happyFace1.draw(g2);
		SadFace sadFace1 = new SadFace(450, 450, 120);
		sadFace1.draw(g2);
		SadFaceWithMustache mustacheFace1 = new SadFaceWithMustache(100, 350, 50);
		SadFaceWithMustache mustacheFace2 = new SadFaceWithMustache(550, 180, 150);
		mustacheFace1.draw(g2);
		mustacheFace2.draw(g2);
	}
}
