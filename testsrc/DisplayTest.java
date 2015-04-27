import static org.junit.Assert.*;

import org.junit.Test;

public class DisplayTest
{

	@Test
	public void displayAceOfSpades()
	{
		Display practceDisplay = new Display();
		Card c = new Card(Suit.SPADES, 14);
		String output = practceDisplay.displayCard(c);
		assertEquals(" ace of \u2660", output);
	}

	@Test
	public void displayKingOfSpades()
	{
		Display practceDisplay = new Display();
		Card c = new Card(Suit.SPADES, 13);
		String output = practceDisplay.displayCard(c);
		assertEquals(" sking of \u2660", output);
	}

	@Test
	public void displayNineOfSpades()
	{
		Display practceDisplay = new Display();
		Card c = new Card(Suit.SPADES, 9);
		String output = practceDisplay.displayCard(c);
		assertEquals(" 9 of \u2660", output);
	}

}
