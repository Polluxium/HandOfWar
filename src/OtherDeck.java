/**
* File:             Deck.java
* Author:           Colin Hauch
* Programming:      1st Hour
* Last Modified:    March 2015
* Description:
* Creates a deck of cards, and can also resort, shuffle,
* and take a card out of the deck to use.
*/

public class OtherDeck {

	//Declares new array of cards called myDeck
    private CardForMeinzen[] myDeck;

    //Integer than tells you the number of cardsDealt
    private int    cardsDealt;

    /**
     * Instantiates myDeck as an array of 52 cards, then puts a card
     * in each slot depending on its value (rank), being "i" in this
     * method, so that a value of 0 would be in slot 0, a value of 1
     * would be in slot 1 and etc...
     */
    public OtherDeck()
    {
		//Instantiates myDeck as an array of 52 cards
        myDeck = new CardForMeinzen[52];

        /*
         * Loops through 51 times, updating the value of i each time,
         * and setting "i" to the slot number the card is in, and the
         * value (rank) that is put into the CardForMeinzen class to
         * generate a new CardForMeinzen and its values.
         */
        for(int i = 0; i <=51; i++)
        {
            myDeck[i] = new CardForMeinzen(i);
        }
    }

    /**
     * This method shuffles the cards by taking two random slots
     * and switching the card objects that are in them.
     */
    public void shuffle()
    {
        CardForMeinzen temp;      //Declare a temporary card variable

        /*
         * Loops through 100 times to make sure the cards are throroughly
         * shuffled.
         */
        for(int loop = 0; loop < 101; loop++)
        {
            /*
             * For both slot1 and slot2, Math.random will feed back a
             * number between 0 and 0.999... and multiplies by 52. It
             * then converts that number into an int so that it will
             * round down to the nearest number. 51 being the highest.
             */
            int slot1 = (int)(Math.random() * 52);
            int slot2 = (int)(Math.random() * 52);

            /*
             * Though very unlikely, if slot2 would happen to equal
             * slot 1 in number value, keep looping through the while
             * loop until this comparison is not true.
             */
            if(slot2 == slot1)
            {
                while(slot2 == slot1)
                {
                    slot2 = (int)(Math.random() * 52);
                }
            }

            /*
             * Switches the cards from each slot
             */
            temp          = myDeck[slot1];
            myDeck[slot1] = myDeck[slot2];
            myDeck[slot2] = temp;
        }
    }

    /**
     * This method sorts the cards back into order of rank in the myDeck
     * array of cards. Rank of 0 will equal slot 0, Rank of 1 will equal
     * slot 1, etc...
     */
    public void sort()
    {
        int i = 0;              //Declare and instantiate slot variable i
        CardForMeinzen temp;    //Declare a temporary card variable

        /*
         * This loop goes through the code below 51 times to make sure
         * the cards are definitly in order
         */
        for(int loop = 0; loop < 52; loop++){

			//Assigns i back to 0 before restarting the loop
            i = 0;

            /*
             * Loops through all 52 cards comparing whether their ranks
             * (values) are greater than the card in the slot in front
             * of them, or not, and if they are greater, it switches them
             */
            for(int count = 0; count < 51; count++)
            {
                /*
                 * If slot i, has a greater value than (i + 1) then
                 * switch the two values.
                 */
                if(myDeck[i].getValue() > myDeck[i+1].getValue())
                {
                    temp                = myDeck[i];
                    myDeck[i]           = myDeck[i+1];
                    myDeck[i+1]         = temp;
                }

                //Keep going through the slots by adding to i
                i++;
            }
        }
    }

    /**
     * Will return a card to the Game class. For now it is used to return
     * the information of the card in slot 0 for testing.
     */
    public CardForMeinzen getCard()
    {
		//Return the card in slot 0. Used for testing
         return myDeck[0];
    }
}
