import java.util.LinkedList;
import java.util.List;

/**
* TESTING DISPLAY CLASS
*/

public class Display
{
	
	public static void main( String a[])
	{
		new Display();
	}

	// TEST CONSTRUCTOR
	public Display()
	{
		//Card c = new Card(Suit.SPADES, 14);
	//	System.out.println(practceDisplay.displayCard(c));
		LinkedList<Card> hand = new LinkedList<>();
		hand.add(new Card(Suit.SPADES, 11));
		hand.add(new Card(Suit.CLUBS, 7));
		hand.add(new Card(Suit.HEARTS, 2));
		hand.add(new Card(Suit.DIAMONDS, 8));
		hand.add(new Card(Suit.SPADES, 13));
	}

	public String displayCard(Card c)
	{
		String cardName = new String();
		if (c.getPlaceHolder() == 11)
			cardName += " jack of ";
		else if (c.getPlaceHolder() == 12)
			cardName += " queen of ";
		else if (c.getPlaceHolder() == 13)
			cardName += " king of ";
		else if (c.getPlaceHolder() == 14)
			cardName += " ace of ";
		else
			cardName += " " + c.getPlaceHolder() + " of ";

		switch(c.getSuit())
		{
			case SPADES:
				cardName += "\u2660";
				break;
			case HEARTS:
				cardName += "\u2661";
				break;
			case DIAMONDS:
				cardName += "\u2662";
				break;
			case CLUBS:
				cardName += "\u2663";
				break;
		}
	/*
		if (c.getSuit() == Suit.SPADES) cardName += "\u2660";
		else if (c.getSuit() == Suit.HEARTS) cardName += "\u2661";
		else if (c.getSuit() == Suit.DIAMONDS) cardName += "\u2662";
		else cardName += "\u2663"; // no other suit, bad form
	 */
		return cardName;
	}

	public void bootup()
	{
		System.out.println("Welcome to HAND OF WAR");
	}

	public void handInstructions()
	{
		System.out.println("This is your hand");
	}

	public void displayHand(LinkedList<Card> playerHand) //this is run in the takecard methods
	{
//		String display = "";
//		for ( int i=0; i!= hand.size(); ++i ) {
//			Card card = hand.get(i);
//			display += displayCard(card);
//		}
		for (int i = 0; i != playerHand.size(); i++)
		{
			Card card = playerHand.get(i);
			if ( i != 0)
				System.out.print(", ");
			String cardstr = displayCard(card);
			System.out.print(cardstr);
		}
		System.out.println("");
	}

	public void playCardConformation()
	{
		System.out.println("You have selected "+"cardname");
	}

	public void compareCards()
	{
		System.out.println("Your oppenent played "+"opponentCardName"+" and you have played "+"cardName"+".");
	}

	public void scorePlay()
	{
		System.out.println("You gained");
	}

	public void playAgain()
	{
		System.out.println("Pick another card to play!");
	}

	public void youWon()
	{
		System.out.println("You won :) ");
	}

	public void youLost()
	{
		System.out.println("You lost :( ");
	}

	public void youTied()
	{
		System.out.println("You tied :/ ");
	}

}

