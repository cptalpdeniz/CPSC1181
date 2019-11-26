public class ExampleClient implements Runnable
{
	public static void main(String[] args)
	{
		Runnable client = new Client();
		Thread t = new Thread(client);
		t.start();
	}

	public void run()
	{
		try
		{
			clientActions();
		}
		catch (Exception e) { }
	}

	public void clientActions()
	{
		System.out.println("it works");
	}
}