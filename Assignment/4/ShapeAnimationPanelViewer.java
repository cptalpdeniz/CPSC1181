import javax.swing.JFrame;


public class ShapeAnimationPanelViewer
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Shape");
		final int FRAME_WIDTH = 1000;
		final int FRAME_HEIGHT = 700;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyTimer comp = new MyTimer();
		frame.add(comp);
		frame.setVisible(true);
	}
}