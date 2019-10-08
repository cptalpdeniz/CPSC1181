import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.lang.Math;

public class Shape3Animated extends Shape3
{

	//private Vector2d direction; // a random direction angle
	private Vector2d velocity;  // a random velocity in pixel 
	// Add instance fields that required
	
	public Shape3Animated(double x, double y, double r, double direction, int velocity)
	{
		super(x,y,r);
		//this.direction = direction;
		this.velocity = new Vector2d(x * velocity + Math.cos(Math.toRadians(direction)), y * velocity + Math.sin(Math.toRadians(direction)));
	}

	public boolean isColliding()
	{
		var condition = false;
		if (position.getPositionInfo(1) - getPositionInfo(2) < 0)
		{
			position.setPositionInfo(0,getPositionInfo(2)); // Place ball against edge
			velocity.setPositionInfo(0,-(velocity.getPositionInfo(1))); // Reverse direction and account for friction
			velocity.setPositionInfo(1,velocity.getPositionInfo(2));
			condition = true;
		}
		else if (position.getPositionInfo(0) + getPositionInfo(2) > 700) // Right Wall
		{
			position.setPositionInfo(0,700 - getPositionInfo(2));		// Place ball against edge
			velocity.setPositionInfo(0,-(velocity.getPositionInfo(1))); // Reverse direction and account for friction
			velocity.setPositionInfo(1,(velocity.getPositionInfo(1)));
			condition = true;
		}

		if (position.getPositionInfo(1) - getPositionInfo(2) < 0)				// Top Wall
		{
			position.setPositionInfo(1,getPositionInfo(2));				// Place ball against edge
			velocity.setPositionInfo(1,-(velocity.getPositionInfo(1))); // Reverse direction and account for friction
			velocity.setPositionInfo(0,(velocity.getPositionInfo(1)));
			condition = true;
		}
		else if (position.getPositionInfo(1) + getPositionInfo(2) > 1000) // Bottom Wall
		{
			position.setPositionInfo(1,1000 - getPositionInfo(2));		// Place ball against edge
			velocity.setPositionInfo(1,-(velocity.getPositionInfo(1)));    // Reverse direction and account for friction
			velocity.setPositionInfo(0,velocity.getPositionInfo(1));
			condition = true;
		}
		return condition;
	}

	public boolean isColliding(Shape3Animated shape1)
	{
		var xPosDiff = getPositionInfo(0) - shape1.getPositionInfo(0);
		var yPosDiff = getPositionInfo(1) - shape1.getPositionInfo(1);
		var distSqr = Math.pow(xPosDiff, 2) + Math.pow(yPosDiff, 2);
		return distSqr < Math.pow(getPositionInfo(2) + shape1.getPositionInfo(2), 2);
	}

	// moves the x or y coordinates of the shape based on direction 
	// and velocity
		public void move(int index)
		{  
			if (!isColliding())
			{
				for (int i = index + 1; i < 15; i++) 
				{
					if (i == index)
					{
						continue;
					}
					else
					{
						var shapeElement = MyTimer.shapes.get(i);

						//olursa hemen islem yap ve momentum vs hesabina girip yon degistir
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
								mtd = delta.multiply(((getPositionInfo(2) + shapeElement.getPositionInfo(2))-d)/d); // minimum translation distance to push shapeElement. apart after intersecting
							}
							else // Special case. Balls are exactly on top of eachother.  }Don't want to divide by zero.
							{
								d = shapeElement.getPositionInfo(2) + getPositionInfo(2) - 1.0f;
								delta = new Vector2d(shapeElement.getPositionInfo(2) + getPositionInfo(2), 0.0);

								mtd = delta.multiply(((getPositionInfo(2) + shapeElement.getPositionInfo(2))-d)/d);
							}

							// resolve intersection
							double im1 = 1 / getPositionInfo(2); // inverse mass quantities
							double im2 = 1 / shapeElement.getPositionInfo(2);

							// push-pull them apart
							position = position.add(mtd.multiply(im1 / (im1 + im2)));
							shapeElement.position = shapeElement.position.subtract(mtd.multiply(im2 / (im1 + im2)));

							// impact speed
							Vector2d v = (this.velocity.subtract(shapeElement.velocity));
							double vn = v.dot(mtd.normalize());

							// sphere intersecting but moving away from each other already
							if (vn > 0.0) return;

							// collision impulse
							double k = (-(1.0f) * vn) / (im1 + im2); 
							Vector2d impulse = mtd.multiply(k);

							// change in momentum
							this.velocity = this.velocity.add(impulse.multiply(im1));
							shapeElement.velocity = shapeElement.velocity.subtract(impulse.multiply(im2));
						}
					}
				}
			//collide olmazsa burda devam ettir
			}
			position.setPositionInfo(0, position.getPositionInfo(0) + (velocity.getPositionInfo(0)));
			position.setPositionInfo(1, position.getPositionInfo(1) + (velocity.getPositionInfo(1)));

		// Commented since bonus questions requires different implementation and the code under will not be used for the correct implementation.
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

	@Override
	public void draw(Graphics2D g2)
	{
		g2.setColor(super.getColor());
		var rad = super.getPositionInfo(2);
		Rectangle2D.Double rectangle = new Rectangle2D.Double(super.getPositionInfo(0) - 1.5 * rad, super.getPositionInfo(1) - 1.5 * rad, 3*rad, 3*rad);
		g2.draw(rectangle);
		g2.fill(rectangle);
		super.draw(g2);
	}
}