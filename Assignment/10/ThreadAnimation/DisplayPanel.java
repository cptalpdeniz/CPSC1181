import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.lang.Thread;
import java.awt.Dimension;
import java.awt.Color;

public class DisplayPanel extends JPanel implements Runnable
{
	private Data data;
	private Lock lock;
	private final static int SIZE = 50;
	private final static int LENGTH = 120;

	public DisplayPanel(Data data)
	{
		this.data = data;
		this.lock = new ReentrantLock();
		setPreferredSize(new Dimension(300, 300));
	}

	public void run()
	{
		while (! Thread.currentThread().isInterrupted())
		{
			try 
			{
				repaint();
				Thread.sleep(50);
			}
			catch (Exception e) { }
		}
	}

	public void paintComponent(Graphics g)
	{
		lock.lock();
		super.paintComponent(g);
		int[] arr = data.getData();
		Graphics2D g2 = (Graphics2D)g;

		g2.setStroke(new BasicStroke(7));
		g2.setColor(Color.RED);
		for (int i = 0; i < arr.length; i++) 
		{
			g2.drawLine(10 * i, 300, 10 * i, arr[i]);
		}
		lock.unlock();
	}
}