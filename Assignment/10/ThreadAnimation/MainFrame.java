import javax.swing.JFrame;

public class MainFrame
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Thread Animation");
		MainPanel panel = new MainPanel();
		frame.setSize(300,300);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);
		frame.setVisible(true);
	}
}