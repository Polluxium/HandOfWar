/**
 * Colin Hauch
 * May 2015
 * 
 * This Class is a computer player class that simply 
 * does whatever the game tells it to do.
 */

import java.util.Collections;
import java.util.LinkedList;

public class ComputerPlayer implements Player
{

	private TableEntity tbl;	//declares a TableTentity: tbl

	//declares and instantiates a new LinkedList called "playerHand"
	private LinkedList<Card> playerHand = new LinkedList<Card>();

	/**
	 * This method is called by the game and is used to 
	 * pass the table object that was declared and 
	 * instantiated in the game class to the player
	 * class. It simply assigns the game's table
	 * object to the player's tbl object
	 */
	public void getTableObj(TableEntity table)
	{
		tbl = table;
	}

	/**
	 * This returns a LinkedList object: playerHand
	 */
	@Override
	public LinkedList<Card> getPlayerHand()
	{
		return playerHand;
	}

	/**
	 * This sets up the game by clearing all 
	 * objects from the player's hand
	 */
	@Override
	public void beginGame()
	{
		playerHand.clear();
	}

	/**
	 * This accepts a card (from the deck) and 
	 * adds it to the player's hand
	 */
	@Override
	public void accept(Card c)
	{
		playerHand.add(0,c);
	}

	/**
	 * This sorts the players hand of 2 cards from 
	 * low to high based solely on the cards' placeHolder
	 */
	@Override
	public void sortHand()
	{
		Collections.sort(playerHand,CardSorters.LOW_TO_HIGH_PH);
	}

	/**
	 * This method determines the best hand that the player
	 * could have. It would be called "getHandType()" but
	 * this game, Texas Holdem, gives the opportunity for
	 * players to utilize 7 cards instead of just 5. This
	 * means that the player could have multiple hand types,
	 * so this method returns the most valuable hand type.
	 */
	public HandCombo determineBestHand()
	{
		//assigns a card from the playerHand a variable
		Card h0 = playerHand.get(0);	
		Card h1 = playerHand.get(1);

		//assigns a card from on the table a variable
		Card t0 = tbl.getSpecCard(0);
		Card t1 = tbl.getSpecCard(1);
		Card t2 = tbl.getSpecCard(2);
		Card t3 = tbl.getSpecCard(3);
		Card t4 = tbl.getSpecCard(4);

		/*
		 * declares and instantiates two LinkedLists, one of all 7 cards 
		 * available (analyzeList) and one of the two cards in the
		 * player's hand (playerPair)
		 */
		LinkedList<Card> analyzeList = new LinkedList<Card>();
		LinkedList<Card> playerPair  = new LinkedList<Card>();
		
		//declares and instantiates a new HandAnalytics object: to analyze the hand
		HandAnalytics             hA = new HandAnalytics(analyzeList);
		
		/*
		 * add all the cards from the table and hand to analyzeList list
		 */
		analyzeList.add(h0);
		analyzeList.add(h1);
		analyzeList.add(t0);
		analyzeList.add(t1);
		analyzeList.add(t2);
		analyzeList.add(t3);
		analyzeList.add(t4);

		/*
		 * add all the cards from the player's hand and hand to playerPair list
		 */
		playerPair.add(h0);
		playerPair.add(h1);

		//sort the lists: low to high based on either the Suit or the PlaceHolder (PH)
		Collections.sort(analyzeList,CardSorters.LOW_TO_HIGH_SUIT);
		Collections.sort(playerPair,CardSorters.LOW_TO_HIGH_PH);

		/*
		 * if block: determines and returns the
		 * handCombination that the player has
		 * (that the object HandAnalytics analyzed).
		 */
		if(hA.hasRoyalFlush() == true)
		{
			return HandCombo.ROYAL_FLUSH;
		}
		if(hA.hasStraightFlush() == true)
		{
			return HandCombo.STRAIGHT_FLUSH;
		}
		if(hA.hasFourOfAKind() == true)
		{
			return HandCombo.FOUR_OF_A_KIND;
		}
		if(hA.hasFullHouse() == true)
		{
			return HandCombo.FULL_HOUSE;
		}
		if(hA.hasFlush() == true)
		{
			return HandCombo.FLUSH;
		}
		if(hA.hasStraight() == true)
		{
			return HandCombo.STRAIGHT;
		}
		if(hA.hasThreeOfAKind() == true)
		{
			return HandCombo.THREE_OF_A_KIND;
		}
		if(hA.hasTwoPairs() == true)
		{
			return HandCombo.TWO_PAIR;
		}
		if(hA.hasPair() == true)
		{
			return HandCombo.PAIR;
		}
		else 
		{
			return HandCombo.HIGH_CARD;
		}
	}
}
