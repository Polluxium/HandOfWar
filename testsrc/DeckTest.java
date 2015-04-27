import org.junit.Before;
import org.junit.Test;

public class DeckTest
{

	private Deck deck;

	@Before
	public void beforeEach()
	{
		deck = new Deck();
	}

	@Test
	public void deckShouldNotBeShuffled()
	{
		while (true)
		{
			Card c = deck.takeCard();
			if (c == null)
				return;
			else
				System.out.println(c);
		}
	}

	@Test
	public void deckShouldShuffle()
	{
		deck.shuffle();
		while (true)
		{
			Card c = deck.takeCard();
			if (c == null)
				return;
			else
				System.out.println(c);
		}
	}

}
