import java.awt.*;

import javax.swing.*;

public class run{
	//Panel saves buttons, and other stuff
	static JFrame frame;
	JPanel panel = new JPanel();

	static //create objects of buttons and x and o
	Buttons button[] = new Buttons[9];
	

	static //true = x, false = o
	boolean value = true;
	
	//if pop up window values
	static int replaying;

	public static void main(String args[]) {
		//to run the game
		new run();
		
	}

	//constructor	
	public run() {

		// creating the dimensions of the frame
		
		frame = new JFrame("Tic Tac Toe");
		
		frame.setSize(400,400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		//creating the dimensions of the panel
		panel.setLayout(new GridLayout(3,3));

		//creating the buttons and adding it to the panel
		for( int i = 0; i < 9; i++) {
			button[i] = new Buttons();
			panel.add(button[i]);
		}

		//adding the panel to the frame
		frame.add(panel);
		
		
		frame.setLocationRelativeTo(null);

		//always do this at the end
		frame.setVisible(true);

	}
	//getters and setters for value
	public static boolean getValue() {
		return value;
	}

	public static void setValue(boolean val) {
		value = val;
	}
	
	//DRAW, when all buttons are full with no winners
	public static boolean draw()  {
		
		for( int i = 0; i < 9; i++) {
			if(button[i].play) {
				return false;
			}
		}
		
		return true;
		
	}
	

	//pop up window that shows the winner and gives replay or close options
	public static void popUpwindow(int winner) {
		
		String winnerStatement = "";
		if(winner == 1 || winner == 2) {
			winnerStatement = "Player " + Integer.toString(winner) + " wins!!\nDo you want to replay?";
		}
		else {
			winnerStatement = "It is a draw!!\nDo you want to replay?";
		}
		//0 - yes, 1 - no
		replaying = JOptionPane.showConfirmDialog(null, winnerStatement, "THE END", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		
		//if yes, then replay. if no, then close the game.
		if(replaying == 0) {
			replay();
		}
		else {
			frame.setVisible(false);
		}
		
	}
	
	//function to replay the game once game is over
	private static void replay() {
		// TODO Auto-generated method stub
		new run();
	}

	//looking for patterns to win
	public static void threeMatch() {
		/*
		 * 0 1 2
		 * 3 4 5
		 * 6 7 8
		 */
		//in row 1, 2, 3 
	
		if(button[0].turn != 0 && button[0].turn == button[1].turn && button[1].turn == button[2].turn) {
			
			popUpwindow(button[0].turn);
			
		}
		else if(button[3].turn != 0 && button[3].turn == button[4].turn && button[4].turn == button[5].turn) {

			popUpwindow(button[3].turn);
			
		}
		else if(button[6].turn != 0 && button[6].turn == button[7].turn && button[7].turn == button[8].turn) {
		
			popUpwindow(button[6].turn);
		}
		
		
		
		//in column 1, 2, 3
		else if(button[0].turn != 0 && button[0].turn == button[3].turn && button[3].turn == button[6].turn) {
			
			popUpwindow(button[0].turn);
		}
		else if(button[1].turn != 0 && button[1].turn == button[4].turn && button[4].turn == button[7].turn) {
			
			popUpwindow(button[1].turn);
		}
		else if(button[2].turn != 0 && button[2].turn == button[5].turn && button[5].turn == button[8].turn) {
			
			popUpwindow(button[2].turn);
		}
		
		//two diagonals 
		else if(button[0].turn != 0 && button[0].turn == button[4].turn && button[4].turn == button[8].turn) {
			
			popUpwindow(button[0].turn);
		}
		else if(button[2].turn != 0 && button[2].turn == button[4].turn && button[4].turn == button[6].turn) {
			
			popUpwindow(button[2].turn);
		}
		else if(draw()) {
			
			popUpwindow(0);
			
		}
		
		
	}
}
