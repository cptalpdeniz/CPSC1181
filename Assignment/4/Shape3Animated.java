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
		//var condition = false;
		if (position.getPositionInfo(0) - hitboxRadius <= 0) //Left wall check check
		{
			position.setPositionInfo(0,hitboxRadius); //Place shape against edge
			velocity.setPositionInfo(0,-(velocity.getPositionInfo(0))); //Reverse the direction 
			velocity.setPositionInfo(1,velocity.getPositionInfo(1));
			return true;
		}
		else if (position.getPositionInfo(0) + hitboxRadius >= 1000) //Right wall check
		{
			position.setPositionInfo(0,1000 - hitboxRadius);		//Place shape against edge
			velocity.setPositionInfo(0,-(velocity.getPositionInfo(0))); //Reverse direction 
			velocity.setPositionInfo(1,(velocity.getPositionInfo(1)));
			return true;
		}
		else if (position.getPositionInfo(1) - hitboxRadius  <= 0) //Top wall check
		{
			position.setPositionInfo(1,hitboxRadius); //Place shape against edge
			velocity.setPositionInfo(1,-(velocity.getPositionInfo(1))); //Reverse direction
			velocity.setPositionInfo(0,(velocity.getPositionInfo(0)));
			return true;
		}
		else if (position.getPositionInfo(1) + hitboxRadius >= 700) //Bottom wall check
		{
			position.setPositionInfo(1,700 - hitboxRadius);		//Place shape against edge
			velocity.setPositionInfo(1,-(velocity.getPositionInfo(1)));    //Reverse direction
			velocity.setPositionInfo(0,velocity.getPositionInfo(0));
			return true;
		}
		return false;
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
		return distSqr < ((hitboxRadius + shape1.hitboxRadius) * (hitboxRadius + shape1.hitboxRadius));
	}

	public void move(int index)
	{  
		if (isColliding())
		{
			position.setPositionInfo(0, position.getPositionInfo(0) + (velocity.getPositionInfo(0)*0.2));
			position.setPositionInfo(1, position.getPositionInfo(1) + (velocity.getPositionInfo(1)*0.2));
			return;
		}

		for (int i = 0; i < 15; i++) 
		{

			if(i == index)
				continue;

			var shapeElement = ShapeAnimationPanel.shapes.get(i);

			if (isColliding(shapeElement))
			{
				
				Vector2d delta = (position.subtract(shapeElement.position));
				double r = getPositionInfo(2) + shapeElement.getPositionInfo(2);
				double distSquared = delta.dot(delta);

				if ( false && distSquared > r * r) 
				{
					continue;
				}

				double d = delta.getLength();

				Vector2d mtd;
				if (d != 0.0)
				{
					mtd = delta.multiply(((getPositionInfo(2) + shapeElement.getPositionInfo(2)) - d) / d); //minimum translation distance to push shapeElement. apart after intersecting
				}	
				else //Special case. shapes are exactly on top of eachother.  Don't want to divide by zero.
				{
					continue;
				}

				//resolve intersection 
				double im1 = 1 / hitboxRadius; //since there is no mass involved, I'm using the radius here
				double im2 = 1 / shapeElement.hitboxRadius;

				//Calculating impact speed
				Vector2d v = (this.velocity.subtract(shapeElement.velocity));
				double vn = v.dot(mtd.normalize());

				//sphere intersecting but moving away from each other already
				if (vn < 0.0) 
					continue;

				//calculating the impulse of the collision
				double k = ( -1.0f * vn) / (im1 + im2); 
				Vector2d impulse = mtd.multiply(k);

				//Calculates the change in momentum
				this.velocity = this.velocity.add(impulse.multiply(im1));
				shapeElement.velocity = shapeElement.velocity.subtract(impulse.multiply(im2));
			}
		}
		
		position.setPositionInfo(0, position.getPositionInfo(0) + (velocity.getPositionInfo(0)*0.2));
		position.setPositionInfo(1, position.getPositionInfo(1) + (velocity.getPositionInfo(1)*0.2));
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