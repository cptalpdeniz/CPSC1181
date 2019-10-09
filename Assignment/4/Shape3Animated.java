/**
* Assignment 4
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.lang.Math;

public class Shape3Animated extends Shape3
{
	/**
	* @param velocity Vector2d, the velocity vector of the shape
	* @param hitboxRadius radius of the hitbox of the shape which is 2 * r
	*/
	private Vector2d velocity;  //a random velocity in pixel
	protected double hitboxRadius; 

	/**
	* Constructor of the class, sets the position of the Shape3Animated using Vector2D class (from super(Shape1)).
	* @param x
	* @param y
	* @param r
	* @param direction direction of the initial movement, in degrees, randomly generated in ShapeAnimationPanel class.
	* @param velocity velocity in terms of pixels, converted into velocity Vector 
	*/	
	public Shape3Animated(double x, double y, double r, double direction, int velocity)
	{
		super(x,y,r);
		//this.direction = direction;
		this.velocity = new Vector2d(velocity * Math.cos(Math.toRadians(direction)), velocity * Math.sin(Math.toRadians(direction)));
		this.hitboxRadius = 2 * r;
	}

	/**
	* Checks if the shape collides with the boundaries of the frame. If yes, makes the correct calculation and reverses the direction of the shape
	* @return condition if the shape hit the boundary of the frame (0 - 1000, 0 - 700)
	*/
	public boolean isColliding()
	{
		var condition = false;
		if (position.getPositionInfo(0) - hitboxRadius <= 0) //Left wall check check
		{
			position.setPositionInfo(0,hitboxRadius); //Place shape against edge
			velocity.setPositionInfo(0,-(velocity.getPositionInfo(0))); //Reverse the direction 
			velocity.setPositionInfo(1,velocity.getPositionInfo(1));
			condition = true;
		}
		else if (position.getPositionInfo(0) + hitboxRadius >= 700) //Right wall check
		{
			position.setPositionInfo(0,700 - hitboxRadius);		//Place shape against edge
			velocity.setPositionInfo(0,-(velocity.getPositionInfo(0))); //Reverse direction 
			velocity.setPositionInfo(1,(velocity.getPositionInfo(1)));
			condition = true;
		}

		else if (position.getPositionInfo(1) - hitboxRadius  <= 0) //Top wall check
		{
			position.setPositionInfo(1,hitboxRadius); //Place shape against edge
			velocity.setPositionInfo(1,-(velocity.getPositionInfo(1))); //Reverse direction
			velocity.setPositionInfo(0,(velocity.getPositionInfo(0)));
			condition = true;
		}
		else if (position.getPositionInfo(1) + hitboxRadius >= 1000) //Bottom wall check
		{
			position.setPositionInfo(1,1000 - hitboxRadius);		//Place shape against edge
			velocity.setPositionInfo(1,-(velocity.getPositionInfo(1)));    //Reverse direction
			velocity.setPositionInfo(0,velocity.getPositionInfo(0));
			condition = true;
		}
		return condition;
	}

	/**
	* isColliding(Shape3Animated shape1) method checks if the current shape collides with any other shape. 
	* The check is done by comparing the calculated distance between the centers of the shapes and the radius of each shape
	* In other words, if the sum of the radius of 2 shapes is bigger than the distance between the positions of the centers of each shape, they are indeed colliding
	* @param shape1 second shape that will be checked with the current shape
	* @return returns true if collision with another shape is detected
	*/
	public boolean isColliding(Shape3Animated shape1)
	{
		var xPosDiff = getPositionInfo(0) - shape1.getPositionInfo(0);
		var yPosDiff = getPositionInfo(1) - shape1.getPositionInfo(1);
		var distSqr = (xPosDiff * xPosDiff) + (yPosDiff * yPosDiff);
		return (distSqr < (hitboxRadius + shape1.hitboxRadius) * (hitboxRadius + shape1.hitboxRadius) * 2);
	}

	//moves the x or y coordinates of the shape based on direction 
	//and velocity
	public void move(int index)
	{  
		if (!isColliding())
		{
			for (int i = index + 1; i < 15; i++) 
			{

				var shapeElement = MyTimer.shapes.get(i);

				if (isColliding(shapeElement))
				{
					Vector2d delta = (position.subtract(shapeElement.position));
					double r = getPositionInfo(2) + shapeElement.getPositionInfo(2);
					double dist2 = delta.dot(delta);

					if (dist2 > r*r) 
					{
						return;
					}

					double d = delta.getLength();

					Vector2d mtd;
					if (d != 0.0)
					{
						mtd = delta.multiply(((getPositionInfo(2) + shapeElement.getPositionInfo(2)) - d) / d); //minimum translation distance to push shapeElement. apart after intersecting
					}	
					else //Special case. shapes are exactly on top of eachother.  Don't want to divide by zero.
					{
						d = shapeElement.hitboxRadius + hitboxRadius - 1.0f;
						delta = new Vector2d(shapeElement.hitboxRadius + hitboxRadius, 0.0);

						mtd = delta.multiply(((hitboxRadius + shapeElement.hitboxRadius) - d) / d);
					}

					//resolve intersection 
					double im1 = 1 / hitboxRadius; //since there is no mass involved, I'm using the radius here
					double im2 = 1 / shapeElement.hitboxRadius;

					//push or pull them apart
					position = position.add(mtd.multiply(im1 / (im1 + im2)));
					shapeElement.position = shapeElement.position.subtract(mtd.multiply(im2 / (im1 + im2)));

					//Calculating impact speed
					Vector2d v = (this.velocity.subtract(shapeElement.velocity));
					double vn = v.dot(mtd.normalize());

					//sphere intersecting but moving away from each other already
					if (vn > 0.0) 
						return;

					//calculating the impulse of the collision
					double k = ( -1.0f * vn) / (im1 + im2); 
					Vector2d impulse = mtd.multiply(k);

					//Calculates the change in momentum
					this.velocity = this.velocity.add(impulse.multiply(im1));
					shapeElement.velocity = shapeElement.velocity.subtract(impulse.multiply(im2));

				}
			}
		}
		position.setPositionInfo(0, position.getPositionInfo(0) + (velocity.getPositionInfo(0)));
		position.setPositionInfo(1, position.getPositionInfo(1) + (velocity.getPositionInfo(1)));

		//Commented since bonus questions requires different implementation and the code under will not be used for the correct implementation.
		/*
		switch (direction) 
		{
			case 0: //0 represents UP
				if ((getPositionInfo(1) - 2 * getPositionInfo(2)) - velocity <= 0)
				{
					direction = 1;
					setPositionInfo(1, getPositionInfo(1) + velocity);	
				}
				else
				{
					setPositionInfo(1, getPositionInfo(1) - velocity);	
				}
				break;
			case 1: //1 represents DOWN
				if ((getPositionInfo(1) + 2 * getPositionInfo(2)) + velocity >= 700)
				{
					direction = 0;
					setPositionInfo(1, getPositionInfo(1) - velocity);  
				}
				else
				{
					setPositionInfo(1, getPositionInfo(1) + velocity);
				}
				break;
			case 2: //2 represents LEFT
				if ((getPositionInfo(0) - 2 * getPositionInfo(2)) - velocity <= 0)
				{
					direction = 3;
					setPositionInfo(0, getPositionInfo(0) + velocity);	
				}
				else 
				{
					setPositionInfo(0, getPositionInfo(0) - velocity);	
				}
				break;
			case 3: //3 represents RIGHT
				if ((getPositionInfo(0) + 2 * getPositionInfo(2)) + velocity >= 1000)
				{
					direction = 2;
					setPositionInfo(0, getPositionInfo(0) - velocity);	
				}
				else
				{
					setPositionInfo(0, getPositionInfo(0) + velocity);
				}
				break;
		}
		*/
	}

	/**
	* Draw method that overrides the Shape3/Shape2/Shape1 draw method and draws Rectangle2D shape
	*/
	@Override
	public void draw(Graphics2D g2)
	{
		g2.setColor(super.getColor());
		var rad = getPositionInfo(2);
		Rectangle2D.Double rectangle = new Rectangle2D.Double(getPositionInfo(0) - 1.5 * rad, getPositionInfo(1) - 1.5 * rad, 3*rad, 3*rad);
		g2.draw(rectangle);
		g2.fill(rectangle);
		super.draw(g2);
	}
}