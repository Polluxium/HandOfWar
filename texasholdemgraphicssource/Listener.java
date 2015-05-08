import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Listener implements ActionListener
{
	/* The playerAmount will tell the listener how many other players 	*/
	/* to make visible.													*/
	int playerAmount = 0;

	/* The checkManager will keep track of how many cards in the middle */
	/* have been set to be visible.										*/
	int checkManager = 0;

	/* The betAmount will be used to show you how much you have placed 	*/
	/* for a bet.														*/
	int betAmount = 0;

	/* The cashAmount will just show you how much cash you have.		*/
	int cashAmount = 0;

	TestDisplay td = new TestDisplay();

	/**
	 * The actionPerformed() method is automatically called when a user
	 * clicks on an object in the window.
	 */
	public void actionPerformed(ActionEvent e)
	{
		/* If the button clicked is the single player button, then 		*/
		/* display the window that will allow the player to enter their */
		/* name.														*/
		if (e.getSource() == Graphics.btnSinglePlayer)
		{
			Graphics.f.setContentPane(Graphics.labNameScreenGraphics);
		}

		/* If the button pressed is the confirm name button (the button */
		/* on the "Enter Name" screen that says OK), then resize the 	*/
		/* window, and make sure it is centered on the screen.  Then, 	*/
		/* display the game screen graphics.  Set text in the player 	*/
		/* name holder to display the name the user typed in.			*/
		if (e.getSource() == Graphics.btnConfirmName)
		{
			Graphics.f.setSize(916,716);
			Graphics.f.setLocationRelativeTo(null);
			Graphics.f.setContentPane(Graphics.labGameScreenGraphics);
			Graphics.labP1Name.setText(Graphics.txtEnterName.getText());
		}

		/* If the source is the restart button, then set the size of 	*/
		/* the window to 616 by 616, and then make sure it is in the 	*/
		/* middle of the screen. Then, show the start screen window.	*/
		/* Call the resetGame method.									*/
		if (e.getSource() == Graphics.btnRestart)
		{
			Graphics.f.setSize(616,616);
			Graphics.f.setLocationRelativeTo(null);
			Graphics.f.setContentPane(Graphics.labStartScreenGraphics);
			resetGame();
		}

		/* If the source is the quit button, just exit the whole game.	*/
		if (e.getSource() == Graphics.btnQuit)
		{
			System.exit(0);
		}

		/* If the source was the check button, call the checkCards() 	*/
		/* method.														*/
		if (e.getSource() == Graphics.btnCheck)
		{
			checkCards();
		}

		/* If the source was the deal button call the dealCards() method */
		if (e.getSource() == Graphics.btnDeal)
		{
			dealCards();
			Graphics.btnDeal.setEnabled(false);
		}

		/* If the button pressed was the bet button, then display an 	*/
		/* input dialog box.  Store the input typed in the variable 	*/
		/* betAmount by converting it to an integer.					*/
		/* Set the text of the label that displays the bet amount to 	*/
		/* show the amount you just typed in.							*/
		if (e.getSource() == Graphics.btnBet)
		{
			try{
				betAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter an amount: "));
				Graphics.labBetAmount.setText("Bet Amount: "+betAmount+" chips");
			} catch (NumberFormatException err){
				JOptionPane.showMessageDialog(null, "You must enter a number between 0 and the amount of chips you have");
			}
		}

		/* If the source was the multiplayer button on the start scren, */
		/* then display the window where the user can enter how many 	*/
		/* players they want to play with.								*/
		if (e.getSource() == Graphics.btnMultiPlayer)
		{
			Graphics.f.setContentPane(Graphics.labPlayerAmountGraphics);
		}

		/* If the source is the confirm player amount button in the 	*/
		/* screen that lets you enter the amount of players you want to */
		/* play with, then try to convert the text in the field on that */
		/* window to an integer.  If you cant, then just tell the user 	*/
		/* to enter a number.  Then, call the setUpPlayers method while */
		/* passing it the variable playerAmount, which is equal to the 	*/
		/* amount of players the user requested.						*/
		if (e.getSource() == Graphics.btnConfirmPlayerAmount)
		{
			try{
				playerAmount = Integer.parseInt(Graphics.txtPlayerAmount.getText());
				setUpPlayers(playerAmount);
			} catch (NumberFormatException err){
				JOptionPane.showMessageDialog(null, "Please enter a number");
			}
		}
	}	// actionPerformed()


	/**
	 * The setUpPlayers() method will set up the multiplayer window by
	 * testing how many players you have.
	 */
	public void setUpPlayers(int pa)
	{
		/* The only value ever passed to this method will be the amount */
		/* of players the user wants to use, so this will test that 	*/
		/* value.														*/
		switch(pa){

			/* If the user wants three players, then show the first 	*/
			/* enemy card holder and then show the card  backs, just to */
			/* simulate that there is another player there.				*/
			/* Show the window where the user can enter their name.		*/
			/* Exit the switch statement.								*/
			case 3:
				Graphics.opposCards[0].setVisible(true);
				Graphics.opposCards[1].setVisible(true);

				Graphics.labEnemyCardHolderOne.setVisible(true);

				Graphics.labEnemyTotalChipsOne.setVisible(true);
				Graphics.labEnemyBetAmountOne.setVisible(true);

				Graphics.f.setContentPane(Graphics.labNameScreenGraphics);
				break;

			/* If the user wants four players, show the first and last  */
			/* enemy card holders by making them visible.  Show the 	*/
			/* card backs positioned on the enemy card holders.			*/
			/* Show the window that lets the user enter their name.		*/
			/* Also, set the label displaying the third and fourth 		*/
			/* players bet amounts from invisible to visible.			*/
			/* Exit the switch statement.								*/
			case 4:
				Graphics.opposCards[0].setVisible(true);
				Graphics.opposCards[1].setVisible(true);
				Graphics.opposCards[4].setVisible(true);
				Graphics.opposCards[5].setVisible(true);

				Graphics.labEnemyBetAmountOne.setVisible(true);
				Graphics.labEnemyBetAmountThr.setVisible(true);

				Graphics.labEnemyCardHolderOne.setVisible(true);
				Graphics.labEnemyCardHolderTwo.setVisible(true);

				Graphics.labEnemyTotalChipsOne.setVisible(true);
				Graphics.labEnemyTotalChipsThr.setVisible(true);

				Graphics.f.setContentPane(Graphics.labNameScreenGraphics);
				break;

			/* If the user does not enter one of the options above, 	*/
			/* then display a message telling the user that they must 	*/
			/* enter an amount of users between 3 and 4.				*/
			default:
				JOptionPane.showMessageDialog(null, "Please enter an amount of players between 3 and 4");
		}	// end of switch statement
	}	// setUpPlayers()


	/**
	 * The dealCards() method will for now, just display the cards you
	 * were given by the card application.
	 */
	public void dealCards()
	{
		for(int i = 0; i < Graphics.yourCards.length; i++)
		{
			Graphics.yourCards[i].setIcon(new ImageIcon("res/51.gif"));
		}
	}	// dealCards();


	/**
	 * The checkCards() method will display the first three cards int the
	 * middle the first time you click the Check button.  The second time,
	 * it will display the second to last card.  The third time, it will
	 * display the last card.
	 */
	public void checkCards()
	{
		/* If checkManager is equal to 0, then use a for loop to loop 	*/
		/* through the first three cards and show their face images 	*/
		/* while adding one to the value of checkManager each time.		*/
		/*																*/
		/* If checkManager is equal to 3, then set the show the second 	*/
		/* to last card's face image and add one to the value of 		*/
		/* checkManager.
		/*																*/
		/* If checkManager is equal to four, then show the last cards 	*/
		/* face image.													*/
		if (checkManager == 0)
		{
			for(int i = 0; i < Graphics.centerCards.length - 2; i++)
			{
				checkManager++;
				Graphics.centerCards[i].setIcon(new ImageIcon("res/"+td.getCard()+".gif"));
			}
		} else if (checkManager == 3){
			Graphics.centerCards[3].setIcon(new ImageIcon("res/"+td.getCard()+".gif"));
			checkManager++;
		} else if (checkManager == 4){
			Graphics.centerCards[4].setIcon(new ImageIcon("res/"+td.getCard()+".gif"));
			Graphics.btnCheck.setEnabled(false);
			Graphics.btnBet.setEnabled(false);
			checkManager = 0;
		}

	}	// checkCards()


	/**
	 * The resetGame() method will reset the whole game.
	 */
	public void resetGame()
	{
		/* Set the center cards images to the card back.				*/
		for(int i = 0; i < Graphics.centerCards.length; i++)
		{
			Graphics.centerCards[i].setIcon(new ImageIcon("res/CardBack.png"));
		}

		/* Set the icons of both of your cards to nothing the back image*/
		Graphics.yourCards[0].setIcon(new ImageIcon("res/CardBack.png"));
		Graphics.yourCards[1].setIcon(new ImageIcon("res/CardBack.png"));

		/* Enable the buttons so the user can click on them next game.	*/
		Graphics.btnCheck.setEnabled(true);
		Graphics.btnDeal.setEnabled(true);
		Graphics.btnBet.setEnabled(true);

		/* Set the bet amount label to display that the bet amount is 	*/
		/* zero.														*/
		Graphics.labBetAmount.setText("Bet Amount: 0 chips");

		/* Set the betAmount variable to 0.								*/
		betAmount = 0;

		/* Set the multiplayer components from visible to invisible.	*/
		Graphics.opposCards[0].setVisible(false);
		Graphics.opposCards[1].setVisible(false);
		Graphics.opposCards[4].setVisible(false);
		Graphics.opposCards[5].setVisible(false);
		Graphics.labEnemyCardHolderOne.setVisible(false);
		Graphics.labEnemyCardHolderTwo.setVisible(false);
		Graphics.labEnemyBetAmountOne.setVisible(false);
		Graphics.labEnemyBetAmountThr.setVisible(false);
		Graphics.labEnemyTotalChipsOne.setVisible(false);
		Graphics.labEnemyTotalChipsThr.setVisible(false);

	}	// resetGame()
}	// end of class