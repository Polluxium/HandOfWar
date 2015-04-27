package org.polluxium;

public class Game {

	public void play()
	{
		Deck d = new Deck();
		d.shuffle();
		Player p1 = new ComputerPlayer();
		Player p2 = new ComputerPlayer();
		
		p1.beginGame();
		p2.beginGame();
		
		for (int i = 0; i != 5; i++)
		{
			p1.accept(d.takeCard());
			p2.accept(d.takeCard());
		}
		
		p1.startHand();
		p2.startHand();

		//for (int i = 0; i != 5; i++)
		//{
			p1.prepareToPlayCard();
			p2.prepareToPlayCard();
			Card c1 = p1.playCard();
			Card c2 = p2.playCard();	
			int difference = c1.compareTo(c2);
			
			if (difference < 0)
			{
				//p2 won
			}
			else if (difference == 0)
			{
				//p1 and p2 tied
			}
			else
			{
				//p1 won
			}
			
		//}
		
		

		
	}
}
