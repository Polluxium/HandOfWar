package org.polluxium;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

	private LinkedList<Card> cards = new LinkedList<>();
	
	public Deck()
	{
		for (Suit s: Suit.values())
		{
			for (int i=2; i<=14; i++)
			{
				Card c = new Card(s,i);
				cards.add(c);
			}
		}
		
	}
	
	public void shuffle()
	{
		Collections.shuffle(cards);
	}
	
	public Card takeCard()
	{
		Card c = cards.pop();
		return c;
	}
	
}
