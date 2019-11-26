import java.io.DataInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
// Server side as a thread
// One-way connection
public class Server {
	public static void main( String[] args )  throws IOException  {
		ServerSocket server = new ServerSocket( 10000 );
		int count =1;
		while (true){
			try{
				System.out.println( "Server waiting for client : " +count++);
				Socket client = server.accept();
				System.out.println("Client connected.");
				Service service = new Service(client);
				Thread t = new Thread(service);
				t.start();
			}
			catch( IOException e ){
				System.out.println("Program terminated unexpectly!");
			}
		}
	}
}	

class Service implements Protocol, Runnable{
	private Socket client=null;
	public Service(Socket client){
		this.client = client;
	}
	@Override
	public void run(){
		int response=0;
		try {
			DataInputStream in = new DataInputStream(client.getInputStream());
			while(response!=Protocol.END) {
				response = in.readInt();
				if(response==Protocol.DATA)
					System.out.println(in.readUTF() );
			}	
		}
          
		catch( IOException e ){
			e.printStackTrace( );
		}
		finally{
			System.out.println("closing connection");
			try{
				client.close();
			}catch( IOException e ){
				System.out.println("Error closing connection");
			}
		}   
		

	}
		
}	
  

