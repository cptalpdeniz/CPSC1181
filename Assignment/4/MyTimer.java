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

public class MyTimer extends JComponent
{
	private int counter;
	private Timer t;
	public static ArrayList<Shape3Animated> shapes;
	public MyTimer()
	{
		counter = 0;
		Random rand = new Random();
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
		startTimer();
	}
	

	/**
	Starts the timer 
	*/
	private void startTimer()
	{
		class TimerListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				counter++;
				if (counter >=3000)
				{
					t.stop();
				}
				for (int i = 0; i < 15; i++)	
				{
					shapes.get(i).move(i);
				}
				repaint();
			}
		}
		
		t = new Timer(1000 /* 1000 milliSecond*/, new TimerListener());
		t.start(); 
	}
	
	/**
	Disply the time
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