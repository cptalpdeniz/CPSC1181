import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JComponent;

public class GameControllerComponent extends JComponent
{
	private ChessBoard theBoard;
	
	public GameControllerComponent()
	{
		theBoard = new ChessBoard();
		theBoard.populate();
	}

	public void paintComponent(Graphics g)
	{  
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		theBoard.draw(g2);
	}	

	public void start()
	{
		// we are not using this method right now. 
		// We will implement it the next version
	}

	private boolean validInput(String start, String end)
	{
		// we are not using this method right now. 
		// We will implement it the next version
		return true;
	}
}

