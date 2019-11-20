/**
* Assignment 10
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.util.Random;
import java.lang.Thread;

public class Producer implements Runnable
{
	private Bucket bucket;

	public Producer(Bucket bucket)
	{
		this.bucket = bucket;
	}

	public void run()
	{
		Random r = new Random();
		try
		{
			while (! Thread.currentThread().isInterrupted())
			{
				for (int i = 0; i < 10; i++) 
				{
					var randomInt = r.nextInt(256);
					bucket.add(randomInt);
				}
				Thread.sleep(1);
			}
		}
		catch (InterruptedException e) { }
	}
}