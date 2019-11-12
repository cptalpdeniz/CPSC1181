/**
* Assignment 9
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DateFrameViewer
{
	public static final int FRAME_WIDTH = 900;
	public static final int FRAME_HEIGHT = 200;
	
	public static void main(final String[] array)
	{
		JFrame frame = new JFrame();
		JPanel component = new DateCounterPanel();
		frame.setSize(900, 200);
		frame.setDefaultCloseOperation(3);
		frame.setTitle("Date Verifier");
		frame.add(component);
		frame.setVisible(true);
	}
}