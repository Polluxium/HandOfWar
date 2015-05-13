import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Listener implements ActionListener
{
	/* The playerAmount will tell the listener how many other players 	*/
	/* to make visible.													*/
	int playerAmount = 0;

	/* The checkManager will keep track of how many times you have 		*/
	/* clicked the check button.										*/
	int checkManager = 0;

	/* The betAmount will be used to show you how much you have placed 	*/
	/* for a bet.														*/
	int betAmount = 0;

	/* The cashAmount will just show you how much cash you have.		*/
	int cashAmount = 0;

	/* This will keep count of how many rounds have been played.		*/
	int roundCounter = 1;

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
			Graphics.yourCards[i].setIcon(new ImageIcon("res/"+td.getCard()+".gif"));
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
		/* Test the checkManager variable.								*/
		switch(checkManager){
			/* If checkManager's value is at 0, then just display the	*/
			/* first three cards in the center cards array.  			*/
			/* Update checkmanager by adding 1 to it.					*/
			/* Call the qBetOrNot() method to see if the user wants to 	*/
			/* bet or not.												*/
			/* Exit the switch statemtnt.								*/
			case 0:
				for(int i = 0; i < Graphics.centerCards.length - 2; i++)
				{
					Graphics.centerCards[i].setIcon(new ImageIcon("res/"+td.getCard()+".gif"));
				}
				Graphics.btnDeal.setEnabled(false);
				checkManager++;
				qBetOrNot();
				break;

			/* If checkManager's value is 1 (which would mean that you  */
			/* have clicked on the check button before), then display 	*/
			/* the next card in the center cards array, which will be 	*/
			/* the fourth card.											*/
			/* Update checkManager by adding 1 to it.					*/
			/* Call the qBetOrNot() method to see if the user wants to 	*/
			/* bet or not.												*/
			/* exit the switch statement.								*/
			case 1:
				Graphics.centerCards[3].setIcon(new ImageIcon("res/"+td.getCard()+".gif"));
				checkManager++;
				qBetOrNot();
				break;

			/* Disregard the last paragraph in this block of comments 	*/
			/* for now.													*/
			/*															*/
			/* If checkManager's value is 2 (which would mean that you 	*/
			/* have clicked on it twice before), then display the last 	*/
			/* center card.												*/
			/* 															*/
			/* Display a dialog box with the winner in it.				*/
			/*															*/
			/* Disable the bet button and the check button.				*/
			/* 															*/
			/* If you have played four three rounds, then ask the user 	*/
			/* if they want to play again.  If they dont, then just		*/
			/* go back to the start screen.  If they do, then reset the */
			/* Main Game Screen by calling the resetMainGameScreen() 	*/
			/* method.  Set checkManager to 0, and roundCounter to 0.	*/
			case 2:
				Graphics.centerCards[4].setIcon(new ImageIcon("res/"+td.getCard()+".gif"));

				// Simulate revealing the other players cards here.
				for(int i = 0; i < Graphics.opposCards.length; i++)
				{
					Graphics.opposCards[i].setIcon(null);
					Graphics.opposCards[i].setIcon(new ImageIcon("res/"+td.getCard()+".gif"));
				}


				// Just simulate displaying who won here.
				JOptionPane.showMessageDialog(null, "Display who won here.");


				// Reset game settings.
				resetMainGameScreen();
				checkManager = 0;
				roundCounter = 1;
				Graphics.btnBet.setEnabled(false);
				Graphics.btnCheck.setEnabled(false);
				roundCounter++;

				if(roundCounter == 4){


					// Disregard this commented out code.
					/*
					int n = JOptionPane.showConfirmDialog(null,
														"Would you like to play again?",
														"Texas Holdem",
														JOptionPane.YES_NO_OPTION);

					if(n == JOptionPane.YES_OPTION)
					{
						resetMainGameScreen();
						checkManager = 0;
						roundCounter = 1;
					}
					if(n == JOptionPane.NO_OPTION)
					{
						resetGame();
						Graphics.f.setContentPane(Graphics.labStartScreenGraphics);
						Graphics.f.setSize(616,616);
						Graphics.f.setLocationRelativeTo(null);
						checkManager = 0;
						roundCounter = 1;
					}
					*/
				} else {

					/* If you have not played atleast three rounds then */
					/* just call the resetMainGameScreen() method and 	*/
					/* set checkManager to 0.							*/
					resetMainGameScreen();
					checkManager = 0;
				}	// Outer if statement.
				break;
			/* If there is an error, just display an error message.		*/
			default:
				JOptionPane.showMessageDialog(null, "Error, Listener(Switch statement)");
		}
	}	// checkCards()


	/**
	 * The qBetOrNot() method will let the user say if they want to bet.
	 */
	public void qBetOrNot()
	{
		// ask the user if they want to bet
		int n = JOptionPane.showConfirmDialog(null,
								"Would you like to bet?",
								"Texas Holdem",
								JOptionPane.YES_NO_OPTION);

		/* Check to see if they pressed yes.							*/
		if (n == JOptionPane.YES_OPTION)
		{
			/* If they did press yes, then store what they type in for	*/
			/* amound in a string and then try to convert that to an 	*/
			/* integer.													*/
			String strBetAmount = JOptionPane.showInputDialog("How Much?");
			try{
				betAmount = Integer.parseInt(strBetAmount);
				// g.setBetAmount(betAmount);
			} catch (NumberFormatException err){
				JOptionPane.showMessageDialog(null, "Please enter a number");
				qBetOrNot();
			}

		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please, press check or fold.");
			// g.skipBet();
		}
	}


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

		/* Reset the player amount and name field.						*/
		Graphics.txtPlayerAmount.setText("");
		Graphics.txtEnterName.setText("");
	}	// resetGame()


	/**
	 * The resetMainGameScreen() method will reset the settings of the
	 * main game screen.  Like, setting the cards back to being face
	 * down.  And re-enabling the buttons that were disabled.
	 */
	public void resetMainGameScreen()
	{
		/* Enable the buttons.											*/
		Graphics.btnCheck.setEnabled(true);
		Graphics.btnDeal.setEnabled(true);
		Graphics.btnBet.setEnabled(true);

		/* Display the back image for your cards.						*/
		Graphics.yourCards[0].setIcon(new ImageIcon("res/CardBack.png"));
		Graphics.yourCards[1].setIcon(new ImageIcon("res/CardBack.png"));

		/* Display the back image for the other players cards.			*/
		for(int i = 0; i < Graphics.opposCards.length; i++)
		{
			Graphics.opposCards[i].setIcon(null);
			Graphics.opposCards[i].setIcon(new ImageIcon("res/CardBack.png"));
		}

		/* Reset the center cards so they are displaying the back image */
		for(int i = 0; i < Graphics.centerCards.length; i++)
		{
			Graphics.centerCards[i].setIcon(new ImageIcon("res/CardBack.png"));
		}
	}	// resetMainGameScreen()
}	// end of class