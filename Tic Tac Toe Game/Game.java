import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Game extends JFrame implements ActionListener{
	Random r = new Random(); // determine whose turn it is randomly.
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textlabel = new JLabel();
	JButton[] button = new JButton[9];
	boolean player1;
	
	Game()
	{
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(" GAME DEVELOPED BY DEEPAK KABRA ");
	    this.getContentPane().setBackground(new Color(50,50,50));
        this.setLayout(new BorderLayout());		
		this.setVisible(true);
		
		textlabel.setBackground(new Color(25,25,25));
		textlabel.setForeground(new Color(25,255,0));
		textlabel.setFont(new Font("Ink Free",Font.BOLD,75));
		textlabel.setHorizontalAlignment(JLabel.CENTER);
        textlabel.setText("TIC TAC TOE");
		textlabel.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0; i<9; i++)
		{
			button[i] = new JButton();
			button_panel.add(button[i]);
			button[i].setFont(new Font("Ink Free",Font.ITALIC,120));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		title_panel.add(textlabel);
		this.add(title_panel,BorderLayout.NORTH); //title panel sticks to top of frame
	    this.add(button_panel); //add this after adding panel always
	    firstTurn();
	}
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0; i<9; i++)
		{
			if(e.getSource()==button[i])
			{
				if(player1) //if it's player1 turn
				{
					if(button[i].getText()=="") // if the specific button has no text
				    {
						button[i].setForeground(Color.red);
						button[i].setText(" X ");
						player1 = false;
						textlabel.setText("0 Turn"); //CHANGE THE TURN 
					    checkWin();
					}
				}
				else{
					if(button[i].getText()=="")
					{
						button[i].setText("0");
						button[i].setForeground(Color.blue);
						player1 = true;
						textlabel.setText("X Turn"); // CHANGE THE TURN
					    checkWin();
					}
				}
			}
		}
	}
	public void firstTurn()// Method to determine whose turn is first(X OR Y)
    {
		try{
		Thread.sleep(2000);
		}		//show turn after 2 seconds
		catch(Exception f)
		{
			f.printStackTrace();
		}
		if(r.nextInt(2)==0) //Randomly decide whose turn to start game.
		{
			player1 = true;
			textlabel.setText("X Turn");
		}
		else
		{
			player1 = false;
			textlabel.setText("0 Turn");
		}
	}
	public void checkWin() //check winning combinations all types possible.(V.V.I part)
    {
		if((button[0].getText()=="X") && (button[1].getText()=="X") && (button[2].getText()=="X"))
		{
			xWins(0,1,2); //winning combinations are 0 1 and 2 buttons for X.
		}
        
        if((button[3].getText()=="X") && (button[4].getText()=="X") && (button[5].getText()=="X"))
		{
			xWins(3,4,5); //winning combinations are 3 4 and 5 buttons for X.
		}
        
        if((button[6].getText()=="X") && (button[7].getText()=="X") && (button[8].getText()=="X"))
		{
			xWins(6,7,8); //winning combinations are 6 7 and 8 buttons for X.
		}

        if((button[0].getText()=="X") && (button[3].getText()=="X") && (button[6].getText()=="X"))
		{
			xWins(0,3,6); //winning combinations are 0 3 and 6 buttons for X.
		}

        if((button[1].getText()=="X") && (button[4].getText()=="X") && (button[7].getText()=="X"))
		{
			xWins(1,4,7); //winning combinations are 1 4 and 7 buttons for X.
		}	

        if((button[2].getText()=="X") && (button[5].getText()=="X") && (button[8].getText()=="X"))
		{
			xWins(2,5,8); //winning combinations are 2 5 and 8 buttons for X.
		}

        if((button[0].getText()=="X") && (button[4].getText()=="X") && (button[8].getText()=="X"))
		{
			xWins(0,4,8); //winning combinations are 0 4 and 8 buttons for X.
		}	

        if((button[2].getText()=="X") && (button[4].getText()=="X") && (button[6].getText()=="X"))
		{
			xWins(2,4,6); //winning combinations are 2 4 and 6 buttons for X.
		}	
		
        //WINNING COMBINATIONS FOR 0
        if((button[0].getText()=="0") && (button[1].getText()=="0") && (button[2].getText()=="0"))
		{
			yWins(0,1,2); //winning combinations are 0 1 and 2 buttons for X.
		}
        
        if((button[3].getText()=="0") && (button[4].getText()=="0") && (button[5].getText()=="0"))
		{
			yWins(3,4,5); //winning combinations are 3 4 and 5 buttons for X.
		}
        
        if((button[6].getText()=="0") && (button[7].getText()=="0") && (button[8].getText()=="0"))
		{
			yWins(6,7,8); //winning combinations are 6 7 and 8 buttons for X.
		}

        if((button[0].getText()=="0") && (button[3].getText()=="0") && (button[6].getText()=="0"))
		{
			yWins(0,3,6); //winning combinations are 0 3 and 6 buttons for X.
		}

        if((button[1].getText()=="0") && (button[4].getText()=="0") && (button[7].getText()=="0"))
		{
			yWins(1,4,7); //winning combinations are 1 4 and 7 buttons for X.
		}	

        if((button[2].getText()=="0") && (button[5].getText()=="0") && (button[8].getText()=="0"))
		{
			yWins(2,5,8); //winning combinations are 2 5 and 8 buttons for X.
		}

        if((button[0].getText()=="0") && (button[4].getText()=="0") && (button[8].getText()=="0"))
		{
			yWins(0,4,8); //winning combinations are 0 4 and 8 buttons for X.
		}	

        if((button[2].getText()=="0") && (button[4].getText()=="0") && (button[6].getText()=="0"))
		{
			yWins(2,4,6); //winning combinations are 2 4 and 6 buttons for X.
		}		
	}
	public void xWins(int a, int b, int c) // if X wins by pressing which buttons(a,b,c)
    {
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);
		
		for(int i=0; i<9; i++) //disable all buttons after winning.
		{
			button[i].setEnabled(false);
		}
		textlabel.setText("X WINS");
	}
	public void yWins(int x, int y, int z)// if Y wins by pressing which buttons(a,b,c)
	{button[x].setBackground(Color.green);
		button[y].setBackground(Color.green);
		button[z].setBackground(Color.green);
		
		for(int i=0; i<9; i++) //disable all buttons after winning.
		{
			button[i].setEnabled(false);
		}
		textlabel.setText("0 WINS");
	}
}