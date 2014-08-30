package chess;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.ChessPiece;
import chess.ChessPieceType;
import chess.ChessPlayerColor;
import chess.board.Board;

public class ChessPieceTest
{
	private final Board board = new Board();
	
	
	@Test
	public void test()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KING, ChessPlayerColor.WHITE, board);
		
		assertTrue(cp.isMoveLegal('a', 1, 'b', 2));
	}
	
	
	@Test
	public void testInvalidInput()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KING, ChessPlayerColor.WHITE, board);
		
		assertFalse(cp.isMoveLegal('g', 1, 'b', 2));
		assertFalse(cp.isMoveLegal('a', 0, 'b', 2));
		assertFalse(cp.isMoveLegal('a', 1, '~', 2));
		assertFalse(cp.isMoveLegal('a', 1, 'b', 9));
	}
	
	@Test
	public void testValidKingMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KING, ChessPlayerColor.WHITE, board);
		
		assertTrue(cp.isMoveLegal('a', 1, 'b', 2));
		assertTrue(cp.isMoveLegal('a', 1, 'b', 1));
		assertTrue(cp.isMoveLegal('a', 1, 'a', 2));
		
		assertTrue(cp.isMoveLegal('b', 2, 'a', 1));
		assertTrue(cp.isMoveLegal('b', 1, 'a', 1));
		assertTrue(cp.isMoveLegal('a', 2, 'a', 1));
	}
	
	@Test
	public void testInvalidKingMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KING, ChessPlayerColor.WHITE, board);
		
		assertFalse(cp.isMoveLegal('a', 1, 'c', 3));
		assertFalse(cp.isMoveLegal('a', 1, 'c', 1));
		assertFalse(cp.isMoveLegal('a', 1, 'a', 3));
		
		assertFalse(cp.isMoveLegal('c', 2, 'a', 1));
		assertFalse(cp.isMoveLegal('c', 1, 'a', 1));
		assertFalse(cp.isMoveLegal('a', 3, 'a', 1));
	}
	
	@Test
	public void testValidQueenMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.QUEEN, ChessPlayerColor.WHITE, board);
		
		assertTrue(cp.isMoveLegal('a', 1, 'h', 8));
		assertTrue(cp.isMoveLegal('a', 1, 'a', 7));
		assertTrue(cp.isMoveLegal('a', 1, 'g', 1));
		
		assertTrue(cp.isMoveLegal('h', 8, 'a', 1));
		assertTrue(cp.isMoveLegal('a', 7, 'a', 1));
		assertTrue(cp.isMoveLegal('g', 1, 'a', 1));
	}
	
	@Test
	public void testInvalidQueenMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.QUEEN, ChessPlayerColor.WHITE, board);
		
		assertFalse(cp.isMoveLegal('a', 1, 'h', 7));
		assertFalse(cp.isMoveLegal('a', 1, 'b', 3));
		assertFalse(cp.isMoveLegal('a', 1, 'f', 3));
		
		assertFalse(cp.isMoveLegal('h', 8, 'd', 1));
		assertFalse(cp.isMoveLegal('f', 1, 'b', 3));
		assertFalse(cp.isMoveLegal('d', 3, 'e', 7));
	}
	
	@Test
	public void testValidBishopMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.BISHOP, ChessPlayerColor.WHITE, board);
		
		assertTrue(cp.isMoveLegal('a', 1, 'h', 8));
		assertTrue(cp.isMoveLegal('a', 1, 'g', 7));
		assertTrue(cp.isMoveLegal('a', 1, 'b', 2));
		
		assertTrue(cp.isMoveLegal('h', 8, 'a', 1));
		assertTrue(cp.isMoveLegal('a', 7, 'e', 3));
		assertTrue(cp.isMoveLegal('g', 1, 'c', 5));
	}
	
	@Test
	public void testInvalidBishopMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.BISHOP, ChessPlayerColor.WHITE, board);
		
		assertFalse(cp.isMoveLegal('a', 1, 'h', 7));
		assertFalse(cp.isMoveLegal('a', 1, 'b', 3));
		assertFalse(cp.isMoveLegal('a', 1, 'f', 3));
		
		assertFalse(cp.isMoveLegal('h', 8, 'h', 1));
		assertFalse(cp.isMoveLegal('f', 3, 'b', 3));
		assertFalse(cp.isMoveLegal('d', 3, 'd', 7));
	}
	
	@Test
	public void testValidRookMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.ROOK, ChessPlayerColor.WHITE, board);
		
		assertTrue(cp.isMoveLegal('a', 1, 'h', 1));
		assertTrue(cp.isMoveLegal('b', 1, 'b', 3));
		
		assertTrue(cp.isMoveLegal('h', 8, 'h', 1));
		assertTrue(cp.isMoveLegal('f', 3, 'b', 3));
	}
	
	@Test
	public void testInvalidRookMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.ROOK, ChessPlayerColor.WHITE, board);
		
		assertFalse(cp.isMoveLegal('a', 2, 'h', 1));
		assertFalse(cp.isMoveLegal('b', 1, 'd', 3));
		
		assertFalse(cp.isMoveLegal('h', 8, 'f', 1));
		assertFalse(cp.isMoveLegal('f', 5, 'b', 3));
	}
	
	@Test
	public void testValidWhitePawnMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.PAWN, ChessPlayerColor.WHITE, board);
		
		assertTrue(cp.isMoveLegal('a', 2, 'a', 3));
		assertTrue(cp.isMoveLegal('a', 2, 'a', 4));
		assertTrue(cp.isMoveLegal('a', 3, 'a', 4));
	}
	
	@Test
	public void testInvalidWhitePawnMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.PAWN, ChessPlayerColor.WHITE, board);
		
		assertFalse(cp.isMoveLegal('a', 1, 'a', 2));
		assertFalse(cp.isMoveLegal('a', 2, 'a', 1));
		assertFalse(cp.isMoveLegal('b', 3, 'a', 4));
		assertFalse(cp.isMoveLegal('b', 3, 'c', 4));
	}
	
	@Test
	public void testValidBlackPawnMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.PAWN, ChessPlayerColor.BLACK, board);
		
		assertTrue(cp.isMoveLegal('a', 7, 'a', 6));
		assertTrue(cp.isMoveLegal('a', 7, 'a', 5));
		assertTrue(cp.isMoveLegal('a', 6, 'a', 5));
	}
	
	@Test
	public void testInvalidBlackPawnMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.PAWN, ChessPlayerColor.BLACK, board);
		
		assertFalse(cp.isMoveLegal('a', 8, 'a', 7));
		assertFalse(cp.isMoveLegal('a', 6, 'a', 7));
		assertFalse(cp.isMoveLegal('b', 5, 'a', 4));
		assertFalse(cp.isMoveLegal('b', 5, 'c', 4));
	}
	
	@Test
	public void testValidKnightMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KNIGHT, ChessPlayerColor.WHITE, board);
		
		assertTrue(cp.isMoveLegal('d', 5, 'c', 7));
		assertTrue(cp.isMoveLegal('d', 5, 'e', 7));
		assertTrue(cp.isMoveLegal('d', 5, 'f', 6));
		assertTrue(cp.isMoveLegal('d', 5, 'f', 4));
		
		assertTrue(cp.isMoveLegal('d', 5, 'c', 3));
		assertTrue(cp.isMoveLegal('d', 5, 'e', 3));
		assertTrue(cp.isMoveLegal('d', 5, 'b', 6));
		assertTrue(cp.isMoveLegal('d', 5, 'b', 4));
	}
	
	@Test
	public void testInvalidKnightMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KNIGHT, ChessPlayerColor.WHITE, board);
		
		assertFalse(cp.isMoveLegal('d', 5, 'd', 7));
		assertFalse(cp.isMoveLegal('d', 5, 'f', 7));
		assertFalse(cp.isMoveLegal('d', 5, 'g', 6));
		assertFalse(cp.isMoveLegal('d', 5, 'g', 4));
		
		assertFalse(cp.isMoveLegal('d', 5, 'd', 3));
		assertFalse(cp.isMoveLegal('d', 5, 'f', 3));
		assertFalse(cp.isMoveLegal('d', 5, 'c', 6));
		assertFalse(cp.isMoveLegal('d', 5, 'c', 4));
	}

	
}
