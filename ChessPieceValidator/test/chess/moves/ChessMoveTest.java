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

import static org.junit.Assert.*;

import org.junit.Test;

import chess.board.ChessLocation;

/**
 * 
 * @author ted
 *
 * tests for chessMove
 */
public class ChessMoveTest
{

	/**
	 * test all the ChessMove equality branches
	 */
	@Test
	public void testEquals()
	{
		ChessMove cmm = new ChessMove(new ChessLocation('a', 2), new ChessLocation('b', 3));
		ChessMove clo = new ChessMove(new ChessLocation('a', 2), new ChessLocation('c', 3));
		ChessMove dup = new ChessMove(new ChessLocation('a', 2), new ChessLocation('b', 3));
		
		// test that it always equals itself
		assertTrue(cmm.equals(cmm));
		
		
		// test that it never equals null
		assertFalse(cmm.equals(null));
		
		//test same starting location, different destination
		assertFalse(cmm.equals(clo));
		
		// equal, but different memory locs
		assertTrue(cmm.equals(dup));
	}
	
	/**
	 * test to make sure the hash codes work
	 */
	@Test
	public void testHashCode()
	{
		ChessMove cmm = new ChessMove(new ChessLocation('a', 2), new ChessLocation('b', 3));
		ChessMove clo = new ChessMove(new ChessLocation('a', 2), new ChessLocation('c', 3));

		// yes, I did do these by hand
		assertEquals(cmm.hashCode(), -732360162);
		assertEquals(clo.hashCode(), -806983273);
	}

	/**
	 * test to make sure you can't pass negatives
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidConstructor()
	{
		new ChessMove(null, new ChessLocation('b', 3));
	}
}
