import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
// Server side of one way connection
public class Server implements Protocol{
   public static void main( String[] args )  throws IOException  {
		ServerSocket serverSoc = null;
		Socket client = null;
		int number=0;
		try {
			serverSoc = new ServerSocket( 10000 );
			System.out.println( "Server waiting for client ... " );
			client = serverSoc.accept( );
			System.out.println( "Client connected." );
			DataInputStream in = new DataInputStream( client.getInputStream( ) );
			int response=0;
			
			while(response!=Protocol.END) {
				response = in.readInt();
				if(response==Protocol.DATA)
					System.out.println(in.readUTF() );
			}	
		}
		catch( IOException e ){
			System.out.println("Program terminated unexpectly!");
		}
		finally{
			System.out.println("closing connection");
			client.close();  // this may also throws exception
			serverSoc.close();
		}
	}
}	
  
