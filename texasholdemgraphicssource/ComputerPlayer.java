

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComputerPlayer implements Player
{

	private TableEntity tbl;

	private LinkedList<Card> playerHand = new LinkedList<Card>();

	private LinkedList<Card> analyzeList;

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
	public void clearHand()
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

		Card t0 = playerHand.get(2);
		Card t1 = playerHand.get(3);
		Card t2 = playerHand.get(4);
		Card t3 = playerHand.get(5);
		Card t4 = playerHand.get(6);

		analyzeList = new LinkedList<Card>();

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
			System.out.println("Royal Flush");
			return HandCombo.ROYAL_FLUSH;
		}
		else if(hA.hasStraightFlush() == true)
		{
			System.out.println("Straight Flush");
			return HandCombo.STRAIGHT_FLUSH;
		}
		else if(hA.hasFourOfAKind() == true)
		{
			System.out.println("Four of a kind");
			return HandCombo.FOUR_OF_A_KIND;
		}
		else if(hA.hasFullHouse() == true)
		{
			System.out.println("Full house");
			return HandCombo.FULL_HOUSE;
		}
		else if(hA.hasFlush() == true)
		{
			System.out.println("Flush");
			return HandCombo.FLUSH;
		}
		else if(hA.hasStraight() == true)
		{
			System.out.println("Straight");
			return HandCombo.STRAIGHT;
		}
		else if(hA.hasThreeOfAKind() == true)
		{
			System.out.println("Three of a kind");
			return HandCombo.THREE_OF_A_KIND;
		}
		else if(hA.hasTwoPairs() == true)
		{
			System.out.println("Two pair");
			return HandCombo.TWO_PAIR;
		}
		else if(hA.hasPair() == true)
		{
			System.out.println("Pair");
			return HandCombo.PAIR;
		}
		else
		{
			System.out.println("High Card");
			return HandCombo.HIGH_CARD;
		}



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
