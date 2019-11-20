/**
* Assignment 10
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.Collections;

/**
* class Bucket manages an ArrayList of integer numbers
*/
public class Bucket
{
	private ArrayList<Integer> bucket;
	private Lock lock;
	
	/** Default constructor*/
	public Bucket()
	{
		bucket = new ArrayList<Integer>();
		lock = new ReentrantLock();
	}
	
	/** add an element to the bucket
	* @param n: an integer number
	*/
	public void add(int n)
	{
		lock.lock();
		bucket.add(n);
		lock.unlock();
	}
	
	/** Returns the median value of the bucket, and then removes all of the elements from the bucket
	* @return the median of the bucket or returns -1 if bucket is empty
	* post condition: the elements of the bucket are removed
	*/
	public double median()
	{	
		lock.lock();
		if (bucket.size() == 0)
			return -1;
		Collections.sort(bucket);
		int median = bucket.get(bucket.size() / 2);
		reset();
		lock.unlock();
		return median;
	}

	/** Removes all of elements from the bucket
	*/
	private void reset()
	{
		bucket.clear();
	}
}