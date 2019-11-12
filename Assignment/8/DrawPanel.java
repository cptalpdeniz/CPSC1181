import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class DrawPanel extends JPanel
{
	ArrayList<Circle> circles;
	public DrawPanel(){
		circles = new ArrayList<Circle>();
	}
	public void addCircle(double x, double y, double r){
		circles.add(new Circle(x,y,r));
		// call reapint from the JPanel
		repaint();
	}
	public void removeCircle(){
		if(circles.size()>0){
			circles.remove(0);
		}
	}

	public void paintComponent(Graphics g)
	{  
		// Important call super.paintComponent(g) first in this case
		// Be carful not to fall in recursion
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Circle c : circles)
			c.draw(g2);
	}
}