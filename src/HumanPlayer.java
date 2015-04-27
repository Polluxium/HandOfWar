import java.util.Collections;
import java.util.LinkedList;

/**
* these methods are used in the game class, so the name of the
methods can not change. Though, what is in the method will vary
greatly compared to the other player classes. Refer to the
Game.java for comments regarding the function of each method.
*/


public class HumanPlayer implements Player {

	private LinkedList<Card> playerHand = new LinkedList<>();
	
	@Override
	public void beginGame()
	{
		playerHand.clear(); // a fresh, new hand!

	}

	@Override
	public void accept(Card c)
	{
		playerHand.add(c);
	}

	@Override
	public void startHand()
	{
		Collections.sort(playerHand,CardSorters.LOW_TO_HIGH);

	}

	@Override
	public void prepareToPlayCard()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Card playCard()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endGame(int p1Score, int p2Score)
	{
		// TODO Auto-generated method stub

	}

}
