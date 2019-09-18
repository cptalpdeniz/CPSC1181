// File: TicketMachine
// Name: Alp Deniz Senyurt
// Student ID: 100342433

/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2011.07.31
 */
public class TicketMachine
{
	
	private int price;  // The price of a ticket from this machine.
	private int balance; // The amount of money entered by a customer so far.
	private int total; // The total amount of money collected by this machine.

	/**
 	* Create a machine that issues tickets of the given price.
 	* Note that the price must be greater than zero, and there
 	* are no checks to ensure this.
 	*/
	public TicketMachine(int cost)
	{
		price = cost;
		balance = 0;
		total = 0;
	}

	/**
 	* Return the price of a ticket.
 	*/
	public int getPrice()
	{
		return price;
	}

	/**
 	* Return the amount of money left for the next ticket.
 	*/
	public int getBalance()
	{
		return balance;
	}

	/**
 	* Receive an amount of money from a customer.
 	*/
	public void insertMoney(int amount)
	{
		balance = balance + amount;
	}

	/**
 	* Print a ticket.
 	* Update the total collected and
 	* reduce the balance to zero.
 	*/
	public void printTicket()
	{
		if (balance >= price)
		{
			// Simulate the printing of a ticket.
		System.out.println("##################");
		System.out.println("# The BlueJ Line");
		System.out.println("# Ticket");
		System.out.println("# " + price + " cents.");
		System.out.println("##################");
		System.out.println();
		balance = balance - price;
		}
		else
		{
			System.out.println("ERROR!\n\nInsufficient Money. Please add $" + (price - balance) + " to get your ticket.");
		}		

		// Update the total collected with the balance.
		
		/* 
		--- QUESTION ---
		Why is the total collected update is done after printing the ticket? It can be safely done in insertMoney() method since  
		we do not implement any refund operation in the program.
		*/
		total = total + price;
	}
	
	public int getTotal()
	{
		return total;
	}	
    
    	/**
            Question 4: emptyMachine
        */
	// develop your code here.

	public int emptyMachine()
	{
		var temp = total;
		balance = 0;
		total = 0;
		return temp;
	}
}
