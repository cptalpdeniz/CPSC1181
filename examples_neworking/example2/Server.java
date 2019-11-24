/*A socket is a type of file. A socket pair forms a communication channel.A server sets up a 
ServerSocket and listens for clients to connect. When a client connects, the server accepts
the new client on a new socket. The server keeps listening for new clients on the ServerSocket. 
*/
    /**
    *    Socket Server to read bytes from a given port and print
    */

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server   {
   public static void main( String[] args )  throws IOException  {
		ServerSocket serverSoc = null;
		Socket server = null;
		int number=0;
		try {
			serverSoc = new ServerSocket( 10000 );
			System.out.println( "Server waiting for client data... " );
			server = serverSoc.accept( );
			Scanner in = new Scanner( server.getInputStream( ) );
			System.out.println( "Client connected." );
			while( in.hasNext()) {
				System.out.println(in.next() );
			}	
		}
              
		catch( IOException e ){
			e.printStackTrace( );
		}
		finally{
			server.close( );
			serverSoc.close( );
		}
	}
}	
  
