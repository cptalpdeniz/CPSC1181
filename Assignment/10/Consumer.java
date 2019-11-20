/**
* Assignment 10
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.lang.Thread;

public class Consumer implements Runnable
{
	private Bucket bucket;

	public Consumer(Bucket bucket)
	{
		this.bucket = bucket;
	}

	public void run()
	{
		try
		{
			while (! Thread.currentThread().isInterrupted())
			{
				System.out.println(bucket.median());
				Thread.sleep(2);
			}
		}
		catch (InterruptedException e) { }
	}
}