import java.io.*;
import java.net.*;
import java.util.*;

public class InventoryServer implements Runnable
{
	private Socket socket;
	private Scanner in;
	private PrintWriter out;
	private Inventory Inventory;

	public InventoryServer(Socket socket, Inventory inventory)
	{
		this.socket = socket;
		this.inventory = inventory;
	}

	public void run()
	{
		try
		{
			try
			{
				in = new Scanner(socket.getInputStream());
				out = new PrintWriter(socket.getOutputStream());
				doService();
			}
			finally
			{
				s.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void doService()
	{
		if (!in.hasNext()) 
			return;
		var command = in.next();
		if (command.equals("QUIT")) 
			return;
		else 
			executeCommand(command);
	}

	public void executeCommand(String command)
	{
		
	}
}