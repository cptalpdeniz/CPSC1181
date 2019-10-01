/**
* Assignment 3
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.lang.Math;

/**
   The Clock class describes a class defined by its centre and radius. 
*/
public class Clock
{  
   public static final double PI = Math.PI; 
   private Point2D centre;
   private double radius;
   /**
      Constructs a Clock.
   */
   public Clock()
   {   
      centre = new Point2D();   
      radius=1;
 
   }
   /**
      Constructs a Clock and initialize 
      @param x coordinate of the centre
      @param y coordinate of the centre
      @param r radius of the cirlce
   */
   public Clock(double x, double y, double r)
   {   
      this.centre = new Point2D(x,y);
      this.radius = r;
   }

  /**
      set the radius of the cirlce 
      @param r radius of the circle
   */
   public void set(double r)
   {   
      radius = r;
   }
  
   /**
      move circle to the new coordinates 
      @param x new coordinate of the centre
      @param y new coordinate of the centre
   */
   public void move(double x, double y)
   {   
      centre.move(x,y); 
   }
   
    /**
      Calculates and returns the area of the circle
      @return double
   */
   public double getArea()
   {
      return radius*radius*PI;
   }
   /**
      Calculates and returns the circumference of the circle
      @return double
   */
   public double getCircumference ()
   {
      return 2*radius*PI;
   }
    /**
     override toString() method of the class
   */
   public String toString()
   {
	return "["+ centre.toString() +", r= " +radius+"]";	   
   }
   /**
     draw circle using Graphics2D g2
  */
   public void draw(Graphics2D g2, Color color)
   {
	   Ellipse2D.Double c= new Ellipse2D.Double(centre.getX()-radius,centre.getY()-radius,2*radius,2*radius);
      g2.setColor(color);
      g2.draw(c);
      g2.fill(c);
   }
}