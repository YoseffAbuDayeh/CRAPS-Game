import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class getPlayers extends JFrame implements ActionListener
{
	
	private JPanel TextP, CountP, ButtonP, NextP;
	private JLabel MainText;
	private JTextField Amount;
	private JButton More, Less, Submit;
	private JMenuBar MB = new JMenuBar();
	private JMenu Menu;
	private JMenuItem MI1, MI2;
	public getPlayers()
	{ 
	/*
	 * Name:				getPlayers
	 * Purpose:			Makes the GUI to add players
	 * Date:				14-04-2023
	 * Author:			Ethan & Yoseff
	 */
		super("Player Count Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300,250);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(4,1,0,0));
		
		TextP = new JPanel (new FlowLayout(FlowLayout.CENTER, 10,10));
		CountP = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		ButtonP = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		NextP = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		
		MainText = new JLabel("Enter the # of players (2 min, 6 max)");
		TextP.add(MainText);
		
		Amount = new JTextField("2");
		Amount.setColumns(5);
		Amount.setEditable(false);
		CountP.add(Amount);
		
		More = new JButton("↑");
		Less = new JButton("↓");
		ButtonP.add(More);
		ButtonP.add(Less);
		
		Submit = new JButton("Submit");
		
		NextP.add(Submit);
		
		
		this.add(TextP);
		this.add(CountP);
		this.add(ButtonP);
		this.add(NextP);
		

		More.setActionCommand("More");
		Less.setActionCommand("Less");
		Submit.setActionCommand("Submit");
		More.addActionListener(this);
		Less.addActionListener(this);
		Submit.addActionListener(this);
		
		
		Menu = new JMenu("Items");
		MI1 = new JMenuItem("Rules");
		MI2 = new JMenuItem("Authors");
		Menu.add(MI1);
		Menu.add(MI2);
		MB.add(Menu);
		MI1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "(1) The shooter (randomly designated) makes a bet. The other players can bet against their bet. \r\n"
						+ "(2) The shooter rolls two dice. If the sum of the roll is:  \r\n"
						+ "\r\n"
						+ "     A) 7 or 11, they win \r\n"
						+ "\r\n"
						+ "     B) 2, 3, or 12, they lose \r\n"
						+ "\r\n"
						+ "    C) any other number (termed a \"point number\"), they keep re-rolling until:\r\n"
						+ "\r\n"
						+ "          i) they roll the point number again, without having rolled a 7. In this case, they win.\r\n"
						+ "\r\n"
						+ "          ii) they roll a 7, without having rolled the point number. In this case, they lose.");
			}
		});
		MI2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Authors: Ethan Reimer, and Yoseff Abu Dayeh");
			}
		});
		this.setJMenuBar(MB);
		this.setVisible(true);
	}//ends the GUI to make players

	@Override
	public void actionPerformed(ActionEvent e)
	 { 
		/*
		 * Name:				actionPerformed
		 * Purpose:			Detects how many players will be playing the game
		 * Date:				14-04-2023
		 * Author:			Ethan & Yoseff
		 */
		int Number = Integer.parseInt(Amount.getText()); //Players will take count of the number of players
		if (Number > 6)
		{
			Number = 6;
		}
		else if (Number < 2)
		{
			Number = 2;
		}
		if(e.getActionCommand().equals("More"))
		{
			Number++;
			if (Number > 6)
				Amount.setText("6");
			else 
				Amount.setText(String.valueOf(Number));
		}
		else if (e.getActionCommand().equals("Less"))
		{
			Number--;
			if (Number < 2)
				Amount.setText("2");
			else 
				Amount.setText(String.valueOf(Number));
		}
		else if (e.getActionCommand().equals("Submit"))
		{ //Sends the number of players to the Game file to proceed with the game
			this.setVisible(false);
			new Game(Number);
		}
		
	}	
}
// end class