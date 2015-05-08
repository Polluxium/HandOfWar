import java.util.Random;

public class TestDisplay
{
	Random rand;

	public TestDisplay()
	{
		rand = new Random();
	}

	public int getCard()
	{
		return rand.nextInt(51)+1;
	}

}