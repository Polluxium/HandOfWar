import java.util.LinkedList;
import java.util.List;



//things to be called in Game.java
public interface Player
{
	public LinkedList<Card> getPlayerHand();		//returns array playerHand
	LinkedList<Card> playerHand = new LinkedList<Card>();

	int chipsToBet = 0;
	boolean isPlayerTurn = false;
	void getTableObj(TableEntity table);
	void setIsPlayerTurn(boolean v);
	public Card getSpecCard(int index);
	void beginGame();							//reset the playerHand
	void accept(Card c);						//makes the player add a card to their hand
	void sortHand();
	HandCombo determineBestHand();
	void setBet(int desiredBet);
	int  getBet();
	void endGame(int p1Score, int p2Score);		//gives score

}

