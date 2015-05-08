/**
 * File: Graphics.java
 * Date: 30April2015
 * Description: Graphics for the hand of war game.
 *
 */


 import javax.swing.*;
 import java.awt.*;

 public class Graphics extends JFrame
 {
	static JFrame 			f;
	static JPanel			p;

	/* These will be the content panes used by the game.				*/
	static JLabel			labStartScreenGraphics;
	static JLabel			labNameScreenGraphics;
	static JLabel			labGameScreenGraphics;
	static JLabel			labPlayerAmountGraphics;

	/* Start Screen Graphical Components.								*/

	static JButton			btnSinglePlayer;
	static JButton			btnMultiPlayer;

	/* End of Start Screen Graphical Components.						*/

	/* Name Screen Graphical Components.								*/

	static JTextField		txtEnterName;
	static JButton			btnConfirmName;

	/* End of Name Screen Graphical Components.							*/

	/* Game Screen Graphical Components.								*/

	static JButton			btnDeal;
	static JButton			btnCheck;
	static JButton			btnFold;
	static JButton			btnBet;
	static JButton			btnRestart;
	static JButton			btnQuit;

	static JLabel			labP1Name;
	static JLabel			labCardDeck;
	static JLabel			labChips;

	static JLabel			labCash;
	static JLabel			labBetAmount;

	static JLabel			labEnemyCardHolderOne;
	static JLabel			labEnemyCardHolderTwo;

	static JLabel			labEnemyBetAmountOne;
	static JLabel			labEnemyBetAmountTwo;
	static JLabel			labEnemyBetAmountThr;
	static JLabel			labEnemyTotalChipsOne;
	static JLabel			labEnemyTotalChipsTwo;
	static JLabel			labEnemyTotalChipsThr;
	/* End of Game Screen Graphical Components.							*/

	/* Start of Player Amount Screen Graphical Components.				*/

	static JButton			btnConfirmPlayerAmount;
	static JTextField		txtPlayerAmount;

	/* End of Player Amount Scren Grpahical Components.					*/

	static JLabel[]	opposCards 	= new JLabel[6];

	static JLabel[] centerCards = new JLabel[5];

	static JLabel[] yourCards 	= new JLabel[2];

	/* End of Game Screen Graphical components.							*/

	public Graphics()
	{
		try{
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e){
			System.out.println("Something bad happened!! Call a javactor!!");
		}
		f = new JFrame("Texas Holdem Poker");

		p = new JPanel();
		p.setLayout(null);

		setWindowLogo();
		makeStartScreenGraphics();
		makeNameScreenGraphics();
		makeGameScreenGraphics();
		makePlayerAmountScreenGraphics();

		f.setContentPane(labStartScreenGraphics);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(616,616);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	/**
	 * This sets the window logo.
	 */
	public void setWindowLogo()
	{
		ImageIcon logo = new ImageIcon("Graphics/ApplicationLogo.png");
		f.setIconImage(logo.getImage());
	}

	/**
	 * The makeStartScreenGraphics() method makes the graphics for the
	 * start screen.
	 *
	 * It will add two buttons for single player and multiplayer and a
	 * label to hold the background image.
	 *
	 *
	 */
	public void makeStartScreenGraphics()
	{
		labStartScreenGraphics = new JLabel();
		labStartScreenGraphics.setBounds(0,0,600,600);
		labStartScreenGraphics.setIcon(new ImageIcon("Graphics/StartScreenGraphics.png"));

		btnSinglePlayer = new JButton("Single Player");
		btnSinglePlayer.setBounds(237,278,125,25);
		btnSinglePlayer.addActionListener(new Listener());
		labStartScreenGraphics.add(btnSinglePlayer);

		btnMultiPlayer = new JButton("Multiplayer");
		btnMultiPlayer.setBounds(237,313,125,25);
		btnMultiPlayer.addActionListener(new Listener());
		labStartScreenGraphics.add(btnMultiPlayer);
	}	// makeStartScreenGraphic()


	/**
	 * The makeNameScreenGraphics() method creates the graphics for the
	 * screen where the user enters their preferred nickname.
	 *
	 * It will add one label to hold the background image.  It will add
	 * one text field for the user to enter their name in.  It will also
	 * have one button to confirm the name they typed in (your basic OK
	 * button).
	 */
	public void makeNameScreenGraphics()
	{
		labNameScreenGraphics = new JLabel();
		labNameScreenGraphics.setBounds(0,0,600,600);
		labNameScreenGraphics.setIcon(new ImageIcon("Graphics/NameScreenGraphics.png"));

		txtEnterName = new JTextField(20);
		txtEnterName.setBounds(237,288,125,25);
		labNameScreenGraphics.add(txtEnterName);

		btnConfirmName = new JButton("Ok");
		btnConfirmName.setBounds(237,323,125,25);
		btnConfirmName.addActionListener(new Listener());
		labNameScreenGraphics.add(btnConfirmName);
	}	// makeNameScreenGraphics()


	/**
	 * The makeGameScreenGraphics() method will create all of the graphics
	 * for the game screen.
	 */
	public void makeGameScreenGraphics()
	{
		/* This will create a label for the background image. 			*/
		labGameScreenGraphics = new JLabel();
		labGameScreenGraphics.setBounds(0,0,900,700);
		labGameScreenGraphics.setIcon(new ImageIcon("Graphics/GameScreenGraphics.png"));

		/* Start of creating buttons.									*/
		btnDeal = new JButton("Deal");
		btnDeal.setBounds(150,475,125,25);
		btnDeal.addActionListener(new Listener());
		labGameScreenGraphics.add(btnDeal);

		btnCheck = new JButton("Check");
		btnCheck.setBounds(150,510,125,25);
		btnCheck.addActionListener(new Listener());
		labGameScreenGraphics.add(btnCheck);

		btnFold = new JButton("Fold");
		btnFold.setBounds(150,545,125,25);
		btnFold.addActionListener(new Listener());
		labGameScreenGraphics.add(btnFold);

		btnBet = new JButton("Bet");
		btnBet.setBounds(625,475,125,25);
		btnBet.addActionListener(new Listener());
		labGameScreenGraphics.add(btnBet);

		btnRestart = new JButton("Restart");
		btnRestart.setBounds(625,510,125,25);
		btnRestart.addActionListener(new Listener());
		labGameScreenGraphics.add(btnRestart);

		btnQuit = new JButton("Quit Game");
		btnQuit.setBounds(625,545,125,25);
		btnQuit.addActionListener(new Listener());
		labGameScreenGraphics.add(btnQuit);

		/* End of creating buttons.										*/

		int x = 253; // variable for top left x position will be updated.
		for (int i = 0; i < 5; i++)
		{
			centerCards[i] = new JLabel();
			centerCards[i].setBounds(x,293,73,97);
			centerCards[i].setIcon(new ImageIcon("res/CardBack.png"));
			labGameScreenGraphics.add(centerCards[i]);

			/* Update x variable.  Add 83 to it to seperate each card 	*/
			/* by 10 points.											*/
			x += 83;
		}

		/* Start of creating your information bar.						*/

		labP1Name = new JLabel();
		labP1Name.setHorizontalAlignment(SwingConstants.CENTER);
		labP1Name.setBounds(387,590,126,25);
		labGameScreenGraphics.add(labP1Name);
		labP1Name.setForeground(Color.white);
		labP1Name.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		labCash = new JLabel("Chips: 999999");
		labCash.setBounds(560,590,200,25);
		labCash.setHorizontalAlignment(SwingConstants.CENTER);
		labGameScreenGraphics.add(labCash);
		labCash.setForeground(Color.green);
		labCash.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		labBetAmount = new JLabel("Bet Amount: 0 Chips");
		labBetAmount.setBounds(160,590,200,25);
		labBetAmount.setHorizontalAlignment(SwingConstants.CENTER);
		labGameScreenGraphics.add(labBetAmount);
		labBetAmount.setForeground(Color.green);
		labBetAmount.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		/* End of creating your information bar.						*/

		/* Create your cards.											*/

		yourCards[0] = new JLabel();
		yourCards[0].setBounds(340,463,73,97);
		yourCards[0].setIcon(new ImageIcon("res/CardBack.png"));
		labGameScreenGraphics.add(yourCards[0]);

		yourCards[1] = new JLabel();
		yourCards[1].setBounds(487,463,73,97);
		yourCards[1].setIcon(new ImageIcon("res/CardBack.png"));
		labGameScreenGraphics.add(yourCards[1]);

		/* End of creating your cards.									*/

		/* Instantiate your opponents cards here.						*/
		for(int i = 0; i < opposCards.length; i++)
		{
			opposCards[i] = new JLabel();
		}

		/* Set the opponent cards positions.							*/
		opposCards[0].setBounds(58,118,73,97);
		opposCards[1].setBounds(205,118,73,97);
		opposCards[2].setBounds(341,118,73,97);
		opposCards[3].setBounds(487,118,73,97);
		opposCards[4].setBounds(628,118,73,97);
		opposCards[5].setBounds(773,118,73,97);

		/* For the first two and last two cards, set their icon, set them
		 * to invisible,(these are the multiplayer components) and then
		 * add them to the graphics.
		 */
		for(int i = 0; i < 2; i++)
		{
			opposCards[i].setIcon(new ImageIcon("res/CardBack.png"));
			opposCards[i].setVisible(false);
			labGameScreenGraphics.add(opposCards[i]);
		}

		/* These two labels will always be showing so never set them 	*/
		/* to be not visible.											*/
		opposCards[2].setIcon(new ImageIcon("res/CardBack.png"));
		opposCards[2].setVisible(true);
		labGameScreenGraphics.add(opposCards[2]);

		opposCards[3].setIcon(new ImageIcon("res/CardBack.png"));
		opposCards[3].setVisible(true);
		labGameScreenGraphics.add(opposCards[3]);

		/* Set up the last two cards.									*/
		for(int i = 4; i < opposCards.length; i++)
		{
			opposCards[i].setIcon(new ImageIcon("res/CardBack.png"));
			opposCards[i].setVisible(false);
			labGameScreenGraphics.add(opposCards[i]);
		}

		/* Set up the enemy cards graphics.								*/
		labEnemyCardHolderOne = new JLabel();
		labEnemyCardHolderOne.setBounds(31,103,275,124);
		labEnemyCardHolderOne.setIcon(new ImageIcon("Graphics/EnemyCardHolder.png"));
		labEnemyCardHolderOne.setVisible(false);
		labGameScreenGraphics.add(labEnemyCardHolderOne);

		labEnemyCardHolderTwo = new JLabel();
		labEnemyCardHolderTwo.setBounds(600,103,275,124);
		labEnemyCardHolderTwo.setIcon(new ImageIcon("Graphics/EnemyCardHolder.png"));
		labEnemyCardHolderTwo.setVisible(false);
		labGameScreenGraphics.add(labEnemyCardHolderTwo);

		labEnemyBetAmountOne = new JLabel("Bet Amount: 0 Chips");
		labEnemyBetAmountOne.setBounds(31,50,254,25);
		labEnemyBetAmountOne.setVisible(false);
		// Set font, type font name, font type, and font size.
		labEnemyBetAmountOne.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labEnemyBetAmountOne.setHorizontalAlignment(SwingConstants.CENTER);
		labEnemyBetAmountOne.setForeground(Color.white);
		labGameScreenGraphics.add(labEnemyBetAmountOne);

		labEnemyBetAmountTwo = new JLabel("Bet Amount: 0 Chips");
		labEnemyBetAmountTwo.setBounds(314,50,254,25);
		labEnemyBetAmountTwo.setVisible(true);
		labEnemyBetAmountTwo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labEnemyBetAmountTwo.setHorizontalAlignment(SwingConstants.CENTER);
		labEnemyBetAmountTwo.setForeground(Color.white);
		labGameScreenGraphics.add(labEnemyBetAmountTwo);

		labEnemyBetAmountThr = new JLabel("Bet Amount: 0 Chips");
		labEnemyBetAmountThr.setBounds(600,50,254,25);
		labEnemyBetAmountThr.setVisible(false);
		labEnemyBetAmountThr.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labEnemyBetAmountThr.setHorizontalAlignment(SwingConstants.CENTER);
		labEnemyBetAmountThr.setForeground(Color.white);
		labGameScreenGraphics.add(labEnemyBetAmountThr);

		labEnemyTotalChipsOne = new JLabel("Total Chips: 0 Chips");
		labEnemyTotalChipsOne.setBounds(31,75,254,25);
		labEnemyTotalChipsOne.setVisible(false);
		labEnemyTotalChipsOne.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labEnemyTotalChipsOne.setHorizontalAlignment(SwingConstants.CENTER);
		labEnemyTotalChipsOne.setForeground(Color.white);
		labGameScreenGraphics.add(labEnemyTotalChipsOne);

		labEnemyTotalChipsTwo  = new JLabel("Total Chips: 0 Chips");
		labEnemyTotalChipsTwo.setBounds(314,75,254,25);
		labEnemyTotalChipsTwo.setVisible(true);
		labEnemyTotalChipsTwo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labEnemyTotalChipsTwo.setHorizontalAlignment(SwingConstants.CENTER);
		labEnemyTotalChipsTwo.setForeground(Color.white);
		labGameScreenGraphics.add(labEnemyTotalChipsTwo);

		labEnemyTotalChipsThr  = new JLabel("Total Chips: 0 Chips");
		labEnemyTotalChipsThr.setBounds(600,75,254,25);
		labEnemyTotalChipsThr.setVisible(false);
		labEnemyTotalChipsThr.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labEnemyTotalChipsThr.setHorizontalAlignment(SwingConstants.CENTER);
		labEnemyTotalChipsThr.setForeground(Color.white);
		labGameScreenGraphics.add(labEnemyTotalChipsThr);
	}

	public void makePlayerAmountScreenGraphics()
	{
		labPlayerAmountGraphics = new JLabel();
		labPlayerAmountGraphics.setBounds(0,0,600,600);
		labPlayerAmountGraphics.setIcon(new ImageIcon("Graphics/EnterPlayerAmountScreenGraphics.png"));

		txtPlayerAmount = new JTextField(20);
		txtPlayerAmount.setBounds(237,288,125,25);
		labPlayerAmountGraphics.add(txtPlayerAmount);

		btnConfirmPlayerAmount = new JButton("Ok");
		btnConfirmPlayerAmount.setBounds(237,323,125,25);
		btnConfirmPlayerAmount.addActionListener(new Listener());
		labPlayerAmountGraphics.add(btnConfirmPlayerAmount);
	}
 }