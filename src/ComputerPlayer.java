

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ComputerPlayer implements Player {

	private LinkedList<Card> playerHand = new LinkedList<>();

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
	public void startHand()
	{
		Collections.sort(playerHand,CardSorters.HIGH_TO_LOW);

	}

	@Override
	public void prepareToPlayCard()
	{
		//do nothing
	}

	@Override
	public Card playCard()
	{
		return playerHand.pop();
	}

	@Override
	public void endGame(int p1Score, int p2Score)
	{
		p1Score = 0;
		p2Score = 0;
	}

}
