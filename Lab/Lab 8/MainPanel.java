import javax.swing.JPanel;
import java.awt.GridLayout;

public class MainPanel extends JPanel
{
	private final int SIZE = 3;
	public MainPanel()
	{
		setLayout(new GridLayout(SIZE,SIZE));
		for(int i = 0; i < SIZE*SIZE; i++)
			add(new MyPanel());
	} 
}