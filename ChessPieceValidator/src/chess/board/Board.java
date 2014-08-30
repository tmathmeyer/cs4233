package chess.board;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import chess.ChessPiece;
import chess.ChessPlayerColor;
import chess.moves.ChessMove;

public class Board
{
	
	public boolean pieceExistsAt(ChessLocation cl)
	{
		return false; // TODO: make this stateful
	}
	
	public Collection<ChessMove> validMovespieceRules(ChessPiece cp, ChessLocation cl)
	{
		return getChessPieceModifiers(cp, cl).applyTo(cl);
	}
	
	private ChessMoveModifiers getChessPieceModifiers(ChessPiece cp, ChessLocation cl)
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
					// bishop-style
					data.add(new ChessMoveModifier(i, i));
					data.add(new ChessMoveModifier(-i, i));
					data.add(new ChessMoveModifier(-i, -i));
					data.add(new ChessMoveModifier(i, -i));
					
					// rook-style
					data.add(new ChessMoveModifier(0, i));
					data.add(new ChessMoveModifier(0, -i));
					data.add(new ChessMoveModifier(i, 0));
					data.add(new ChessMoveModifier(-i, 0));
				}
				break;
			case ROOK:
				for( int i = 1; i < 8; i++)
				{
					// rook-style
					data.add(new ChessMoveModifier(0, i));
					data.add(new ChessMoveModifier(0, -i));
					data.add(new ChessMoveModifier(i, 0));
					data.add(new ChessMoveModifier(-i, 0));
				}
				break;
			case BISHOP:
				for( int i = 1; i < 8; i++)
				{
					// rook-style
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
					// do nothing with this failure
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
					// do nothing with this failure
				}
				
		}
		return new ChessMoveModifiers(data);
	}
	
	
	private static class ChessMoveModifiers
	{
		private final Collection<ChessMoveModifier> moveModifiers;
		
		public ChessMoveModifiers(Collection<ChessMoveModifier> mods)
		{
			moveModifiers = new HashSet<>();
			moveModifiers.addAll(mods);
		}
		
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
					// just dont add this to the valid moves
				}
			}
			return result;
		}
	}
	
	private static class ChessMoveModifier
	{
		private final int alph;
		private final int num;
		
		public ChessMoveModifier(int alphabetic, int numeric)
		{
			alph = alphabetic;
			num = numeric;
		}

		public ChessMove apply(ChessLocation cl)
		{
			return new ChessMove(cl, new ChessLocation((char) (cl.getAlphabetic() + alph), cl.getNumeric() + num));
		}
		
		@Override
		public boolean equals(Object other)
		{
			if (other == this)
			{
				return true;
			}
			if (other instanceof ChessMoveModifier)
			{
				ChessMoveModifier cmm = (ChessMoveModifier)other;
				return (cmm.alph == alph) && (cmm.num == num); 
			}
			return false;
		}
	}
	
}
