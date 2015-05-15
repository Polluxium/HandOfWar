/**
 * Colin Hauch
 * May 2015
 *
 * These are the methods that determine the
 * hand of the player, and returns a
 * enum of the possible hands.
 *
 */

import java.util.Collections;
import java.util.LinkedList;

public class HandAnalytics
{
	private int[] counters = new int[14];	//an array of 15 integers, 0 to 14

	private LinkedList<Card> cardsFromPlayer;	//a list of cards from the player class

	/**
	 * this is the constructor class, and it takes a list
	 * @param cardsInHand	-> is a list of all cards on the table
	 */
	public HandAnalytics(LinkedList<Card> cardsInHand)
	{
		/*
		 * sets the list of all cards on the table (cardsInHand)
		 * to a new list called "cardsFromPlayer"
		 */
		cardsFromPlayer = cardsInHand;

		//sort the list cardsFromPlayer by placeholder
		Collections.sort(cardsFromPlayer,CardSorters.LOW_TO_HIGH_PH);

		// Initialize the array of counters each to be 0
		for ( int i=0; i!=counters.length; ++i )
		{
			counters[i] = 0;
		}


		/*
		 * Loop over the cards in hand and increment the correct counter.
		 * For each card in cardsInHand, go through the array of integers
		 * and add one to the array slot that is the same number as the
		 * placeholder of the card. It then adds one to the integer at
		 * that slot.
		 *
		 * For example:
		 *
		 * If the hand has a 7 of Clubs, a 7 of Hearts, and a King of Spades, the array will show
		 *
		 * slot number:  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
		 * array:      [ 0 0 0 0 0 0 0 2 0 0 0  0  0  1  0  ]
		 *
		 * There are two 7s and one King (of a placeholder of 13), so the array is as shown.
		 *
		 */
		for(Card card: cardsInHand)
		{
			//the int placeholder is set to placeholder of the card that the loop is on
			int placeholder = card.getPlaceHolder();

			/*
			 * currentCount is the int in the array that depicts the number of cards in the hand.
			 *
			 * The int in the array at slot *placeHolder* (which currently depicts the number of
			 * cards in the hand [that the loop has gone over] with that placeholder) is added to
			 * 1 to update the array.
			 */
			int currentCount = counters[placeholder];
			counters[placeholder] = currentCount + 1;
		}
	}



	/**
	 * If the int at slot 13 in the counter is one (or greater) and
	 * the int at slot 12 in the counter is one (or greater) and
	 * the int at slot 11 in the counter is one (or greater) and
	 * the int at slot 10 in the counter is one (or greater) and
	 * the int at slot  9 in the counter is one (or greater) then...
	 * 		declare a commonSuit variable
	 * 		for each suit value "s"
	 * 			set commonSuit to s
	 * 				for each suit value possible, check if all the cards have that suit
	 * 					if every card has the same suit, return true
	 *
	 */
	public boolean hasRoyalFlush()
	{
		if(counters[13] >= 1 && counters[12] >= 1 && counters[11] >= 1 && counters[10] >= 1 && counters[9] >= 1)
		{
			Suit commonSuit;

			for (Suit s: Suit.values())
			{
				commonSuit = s;

				for(int w = 0; w <= 7; w++)
				{
					if(cardsFromPlayer.get(13).getSuit() == commonSuit
							&& cardsFromPlayer.get(12).getSuit() == commonSuit
							&& cardsFromPlayer.get(11).getSuit() == commonSuit
							&& cardsFromPlayer.get(10).getSuit() == commonSuit
							&& cardsFromPlayer.get( 9).getSuit() == commonSuit)
					{
						return true;
					}
				}
			}
		}

		return false;

	}

