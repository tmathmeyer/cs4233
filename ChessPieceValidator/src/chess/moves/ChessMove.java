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
 * A holder for a move in the game of chess
 */
public class ChessMove
{
	private final ChessLocation locFrom, locTo;
	
	/**
	 * 
	 * @param from the location from which the piece moves
	 * @param to the location to which the piece may be moving
	 */
	public ChessMove(ChessLocation from, ChessLocation to)
	{
		if (from == null || to == null)
		{
			throw new IllegalArgumentException("parameters to chessmove can not be null");
		}
		locFrom = from;
		locTo = to;
	}

	/**
	 * @return the locFrom
	 */
	public ChessLocation getLocFrom() {
		return locFrom;
	}

	/**
	 * @return the locTo
	 */
	public ChessLocation getLocTo() {
		return locTo;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if (other instanceof ChessMove)
		{
			ChessMove cm = (ChessMove)other;
			return locFrom.equals(cm.locFrom) && locTo.equals(cm.locTo);
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return (locFrom.hashCode()  ^ locTo.hashCode());
	}
}
