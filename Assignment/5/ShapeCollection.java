/**
* Assignment 5
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.util.Random;

// All casses have package access

public class ShapeCollection
{
	private GeometricShape[] shapes;
	
	public static void main(String[] args)
	{
		ShapeCollection shapeTester = new ShapeCollection();
		System.out.println("\nTest case 1:");
		double average = shapeTester.findAverage();
		System.out.println("average: " + Math.round(average));
		
		System.out.println("\nTest case 2:");
		GeometricShape s = shapeTester.getMax();
		System.out.println(s);


		GeometricShape[] shapes = shapeTester.getShapes();
		System.out.println("\nTest case 3:");
		System.out.println("list of the shapes:");
		for(GeometricShape e : shapes)
			System.out.println(e);

		System.out.println("\nTest case 4:");
		shapeTester.sort();
		System.out.println("shapes sorted in ascending order based on their area:");
		for(GeometricShape e:shapes)
			System.out.println(e);

	}
	public ShapeCollection()
	{
		shapes = new GeometricShape[20];
		Random rand = new Random();
		int option;
		final int COORD = 50;
		final int LENGTH1 = 50;
		final int LENGTH2 = 100;
		for(int i = 0; i < shapes.length; i++)
		{
			option = rand.nextInt(4);
			switch(option)
			{
				case 0:
					shapes[i] = new Rectangle(
						rand.nextInt(COORD),
						rand.nextInt(COORD),
						rand.nextInt(LENGTH2),
						rand.nextInt(LENGTH2));
					break;
				case 1:
					shapes[i] = new Square(
						rand.nextInt(COORD),
						rand.nextInt(COORD),
						rand.nextInt(LENGTH2));
					break;
				case 2:
					shapes[i] = new Oval(
						rand.nextInt(COORD),
						rand.nextInt(COORD),
						rand.nextInt(LENGTH1),
						rand.nextInt(LENGTH2));
					break;
				case 3:
					shapes[i]= new Circle(
						rand.nextInt(COORD),
						rand.nextInt(COORD),
						rand.nextInt(LENGTH1));
					break;
			}
		}	
	}
	public double findAverage()
	{
		double total = 0;
		for(int i = 0; i < shapes.length; i++)
		{
			total += shapes[i].getArea();
		}
		return total / shapes.length;
	}
	public GeometricShape getMax()
	{
		GeometricShape max = shapes[0];
		for(int i = 1; i < shapes.length; i++)
		{
			if(shapes[i].getArea() > max.getArea())
				max = shapes[i];
		}
		return max;
	}
	public void sort()
	{
		GeometricShape tmp;
		for(int i = 0; i < shapes.length; i++)
		{
			for(int j=i+1; j<shapes.length; j++)
			{
				if(shapes[i].getArea()>shapes[j].getArea())
				{
					tmp = shapes[i];
					shapes[i] = shapes[j];
					shapes[j] = tmp;
				}

			}
		}

	}
	public GeometricShape[] getShapes()
	{
		return shapes;
	}
}