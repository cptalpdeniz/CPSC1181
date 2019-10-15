import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Bishop extends Piece
{
	private BufferedImage img;
	public Bishop(int color, int x, int y)
	{	
		super(color,x,y);
	 	try
	 	{
	 		if(color == Def.BLACK)
				img = ImageIO.read(new File(Def.BISHOP_BLACK));
			else
				img = ImageIO.read(new File(Def.BISHOP_WHITE));
		}
		catch  (IOException e) 
		{
			// We will learn about this later
			// For now just use it as is.
		}
	}
	

	public int getType()
	{
		return Def.BISHOP;
	}	
	
	public void draw(Graphics2D g2) 
	{
		int offsetX = (Def.LENGTH - img.getWidth()) / 2;
		int offsetY = (Def.LENGTH - img.getHeight()) / 2;
		g2.drawImage(img, offsetX + Def.GAP + getX() * Def.LENGTH, offsetY + Def.GAP + getY() * Def.LENGTH, img.getWidth(), img.getHeight(), null);
	}
}