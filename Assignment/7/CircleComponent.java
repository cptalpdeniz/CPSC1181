/**
* Assignment 7
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.ArrayList;
import java.awt.Color;
import java.lang.Math;
import java.awt.BasicStroke;
import java.awt.Stroke;
import java.lang.Math;

/**
* Panel class which is inherited from JComponent of Swing
* @param mouseX X coordinate of the cursor on the screen
* @param mouseY Y coordinate of the cursor on the screen
* @param circleList ArrayList of all the circles on the screen
* @param dashLine BasicStroke object for dashed line
* @param newCircle Circle object
* @param newCircleColor Color of the newly created circle which is red.
* @param finalCircleColor Final color of the circle which is blue
*/
public class CircleComponent extends JComponent
{
	private int mouseX;
	private int mouseY;
	private ArrayList<Circle> circleList;
	private final BasicStroke dashLine = new BasicStroke(1, 
			BasicStroke.CAP_BUTT, 
			BasicStroke.JOIN_BEVEL, 
			0, new float[]{6}, 0);
	private Circle newCircle;
	private final Color newCircleColor = Color.RED;
	private final Color finalCircleColor = Color.BLUE;

	public CircleComponent()
	{
		this.circleList = new ArrayList<Circle>();
		this.mouseX = 0;
		this.mouseY = 0;
	}

	/**
	* gets the coordinates of the mouse and changes the radius of the circle accordingly
	*/
	public void moveTo(int x, int y)
	{
		mouseX = x;
		mouseY = y;
		if (newCircle == null)
		{
			newCircle = new Circle(x,y,0);
		}
		else
		{
			int dX = newCircle.get(0) - mouseX;
			int dY = newCircle.get(1) - mouseY;
			newCircle.set(2, (int)Math.sqrt(dX*dX + dY*dY));
		}
		repaint();
	}

	/**
	* final changes to circle instant and add it to ArrayList
	*/
	public void finalMove()
	{
		if (newCircle != null)
		{
			circleList.add(newCircle);
			newCircle = null;
			repaint();
		}
	}

	/**
	* Calculate the location of the circle according to the screen. HOWEVER, this approach is very primitive and would not actually alter the radius of the circles. Basically, it wouldn't keep the same screen ratio as it should be. I want to implement that but I'm way too busy with assignments, essays and midterms to implement it that way. Hopefully this is enough -Alp
	*/
	public void frameResizeCalculation(int width, int height)
	{
		var dX = width - CircleViewer.FRAME_WIDTH;
		var dY = height - CircleViewer.FRAME_HEIGHT;
		System.out.println(dX + " + " + dY);
		for (Circle circle : circleList) 
		{
			circle.set(0, circle.get(0) + dX);
			circle.set(1, circle.get(1) + dY);
		}
		CircleViewer.FRAME_WIDTH = width;
		CircleViewer.FRAME_HEIGHT = height;
		repaint();
	}

	/**
	* Overriden paintComponent method of Graphics2D. Draws dashed line and calls the drawCircle()
	*/
	public void paintComponent(Graphics g)
	{

		g.setColor(finalCircleColor);
		for (Circle circle : circleList) 
		{

			drawCircle(g, circle);
		}

		Circle c = newCircle;
		if (c != null)
		{
			g.setColor(newCircleColor);
			drawCircle(g, c);

			Graphics2D g2 = (Graphics2D)g.create();
			g2.setStroke(dashLine);
			g2.drawLine(c.get(0), c.get(1), mouseX, mouseY);
			g2.dispose();
		}
	}

	/**
	* Draws the circle using the drawOval method of Graphics2D
	*/
	public void drawCircle(Graphics g, Circle c)
	{
		g.drawOval(c.get(0) - c.get(2), c.get(1) - c.get(2), c.get(2) * 2, c.get(2) * 2);
	}
}