	/**
	 * for each slot in the counter array,
	 * 		if one of those slots has an int greater than 0 (meaning the hand has a card of that placeholder
	 * 			and if that slot has an int greater than 1
	 * 			and the next slot has an int greater than 1
	 * 			and the next slot has an int greater than 1
	 * 			and the next slot has an int greater than 1
	 * 			and the next slot has an int greater than 1
	 * 				declare a commonSuit variable
	 * 				for each suit value "s"
	 * 					set commonSuit to s
	 * 					for each suit value possible, check if all the cards have that suit
	 * 						if every card has the same suit, return true
	 *
	 */
	public boolean hasStraightFlush()
	{
		for ( int i=0; i!=(counters.length-4); i++ )
		{
			if ( counters[i] > 0 )
			{
				// We have a card with this placeholder; look for the next four cards ...
				if ( counters[i] >= 1 && counters[i+1] >= 1 && counters[i+2] >= 1 && counters[i+3] >= 1 && counters[i+4] >= 1 )
				{
					Suit commonSuit;

					for (Suit s: Suit.values())
					{
						commonSuit = s;

						for(int w = 0; w <= 7; w++)
						{

							if(cardsFromPlayer.get(w).getSuit() == commonSuit
									&& cardsFromPlayer.get(w+1).getSuit() == commonSuit
									&& cardsFromPlayer.get(w+2).getSuit() == commonSuit
									&& cardsFromPlayer.get(w+3).getSuit() == commonSuit
									&& cardsFromPlayer.get(w+4).getSuit() == commonSuit)
							{
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}

	/**
	 * This method loops through the counters[] array
	 * and determines if any of the slots in the counters[]
	 * array have a 4. That would indicate that there are
	 * 4 of one placeHolder value of card in
	 * the hand : a four of a kind
	 */
	public boolean hasFourOfAKind()
	{
		for ( int i=0; i!=counters.length; ++i )	//loop through each counters[] position
		{
			if ( counters[i] == 4 )		//if any of the slots have a 4...
			{
				return true;			//return true
			}
		}
		return false;
	}

	/**
	 * determines if the player has a full house
	 */
	public boolean hasFullHouse()
	{
		/*
		 * variables that can only be seen in the method
		 * that tell if there is a two of a kind (a pair)
		 *  and a three of a kind.
		 */
		boolean commonThree = false;
		boolean commonTwo	= false;

		for ( int i=0; i!=counters.length; ++i )	//loop through each counters[] posistion
		{
			if ( counters[i] == 3 )		//if any of the slots have a 3...
			{
				commonThree = true;		//set commonThree to true
			}
			if ( counters[i] == 2 )		//if any of the slots have a 2...
			{
				commonTwo = true;		//set commonTwo to true
			}
		}

		if(commonThree == true && commonTwo == true)	//if both commonThree and commonTwo are true...
		{
			return true;	//return true
		}

		return false;
	}

	/**
	 * determines if the player has a flush
	 */
	public boolean hasFlush()
	{
		/*
		 * variables that can only be seen in the method
		 * that count the number of cards of each suit
		 */
		int numberCLUBS 	= 0;
		int numberHEARTS 	= 0;
		int numberDIAMONDS 	= 0;
		int numberSPADES	= 0;

		for(Card card: cardsFromPlayer)	//for each card in the list of cards called "cardsFromPlayer"...
		{
			/*
			 * check the suit of the card..
			 * if CLUBS, add 1 to the count of the number of cards that are CLUBS
			 */
			if(card.getSuit() == Suit.CLUBS)
			{
				numberCLUBS++;
			}
			//if HEARTS, add 1 to the count of the number of cards that are HEARTS
			if(card.getSuit() == Suit.HEARTS)
			{
				numberHEARTS++;
			}
			//if DIAMONDS, add 1 to the count of the number of cards that are DIAMONDS
			if(card.getSuit() == Suit.DIAMONDS)
			{
				numberDIAMONDS++;
			}
			//if SPADES, add 1 to the count of the number of cards that are SPADES
			if(card.getSuit() == Suit.SPADES)
			{
				numberSPADES++;
			}
		}

		/*
		 * if there are ever 5 cards in the hand of the same suit, return true
		 */
		if ( numberCLUBS == 5 || numberHEARTS == 5 || numberDIAMONDS == 5 || numberSPADES == 5 )
		{
			return true;
		}

		return false;
	}

	/**
	 * for each slot in the counter array,
	 * 		if one of those slots has an int greater than 0 (meaning the hand has a card of that placeholder
	 * 			and if that slot has an int greater than 1
	 * 			and the next slot has an int greater than 1
	 * 			and the next slot has an int greater than 1
	 * 			and the next slot has an int greater than 1
	 * 			and the next slot has an int greater than 1
	 */
	public boolean hasStraight()
	{
		for ( int i=0; i!=(counters.length-4); i++ )	//.length-4 because the top four could be a royal flush (and already checked)
		{
			if ( counters[i] > 0 )
			{
				// We have a card with this placeholder; look for the next four cards ...
				if ( counters[i] >= 1 && counters[i+1] >= 1 && counters[i+2] >= 1 && counters[i+3] >= 1 && counters[i+4] >= 1 )
				{
					// Found a straight ...
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method loops through the counters[] array
	 * and determines if any of the slots in the counters[]
	 * array have a 3. That would indicate that there are
	 * 3 of one placeHolder value of card in
	 * the hand: a three of a kind
	 */
	public boolean hasThreeOfAKind()
	{
		for ( int i=0; i!=counters.length; ++i )	//loop through each counters[] position
		{
			if ( counters[i] == 3 )		//if any of the slots have a 4...
			{
				return true;			//return true
			}
		}
		return false;
	}

	/**
	 * This method loops through the counters[] array
	 * and determines if any of the slots in the counters[]
	 * array have a 2. That would indicate that there are
	 * 2 of one placeHolder value of card in
	 * the hand: a pair. It then checks to see if there
	 * are any other slots with a 2.
	 */
	public boolean hasTwoPairs()
	{
		for ( int i=0; i!=counters.length; ++i )
		{
			if ( counters[i] == 2 )
			{
				for(int p = 1; p <= 11; p++)
				{
					if ( counters[i+p] == 2 )
					{
						return true;
					}
				}
			}

		}
		return false;
	}

	/**
	 * This method loops through the counters[] array
	 * and determines if any of the slots in the counters[]
	 * array have a 2. That would indicate that there are
	 * 2 of one placeHolder value of card in
	 * the hand: a pair.
	 */
	public boolean hasPair()
	{
		for ( int i=0; i!=counters.length; ++i )
		{
			if ( counters[i] == 2 )
			{
				return true;
			}

		}
		return false;
	}

	/**
	 * this method returns the second card in the playerPair list
	 * of two cards (it was sorted from low to high, so the 
	 * second card would be the higher of the two)
	 */
	public int getHighCard(LinkedList<Card> playerPair)
	{
		return playerPair.getLast().getPlaceHolder();
	}

	/**
	 * this card returns the first card in the playerPair list
	 * of two cards (it was sorted from low to high, so the 
	 * first card would be the second highest of the two)
	 */
	public int getNextHighCard(LinkedList<Card> playerPair)
	{
		return playerPair.getFirst().getPlaceHolder();
	}
}
