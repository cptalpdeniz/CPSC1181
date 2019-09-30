import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.time.*;
import java.lang.Math;

/**
   A component that draws two rectangles.
*/
public class ClockComponent extends JComponent
{  	
	/**
	* @param c1 c1 variable is used for outer circle (tried to find a simple way to draw the clock then draw stroke with color, however was unavailable to do it hence 2 circles)
	* @param c2 c2 variable is used for the actual clock
	* @param c3 the center of the circle where the clock handles originate from
	*/
    Clock c1, c2, c3;
	public ClockComponent()
	{
		/* 
		200 is the center for both Width and Height properties of the frame as FRAME_WIDTH and FRAME_HEIGHT is both set to 400
		However, I do not understand why neither 200 nor getHeight() / 2 is not working. It seems to draw the circle a little bit below the center of the frame for some reason.
		Tested on macOS 10.13.1, MacBook Air. 
		Running Java 12.0.1 2019-04-16.
		I would appreaciate if you could tell me why because I couldn't find any answer on stackoverflow as well (might as well post it there too)
		Thanks!
		*/
		c1 = new Clock(200, 200, 365 / 2.0);
		c2 = new Clock(200, 200, 360 / 2.0);
		c3 = new Clock(200, 200, 8);
		
		// For testing purposes
		System.out.println(c1);
	}	
	public void paintComponent(Graphics g)
	{  
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
	
		// draw circles
		c1.draw(g2, Color.GRAY);
		c2.draw(g2, getBackground());
		g2.setColor(Color.BLACK);
		/*
		g2.draw(new Line2D.Double(200, 50, 200, 30)); 
		g2.draw(new Line2D.Double(200, 350, 200, 370));
		g2.draw(new Line2D.Double(30, 200, 50, 200));
		g2.draw(new Line2D.Double(350, 200, 370, 200));
		*/
		for (int i = 0; i < 360 ; i += 30) 
		{
			g2.draw(new Line2D.Double(200 + 150 * Math.cos(Math.toRadians(i)), 200 + 150 * Math.sin(Math.toRadians(i)), 200 + 170 * Math.cos(Math.toRadians(i)), 200 + 170 * Math.sin(Math.toRadians(i))));	
		}
		LocalDateTime now = LocalDateTime.now();
		var hours = now.getHour()%12;
		var minute = now.getMinute();
		var seconds = now.getSecond();
		System.out.println(hours + " " + minute + " " + seconds);
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(1));
		g2.draw(new Line2D.Double(200, 200, 200 + 160 * Math.cos(Math.toRadians((270 + 6 * seconds) % 360)), 200 + 160 * Math.sin(Math.toRadians((270 + 6 * seconds) % 360))));
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Line2D.Double(200, 200, 200 + 130 * Math.cos(Math.toRadians((270 + 6 * minute) % 360)), 200 + 130 * Math.sin(Math.toRadians((270 + 6 * minute) % 360))));
		g2.draw(new Line2D.Double(200, 200, 200 + 100 * Math.cos(Math.toRadians((270 + 30 * hours + hours / 2 ) % 360)), 200 + 100 * Math.sin(Math.toRadians((270 + 30 * hours + hours / 2 ) % 360))));

		c3.draw(g2, Color.RED);
	}
	
}
