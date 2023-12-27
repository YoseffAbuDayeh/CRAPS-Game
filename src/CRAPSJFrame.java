
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;





@SuppressWarnings("serial")
public class CRAPSJFrame extends JFrame implements ActionListener
{
	private JPanel UserPanel, PlayerNames, PlayerBalances, numberPanel, betsPanel, sidePanel, PlayerBets;
	private JTextArea p1, p2, p3, p4, p5, p6, m1, m2, m3, m4, m5, m6;
	private JLabel num4, num5, num6, num8, num9, num10;
	private JTextField on4, on5, on6, on8, on9, on10, placeBets, eventText;
	private JButton betOnPass, rollDice;
	private boolean firstTurn=true, On4=false, On5=false, On6=false, On8=false, On9=false, On10=false, isOn=false, allBetsPlaced = false;
	private boolean onArray[] = {On4, On5, On6, On8, On9, On10, isOn};
	private int Winner;
	
	
	private JTextArea p1bet, p2bet, p3bet, p4bet, p5bet, p6bet;
	
	private int lastBeterNum;	//to hold the last better's array element
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ArrayList<Player> playerArray = new ArrayList();

	
	
	private ArrayList<Player> players = new ArrayList<>();
	public CRAPSJFrame(ArrayList<Player>playerList)
	{
		/*
		 * Name:				CRAPSJFrame
		 * Purpose:			This is what the players see and interact with
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		super("craps table");
		players = playerList;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1,2));
		
		playerArray = playerList;
		
		
//setting up panels
		UserPanel = new JPanel(new GridLayout(1,3));
		PlayerNames = new JPanel(new GridLayout(playerList.size(),1));
		PlayerBalances = new JPanel(new GridLayout(playerList.size(),1));
		PlayerBets = new JPanel(new GridLayout(playerList.size(),1));
		
		numberPanel = new JPanel(new GridLayout(2,6));
		sidePanel = new JPanel(new BorderLayout());
		
//end
		
		
		
//pass numbers
		num4 = new JLabel("4", SwingConstants.CENTER);
		num5 = new JLabel("5", SwingConstants.CENTER);
		num6 = new JLabel("6", SwingConstants.CENTER);
		num8 = new JLabel("8", SwingConstants.CENTER);
		num9 = new JLabel("9", SwingConstants.CENTER);
		num10 = new JLabel("10", SwingConstants.CENTER);
		
//on text
		on4 = new JTextField(SwingConstants.CENTER);
		on5 = new JTextField(SwingConstants.CENTER);
		on6 = new JTextField(SwingConstants.CENTER);
		on8 = new JTextField(SwingConstants.CENTER);
		on9 = new JTextField(SwingConstants.CENTER);
		on10 = new JTextField(SwingConstants.CENTER);
//end 
	
		
//setting up the number panel
		numberPanel.add(on4);
		numberPanel.add(on5);
		numberPanel.add(on6);
		numberPanel.add(on8);
		numberPanel.add(on9);
		numberPanel.add(on10);
		
		on4.setEditable(false);
		on5.setEditable(false);
		on6.setEditable(false);
		on8.setEditable(false);
		on9.setEditable(false);
		on10.setEditable(false);
		
		on4.setBackground(Color.lightGray);
		on5.setBackground(Color.lightGray);
		on6.setBackground(Color.lightGray);
		on8.setBackground(Color.lightGray);
		on9.setBackground(Color.lightGray);
		on10.setBackground(Color.lightGray);
		
		numberPanel.add(num4);
		numberPanel.add(num5);
		numberPanel.add(num6);
		numberPanel.add(num8);
		numberPanel.add(num9);
		numberPanel.add(num10);
//end
		
		
//setting up userPanel
		p1 = new JTextArea();
		p2 = new JTextArea();
		p3 = new JTextArea();
		p4 = new JTextArea();
		p5 = new JTextArea();
		p6 = new JTextArea();
		
		m1 = new JTextArea();
		m2 = new JTextArea();
		m3 = new JTextArea();
		m4 = new JTextArea();
		m5 = new JTextArea();
		m6 = new JTextArea();
	
		p1bet = new JTextArea();
		p2bet = new JTextArea();
		p3bet = new JTextArea();
		p4bet = new JTextArea();
		p5bet = new JTextArea();
		p6bet = new JTextArea();
	
		
		//making the text not editable
		p1.setEditable(false);
		p2.setEditable(false);
		p3.setEditable(false);
		p4.setEditable(false);
		p5.setEditable(false);
		p6.setEditable(false);
		
		m1.setEditable(false);
		m2.setEditable(false);
		m3.setEditable(false);
		m4.setEditable(false);
		m5.setEditable(false);
		m6.setEditable(false);
		
		p1bet.setEditable(false);
		p2bet.setEditable(false);
		p3bet.setEditable(false);
		p4bet.setEditable(false);
		p5bet.setEditable(false);
		p6bet.setEditable(false);
		
//this will set the userPanel to the right amount of users based on the size of the playerList
		setPlayerPanel(playerList);
		
		UserPanel.add(PlayerNames);
		UserPanel.add(PlayerBalances);
		UserPanel.add(PlayerBets);
		UserPanel.setPreferredSize(new Dimension(250, 400));
//end
		
//setting up buttons		
		
		
		betsPanel = new JPanel();
		placeBets = new JTextField();
		eventText = new JTextField();
		
		betsPanel.setLayout(new GridLayout(1,3));
		
		betOnPass = new JButton("place bet");
		rollDice = new JButton("roll the dice");
		
		betOnPass.addActionListener(this);
		rollDice.addActionListener(this);
		
		
		
		betsPanel.add(rollDice);
		betsPanel.add(betOnPass);
		betsPanel.add(placeBets);
		
		sidePanel.add(numberPanel, BorderLayout.NORTH);
		sidePanel.add(eventText, BorderLayout.CENTER);
		sidePanel.add(betsPanel, BorderLayout.SOUTH);
		
		
		betsPanel.setPreferredSize(new Dimension(400, 100));
		numberPanel.setPreferredSize(new Dimension(400, 200));
		
//use a switch to input into text fields
		this.add(sidePanel);
		this.add(UserPanel);
		startGameShooter(playerList);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{	
		/*
		 * Name:				main
		 * Purpose:			Launches the game
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		new getPlayers();
	}			
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		/*
		 * Name:				actionPerformed
		 * Purpose:			This is a method that will listen to the buttons that were pressed in the game
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		if(e.getActionCommand().equals("place bet"))
		{
			allPassesCompleted(playerArray);
			
			
			if(placeBets.getText().equals(""))
			{
				eventText.setText("no bet input. please try again. legal bets are 0, 10, 20,...");
				return;
			}
			int bet = Integer.parseInt(placeBets.getText());
			
			if(bet % 10 != 0)
			{
				eventText.setText("this is a illegal bet, legal bets are multiples of 10");
				return;
			}
			else
			{
				//setting bets and changing who's betting
				
				setNextBeter(playerArray,bet);
				eventText.setText("bet placed, " + playerArray.get(lastBeterNum).getName() + " place you bet!");
			}

		}
		
		else if(e.getActionCommand().equals("roll the dice"))
		{
			if(allBetsPlaced == true)
			{
				Die die1 = new Die();
				Die die2 = new Die();
			
				die1.rollDie();
				die2.rollDie();
			
				int sum = die1.getRollValue() + die2.getRollValue();
				while(sum < 2)
				{
					die1.rollDie();
					die2.rollDie();
				
					sum = die1.getRollValue() + die2.getRollValue();
				}
			
			
				if((sum== 7 || sum == 11) && firstTurn == true)
				{
				eventText.setText(sum + " was rolled, table wins");
				//double bets and increase balances
				//ask for new bets
				StonksPlayers();
				allBetsPlaced = false;
				for(int i = 0; i < players.size(); i++)
					players.get(i).setPassCompleted(false);
				}
				else if((sum == 2 || sum == 3 ||sum == 12) && firstTurn == true )
				{
				
					eventText.setText(sum + " was rolled, house wins");
					//bets are all set to 0
					//new shooter is chosen
					StonksPlayer();
					allBetsPlaced = false;
					for(int i = 0; i < players.size(); i++)
						players.get(i).setPassCompleted(false);
				
				}
				else if((sum != 2 || sum != 3 || sum!=12) && firstTurn == true)
				{
					eventText.setText(sum + " was rolled, " + sum + " is now ON");
					setOn(sum);
					firstTurn = false;
				
				}
			
				else if(firstTurn == false)
				{
			
					boolean passWon = getOn(sum);
				
					if(passWon == true)
					{
						eventText.setText(sum + " was rolled, table wins");
						//bets are doubled and returned
						StonksPlayers();
						allBetsPlaced = false;
						for(int i = 0; i < players.size(); i++)
							players.get(i).setPassCompleted(false);
						resetOn();
						firstTurn = true;
					}
					else if(sum != 7)
					{
						eventText.setText(sum + " was rolled, roll again");
					}
					else
					{
						eventText.setText(sum + " was rolled, house wins.");
						StonksPlayer();
						allBetsPlaced = false;
						for(int i = 0; i < players.size(); i++)
							players.get(i).setPassCompleted(false);
				
						resetOn();
						firstTurn = true;
					}
				
				
				}
			

				Winner = Game.checkForGameWinner(players);
				if (Winner != -1)
				{
					JOptionPane.showMessageDialog(null, "Congrats on winning " + players.get(Winner).getName());
				}
		}
		else
		{
			eventText.setText("its not time to shoot yet, wait a minute.");
		}
		}
			
	}
	
	
	
	
	
	//--------------------------------------------- additional methods------------------------------------------------------
	
	public void setNextBeter(ArrayList<Player>playerList, int bet)
	{
		/*
		 * Name:				setNextBetter
		 * Purpose:			to set the next better in line
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		
		
		if(allBetsPlaced == false)
		{
			
			//then we switch to the next better
			
			playerList.get(lastBeterNum).setPassCompleted(true);
			switch(lastBeterNum)
			{
				case(0):
				{
					if (players.get(0).getBankBalance() < bet)
					{
						lastBeterNum--;
						break;
					}
					p1bet.setBackground(Color.white);
					p2bet.setBackground(Color.lightGray);
					players.get(0).setBankBalance(players.get(0).getBankBalance() - bet);
					m1.setText(String.valueOf(players.get(0).getBankBalance()));
					p1bet.setText(String.valueOf(bet));
					players.get(0).setAmountBet(bet);
					break;
				}
				case(1):
				{
					if (players.get(1).getBankBalance() < bet)
					{
						lastBeterNum--;
						break;
					}
					if(playerList.size() >= 3)
					{
						p2bet.setBackground(Color.white);
						p3bet.setBackground(Color.lightGray);
						
					}
					else
					{
						p2bet.setBackground(Color.white);
						p1bet.setBackground(Color.lightGray);
					}	
					players.get(1).setBankBalance(players.get(1).getBankBalance() - bet);
					m2.setText(String.valueOf(players.get(1).getBankBalance()));
					p2bet.setText(String.valueOf(bet));
					players.get(1).setAmountBet(bet);
					break;
				}
				case(2):
				{
					if (players.get(2).getBankBalance() < bet)
					{
						lastBeterNum--;
						break;
					}
					if(playerList.size() >= 4)
					{
						p3bet.setBackground(Color.white);
						p4bet.setBackground(Color.lightGray);
					}
					else
					{
						p3bet.setBackground(Color.white);
						p1bet.setBackground(Color.lightGray);
					}	
					players.get(2).setBankBalance(players.get(2).getBankBalance() - bet);
					m3.setText(String.valueOf(players.get(2).getBankBalance()));
					p3bet.setText(String.valueOf(bet));
					players.get(2).setAmountBet(bet);
					break;
				}
				case(3):
				{
					if (players.get(3).getBankBalance() < bet)
					{
						lastBeterNum--;
						break;
					}
					if(playerList.size() >= 5)
					{
						p4bet.setBackground(Color.white);
						p5bet.setBackground(Color.lightGray);
					}
					else
					{
						p4bet.setBackground(Color.white);
						p1bet.setBackground(Color.lightGray);
					}
					players.get(3).setBankBalance(players.get(3).getBankBalance() - bet);
					m4.setText(String.valueOf(players.get(3).getBankBalance()));
					p4bet.setText(String.valueOf(bet));
					players.get(3).setAmountBet(bet);
					break;
				}
				case(4):
				{
					if (players.get(4).getBankBalance() < bet)
					{
						lastBeterNum--;
						break;
					}
					if(playerList.size() == 6)
					{
						p5bet.setBackground(Color.white);
						p6bet.setBackground(Color.lightGray);
					}
					else
					{
						p5bet.setBackground(Color.white);
						p1bet.setBackground(Color.lightGray);
					}	
					players.get(4).setBankBalance(players.get(4).getBankBalance() - bet);
					m5.setText(String.valueOf(players.get(4).getBankBalance()));
					p5bet.setText(String.valueOf(bet));
					players.get(4).setAmountBet(bet);
					break;
				}
				case(5):
				{
					if (players.get(5).getBankBalance() < bet)
					{
						lastBeterNum--;
						break;
					}
					p6bet.setBackground(Color.white);
					p1bet.setBackground(Color.lightGray);
					players.get(5).setBankBalance(players.get(5).getBankBalance() - bet);
					m6.setText(String.valueOf(players.get(5).getBankBalance()));
					p6bet.setText(String.valueOf(bet));
					players.get(5).setAmountBet(bet);
					break;
				}
				}
			lastBeterNum++;
			if (lastBeterNum == playerList.size())
				lastBeterNum = 0;
			}
			else
			{
				eventText.setText("all bets placed, time to shoot!");
			}
		}

	
	public void allPassesCompleted(ArrayList<Player>playerList)
	{
		/*
		 * Name:				allPassesCompleted
		 * Purpose:			 to check if all the players have placed a bet
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		for(int i = 0; i < playerList.size();i++)
		{
			if(playerList.get(i).getPassCompleted() == true)
			{
				allBetsPlaced = true;
			}
			else
			{
				allBetsPlaced = false;
				return;
			}
			
		}
	}
	
	
	public void resetPassCompleted(ArrayList<Player>playerList)
	{
		/*
		 * Name:				resetPassCompleted
		 * Purpose:			to reset passCompleted boolean for all players to false
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		for(int i = 0; i < playerList.size();i++)
		{
			playerList.get(i).setPassCompleted(false);
		}
		
		
		
	}

	public void resetOn()
	{
		/*
		 * Name:				resetOn
		 * Purpose:			to reset all possible 'on' TextFields
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
	on4.setText("");
	on5.setText("");
	on6.setText("");
	on8.setText("");
	on9.setText("");
	on10.setText("");
	}
	
	public void setOn(int sum)
	{
		/*
		 * Name:				setOn
		 * Purpose:			to set the 'on' TextField
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		if(onArray[6] == false)
		{
			if(sum != 7)
			{
				switch(sum)
				{
				case(4):
				{
					on4.setVisible(true);
					on4.setText("ON");
					onArray[6] = true;
					onArray[0] = true;
					break;
				}
				case(5):
				{
					on5.setVisible(true);
					on5.setText("ON");
					onArray[6] = true;
					onArray[1] = true;
					break;
				}
				case(6):
				{
					on6.setVisible(true);
					on6.setText("ON");
					onArray[6] = true;
					onArray[2] = true;
					break;
				}
				case(8):
				{
					on8.setVisible(true);
					on8.setText("ON");
					onArray[6] = true;
					onArray[3] = true;
					break;
				}
				case(9):
				{
					on9.setVisible(true);
					on9.setText("ON");
					onArray[6] = true;
					onArray[4] = true;
					break;
				}
				case(10):
				{
					on10.setVisible(true);
					on10.setText("ON");
					onArray[6] = true;
					onArray[5] = true;
					break;
				}
				}
			}
		}
	}
	
	public boolean getOn(int sum)
	{
		/*
		 * Name:				getOn
		 * Purpose:			to get the 'on' TextField and see if the given number is a winner or loser
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		boolean win = false;
		switch(sum)
		{
			case(4):
			{
				if(onArray[0] == true)
				{
					win = true;
					onArray[6] = false;
					onArray[0] = false;
					break;
				}
				else
					break;
			}
			case(5):
			{
				if(onArray[1] == true)
				{
					win = true;
					onArray[6] = false;
					onArray[1] = false;
					break;
				}
				else
					break;
			}
			case(6):
			{
				if(onArray[2] == true)
				{
					win = true;
					onArray[6] = false;
					onArray[2] = false;
					break;
				}
				else
					break;
			}
			case(8):
			{
				if(onArray[3] == true)
				{
					win = true;
					onArray[6] = false;
					onArray[3] = false;
					break;
				}
				else
					break;
			}
			case(9):
			{
				if(onArray[4] == true)
				{
					win = true;
					onArray[6] = false;
					onArray[4] = false;
					break;
				}
				else
					break;
			}
			case(10):
			{
				if(onArray[5] == true)
				{
					win = true;
					onArray[6] = false;
					onArray[5] = false;
					break;
				}
				else
					break;
			}
			case(7):
			{
				win = false;
				onArray[6] = false;
			}
		}
		return win;
	}
	
	public void setPlayerPanel(ArrayList<Player> playerList)
	{
		/*
		 * Name:				setPlayerPanel
		 * Purpose:			to set the player panel with the proper info
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		for(int i = 0; i < playerList.size();i++)
		{
			switch(i)
			{
				case(0):
				{	
					p1.setText(playerList.get(0).getName());
					m1.setText(String.valueOf(playerList.get(0).getBankBalance()));	
					PlayerNames.add(p1);
					PlayerBalances.add(m1);
					PlayerBets.add(p1bet);
					break;
				}
			
				case(1):
				{
					p2.setText(playerList.get(1).getName());
					m2.setText(String.valueOf(playerList.get(1).getBankBalance()));	
					PlayerNames.add(p2);
					PlayerBalances.add(m2);
					PlayerBets.add(p2bet);
					break;
				}
			
				case(2):
				{
					p3.setText(playerList.get(2).getName());
					m3.setText(String.valueOf(playerList.get(2).getBankBalance()));	
					PlayerNames.add(p3);
					PlayerBalances.add(m3);
					PlayerBets.add(p3bet);
					break;
				}
			
				case(3):
				{
					p4.setText(playerList.get(3).getName());
					m4.setText(String.valueOf(playerList.get(3).getBankBalance()));	
					PlayerNames.add(p4);
					PlayerBalances.add(m4);
					PlayerBets.add(p4bet);
					break;
				}
			
				case(4):
				{
					p5.setText(playerList.get(4).getName());
					m5.setText(String.valueOf(playerList.get(4).getBankBalance()));	
					PlayerNames.add(p5);
					PlayerBalances.add(m5);
					PlayerBets.add(p5bet);
					break;
				}
			
				case(5):
				{
					p6.setText(playerList.get(5).getName());
					m6.setText(String.valueOf(playerList.get(5).getBankBalance()));	
					PlayerNames.add(p6);
					PlayerBalances.add(m6);
					PlayerBets.add(p6bet);
					break;
				}
			}
		}
	}
	
	public void startGameShooter(ArrayList<Player> playerList)
	{
		/*
		 * Name:				startGameShooter
		 * Purpose:			to randomly select the starting shooter
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		int max = playerList.size();
		int randShooter = (int)(Math.random() * max);
		playerList.get(randShooter).setIsShooter(true);
		eventText.setText(playerList.get(randShooter).getName() + " is the shooter. place your bets!");
		switch(randShooter)
		{
			case(0):
			{
				p1.setBackground(Color.green);
				p1bet.setBackground(Color.lightGray);
				lastBeterNum = 0;
				break;
			}
			case(1):
			{
				p2.setBackground(Color.green);
				p2bet.setBackground(Color.lightGray);
				lastBeterNum = 1;
				break;
			}
			case(2):
			{
				p3.setBackground(Color.green);
				p3bet.setBackground(Color.lightGray);
				lastBeterNum = 2;
				break;
			}
			case(3):
			{
				p4.setBackground(Color.green);
				p4bet.setBackground(Color.lightGray);
				lastBeterNum = 3;
				break;
			}
			case(4):
			{
				p5.setBackground(Color.green);
				p5bet.setBackground(Color.lightGray);
				lastBeterNum = 4;
				break;
			}
			case(5):
			{
				p6.setBackground(Color.green);
				p6bet.setBackground(Color.lightGray);
				lastBeterNum = 5;
				break;
			}
		}
	}
	
		
public void changeShooter(ArrayList<Player> playerList)
{
	/*
	 * Name:				changeShooter
	 * Purpose:			to change the shooter to the next player
	 * Date:				14-04-2023
	 * Author:			Ethan & Yoseff
	 */
	for(int i = 0; i < playerList.size(); i++)
	{
		if(playerList.get(i).getIsShooter() == true)
		{
			playerList.get(i).setIsShooter(false);
			changeShooterBG(i, playerList);
			
		}
	}
	
	
}
	
public void changeShooterBG(int shooter, ArrayList<Player>playerList)
{
	/*
	 * Name:				changeShooterBG
	 * Purpose:			to change the shooter background to the next player
	 * Date:				14-04-2023
	 * Author:			Ethan & Yoseff
	 */
	
	
	switch(shooter)
	{
	case(0):
	{
		p1.setBackground(Color.white);
		playerList.get(0).setIsShooter(false);
		
		p2.setBackground(Color.green);
		p2bet.setBackground(Color.lightGray);
		playerList.get(1).setIsShooter(true);
		eventText.setText(playerList.get(1).getName() + " is the new shooter! place your bets!");
		
	}
	case(1):
	{
		p2.setBackground(Color.white);
		playerList.get(1).setIsShooter(false);
		
		if(playerList.size() >= 3)
		{
			playerList.get(2).setIsShooter(true);
			p3.setBackground(Color.green);
			p3bet.setBackground(Color.lightGray);
			eventText.setText(playerList.get(2).getName() + " is the new shooter! place your bets!");
		}
		else
		{
			playerList.get(0).setIsShooter(true);
			p1.setBackground(Color.green);
			p1bet.setBackground(Color.green);
			eventText.setText(playerList.get(0).getName() + " is the new shooter! place your bets!");
		}
	break;
	}
	case(2):
	{
		p3.setBackground(Color.white);
		playerList.get(2).setIsShooter(false);
		if(playerList.size() >= 4)
		{
			playerList.get(3).setIsShooter(true);
			p4.setBackground(Color.green);
			p4bet.setBackground(Color.lightGray);
			eventText.setText(playerList.get(3).getName() + " is the new shooter! place your bets!");
		}
		else
		{
			playerList.get(0).setIsShooter(true);
			p1.setBackground(Color.green);
			p1bet.setBackground(Color.green);
			eventText.setText(playerList.get(0).getName() + " is the new shooter! place your bets!");
		}
	break;
	}
	case(3):
	{
		p4.setBackground(Color.white);
		playerList.get(3).setIsShooter(false);
		if(playerList.size() >= 5)
		{
			playerList.get(4).setIsShooter(true);
			p5.setBackground(Color.green);
			p5bet.setBackground(Color.lightGray);
			eventText.setText(playerList.get(4).getName() + " is the new shooter! place your bets!");
		}
		else
		{
			playerList.get(0).setIsShooter(true);
			p1.setBackground(Color.green);
			p1bet.setBackground(Color.green);
			eventText.setText(playerList.get(0).getName() + " is the new shooter! place your bets!");
		}
	break;
	}
	case(4):
	{
		p5.setBackground(Color.white);
		playerList.get(4).setIsShooter(false);
		if(playerList.size() >= 6)
		{
			playerList.get(5).setIsShooter(true);
			p6.setBackground(Color.green);
			p6bet.setBackground(Color.lightGray);
			eventText.setText(playerList.get(5).getName() + " is the new shooter! place your bets!");
		}
		else
		{
			playerList.get(0).setIsShooter(true);
			p1.setBackground(Color.green);
			p1bet.setBackground(Color.green);
			eventText.setText(playerList.get(0).getName() + " is the new shooter! place your bets!");
		}
	break;
	}
	case(5):
	{
		playerList.get(5).setIsShooter(false);
		p6.setBackground(Color.white);
		p1.setBackground(Color.green);
		playerList.get(0).setIsShooter(true);
		p1bet.setBackground(Color.lightGray);
		eventText.setText(playerList.get(0).getName() + " is the new shooter! place your bets!");
	}
	}
	
	
	
}
	
public void StonksPlayer()
{
	/*
	 * Name:				StonksPlayer
	 * Purpose:			Gives the better the amount earned for winning
	 * Date:				14-04-2023
	 * Author:			Ethan & Yoseff
	 */
	int amount = 0;
	for (int i = 0; i < players.size(); i++)
	{
		if (i == 0) {
			amount += Integer.parseInt(p1bet.getText());
			p1bet.setText("0");
		}
		else if (i == 1) {
			amount += Integer.parseInt(p2bet.getText());
			p2bet.setText("0");
		}
		else if (i == 2) {
			amount += Integer.parseInt(p3bet.getText());
			p3bet.setText("0");
		}
		else if (i == 3) {
			amount += Integer.parseInt(p4bet.getText());
			p4bet.setText("0");
		}
		else if (i == 4) {
			amount += Integer.parseInt(p5bet.getText());
			p5bet.setText("0");
			}
		else if (i == 5)
		{
			amount += Integer.parseInt(p6bet.getText());
			p6bet.setText("0");
		}	
	}
	for (int i = 0; i < players.size(); i++)
	{
		players.get(i).setAmountBet(0);
		if (players.get(i).getIsShooter())
		{
			players.get(i).setBankBalance(amount + players.get(i).getBankBalance());
			STONKS(i);
		}
	}
}

public void STONKS(int i)
{
	/*
	 * Name:				STONKS
	 * Purpose:			Output the value that they have in the bank
	 * Date:				14-04-2023
	 * Author:			Ethan & Yoseff
	 */
	if (i == 0)
		m1.setText(String.valueOf(players.get(i).getBankBalance()));
	else if (i == 1)
		m2.setText(String.valueOf(players.get(i).getBankBalance()));
	else if (i == 2)
		m3.setText(String.valueOf(players.get(i).getBankBalance()));
	else if (i == 3)
		m4.setText(String.valueOf(players.get(i).getBankBalance()));
	else if (i == 4)
		m5.setText(String.valueOf(players.get(i).getBankBalance()));
	else if (i == 5)
		m6.setText(String.valueOf(players.get(i).getBankBalance()));
	
	
}

public void StonksPlayers()
{
	/*
	 * Name:				StonksPlayers	
	 * Purpose:			gives each player the amount earned by playing the game
	 * Date:				14-04-2023
	 * Author:			Ethan & Yoseff
	 */
	int amBet =0;
	int amGot = 0;
	int currAmount = 0;
	for (int i = 0; i < players.size(); i++)
	{
		if (players.get(i).getIsShooter())
			continue;
		if (i == 0) {
			amBet = Integer.parseInt(p1bet.getText());
			amGot = Integer.parseInt(m1.getText());
			currAmount = amGot + amBet + amBet;
			m1.setText(String.valueOf(currAmount));
			p1bet.setText("0");
			players.get(i).setAmountBet(0);
			players.get(i).setBankBalance(currAmount);
		}
		else if (i == 1) {
			amBet = Integer.parseInt(p2bet.getText());
			amGot = Integer.parseInt(m2.getText());
			currAmount = amGot + amBet + amBet;
			m2.setText(String.valueOf(currAmount));
			p2bet.setText("0");
			players.get(i).setAmountBet(0);
			players.get(i).setBankBalance(currAmount);
		}
		else if (i == 2) {
			amBet = Integer.parseInt(p3bet.getText());
			amGot = Integer.parseInt(m3.getText());
			currAmount = amGot + amBet + amBet;
			m3.setText(String.valueOf(currAmount));
			p3bet.setText("0");
			players.get(i).setAmountBet(0);
			players.get(i).setBankBalance(currAmount);
		}
		else if (i == 3) {
			amBet = Integer.parseInt(p4bet.getText());
			amGot = Integer.parseInt(m4.getText());
			currAmount = amGot + amBet + amBet;
			m4.setText(String.valueOf(currAmount));
			p4bet.setText("0");
			players.get(i).setAmountBet(0);
			players.get(i).setBankBalance(currAmount);
		}
		else if (i == 4) {
			amBet = Integer.parseInt(p5bet.getText());
			amGot = Integer.parseInt(m5.getText());
			currAmount = amGot + amBet + amBet;
			m5.setText(String.valueOf(currAmount));
			p5bet.setText("0");
			players.get(i).setAmountBet(0);
			players.get(i).setBankBalance(currAmount);
			}
		else if (i == 5)
		{
			amBet = Integer.parseInt(p6bet.getText());
			amGot = Integer.parseInt(m6.getText());
			currAmount = amGot + amBet + amBet;
			m6.setText(String.valueOf(currAmount));
			p6bet.setText("0");
			players.get(i).setAmountBet(0);
			players.get(i).setBankBalance(currAmount);
		}

		
	}
}
}
