/**
* This is the "constructor" class of the game
*/

public class Game {

	private Display display = new Display();

	public void play( Player p1, Player p2 )		//start the game
	{
		Deck d = new Deck();						//creates a new deck LinkedList
		d.shuffle();								//shuffles that new deck

		p1.beginGame();								//starts the hand
		p2.beginGame();
		display.bootup();

		for (int i = 0; i != 5; i++)				//do 5 times
		{
			p1.accept(d.takeCard());				//tells player1 to take a card
			p2.accept(d.takeCard());				//tells player2 to take a card
		}

		p1.startHand();								//tells player1 to sort hand
		p2.startHand(); 							//tells player2 to sort hand
		display.handInstructions();
		display.displayHand(p1.getPlayerHand());
		display.displayHand(p2.getPlayerHand());
		
		
		
		

		/**
		* this is a simulated game, that would run
		* 5 hands.
		* Still in development
		*/

		for (int i = 0; i != 5; i++)
		{
			p1.prepareToPlayCard();
			p2.prepareToPlayCard();
			Card c1 = p1.playCard();				//takes card from p1
			Card c2 = p2.playCard();				//takes card from p2

			int difference = c1.compareTo(c2);		//compares them (subtracts and finds the difference)

			if (difference < 0)
			{
				System.out.println("p2 won");
			}
			else if (difference == 0)
			{
				System.out.println("Tie");			}
			else
			{
				System.out.println("p1 won");
			}
		}
	}
}
