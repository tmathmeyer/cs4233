/*******************************************************************************
 * This file was developed by Ted Meyer for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package chess;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author ted
 * 
 * Tests for methods on the ChessPiece class
 *
 */
public class ChessPieceTest
{
	/**
	 * Tests invalid method input
	 */
	@Test
	public void testInvalidInput()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KING, ChessPlayerColor.WHITE);
		
		assertFalse(cp.isMoveLegal('g', 1, 'b', 2));
		assertFalse(cp.isMoveLegal('a', 0, 'b', 2));
		assertFalse(cp.isMoveLegal('a', 1, '~', 2));
		assertFalse(cp.isMoveLegal('a', 1, 'b', 49));
	}
	
	/**
	 * tests valid moves for king pieces
	 */
	@Test
	public void testValidKingMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KING, ChessPlayerColor.WHITE);
		
		assertTrue(cp.isMoveLegal('a', 1, 'b', 2));
		assertTrue(cp.isMoveLegal('a', 1, 'b', 1));
		assertTrue(cp.isMoveLegal('a', 1, 'a', 2));
		
		assertTrue(cp.isMoveLegal('b', 2, 'a', 1));
		assertTrue(cp.isMoveLegal('b', 1, 'a', 1));
		assertTrue(cp.isMoveLegal('a', 2, 'a', 1));
	}
	
	/**
	 * test invalid moves for king pieces
	 */
	@Test
	public void testInvalidKingMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KING, ChessPlayerColor.WHITE);
		
		assertFalse(cp.isMoveLegal('a', 1, 'c', 3));
		assertFalse(cp.isMoveLegal('a', 1, 'c', 1));
		assertFalse(cp.isMoveLegal('a', 1, 'a', 3));
		
		assertFalse(cp.isMoveLegal('c', 2, 'a', 1));
		assertFalse(cp.isMoveLegal('c', 1, 'a', 1));
		assertFalse(cp.isMoveLegal('a', 3, 'a', 1));
	}
	
	/**
	 * test valid moves for queen pieces
	 */
	@Test
	public void testValidQueenMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.QUEEN, ChessPlayerColor.WHITE);
		
		assertTrue(cp.isMoveLegal('a', 1, 'h', 8));
		assertTrue(cp.isMoveLegal('a', 1, 'a', 7));
		assertTrue(cp.isMoveLegal('a', 1, 'g', 1));
		
		assertTrue(cp.isMoveLegal('h', 8, 'a', 1));
		assertTrue(cp.isMoveLegal('a', 7, 'a', 1));
		assertTrue(cp.isMoveLegal('g', 1, 'a', 1));
	}
	
	/**
	 * test invalid moves for queen pieces
	 */
	@Test
	public void testInvalidQueenMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.QUEEN, ChessPlayerColor.WHITE);
		
		assertFalse(cp.isMoveLegal('a', 1, 'h', 7));
		assertFalse(cp.isMoveLegal('a', 1, 'b', 3));
		assertFalse(cp.isMoveLegal('a', 1, 'f', 3));
		
		assertFalse(cp.isMoveLegal('h', 8, 'd', 1));
		assertFalse(cp.isMoveLegal('f', 1, 'b', 3));
		assertFalse(cp.isMoveLegal('d', 3, 'e', 7));
	}
	
	/**
	 * test valid moves for bishops
	 */
	@Test
	public void testValidBishopMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.BISHOP, ChessPlayerColor.WHITE);
		
		assertTrue(cp.isMoveLegal('a', 1, 'h', 8));
		assertTrue(cp.isMoveLegal('a', 1, 'g', 7));
		assertTrue(cp.isMoveLegal('a', 1, 'b', 2));
		
		assertTrue(cp.isMoveLegal('h', 8, 'a', 1));
		assertTrue(cp.isMoveLegal('a', 7, 'e', 3));
		assertTrue(cp.isMoveLegal('g', 1, 'c', 5));
	}
	
	/**
	 * test invalid moves for bishops
	 */
	@Test
	public void testInvalidBishopMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.BISHOP, ChessPlayerColor.WHITE);
		
		assertFalse(cp.isMoveLegal('a', 1, 'h', 7));
		assertFalse(cp.isMoveLegal('a', 1, 'b', 3));
		assertFalse(cp.isMoveLegal('a', 1, 'f', 3));
		
		assertFalse(cp.isMoveLegal('h', 8, 'h', 1));
		assertFalse(cp.isMoveLegal('f', 3, 'b', 3));
		assertFalse(cp.isMoveLegal('d', 3, 'd', 7));
	}
	
	/**
	 * test valid moves for rooks
	 */
	@Test
	public void testValidRookMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.ROOK, ChessPlayerColor.WHITE);
		
		assertTrue(cp.isMoveLegal('a', 1, 'h', 1));
		assertTrue(cp.isMoveLegal('b', 1, 'b', 3));
		
		assertTrue(cp.isMoveLegal('h', 8, 'h', 1));
		assertTrue(cp.isMoveLegal('f', 3, 'b', 3));
	}
	
	/**
	 * test invalid moves for rooks
	 */
	@Test
	public void testInvalidRookMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.ROOK, ChessPlayerColor.WHITE);
		
		assertFalse(cp.isMoveLegal('a', 2, 'h', 1));
		assertFalse(cp.isMoveLegal('b', 1, 'd', 3));
		
		assertFalse(cp.isMoveLegal('h', 8, 'f', 1));
		assertFalse(cp.isMoveLegal('f', 5, 'b', 3));
	}
	
	/**
	 * test vaid moves for white pawns
	 */
	@Test
	public void testValidWhitePawnMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.PAWN, ChessPlayerColor.WHITE);
		
		assertTrue(cp.isMoveLegal('a', 2, 'a', 3));
		assertTrue(cp.isMoveLegal('a', 2, 'a', 4));
		assertTrue(cp.isMoveLegal('a', 3, 'a', 4));
	}
	
	/**
	 * test invalid moves for white pawns
	 */
	@Test
	public void testInvalidWhitePawnMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.PAWN, ChessPlayerColor.WHITE);
		
		assertFalse(cp.isMoveLegal('a', 1, 'a', 2));
		assertFalse(cp.isMoveLegal('a', 2, 'a', 1));
		assertFalse(cp.isMoveLegal('b', 3, 'a', 4));
		assertFalse(cp.isMoveLegal('b', 3, 'c', 4));
	}
	
	/**
	 * test valid moves for black pawns
	 */
	@Test
	public void testValidBlackPawnMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.PAWN, ChessPlayerColor.BLACK);
		
		assertTrue(cp.isMoveLegal('a', 7, 'a', 6));
		assertTrue(cp.isMoveLegal('a', 7, 'a', 5));
		assertTrue(cp.isMoveLegal('a', 6, 'a', 5));
	}
	
	/**
	 * test invalid moves for black pawns
	 */
	@Test
	public void testInvalidBlackPawnMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.PAWN, ChessPlayerColor.BLACK);
		
		assertFalse(cp.isMoveLegal('a', 8, 'a', 7));
		assertFalse(cp.isMoveLegal('a', 6, 'a', 7));
		assertFalse(cp.isMoveLegal('b', 5, 'a', 4));
		assertFalse(cp.isMoveLegal('b', 5, 'c', 4));
	}
	
	/**
	 * test valid moves for knights
	 */
	@Test
	public void testValidKnightMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KNIGHT, ChessPlayerColor.WHITE);
		
		assertTrue(cp.isMoveLegal('d', 5, 'c', 7));
		assertTrue(cp.isMoveLegal('d', 5, 'e', 7));
		assertTrue(cp.isMoveLegal('d', 5, 'f', 6));
		assertTrue(cp.isMoveLegal('d', 5, 'f', 4));
		
		assertTrue(cp.isMoveLegal('d', 5, 'c', 3));
		assertTrue(cp.isMoveLegal('d', 5, 'e', 3));
		assertTrue(cp.isMoveLegal('d', 5, 'b', 6));
		assertTrue(cp.isMoveLegal('d', 5, 'b', 4));
	}
	
	/**
	 * test invalid moves for knights
	 */
	@Test
	public void testInvalidKnightMoves()
	{
		ChessPiece cp = new ChessPiece(ChessPieceType.KNIGHT, ChessPlayerColor.WHITE);
		
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
