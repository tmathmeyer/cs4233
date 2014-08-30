package chess.moves;

import chess.board.ChessLocation;

public class ChessMove
{
	private final ChessLocation locFrom, locTo;
	
	/**
	 * 
	 * @param color
	 * @param type
	 * @param piece
	 */
	public ChessMove(ChessLocation from, ChessLocation to)
	{
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
}
