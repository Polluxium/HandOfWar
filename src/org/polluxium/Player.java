package org.polluxium;

//things to be called in Game.java
public interface Player 
{

	void beginGame();		//reset
	void accept(Card c);		//used when game gives each card(s) (5 times per player)
	void startHand();		// starts new hand/sorts cards
	void prepareToPlayCard();	
	Card playCard();		//
	void endGame(int p1Score, int p2Score);		//gives score
	
}
