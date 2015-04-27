import java.util.Collections;
import java.util.Comparator;

public class CardSorters {
	public static Comparator<Card> LOW_TO_HIGH = new Comparator<Card>() {
		@Override
		public int compare(Card o1, Card o2) {
			if (o1 == o2) 
			{
				return 0;	
			}
			
			return o1.getPlaceHolder()-o2.getPlaceHolder();
		}		
	};
	public static Comparator<Card> HIGH_TO_LOW = new Comparator<Card>() {
		@Override
		public int compare(Card o1, Card o2) {
			if (o1 == o2) 
			{
				return 0;	
			}
			
			return o2.getPlaceHolder()-o1.getPlaceHolder();
		}		
	};
	
	/*
	 * to randomize, use: Collections.shuffle(playerHand)
	 */
}
