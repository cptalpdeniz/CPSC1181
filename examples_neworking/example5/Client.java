import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
*   This program tests the bank server.
*/
public class Client implements Protocol
{
   public static void main(String[] args) throws IOException
   {
      Socket client = new Socket("localhost",Protocol.PORT);
      DataInputStream in = new DataInputStream(client.getInputStream());
      DataOutputStream out= new DataOutputStream(client.getOutputStream());
      
      double balance;
      int response;

      System.out.print("Deposit 1000$ in account #3: ");
      out.writeInt(Protocol.DEPOSIT);
      out.writeInt(3); // account Number
      out.writeDouble(1000);
      out.flush();
      response = in.readInt();
      System.out.println("Received: " + response);
      System.out.println();
      
      System.out.print("Withdraw 200$ from account #3: ");
      out.writeInt(Protocol.WITHDRAW);
      out.writeInt(3); // account Number
      out.writeDouble(200);
      out.flush();
      response = in.readInt();
      System.out.println("Received: " + response);
      System.out.println();

      System.out.print("get balance of account #3: ");
      out.writeInt(Protocol.BALANCE);
      out.writeInt(3); // account Number
      out.flush();
      response = in.readInt();
      if(response==Protocol.SUCCEED)
         System.out.println("balance: " + in.readDouble());
      System.out.println();

      System.out.print("send invalid command: ");
      out.writeInt(888);
      out.flush();
      response = in.readInt();
      System.out.println("Received: " + response);
      System.out.println();

      System.out.print("quit: ");
      out.writeInt(Protocol.QUIT);
      out.flush();
      response = in.readInt();
      System.out.println("Received: " + response);
    

      client.close();
   }
}





