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
		
		ShapeAnimationPanel comp = new ShapeAnimationPanel();
		frame.add(comp);
		frame.setVisible(true);
	}
}