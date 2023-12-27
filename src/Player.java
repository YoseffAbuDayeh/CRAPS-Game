
public class Player
{

	private String name;
	private int bankBalance;
	private boolean isShooter;
	private int betAmount;
	private boolean passCompleted;
	//constructor
	public Player(String name)
	{
		/*
		 * Name:				Player	
		 * Purpose:			initialize items needed for later
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		this.name = name;
		this.bankBalance = 100;
		this.isShooter = false;
		this.betAmount = 0;
		this.passCompleted = false;
		
		
	}
	
	
	//getters
	public String getName()
	{
		/*
		 * Name:				getName
		 * Purpose:			get the name of the player
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		return name;
	}
	
	public int getBankBalance()
	{
		/*
		 * Name:				getBankBalance
		 * Purpose:			return the money the player currently has
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		return bankBalance;
	}
	
	public boolean getIsShooter()
	{
		/*
		 * Name:				getIsShooter
		 * Purpose:			return whether the current player is the shooter
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		return isShooter;
	}
	
	public int getAmountBet()
	{
		/*
		 * Name:				getAmountBet
		 * Purpose:			return the amount that the user bet
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		return betAmount;
	}
	
	public boolean getPassCompleted()
	{
		/*
		 * Name:				getPassCompleted
		 * Purpose:			returns whether the pass has been completed
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		return passCompleted;
	}
	
	
	//setters
	public void setBankBalance(int newBalance)
	{
		/*
		 * Name:				setBankBalance
		 * Purpose:			changes the current bank balance with a new balance
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		this.bankBalance = newBalance;
	}
	
	public void setPassCompleted(boolean value)
	{
		/*
		 * Name:				setPassCompleted
		 * Purpose:			changes the value that tells the user whether the pass has been completed
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		this.passCompleted = value;
	}
	
	public void setIsShooter(boolean value)
	{
		/*
		 * Name:				setIsShooter
		 * Purpose:			changes the players value of IsShooter
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		this.isShooter = value;
	}
	public void setAmountBet(int betAmount)
	{
		/*
		 * Name:				setAmountBet
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		this.betAmount = betAmount;
	}
	
	
	
	
	
	
	
	
}
