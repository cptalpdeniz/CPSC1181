import java.io.*;
import java.net.*;
import java.util.*;

public class InventoryServer implements Runnable
{
	private Socket socket;
	private Scanner in;
	private PrintWriter out;
	private Inventory inventory;

	public InventoryServer(Socket socket, Inventory inventory)
	{
		this.socket = socket;
		this.inventory = inventory;
	}

	public void run()
	{
		try
		{
			in = new Scanner(socket.getInputStream());
			out = new PrintWriter(socket.getOutputStream());
			doService();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void doService() throws IOException
	{
		if (!in.hasNext()) 
			return;
		var command = in.next();
		if (command.equals("QUIT")) 
			return;
		else 
			executeCommand(command);
	}

	public void executeCommand(String command) throws IOException
	{
		int account = in.nextInt();
		
	}
}