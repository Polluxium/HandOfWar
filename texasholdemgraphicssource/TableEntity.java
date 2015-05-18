

import java.util.ArrayList;
import java.util.List;



//things to be called in Game.java
public interface TableEntity
{
	public ArrayList<Card> tableCards = new ArrayList<Card>(5);
	public Card getSpecCard(int index);
	public boolean isEmpty();
	public void clearTableHand();
	public void accept(Card c);
	public void printSomething();

}