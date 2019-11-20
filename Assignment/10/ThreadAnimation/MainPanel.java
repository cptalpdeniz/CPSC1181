import java.lang.Thread;
import javax.swing.JPanel;

public class MainPanel extends JPanel
{
	public MainPanel()
	{	
		Runnable data = new Data();
		Runnable dispPanel = new DisplayPanel((Data)data);

		Thread tD = new Thread(data);
		Thread tP = new Thread(dispPanel);

		tD.start();
		tP.start();
		this.add((DisplayPanel)dispPanel);
	}
}