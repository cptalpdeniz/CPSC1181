import javax.swing.JButton;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;
//import java.awt.*;
import javax.swing.ImageIcon;


public class ImageButton extends JButton 
{
	private ImageIcon  newIcon ;
	private String[] imageFiles = {"horse1.jpg","horse2.jpg","horse3.png"};
	private int index=0;
	/**
		constructor
		set the button image to the first image
	*/
	public ImageButton()
	{
		this.setIcon(imageFiles[index]);
	}
/**
	changes the index of the imag 

*/
	public void switchImage()
	{
		index = (++index)%imageFiles.length;
		this.setIcon(imageFiles[index]);
	}	
/**
	set icon of the image to the new one
	@param fileName of the image file
*/	
	private void setIcon(String fileName)
	{
		ImageIcon icon = new ImageIcon(fileName);
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		super.setIcon(icon);
	}
}