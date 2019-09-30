import java.util.*;

public class InOut
{
	public static void main (String[] args)  
	{
		boolean flag=true;
		Scanner myInput = new Scanner(System.in);    
		String str;
		double x,y;

		do {
		 	System.out.print("\ninput X : "); 
			x = myInput.nextInt();
			
			if(flag)
				System.out.println(x);
			
			System.out.print("input Y : "); 
			y = myInput.nextInt();
			
			if(flag)
				System.out.println(y);
			
			System.out.println("X + Y = "+(x+y));
		
		} while (x!=0 || y!=0);
	}
}