import javax.swing.JFrame;

/**
	 This program displays the growth of an investment. 
*/
public class Application
{  
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*MyPanel myPanel = new MyPanel();	
		frame.add(myPanel);*/
		MainPanel mainPanel = new MainPanel();
    	frame.add(mainPanel);

		frame.setVisible(true);
	}
}
