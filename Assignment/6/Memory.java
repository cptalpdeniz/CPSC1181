import java.util.*;

public class Memory
{
	ArrayList<String> lifeData;
	 
	public Memory(String name, int age)
	{
		lifeData = new ArrayList<String>();
		lifeData.add("Name: " + name);
		lifeData.add("Age:  " + age);
	}

	public void addLifeData(String datum)
	{
		lifeData.add(datum);
	}

	public void dumpMemory()
	{
		for (String s : lifeData)
		{
			System.out.println(s);
		}
	}
}