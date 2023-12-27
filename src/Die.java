import java.util.Random;

public class Die
{
	private int rollValue;
	//constructor
	public Die()
	{
		/*
		 * Name:				Die
		 * Purpose:			Instantiate a die for the player to use
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		this.rollValue = 0;
	}
	//getter
	public int getRollValue()
	{
		/*
		 * Name:				getRollValue
		 * Purpose:			returns the random number from the die
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		return rollValue;
	}
	//method
	public int rollDie()
	{
		/*
		 * Name:				rollDie
		 * Purpose:			returns the value that the die rolled
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		Random dieRoll = new Random();
		
		rollValue = dieRoll.nextInt((6) + 1);
		
		return rollValue;
	}	
}