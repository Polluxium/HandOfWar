

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComputerPlayer implements Player
{

	private TableEntity tbl;

	private LinkedList<Card> playerHand = new LinkedList<Card>();

	private int chipsToBet = 0;
	private boolean isPlayerTurn = false;

	public Card getSpecCard(int index)
	{
		return playerHand.get(index);
	}

	public void getCardImageString()
	{
		System.out.println(playerHand.size());
	}
	public void getTableObj(TableEntity table)
	{
		tbl = table;
	}

	@Override
	public LinkedList<Card> getPlayerHand()
	{
		return playerHand;
	}

	@Override
	public void beginGame()
	{
		playerHand.clear();
	}

	@Override
	public void accept(Card c)
	{
		playerHand.add(c);
	}

	@Override
	public void sortHand()
	{
		Collections.sort(playerHand,CardSorters.LOW_TO_HIGH_PH);
	}

	public void setIsPlayerTurn(boolean v)
	{
		isPlayerTurn = v;
	}

	public HandCombo determineBestHand()
	{
		Card h0 = playerHand.get(0);
		Card h1 = playerHand.get(1);

		Card t0 = tbl.getSpecCard(0);
		Card t1 = tbl.getSpecCard(1);
		Card t2 = tbl.getSpecCard(2);
		Card t3 = tbl.getSpecCard(3);
		Card t4 = tbl.getSpecCard(4);

//		Card h0 = new Card(Suit.SPADES, 3);
//		Card h1 = new Card(Suit.SPADES, 3);
//
//		Card t0 = new Card(Suit.HEARTS, 10);
//		Card t1 = new Card(Suit.HEARTS, 11);
//		Card t2 = new Card(Suit.HEARTS, 12);
//		Card t3 = new Card(Suit.HEARTS, 13);
//		Card t4 = new Card(Suit.HEARTS, 14);

		LinkedList<Card> analyzeList = new LinkedList<Card>();

		LinkedList<Card> playerPair  = new LinkedList<Card>();

		analyzeList.add(h0);
		analyzeList.add(h1);
		analyzeList.add(t0);
		analyzeList.add(t1);
		analyzeList.add(t2);
		analyzeList.add(t3);
		analyzeList.add(t4);

		playerPair.add(h0);
		playerPair.add(h1);

		Collections.sort(analyzeList,CardSorters.LOW_TO_HIGH_SUIT);

		Collections.sort(playerPair,CardSorters.LOW_TO_HIGH_PH);

		HandAnalytics hA = new HandAnalytics(analyzeList);

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
		else return HandCombo.HIGH_CARD;



	}
/*
	public void bets(AllBets allBets)
	{

		allBets.

	}
*/
	public void setBet(int desiredBet)
	{
		chipsToBet = desiredBet;
	}

	public int getBet()
	{
		return chipsToBet;
	}

	@Override
	public void endGame(int p1Score, int p2Score)
	{
		p1Score = 0;
		p2Score = 0;
	}

	public void printSomething()
	{
		System.out.println(playerHand);
		System.out.println(playerHand.size());
	}
}
