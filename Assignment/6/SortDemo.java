import java.awt.*;
import java.util.*;

public class SortDemo
{
	public static void main(String[] args)
	{
		Rectangle rect1 = new Rectangle(5, 10, 20, 30); 
		Rectangle rect2 = new Rectangle(10, 20, 30, 15); 
		Rectangle rect3 = new Rectangle(20, 30, 45, 10);  

	// Put the rectangles into a list 
		ArrayList<Rectangle> list = new ArrayList<Rectangle>(); 
		list.add(rect1); 
		list.add(rect2); 
		list.add(rect3); 

		class RectangleComparator implements Comparator<Rectangle>
		{
			/**
		  	Compares two Rectangle objects.
			@param r1 the first rectangle
			@param r2 the second rectangle
			@return 1 if the area of the first rectangle is larger than the area of
				the second rectangle, -1 if the area of the first rectangle is
				smaller than the area of the second rectangle or 0 if the two
				rectangles have the same area
			*/
			public int compare(Rectangle r1, Rectangle r2)
			{
				if ((r1.getHeight() * r1.getWidth()) > (r2.getHeight() * r2.getWidth())) { return 1; }
				else if ((r1.getHeight() * r1.getWidth()) < (r2.getHeight() * r2.getWidth())) { return -1; }
				else if ((r1.getHeight() * r1.getWidth()) == (r2.getHeight() * r2.getWidth())) { return 0; }
				return 9;
			}
		}
		RectangleComparator comparator = new RectangleComparator();
		for (int i = 1; i < list.size(); i++) 
		{
			for (int j = i ; j > 0 ; j--)
			{
				if (comparator.compare((Rectangle)list.get(j), (Rectangle)list.get(j-1)) == 1)
				{
					var temp = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1,temp);
				}
			}
		}
		sort(list);

	// Print out the sorted list 
		for (int i = 0; i < list.size(); i++) 
		{
			Rectangle r = list.get(i); 
			System.out.println(r.getWidth() + " " + r.getHeight()); 
			System.out.println(r.getWidth() * r.getHeight()); 
		}
	}		
}