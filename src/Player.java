import java.util.LinkedList;
import java.util.List;



//things to be called in Game.java
public interface Player
{

	void beginGame();							//reset the game
	void accept(Card c);						//used when game gives each card(s)to each player (5 times per player)
	void startHand();							//starts new hand and sorts cards
	void prepareToPlayCard();					//tell player(s) to select card to play
	Card playCard();							//take that card from the players
	void endGame(int p1Score, int p2Score);		//gives score
	LinkedList<Card> getPlayerHand();
}
