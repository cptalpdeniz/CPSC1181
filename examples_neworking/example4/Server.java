import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
// Server side as a thread
// Two-way connection
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
				e.printStackTrace( );
			}
		}
	}
}	

class Service implements Protocol, Runnable{
	private Socket client=null;
	public Service(Socket client){
		this.client = client;
	}
	public void run(){
		int response=0;
		int n;
		try {
			DataInputStream in = new DataInputStream(client.getInputStream());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			while(response!=Protocol.QUIT) {
				response = in.readInt();
				if(response==Protocol.NUMBER){
					n = in.readInt();
					out.writeInt(Protocol.RESULT);
					out.writeInt(n*n);
				}
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
				System.out.println("Unkonw Error closing connection");
			}
		}   
		

	}
		
}	
  

