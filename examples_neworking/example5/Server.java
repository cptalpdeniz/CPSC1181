import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
*   A server that executes the Simple Bank Access Protocol.
*/
public class Server
{  
   public static void main(String[] args) throws IOException
   {  
      final int ACCOUNTS_LENGTH = 10;
      Bank bank = new Bank(ACCOUNTS_LENGTH);
      final int SBAP_PORT = 18888;
      ServerSocket server = new ServerSocket(SBAP_PORT);
      
      while (true)
      {
         System.out.println("Waiting for clients to connect...");
         Socket client = server.accept();
         System.out.println("Client connected.");
         BankService service = new BankService(client, bank);
         Thread t = new Thread(service);
         t.start();
      }
   }
}

class BankService implements Runnable, Protocol
{
   private Socket client;
   private DataInputStream in;
   private DataOutputStream out;
   private Bank bank;
   /**
   *   Constructs a service object that processes commands
   *   from a socket for a bank.
   *   @param aSocket the socket
   *   @param aBank the bank
   */
   public BankService(Socket client, Bank bank)
   {
      this.client = client;
      this.bank = bank;
   }

   public void run()
   {
      try
      {
         in = new DataInputStream(client.getInputStream());
         out = new DataOutputStream(client.getOutputStream());
         doService();            
        
      }
      catch (IOException exception)
      {
         System.out.println("something is wrong");
         // do nothing
      } 
      finally
      {
        // System.out.println("finally");
         try{
            client.close();
         }  
         catch (IOException exception){
            // do nothing
         }  
      }
   }

   /**
   *   Executes all commands until the QUIT command or the
   *   end of input.
   */
   public void doService() throws IOException {      
      int command=0;
      double amount,balance;
      int account;
      while(command!=Protocol.QUIT)
      {  
         command = in.readInt();
         switch(command){
            case Protocol.WITHDRAW:
               account = in.readInt();
               amount = in.readDouble(); 
               bank.withdraw(account, amount);
               out.writeInt(Protocol.SUCCEED);
               out.flush();
            break; 

            case Protocol.DEPOSIT:
               account = in.readInt();
               amount = in.readDouble(); 
               bank.deposit(account, amount);
               out.writeInt(Protocol.SUCCEED);
               out.flush();
            break;   

            case Protocol.BALANCE:
               account = in.readInt();
               balance = bank.getBalance(account);
               out.writeInt(Protocol.SUCCEED);
               out.writeDouble(balance);
               out.flush();
            break;

            case Protocol.QUIT:
               out.writeInt(Protocol.CLOSED);
               out.flush();
            break;

            default:
               out.writeInt(Protocol.INVALID_COMMAND);
               out.flush();
         }

      }
   }
}









