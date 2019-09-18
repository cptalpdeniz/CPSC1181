// File: TicketMachineTester
// Name: Alp Deniz Senyurt
// Student ID: 100342433
import java.util.*;

public class TicketMachineTester
{
	public static void main(String[] args){
		
		Scanner S = new Scanner(System.in);
		// Question 1
		System.out.println("\n\n--------- QUESTION 1 TEST ---------");
		TicketMachine q1 = new  TicketMachine(20); // Creates a TicketMachine for 75 cents price of each ticket.
    	System.out.println("my balance :" + q1.getBalance());        
    	q1.insertMoney(20);
		q1.printTicket();
        // Write your test cases for part 1 below after you have fixed the problems and delete the preceding lines of code. 
    	
    	System.out.println("\n\nTest case. Insert the price of the ticket that you want to get:");
    	var a = S.nextInt(); //variable name a for quick variable initilization.
    	TicketMachine testMachine = new TicketMachine(a);
    	System.out.println("\nPlease insert money: ");
    	testMachine.insertMoney(S.nextInt());
    	testMachine.printTicket();

		
        // Question 2 : implement your code below
        System.out.println("\n\n--------- QUESTION 2 TEST ---------");
    	TicketMachine t1 = new TicketMachine(50);
    	TicketMachine t2 = new TicketMachine(80);
    	
    	t1.insertMoney(100);
    	t2.insertMoney(40);
    	
    	System.out.println("\nFirst ticket:");
    	t1.printTicket();
    	System.out.println("Second ticket:");
    	t2.printTicket();

    	System.out.println("\n\nMachine 1 balance: " + Integer.toString(t1.getBalance()) + "\nMachine 2 balance: " + Integer.toString(t2.getBalance()));


	/*
	  Question 3: 
		The program would compile however it won't work as intended since when we add the "int" keyword to the price variable, we are creating a new
		local variable and not actually using the price variable that is defined in the class.	
	*/
        
        
        
        // Question 4 : implement test case for your code below
        System.out.println("\n\n--------- QUESTION 4 TEST ---------");
        TicketMachine t4 = new TicketMachine(5);
        t4.insertMoney(100);
        for (int i = 0; i < 6; i++) 
        {
        	t4.printTicket();	
        }
        System.out.println("\nBefore calling the emptyMachine() method, the balance is: " + Integer.toString(t4.getBalance()) + "\nTotal is: " + Integer.toString(t4.getTotal()));
        var tempTotal = t4.emptyMachine();
        System.out.println("\nAfter calling the emptyMachine() method, the balance is: " + Integer.toString(t4.getBalance()) + "\nTotal sold is: " + Integer.toString(tempTotal) + "\nAnd the total variable in the class is actually : " + Integer.toString(t4.getTotal()));
        

        
	} 
}	

/* Anser Question 3:







*/
