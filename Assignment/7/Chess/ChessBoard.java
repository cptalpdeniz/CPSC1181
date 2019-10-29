/**
* Assignment 7
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.util.*;
import java.awt.Color;

public class ChessBoard
{
	private int SIZE = 8;
	private Box[][] board;
	private Piece[][] pieces;
	private Piece selectedPiece;
	private int tempX;
	private int tempY;

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
		tempX = tempY = -1;
		selectedPiece = null;
		populate();
	}

	public void draw(Graphics2D g2)
	{  
		var tempI = -1;
		var tempJ = -1;
		boolean isSelectedWhiteBox = false;
		Color defaultColor = new Color(0,0,0);
		for (int i = 0; i < SIZE; i++)
		{
			for(int j = 0; j < SIZE; j++)
			{
				if ((i + j) % 2 == 0)
				{
					if (selectedPiece instanceof Piece && selectedPiece.getY() == i && selectedPiece.getX() == j)
					{
						board[i][j].draw(g2);
						tempI = i;
						tempJ = j;
						isSelectedWhiteBox = true;
					}
					else
					{
						board[i][j].draw(g2);
					}
					defaultColor = g2.getColor();

				}
				else
				{
					if (selectedPiece instanceof Piece && selectedPiece.getY() == i && selectedPiece.getX() == j)
					{
						board[i][j].fill(g2);
						tempI = i;
						tempJ = j;
						isSelectedWhiteBox = false;
					}
					else
					{
						board[i][j].fill(g2);
					}
					defaultColor = g2.getColor();
				}
			}
		}
		if (selectedPiece instanceof Piece)
		{
			board[tempI][tempJ].drawSelectedBox(g2, defaultColor, isSelectedWhiteBox);
		}
		for (int i = 0; i < SIZE; i++)
		{
			for(int j = 0; j < SIZE; j++)
			{
				pieces[i][j].draw(g2);
			}
		}
	}

	public void populateTerminalRow(int color)
	{

		int row = color == Def.BLACK ? 0 : 7;

		ArrayList<Piece> terminalRow = new ArrayList<Piece>();
		terminalRow.add(new Rook(color,0,row));
		terminalRow.add(new Knight(color,1,row));
		terminalRow.add(new Bishop(color,2,row));
		terminalRow.add(new Queen(color,3,row));
		terminalRow.add(new King(color,4,row));
		terminalRow.add(new Bishop(color,5,row));
		terminalRow.add(new Knight(color,6,row));
		terminalRow.add(new Rook(color,7,row));

		for (var p : terminalRow)
		{
			pieces[p.getY()][p.getX()] = p;
		}
	}

	public void populate()
	{

		populateTerminalRow(Def.BLACK);
		populateTerminalRow(Def.WHITE);

		for (int i = 0; i < 8; i++)
		{
			pieces[1][i] = new Pawn(Def.BLACK,i,1);
			pieces[6][i] = new Pawn(Def.WHITE,i,6);	
		}

		// Still don't understand why we need the Dummy class??????
		for (int i = 0; i < 8; i++ ) 
		{
			for(int j = 2; j <6; j++)
				pieces[j][i] = new Dummy(1,i);	
		}
	}

	public Box[][] getBoxes()
	{
		return board;
	}

	public void movePieces(int x, int y)
	{
		tempX = x;
		tempY = y;
		if (pieces[y][x] instanceof Dummy && selectedPiece == null)
		{
			return;
		}
		else
		{
			if (selectedPiece != null)
			{
				if (!(pieces[y][x] instanceof Dummy))
				{
					System.out.println("This part has not been implemented yet. I'm sorry but I'm gonna have to exit now.");
					System.exit(0);
				}
				else
				{
					var tempX = selectedPiece.getX();
					var tempY = selectedPiece.getY();
					selectedPiece.move(x, y);
					pieces[y][x] = selectedPiece;
					pieces[tempY][tempX] = new Dummy(1, tempY);
					selectedPiece = null;
					Def.isWhiteMove = !Def.isWhiteMove;
				}
			}
			else 
			{
				selectedPiece = pieces[y][x];
			}
		}
	}
}