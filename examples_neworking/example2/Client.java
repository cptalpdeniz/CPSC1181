
import java.io.*;
import java.net.Socket;
import java.util.*;

	public class Client {
		public static void main( String[] args )  throws IOException {
		
			Socket client = null;
                
			try {
				client = new Socket( "localhost", 10000 );
				OutputStream outS = client.getOutputStream( );
				PrintWriter out = new PrintWriter(outS);
				for( int i = 0; i < 20; i++ ){
					out.println("CPSC1181_"+i);
					out.flush();
				}	
				
			}
			catch( IOException e ) {
				e.printStackTrace( );
			}
			finally {
				client.close( );
			}

		}
	}
  
 
