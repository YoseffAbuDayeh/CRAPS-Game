import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Game
{
	private static int totalPotAmount;
	private ArrayList<Player> playerList = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	private int playersDone = 0;
	
	
	//constructor
	public Game(int amountOfPlayers)
	{
		/*
		 * Name:				Game
		 * Purpose:			Constructor which initializes stuff
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		totalPotAmount = 0;
		populatePlayerList(amountOfPlayers);
				
	}
	 
	
	//getters
	public int getTotalPotAmount()
	{
		/*
		 * Name:				getTotalPotAmount
		 * Purpose:			getter for the Pot Amount
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		return totalPotAmount;
	}
	
	public ArrayList<Player> getPlayerList()
	{
		/*
		 * Name:				getPlayerList
		 * Purpose:			getter for the playerList
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		return playerList;
	}
	
	
	//methods
	public void populatePlayerList(int AmountOfPlayers)
	{
		/*
		 * Name:				populatePlayerList
		 * Purpose:			Populate the playerList
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		
		for(int i = 0; i< AmountOfPlayers; i++)
		{
			//Makes a new JPanel for each single player.
			JPanel top, medium, bottom;
			JLabel Text;
			JTextField input;
			JButton Submit;
			JFrame player = new JFrame("Name Getter");
			player.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			player.setSize(200,150);
			player.setLocationRelativeTo(null);
			player.setLayout(new GridLayout(3,1,0,0));
			
			
			top = new JPanel(new FlowLayout(FlowLayout.CENTER, 0,0));
			medium = new JPanel(new FlowLayout(FlowLayout.CENTER,0, 0));
			bottom = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
			
			Text = new JLabel("Enter the name of player " + (i+1));
			top.add(Text);
			
			input = new JTextField("");
			input.setColumns(10);
			medium.add(input);
			
			Submit = new JButton("Submit");
			bottom.add(Submit);
			
			player.add(top);
			player.add(medium);
			player.add(bottom);
			
			
			player.setVisible(true);
			//Ends name getter JFrame
			Submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evnt)
				{
					if (input.getText().equals("") || input.getText().equals(" "))
					{
						JOptionPane.showMessageDialog(null, "Please input a name for the user");
					} //If they don't input anything then it tells the user to input a name
					else
					{
						playerList.add(new Player(input.getText()));
						player.setVisible(false);
						if (++playersDone == AmountOfPlayers)
						{
							new CRAPSJFrame(playerList);
						} //Creates a new person object from the name inputted in the text space
					}
				}
			});
			
		}
		totalPotAmount = AmountOfPlayers*100;
		//Sets the totalPotAmount
	}
	
	public static int checkForGameWinner(ArrayList<Player> p)
	{ 
		/*
		 * Name:				checkForGameWinner
		 * Purpose:			This method will check for the winner of the game if there is one
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		int playersWithoutCash = 0;
		int guy = 0;
		for(int i = 0; i<p.size();i++)
		{
			Player currPlayer = p.get(i);
			if (currPlayer.getIsShooter())
				guy = i; // Learns whos the shooter
			if (currPlayer.getBankBalance() == 0)
				playersWithoutCash++; // Counts how many players have no money
			if (currPlayer.getBankBalance() >= totalPotAmount)
				return i; // If any player has reached the required amount returns him
		}
		if (playersWithoutCash == p.size() - 1)
			return guy; // If the guy stole everyone else's lunch money then it wins
		return -1;
	}	
	
	
}
