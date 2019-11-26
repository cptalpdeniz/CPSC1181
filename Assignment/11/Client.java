import java.io.*;
import java.io.DataInputStream;
import java.net.*;
import java.util.*;


public class Client implements Runnable, Protocol
{
	private Socket socket;
	private DataOutputStream out;
	private DataInputStream in;
	private ProtocolFunctional protocol;

	public static void main(String[] args)
	{
		Runnable client = new Client();
		Thread t = new Thread(client);
		t.start();
	}

	public Client()
	{	
		try
		{
			protocol = (int command, int response, DataInputStream in) -> {
				String tempStr = "";
				try
				{
					switch (response)
					{
						case Protocol.SUCCEED:
							tempStr = "Server responded with: SUCCEED. \n";
							switch (command)
							{
								case Protocol.ADD_ITEM:
									tempStr += "Item has been added successfully.";
									break;
								case Protocol.CHECK_ITEM:
									tempStr += "The inventory has " + in.readInt() + " number of this item.";
									break;
								case Protocol.TAKE_ITEM:
									tempStr += in.readInt() + " items has been removed from the inventory"; 
									break;
								case Protocol.GET_THRESHOLD:
									tempStr += "Items under this threshold are: " + in.readUTF();
							}
							break;
						case Protocol.FAILED:
							tempStr = "Server responded with: FAILED!";
							break;
					}
				}
				catch (Exception e) { }
				return tempStr;
			};
			this.socket = new Socket("localhost", Protocol.PORT);	
			this.out = new DataOutputStream(socket.getOutputStream());
			this.in = new DataInputStream(socket.getInputStream());
		}
		catch(IOException e)
		{
			System.out.println("Error! Can't connect to the server.");
		}
	}

	public void run()
	{
		Random r = new Random();
		while (! Thread.currentThread().isInterrupted())
		{
			try
			{
				var count = r.nextInt((20 - 10) + 1) + 10; //random number of requests between 10-20. nth command after 10th command will be QUIT command. However on the final iteration command will always be QUIT
				for (int i = 0; i < count; i++)
				{
					if (i - 1 == count || i >= 10 && r.nextBoolean())
					{
						clientActions(Protocol.QUIT);
						break;
					}
					clientActions(r.nextInt((10 - 2) + 1) + 2); //adding randomization to sent 
					Thread.sleep(r.nextInt((500 - 100) + 1) + 100); //random delay between 100-500 ms
				}
			}
			catch (IOException e) 
			{
				System.out.println("Error with Input/Output stream!");
			}
			catch (InterruptedException e)
			{
				System.out.println("Thread interrupted!");
			}
		}
	}

	public void clientActions(int command) throws IOException
	{
		Random rand = new Random();
		String readableResponse = "";
		boolean serverConnectionClosed = false;
		var tempItem = ListInventory.list[rand.nextInt(7)];

		try
		{
			switch (command)
			{
				case Protocol.ADD_ITEM:
					out.writeInt(Protocol.ADD_ITEM);
					out.writeUTF(tempItem);
					out.writeInt(rand.nextInt(30));
					out.flush();
					System.out.println("Sending ADD_ITEM command for " + tempItem);
					readableResponse = protocol.m_serverResponse(Protocol.ADD_ITEM, in.readInt(), in);
					break;
				case Protocol.CHECK_ITEM:
					out.writeInt(Protocol.CHECK_ITEM);
					out.writeUTF(tempItem);
					out.flush();
					System.out.println("Sending CHECK_ITEM command for " + tempItem);
					readableResponse = protocol.m_serverResponse(Protocol.CHECK_ITEM, in.readInt(), in);
					break;
				case Protocol.TAKE_ITEM:
					out.writeInt(Protocol.TAKE_ITEM);
					out.writeUTF(tempItem);
					out.writeInt(rand.nextInt(5));
					out.flush();
					System.out.println("Sending TAKE_ITEM command for " + tempItem);
					readableResponse = protocol.m_serverResponse(Protocol.TAKE_ITEM, in.readInt(), in);
					break;
				case Protocol.GET_THRESHOLD:
					var tempInt = rand.nextInt(6);
					out.writeInt(Protocol.GET_THRESHOLD);
					out.writeInt(tempInt);
					out.flush();
					System.out.println("Sending GET_THRESHOLD command for number of " + tempInt);
					readableResponse = protocol.m_serverResponse(Protocol.GET_THRESHOLD, in.readInt(), in);
					break;
				case Protocol.QUIT:
					out.writeInt(Protocol.QUIT);
					out.flush();
					serverConnectionClosed = (in.readInt() == 1) ? true : false;
					break;
				default:
					out.writeInt(command);
					out.flush();
					readableResponse = protocol.m_serverResponse(7, in.readInt(), in);
					break;
			}
		}
		catch (IOException e)
		{
			System.out.println("Error with Input/Output stream!");
		}
		finally
		{
			if (serverConnectionClosed)
			{
				try
				{
					socket.close();
					System.out.println("Server connection closed successfully");
				}
				catch (Exception e)
				{
					System.out.println("Error when closing the connection! Error is: " + e.toString());
				}
			}
			else
			{
				System.out.println(readableResponse);
			}
		}
	}
}