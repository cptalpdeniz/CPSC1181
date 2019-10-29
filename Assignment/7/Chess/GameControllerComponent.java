/**
* Assignment 7
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.Font;
import java.awt.Color;

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
		g2.setColor(Color.BLUE);
		g2.setFont(new Font("Arial", Font.PLAIN, 30));
		if (Def.isWhiteMove)
		{
			g2.drawString("White Moves", 15, 570);
		}
		else
		{
			g2.drawString("Black Moves", 15, 570);	
		}
	}	
	// convert x-y coordinate to 2D array box system by doing a box check through the board
	public void gameController(Point point)
	{
		var tempBoxes = theBoard.getBoxes();
		outerloop:
		for (int i = 0; i < 8 ; i++) //y-coord
		{
			for (int j = 0; j < 8; j++) //x-coord
			{
				if (tempBoxes[i][j].getRectangleBox().contains(point))
				{
					theBoard.movePieces(j,i);
					break outerloop;
				}
			}
		}
		repaint();
	}

	/*
	* Could you please email me why do we need start() and validInput() methods here? As you can see I already implemented the EventHandling.
	* Tried thinking for what we can use the start() method for, maybe to initiate the first beginning state of the Chess game however it doesn't make that much sense considering we don't need method for specific state of the game. Thus I seriously don't understand where we can use the validInput() method which takes two Strings are parameters? Maybe for console implemention of the game but that would be useless?
	* Thanks!
	*/
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