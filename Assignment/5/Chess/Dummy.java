/**
* Assignment 5
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Dummy extends Piece
{
	private BufferedImage img;
	public Dummy(int x, int y)
	{	
		super(x,y);
	}
	

	public int getType()
	{
		return Def.DUMMY;
	}	
	
	public void draw(Graphics2D g2) 
	{
		
	}
}