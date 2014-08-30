package chess.board;

public class ChessLocation
{
	private final Character alphabetic;
	private final Integer numeric;
	
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
			return getNumeric().equals(cl.getNumeric()) && getAlphabetic().equals(cl.getAlphabetic());
		}
		return false;
	}
}
