/**
* Assignment 7
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import javax.swing.JFrame;
import java.awt.event.*;
public class Chess
{
	public static void main(String[] args)
	{
		final GameControllerComponent component = new GameControllerComponent();
		
		class MousePressListener implements MouseListener
		{
			public void mouseClicked(MouseEvent event) { }
			public void mouseEntered(MouseEvent event) { }
			public void mouseExited(MouseEvent event) { }
			public void mouseWheelMoved(MouseWheelEvent event) { }
			public void mouseReleased(MouseEvent event) { }

			@Override
			public void mousePressed(MouseEvent event)
			{
				component.gameController(event.getPoint());
				System.out.println(event.getX() + " + " + event.getY());
			}
		}

		JFrame frame = new JFrame();
		
		MousePressListener listener = new MousePressListener();
		component.addMouseListener(listener);

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(component);

		frame.setVisible(true);

	  	// Note that you should call after set frame to visible.
		component.start();
	}
	private static final int FRAME_WIDTH = 540;
	private static final int FRAME_HEIGHT = 630;
}
