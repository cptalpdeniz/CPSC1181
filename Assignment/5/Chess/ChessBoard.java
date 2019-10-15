import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
*/
public class ChessBoard
{
	private int SIZE =8;
	private Box[][] board;
	private Piece[][] pieces;

	public ChessBoard()
	{
		board = new Box[SIZE][SIZE];
		pieces = new Piece[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				board[i][j] = new Box(Def.GAP + j * Def.LENGTH, Def.GAP + i * Def.LENGTH, Def.LENGTH);
			}
		}
		populate();
	}

	public void draw(Graphics2D g2)
	{  
		for (int i = 0; i < SIZE; i++)
		{
			for(int j = 0; j < SIZE; j++)
			{
				if ((i + j) % 2 == 0)
					board[i][j].draw(g2);
				else
					board[i][j].fill(g2);
			}
		}
		pieces[0][1].draw(g2);	
		pieces[0][2].draw(g2);
	}

	public void populate()
	{
		// Sample code
		for (int y = 0; y < SIZE; y++) 
		{
			for (int x = 0; x < SIZE; x++) 
			{
				if ()
				pieces[i][j] = new Pawn
			}	
		}
		pieces[0][1] = new Pawn(Def.BLACK, 0,1);
		pieces[0][1] = new Pawn(Def.BLACK, 0,1);
		pieces[0][2] = new Pawn(Def.WHITE, 0,6);
	}
}