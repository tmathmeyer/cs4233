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

/**
 * 
 * @author ted
 *
 * A representation of a place on the board, such that
 * an invalid space cannot be constructed
 */
public class ChessLocation
{
	private final Character alphabetic;
	private final Integer numeric;
	
	/**
	 * will fail if created with out of bounds parameters
	 * 
	 * @param alph the alphabetic (column) of the location
	 * @param num the numeric (row) of the location
	 */
	public ChessLocation(char alph, int num)
	{
		if (alph >= 'a' && alph <= 'h')
		{
			alphabetic = alph;
		}
		else
		{
			throw new IllegalArgumentException("invalid alpha @ " + alph);
		}
		
		if (num >= 1 && num <= 8)
		{
			numeric = num;
		}
		else
		{
			throw new IllegalArgumentException("invalid num @ " + num);
		}
	}

	/**
	 * @return the alphabetic
	 */
	public Character getAlphabetic()
	{
		return alphabetic;
	}

	/**
	 * @return the numeric
	 */
	public Integer getNumeric()
	{
		return numeric;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if (other instanceof ChessLocation)	
		{
			ChessLocation cl = (ChessLocation) other;
			return numeric.equals(cl.getNumeric()) && alphabetic.equals(cl.getAlphabetic());
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return ((alphabetic * 11443) + (numeric * 16603)) * 31277;
	}
}
