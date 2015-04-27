

public final class Card implements Comparable<Card> {

	private Suit s;
	private int placeHolder;

	Card(Suit s, int i) //package visible
	{
		this.s		= s;
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
	
	@Override
	public String toString() {
		return s.toString() + " " + placeHolder;
	}
}
