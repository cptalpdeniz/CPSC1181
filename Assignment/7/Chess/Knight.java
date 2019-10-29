/**
* Assignment 7
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Knight extends Piece
{
	private BufferedImage img;
	public Knight(int color, int x, int y)
	{	
		super(color,x,y);
	 	try
	 	{
	 		if(color == Def.BLACK)
				img = ImageIO.read(new File(Def.KNIGHT_BLACK));
			else
				img = ImageIO.read(new File(Def.KNIGHT_WHITE));
		}
		catch  (IOException e) 
		{
			// We will learn about this later
			// For now just use it as is.
		}
	}
	

	public int getType()
	{
		return Def.KNIGHT;
	}	
	
	public void draw(Graphics2D g2) 
	{
		int offsetX = (Def.LENGTH - img.getWidth()) / 2;
		int offsetY = (Def.LENGTH - img.getHeight()) / 2;
		g2.drawImage(img, offsetX + Def.GAP + getX() * Def.LENGTH, offsetY + Def.GAP + getY() * Def.LENGTH, img.getWidth(), img.getHeight(), null);
	}
}