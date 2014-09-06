/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package chess;

import chess.board.Board;
import chess.board.ChessLocation;
import chess.moves.ChessMove;

/**
 * A class that contains the information needed for a chess piece.
 * 
 * Modified by Ted Meyer for homework 1
 * tmathmeyer@gmail.com
 * tjmeyer@wpi.edu
 * 
 * @version Aug 15, 2014
 */
public class ChessPiece
{
	
	private final ChessPieceType chessPieceType;
	private final ChessPlayerColor chessPlayerColor;
	
	/**
	 * Constructor that creates the piece
	 * @param type the type of piece
	 * @param color the piece color
	 */
	public ChessPiece(ChessPieceType type, ChessPlayerColor color)
	{
		chessPieceType = type;
		chessPlayerColor = color;
	}
	
	/**
	 * <p>
	 * 	This method determines whether the piece can move from the specified 
	 * 	column and row to the specified destination column and row. This assumes
	 * 	that the board is a standard 8x8 chess board. Standard 
	 * 	<a href="http://www.quadibloc.com/chess/images/descr.gif">algebraic notation</a>
	 * 	is used to represent rows and columns.
	 * </p><p>
	 * 	For purposes of this assignment, you may assume that the following conditions
	 * 	hold:
	 *  <ul>
	 *  	<li>
	 *  		All rows and columns are valid. That is, the column will be a 
	 *  		character in the range 'a'-'h' and rows will be integers in the
	 *  		range 1-8.
	 *      </li>
	 *      <li> 
	 *      	Any pawn's starting location will be in a valid position. For example,
	 *      	you will never be presented with a White pawn starting on the first row of
	 *      	the board.
	 *      </li>
	 *      <li> The board is assumed to be empty. </li>
	 *      <li> 
	 *      	Since the board is empty, pawns may not move diagonally. They do,
	 *      	however, need to move in the correct direction.
	 *      </li>
	 *		<li>
	 *      	You can assume that a piece will not try to move onto the square
	 *      	it starts on.
	 *      </li>	 
	 *  </ul>
	 * </p>
	 * <p>
	 * 	If you do not know how the various chess pieces move, you can find out by
	 * 	looking <a href="http://www.chess.com/learn-how-to-play-chess#howtomove">
	 *  here</a>.
	 * </p>
	 * @param fromColumn the starting column
	 * @param fromRow the starting row
	 * @param toColumn the destination column
	 * @param toRow the destination row
	 * @return true if the piece may legally move from the starting location to the
	 * 	destination location.
	 */
	public boolean isMoveLegal(char fromColumn, int fromRow, char toColumn, int toRow)
	{
		try
		{
			ChessLocation from = new ChessLocation(fromColumn, fromRow);
			ChessLocation to   = new ChessLocation(toColumn, toRow);
			
			ChessMove definedMove = new ChessMove(from, to);
			return Board.getInstance().validMovespieceRules(this, from).contains(definedMove);
		}
		catch(IllegalArgumentException iae)
		{
			// either from or to is an invalid spot, so automatically return false;
			return false;
		}
		
	}

	/**
	 * @return the chessPieceType
	 */
	public ChessPieceType getChessPieceType() {
		return chessPieceType;
	}

	/**
	 * @return the chessPlayerColor
	 */
	public ChessPlayerColor getChessPlayerColor() {
		return chessPlayerColor;
	}
}
