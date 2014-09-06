/*******************************************************************************
 * This file was developed by Ted Meyer for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package chess.moves;

import chess.board.ChessLocation;

/**
 * 
 * @author ted
 *
 * A helper class for representing a movement modifier (each piece generates a different set of them)
 */
public class ChessMoveModifier
{
	private final int alph;
	private final int num;
	
	/**
	 * 
	 * @param alphabetic the alphabetic (column) of the chess board
	 * @param numeric the numeric (row) of the chess board
	 */
	public ChessMoveModifier(int alphabetic, int numeric)
	{
		alph = alphabetic;
		num = numeric;
	}
	
	/**
	 * 
	 * @param cl the location to apply this modification to
	 * @return a move from the given loc to the modified one
	 */
	public ChessMove apply(ChessLocation cl)
	{
		return new ChessMove(cl, new ChessLocation((char) (cl.getAlphabetic() + alph), cl.getNumeric() + num));
	}
}