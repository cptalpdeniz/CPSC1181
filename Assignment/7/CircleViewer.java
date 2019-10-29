/**
* Assignment 7
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import javax.swing.JFrame;
import java.awt.event.*;


/**
* Main Viewer class (which contains the main method as well)
*/
public class CircleViewer
{
	public static void main(String[] args)
	{
		final JFrame frame = new JFrame("Circle Shapes");
		final CircleComponent component = new CircleComponent();

		// Class for Mouse Listener which implements the necessary interfaces
		class MousePressListener implements MouseListener, MouseMotionListener
		{
			public void mouseClicked(MouseEvent event) { }
			public void mouseEntered(MouseEvent event) { }
			public void mouseExited(MouseEvent event) { }
			public void mouseWheelMoved(MouseWheelEvent event) { }
			public void mouseMoved(MouseEvent event) { }
			public void mousePressed(MouseEvent event) { }

			@Override
			public void mouseDragged(MouseEvent event)
			{
				var x = event.getX();
				var y = event.getY();
				component.moveTo(x, y);
			}

			@Override
			public void mouseReleased(MouseEvent event)
			{
				component.finalMove();
			}
		}

		component.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent event)
			{
				component.frameResizeCalculation(frame.getWidth(), frame.getHeight());
			}
		});

		MousePressListener listener = new MousePressListener();
		component.addMouseListener(listener);
		component.addMouseMotionListener(listener);

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(component);
		frame.setVisible(true);
	}
	public static int FRAME_WIDTH = 700;
	public static int FRAME_HEIGHT = 500;
}