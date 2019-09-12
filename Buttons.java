import java.awt.event.*;


import javax.swing.*;

public class Buttons extends JButton implements ActionListener{

	//imageicon creates images and holds the dimensions of the image
	ImageIcon X,O;
	int turn = 0; //2 == 'O' 1 == X

	 //to press a button only once
	public boolean play = true;

	//constructor
	public Buttons() {
		//initiate Image icon
		//get images by going to class's direcotry and getting the resource named x and o
		X = new ImageIcon(this.getClass().getResource("images/x.png"));
		O = new ImageIcon(this.getClass().getResource("images/o.png"));

		//add actionlistener to the button
		addActionListener(this);
		setIcon(null);
	}

	//if button is clicked, this function is called
	@Override
	public void actionPerformed(ActionEvent e) {

		if(play) {

			boolean value = run.getValue();

			//sets icon on the button to x or o
			if(value) {
				turn = 1;
				setIcon(X);
			}
			else {
				turn = 2;
				setIcon(O);
			}
			
			
			//swtiches between x and o
			value = !value;

			run.setValue(value);

			play = false;
			
			//run.replay();
			run.threeMatch();
		}
		
	}
	
}
