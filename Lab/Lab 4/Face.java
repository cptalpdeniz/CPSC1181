import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics2D;

/**
   @author jmadar
  Modified by: H.Darbandi on Oct 4, 2016
 
 */
public class Face {    
    
    protected int radius;
    protected Point2D.Double centre;
    // constructor
    public Face(int x, int y, int radius) {
        centre= new Point2D.Double(x,y);
        this.radius = radius;
    }
    // override draw method
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.YELLOW);        
        graphics.fillOval((int)centre.getX()-radius, (int)centre.getY()-radius, radius*2, radius*2);
        
        // eyes
        graphics.setColor(Color.BLACK);
        graphics.fillOval((int)centre.getX()-(radius/2), (int)centre.getY()-(radius/2), radius/10, radius/10);
        graphics.fillOval((int)centre.getX()+(radius/2), (int)centre.getY()-(radius/2), radius/10, radius/10);
    } 
    // get radius
    public int getRadius()
    {
        return radius;
    }
    // get x coordinate of the centre of the face
    public int getX()
    {
        return (int)centre.getX();
    }
    // get y coordinate of the centre of the face
    public int getY()
    {
        return (int)centre.getY();
    }
    
        
}
