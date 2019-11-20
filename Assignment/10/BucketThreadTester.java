/**
* Assignment 10
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.lang.Thread;

/**
*		IMPORTANT NOTE
* I don't know why but the program does not provide consistent results. Sometimes the output is -1 since the arraylist is empty
* sometimes its normal random numbers and the median is printed.
*/
public class BucketThreadTester
{
	public static void main(String[] args)
	{
		Bucket bucket = new Bucket();

		Runnable producer = new Producer(bucket);
		Runnable consumer = new Consumer(bucket);

		Thread tP = new Thread(producer);
		Thread tC = new Thread(consumer);
		tP.start();
		tC.start();

		var end = System.currentTimeMillis() + 30 * 1000;
		while (true)
		{
			if (System.currentTimeMillis() > end)
			{
				tP.interrupt();
				tC.interrupt();
			}
		}
	}
}