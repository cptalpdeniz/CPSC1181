import java.lang.Thread;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.BasicStroke;
import java.awt.Stroke;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Data implements Runnable
{
	private int[] arr;
	private double angle=0;
	private final static int SIZE = 50;
	private final static int DELAY = 50;
	private final static int LENGTH = 120;
	private final static double SPEED = 0.01;
	private Lock lock;

	/** Default constructor that creates an array of integers*/
	public Data()
	{
		arr = new int[SIZE];
		this.lock = new ReentrantLock();
	}

	/** Accessor method to return data
	* @return data
	*/
	public int[] getData()
	{
		return arr;
	}

	/** Generates Sinusoidal data based on the speed and length of the array
	*/
	private void setData()
	{
		lock.lock();
		for(int i=0; i<arr.length; i++)
			arr[i] = LENGTH+(int)(Math.sin(angle+(double)i/Math.PI)*LENGTH);
		angle += SPEED;
		lock.unlock();
	}

	public void run()
	{
		while (! Thread.currentThread().isInterrupted())
		{
			try 
			{
				setData();
				Thread.sleep(50);
			}
			catch (Exception e) { }
		}		
	}
}