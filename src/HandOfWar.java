public class HandOfWar
{

	public static void main( String a[])
	{
		//Player p1 = null;
		//Player p2 = null;



	/*	Mode m = Mode.COMPUTER_V_COMPUTER;	// set via menu
		switch(m)
		{
			case HUMAN_V_COMPUTER:
				p1 = new HumanPlayer();			//creates new player (computer player)
				p2 = new ComputerPlayer();			//creates new player (computer player)
				break;
			case COMPUTER_V_COMPUTER:
				p1 = new ComputerPlayer();			//creates new player (computer player)
				p2 = new ComputerPlayer();			//creates new player (computer player)
				break;
			case HUMAN_V_HUMAN:
				p1 = new HumanPlayer();			//creates new player (computer player)
				p2 = new ComputerPlayer();			//creates new player (computer player)
				break;
		}*/
		/* //FOR MEINZEN -----------------------------------------------------------------------
		int mode = 0;
		if ( mode == 1 ) {
			p1 = new ComputerPlayer();			//creates new player (computer player)
			p2 = new ComputerPlayer();			//creates new player (computer player)
		} else if ( ... ) {
			p1 = new HumanPlayer();			//creates new player (computer player)
			p2 = new ComputerPlayer();			//creates new player (computer player)
		}
		-----------------------------------------------------------------------------------------
		*/
		//testing:
		Player p1 = new ComputerPlayer();
		Player p2 = new ComputerPlayer();

		Game game = new Game();
		game.play(p1,p2);



	}
}