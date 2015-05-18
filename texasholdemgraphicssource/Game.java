/**
* This is the "constructor" class of the game
*/
import javax.swing.*;

public class Game
{

	int numberOfPlayers = 0;

	Deck d;
	Card c;
	Card c2;
	Card c3;
	Card c4;
	Card tc;

	// wub keeps track of how many image icons are in the eCards array.
	int wub = 0;
	int yWub = 0;
	int tWub = 0;
	static ImageIcon[] eCards = new ImageIcon[6];
	static ImageIcon[] yCards = new ImageIcon[2];
	static ImageIcon[] tCards = new ImageIcon[5];

	int placeHolder;

	Player p1;
	Player p2;
	Player p3;
	Player p4;

	TableEntity tbl;

	public Game(int p)
	{
		tbl 		= new Table();
		d 			= new Deck();

		d.shuffle();

		setNumberOfPlayers(p);

		if(numberOfPlayers == 2)
		{
			p1 = new ComputerPlayer();
			p2 = new ComputerPlayer();
		}
		if(numberOfPlayers == 3)
		{
			p1 = new ComputerPlayer();
			p2 = new ComputerPlayer();
			p3 = new ComputerPlayer();
		}
		if(numberOfPlayers == 4)
		{
			p1 = new ComputerPlayer();
			p2 = new ComputerPlayer();
			p3 = new ComputerPlayer();
			p4 = new ComputerPlayer();
		}
	}


	public void instantiatePlayers()
	{
		System.out.println(numberOfPlayers);
	}

	public void playTH()
	{
		putCardOnTable();
		putCardOnTable();
		putCardOnTable();
		putCardOnTable();
		putCardOnTable();
	}

	public void determineBestHand()
	{
		if(numberOfPlayers == 2){
			System.out.println("Player ones hand: ");
			p1.determineBestHand();
			System.out.println("Player twos hand: ");
			p2.determineBestHand();
		} else if(numberOfPlayers == 3){
			System.out.println("Player ones hand: ");
			p1.determineBestHand();
			System.out.println("Player twos hand: ");
			p2.determineBestHand();
			System.out.println("Player Threes hand: ");
			p3.determineBestHand();
		} else if (numberOfPlayers == 4){
			System.out.println("Player ones hand: ");
			p1.determineBestHand();
			System.out.println("Player twos hand: ");
			p2.determineBestHand();
			System.out.println("Player Threes hand: ");
			p3.determineBestHand();
			System.out.println("Player Fours hand: ");
			p4.determineBestHand();
		}
	}
	//klkjhlkjhlkjhkjhlkjhlkh
	public TableEntity getTableObj()
	{
		return tbl;
	}

	public void putCardOnTable()
	{
		tc = d.dealCard();
		storeCenterTableCardImageIcons(tc);
		tbl.accept(tc);
		if(numberOfPlayers == 2)
		{
			p1.accept(tc);
			p2.accept(tc);
		} else if (numberOfPlayers == 3){
			p1.accept(tc);
			p2.accept(tc);
			p3.accept(tc);
		} else if (numberOfPlayers == 4){
			p1.accept(tc);
			p2.accept(tc);
			p3.accept(tc);
			p4.accept(tc);
		}
	}

	public void setNumberOfPlayers(int n)
	{
		numberOfPlayers = n;
	}

	public int getNumberOfPlayers()
	{
		return numberOfPlayers;
	}

	public void initializeGame()		//start the game
	{
		newShuffledDeck();
	}

	public void newShuffledDeck()		//start the game
	{
		d = new Deck();						//creates a new deck LinkedList
		d.shuffle();								//shuffles that new deck
	}

	public void dealOneHand()
	{
		if(numberOfPlayers == 2)
		{
			c = d.dealCard();
			storeP1CardImageIcons(c);
			p1.accept(c);

			c2 = d.dealCard();
			storeEnemyCardImageIcons(c2);
			p2.accept(c2);

			c = d.dealCard();
			p1.accept(c);
			storeP1CardImageIcons(c);

			c2 = d.dealCard();
			storeEnemyCardImageIcons(c2);
			p2.accept(c2);
		}
		if(numberOfPlayers == 3)
		{
			c = d.dealCard();
			storeP1CardImageIcons(c);
			p1.accept(c);

			c2 = d.dealCard();
			storeEnemyCardImageIcons(c2);
			p2.accept(c2);

			c3 = d.dealCard();
			storeEnemyCardImageIcons(c3);
			p3.accept(c3);

			c = d.dealCard();
			storeP1CardImageIcons(c);
			p1.accept(c);

			c2 = d.dealCard();
			storeEnemyCardImageIcons(c2);
			p2.accept(c2);

			c3 = d.dealCard();
			storeEnemyCardImageIcons(c3);
			p3.accept(c3);
		}
		if(numberOfPlayers == 4)
		{
			c = d.dealCard();
			storeP1CardImageIcons(c);
			p1.accept(c);

			c2 = d.dealCard();
			storeEnemyCardImageIcons(c2);
			p2.accept(c2);

			c3 = d.dealCard();
			storeEnemyCardImageIcons(c3);
			p3.accept(c3);

			c4 = d.dealCard();
			storeEnemyCardImageIcons(c4);
			p4.accept(c4);

			c = d.dealCard();
			storeP1CardImageIcons(c);
			p1.accept(c);

			c2 = d.dealCard();
			storeEnemyCardImageIcons(c2);
			p2.accept(c2);


			c3 = d.dealCard();
			storeEnemyCardImageIcons(c3);
			p3.accept(c3);

			c4 = d.dealCard();
			storeEnemyCardImageIcons(c4);
			p4.accept(c4);
		}
	}

	public void askForBets()
	{
		int temp = numberOfPlayers;

		while(temp > 0)
		{
			String plyr = "p"+temp;

			//how to ask player for bet

			temp--;
		}
	}

	public void resetGame()
	{
		wub = 0;
		yWub = 0;
		tWub = 0;
		tbl.clearTableHand();
		if(numberOfPlayers == 2)
		{
			p1.clearHand();
			p2.clearHand();
		} else if (numberOfPlayers == 3){
			p1.clearHand();
			p2.clearHand();
			p3.clearHand();
		} else if (numberOfPlayers == 4){
			p1.clearHand();
			p2.clearHand();
			p3.clearHand();
			p4.clearHand();
		}
		playTH();
		dealOneHand();
		determineBestHand();

	}

	public void storeEnemyCardImageIcons(Card crd)
	{
		eCards[wub] = new ImageIcon("res/pics/"+crd.getSuit()+"-"+crd.getPlaceHolder()+".gif");
		wub++;
	}

	public void storeP1CardImageIcons(Card crd)
	{
		yCards[yWub] = new ImageIcon("res/pics/"+crd.getSuit()+"-"+crd.getPlaceHolder()+".gif");
		yWub++;
	}

	public void storeCenterTableCardImageIcons(Card crd)
	{
		tCards[tWub] = new ImageIcon("res/pics/"+crd.getSuit()+"-"+crd.getPlaceHolder()+".gif");
		tWub++;
	}

	public ImageIcon showYourCards(int r)
	{
		return yCards[r];
	}

	public ImageIcon showEnemyCards(int r)
	{
		return eCards[r];
	}

	public ImageIcon showTableCard(int r)
	{
		return tCards[r];
	}

	public void dealOneCard()
	{
		d.dealCard();
	}

	public void flipOneCard()
	{

	}

	public void checkIfHandIsPair( Player p1, Player p2 )
	{


	}

	public void bets()
	{



	}

}
