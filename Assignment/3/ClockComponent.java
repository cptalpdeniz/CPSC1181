/**
* Assignment 3
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.time.LocalDateTime;

/**
   A component that draws two rectangles.
*/
public class ClockComponent extends JComponent
{  	
	/**
	* @param c1 c1 variable is used for outer circle (tried to find a simple way to draw the clock then draw stroke/border with color, however was unavailable to do it hence 2 circles)
	* @param c2 c2 variable is used for the actual clock
	* @param c3 the center of the circle where the clock handles originate from
	*/
    Clock c1, c2, c3;
	public ClockComponent()
	{
		/* 
		200 is the center for both Width and Height properties of the frame as FRAME_WIDTH and FRAME_HEIGHT are both set to 400
		However, I do not understand why neither 200 nor getHeight() / 2 is not working. It seems to draw the circle a little bit below the center of the frame for some reason. Maybe it 400 is the frame of the window which includes the title bar hence not being in the middle. However I'm not sure about this.
		Tested on macOS 10.13.1, MacBook Air. 
		Running Java 12.0.1 2019-04-16.
		I would appreaciate if you could tell me why because I couldn't find any answer on stackoverflow as well (might as well post it there too)
		Thanks!
		*/
		c1 = new Clock(200, 200, 376 / 2.0);
		c2 = new Clock(200, 200, 360 / 2.0);
		c3 = new Clock(200, 200, 8);
	}	

	public void paintComponent(Graphics g)
	{  
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		Stroke defaultStroke = g2.getStroke();
	
		// draw circles
		c1.draw(g2, Color.GRAY);
		c2.draw(g2, getBackground());
		g2.setColor(Color.BLACK);

		//Hour marks
		for (int i = 0; i < 360 ; i += 6) 
		{
			if (i % 5 != 0)
			{
				g2.setStroke(defaultStroke);
				g2.draw(new Ellipse2D.Double(200 + 170 * Math.cos(Math.toRadians(i)), 200 + 170 * Math.sin(Math.toRadians(i)), 4, 4));	
			}
			else if (i % 90 != 0)
			{
				g2.setStroke(new BasicStroke(2));
				g2.draw(new Line2D.Double(200 + 170 * Math.cos(Math.toRadians(i)), 200 + 170 * Math.sin(Math.toRadians(i)), 200 + 175 * Math.cos(Math.toRadians(i)), 200 + 175 * Math.sin(Math.toRadians(i))));				
			}
			else if (i % 90 == 0)
			{
				g2.setStroke(new BasicStroke(4));
				g2.draw(new Line2D.Double(200 + 165 * Math.cos(Math.toRadians(i)), 200 + 165 * Math.sin(Math.toRadians(i)), 200 + 175 * Math.cos(Math.toRadians(i)), 200 + 175 * Math.sin(Math.toRadians(i))));
			}

		}
		LocalDateTime now = LocalDateTime.now();
		var hours = now.getHour()%12;
		var minute = now.getMinute();
		var seconds = now.getSecond();

		//Second handle
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(1));
		g2.draw(new Line2D.Double(200, 200, 200 + 165 * Math.cos(Math.toRadians((270 + 6 * seconds) % 360)), 200 + 165 * Math.sin(Math.toRadians((270 + 6 * seconds) % 360))));
		
		//Minute handle
		g2.setStroke(new BasicStroke(4));
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Line2D.Double(200, 200, 200 + 130 * Math.cos(Math.toRadians((270 + 6 * minute) % 360)), 200 + 130 * Math.sin(Math.toRadians((270 + 6 * minute) % 360))));

		//Hour handle
		g2.setStroke(new BasicStroke(8));
		g2.draw(new Line2D.Double(200, 200, 200 + 100 * Math.cos(Math.toRadians((270 + 30 * hours + hours / 2 ) % 360)), 200 + 100 * Math.sin(Math.toRadians((270 + 30 * hours + hours / 2 ) % 360))));

		//handle origin circle
		c3.draw(g2, Color.RED);
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Arial", Font.PLAIN, 18));
		g2.drawString("CPSC1181", getWidth() / 2 - 50, 100); //very primitive approach to the problem. Can be made converted to become dynamic with FontMetrics class and ggetFontMetric() method of Graphics2D class showever for the simplicity and syllabus of this course, I won't use that.
	}	
}