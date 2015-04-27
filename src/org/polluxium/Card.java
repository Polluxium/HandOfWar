package org.polluxium;

public final class Card implements Comparable<Card> {
	
	private Suit s;
	private int placeHolder;
	
	Card(Suit suit, int i) //package visible
	{
		s 			= suit;
		placeHolder = i;
	}
	
	public Suit getSuit() 
	{
		return s;
	}
	
	public int getPlaceHolder() 
	{
		return placeHolder;
	}

	@Override
	public int compareTo(Card other) 
	{
		if (this == other) 
		{
			return 0;	
		}
		
		return this.placeHolder-other.placeHolder;
	}
}
