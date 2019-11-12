import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Random;

public class MainPanel extends JPanel
{
	JPanel topPanel;
	DrawPanel drawPanel;
	Random rand;
	
	public MainPanel(){
		rand = new Random();
		setLayout(new BorderLayout());
		topPanel = new JPanel();

		JButton button1 = addButton("add");
		JButton button2 = delButton("remove");
		topPanel.add(button1);
		topPanel.add(button2);
		
		add(topPanel, BorderLayout.NORTH); 
		
		drawPanel = new DrawPanel();
		add(drawPanel, BorderLayout.CENTER); 
	}
	private JButton addButton(String title){   
		class CreateListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				int w = getWidth();
				int h = getHeight();
				drawPanel.addCircle(rand.nextInt(w/2),rand.nextInt(h/2),rand.nextInt(w/4));

			}
		}
		JButton button = new JButton(title);
		button.addActionListener(new CreateListener());
		return button;
	}

	private JButton delButton(String title){   
		class DeleteListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				drawPanel.removeCircle();
				// Call repaint from outside.
				// Its effect is the same as call it from drawPanel
				drawPanel.repaint();
			} 
		}
		JButton button = new JButton(title);
		button.addActionListener(new DeleteListener());
		return button;
	}
}