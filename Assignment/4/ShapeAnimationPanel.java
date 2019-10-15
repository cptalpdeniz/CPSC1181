/**
* Assignment 4
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.util.Random;
import java.util.ArrayList;

public class ShapeAnimationPanel extends JComponent
{
	/**
	* ShapeAnimationPanel is the main panel where Shapes are created, animated and drawn. 
	* @param t Timer class instance variable [private]
	* @param shapes ArrayList<Shape3Animated> 
	*/
	private Timer t;
	public static ArrayList<Shape3Animated> shapes;
	public ShapeAnimationPanel()
	{
		Random rand = new Random(); //creating random instance for randomizing: x, y, r, d, v
		shapes = new ArrayList<Shape3Animated>();
		for (int i = 0; i < 15 ; i++) 
		{
			var x = rand.nextInt(1000);
			var y = rand.nextInt(700);
			var r = rand.nextInt((30 - 10) + 1) + 10;
			var d = rand.nextInt(360);
			var v = rand.nextInt((10 - 1) + 1) + 1;
			shapes.add(new Shape3Animated(x,y,r,d,v));
		}
		//calling for timer method to start
		startTimer();
	}
	

	/*
	This implementation is wrong. Since ActionEvent is listening to any differences in values between frames and there are so many changes happening at the same time, some calculations are not executed. Because of this, some shapes stop moving after collision and when the calculations are done, start moving again.
	*/
	private void startTimer()
	{
		class TimerListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				for (int i = 0; i < 15; i++)	
				{
					shapes.get(i).move(i);
				}
				repaint();
			}
		}
		
		t = new Timer(10 /* 1000 milliSecond*/, new TimerListener());
		t.start(); 
	}

	/**
	Draws the shapes using Graphics2D class
	*/
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		for (Shape3Animated shape : shapes) 
		{
			shape.draw(g2);
		}

	}
}