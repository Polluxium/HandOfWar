import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Table implements TableEntity
{

	public ArrayList<Card> tableCards = new ArrayList<Card>(5);


	public Card getSpecCard(int index)
	{
		return tableCards.get(index);
	}

	public boolean isEmpty()
	{
		return tableCards.isEmpty();
	}

	public void clearTableHand()
	{
		tableCards.clear();
	}

	public void accept(Card c)
	{
		tableCards.add(c);
	}

	public void printSomething()
	{
		System.out.println(tableCards);
	}

}