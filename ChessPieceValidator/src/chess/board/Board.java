/*******************************************************************************
 * This file was developed by Ted Meyer for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package chess.board;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import chess.ChessPiece;
import chess.ChessPlayerColor;
import chess.moves.ChessMove;
import chess.moves.ChessMoveModifier;

/**
 * 
 * @author ted
 * 
 * The Board will hold all stateful information about the game,
 * including locations of pieces, who's turn it is, and things
 * like check / checkmate. It also calculates move validity,
 * including special moves like en-epssant and castling.
 *
 */
public class Board
{
	/**
	 * a non-lazy instantianted singleton instance
	 */
	private static final Board INSTANCE = new Board();
	
	/**
	 * As per being a singleton, do not let other classes create instances
	 * of board, and do not let board be subclassed
	 */
	private Board() {}
	
	/**
	 * The singleton accessor
	 * 
	 * @return the singleton instance
	 */
	public static Board getInstance()
	{
		return INSTANCE;
	}
	
	
	/**
	 * 
	 * @param cl the location to test
	 * @return whethere there is a piece at the provided location
	 */
	public boolean pieceExistsAt(ChessLocation cl)
	{
		return false; // TODO: make this stateful
	}
	
	/**
	 * 
	 * This method will not check path intersections, ie, it would
	 * report that a space is valid for a queen, even if there is a
	 * piece blocking its path there
	 * 
	 * @param cp The chess piece in question (for the type)
	 * @param cl the location of the piece on the board
	 * @return a collection of all moves that the piece can make
	 */
	public Collection<ChessMove> validMovespieceRules(ChessPiece cp, ChessLocation cl)
	{
		return getChessPieceModifiers(cp, cl).applyTo(cl);
	}
	
	/**
	 * 
	 * @param cp the chess piece
	 * @param cl the location (only used for pawns... TODO: remove this)
	 * @return a wrapper object for the set of all available moves
	 */
	private ChessMoveModifierCollection getChessPieceModifiers(ChessPiece cp, ChessLocation cl)
	{
		Collection<ChessMoveModifier> data = new HashSet<ChessMoveModifier>();
		switch(cp.getChessPieceType())
		{
			case KING:
				for(int i = -1; i < 2; i++)
				{
					for(int j = -1; j < 2; j++)
					{
						if (! (i==0 && j==0))
						{
							data.add(new ChessMoveModifier(i, j));
						}
					}
				}
				break;
			case QUEEN:
				for( int i = 1; i < 8; i++)
				{
					// bishop style
					data.add(new ChessMoveModifier(i, i));
					data.add(new ChessMoveModifier(-i, i));
					data.add(new ChessMoveModifier(-i, -i));
					data.add(new ChessMoveModifier(i, -i));
					
					// rook style
					data.add(new ChessMoveModifier(0, i));
					data.add(new ChessMoveModifier(0, -i));
					data.add(new ChessMoveModifier(i, 0));
					data.add(new ChessMoveModifier(-i, 0));
				}
				break;
			case ROOK:
				for( int i = 1; i < 8; i++)
				{
					data.add(new ChessMoveModifier(0, i));
					data.add(new ChessMoveModifier(0, -i));
					data.add(new ChessMoveModifier(i, 0));
					data.add(new ChessMoveModifier(-i, 0));
				}
				break;
			case BISHOP:
				for( int i = 1; i < 8; i++)
				{
					data.add(new ChessMoveModifier(i, i));
					data.add(new ChessMoveModifier(-i, i));
					data.add(new ChessMoveModifier(-i, -i));
					data.add(new ChessMoveModifier(i, -i));
				}
				break;
			case KNIGHT:
				data.add(new ChessMoveModifier(2, 1));
				data.add(new ChessMoveModifier(1, 2));
				
				data.add(new ChessMoveModifier(-2, 1));
				data.add(new ChessMoveModifier(-1, 2));
				
				data.add(new ChessMoveModifier(-2, -1));
				data.add(new ChessMoveModifier(-1, -2));
				
				data.add(new ChessMoveModifier(2, -1));
				data.add(new ChessMoveModifier(1, -2));
				
				break;
			case PAWN:
				boolean white = cp.getChessPlayerColor()==ChessPlayerColor.WHITE;
				if (cl.getNumeric()==(white?1:8))
				{
					break;
				}
				data.add(new ChessMoveModifier(0, white?1:-1));
				
				if (cl.getNumeric()==(white?2:7))
				{
					data.add(new ChessMoveModifier(0, white?2:-2));
				}
				try
				{
					ChessMoveModifier atkLeft = new ChessMoveModifier(-1, white?1:-1);
					if (pieceExistsAt(atkLeft.apply(cl).getLocTo()))
					{
						data.add(atkLeft);
					}
				}
				catch(IllegalArgumentException iae)
				{
					maybeLogException(iae, false);
				}
				try
				{
					ChessMoveModifier atkRight = new ChessMoveModifier(1, white?1:-1);
					if (pieceExistsAt(atkRight.apply(cl).getLocTo()))
					{
						data.add(atkRight);
					}
				}
				catch(IllegalArgumentException iae)
				{
					maybeLogException(iae, false);
				}
				
		}
		return new ChessMoveModifierCollection(data);
	}
	
	/**
	 * 
	 * @author ted
	 *
	 * A helper class for wrapping a set of modifiers
	 */
	private static class ChessMoveModifierCollection
	{
		private final Collection<ChessMoveModifier> moveModifiers;
		
		private ChessMoveModifierCollection(Collection<ChessMoveModifier> mods)
		{
			moveModifiers = new HashSet<>();
			moveModifiers.addAll(mods);
		}
		
		/**
		 * 
		 * @param cl the location to apply the set of move modifiers to
		 * @return a collection of all the new chess moves
		 */
		public Collection<ChessMove> applyTo(ChessLocation cl)
		{
			Collection<ChessMove> result = new LinkedList<ChessMove>();
			for(ChessMoveModifier cmm : moveModifiers)
			{
				try
				{
					result.add(cmm.apply(cl));
				}
				catch (IllegalArgumentException iae)
				{
					Board.maybeLogException(iae, false);
				}
			}
			return result;
		}
	}
	
	/**
	 * TODO: use a logger
	 * @param e any exception
	 * @param doLog should we log it?
	 */
	public static void maybeLogException(Exception e, boolean doLog)
	{
		if (doLog)
		{
			e.printStackTrace();
		}
	}
}
