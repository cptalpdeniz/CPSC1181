import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.net.URLConnection;
import java.net.URL;

/**
*   This program demonstrates how to use a socket to communicate
*   with a web server. Supply the name of the host and the
*   resource on the command-line, for example
*   java WebGet java.sun.com index.html
*/
public class URLc
{
   public static void main(String[] args) throws IOException
   {
      URL u = new URL("http://goole.com/");
      URLConnection connection = u.openConnection();
      System.out.println(connection);
      InputStream instream = connection.getInputStream();
 
      Scanner in = new Scanner(instream);
      // Read server response

      while (in.hasNextLine())
      {
         String input = in.nextLine();
         System.out.println(input);
      }

      // Always close the socket at the end

      in.close();
   }
}
