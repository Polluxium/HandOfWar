
import java.util.Collections;
import java.util.LinkedList;

public class Deck {

	private LinkedList<Card> cards = new LinkedList<>();	//creates new LinkedList of type Card

	public Deck()
	{
		for (Suit s: Suit.values())							//run for each of the suit values (see Suit.java)
		{
			for (int i=2; i<=14; i++)						//make a card numbered 2 to 14 (not 0 and 1)
			{
				Card c = new Card(s,i);						//make each new card have a suit (s) and a placeholder (i)
				cards.add(c);								//add that new card to the LinkedList
			}
		}
	}

	public void shuffle()
	{
		Collections.shuffle(cards);							//shuffles the list
	}

	public void sort()
	{
		Collections.sort(cards);							//reorders the list
	}

	public Card takeCard()
	{
		if ( cards.isEmpty() ) return null;					//pop will break without when cards is empty
		Card c = cards.pop();								//takes a card off of the top of the list
		return c;											//returns that card
	}
}
