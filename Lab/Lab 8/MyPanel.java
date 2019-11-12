import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.*;

public class MyPanel extends JPanel
{    
	private ImageButton imgBtn;
	public MyPanel()
	{  
		createCrButton();
	}

   //--------
	private void createCrButton()
	{
		imgBtn = new ImageButton();
		add(imgBtn);
		class ImageButtonInvoker implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				imgBtn.switchImage();
			}
		}
		imgBtn.addActionListener(new ImageButtonInvoker());
	}

	
	/**
	@override
	*/
	public void paintComponent(Graphics g)
	{  
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		imgBtn.repaint();
		// Note that we do not call the paint method of the button directly
		// we just sending a notification to reprint the button itself
	}	
}