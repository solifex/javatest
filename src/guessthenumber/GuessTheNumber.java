package guessthenumber;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner; 

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
 
 
public class GuessTheNumber implements ActionListener {
	
	    Scanner Scanner = new Scanner(System.in);
	    
        public static int number;
        public int inputNumber;
        public String inputString;
        public static JTextField inputTextField;
        public static JTextArea outputJTextArea;
 
public GuessTheNumber(){
  inputTextField  = new JTextField();
  inputTextField.setSize(500, 25);
  inputTextField.setText("");
  inputTextField.setLocation(0, 450);
  inputTextField.addActionListener(this);    
     
  outputJTextArea = new JTextArea();
  outputJTextArea.setSize(500, 475);
  outputJTextArea.setRows(20);
  outputJTextArea.setEditable(false);
              
  JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(3);
     frame.setVisible(true);
     frame.setSize(500, 500);
     frame.setLocation(500, 0);
     frame.setResizable(false);
     frame.add(inputTextField);
     frame.add(outputJTextArea);    
	 
 }
 
public static void appendToTextArea()
{
        number = randomNumber(100);
        outputJTextArea.append("random number " + number + "\n");
 
}
 
 
public void actionPerformed(ActionEvent evt) {
    inputString = inputTextField.getText();

	checkNumber();
//	inputNumber = Scanner.nextInt();
	
//	while(number!=inputNumber){
//		if(number>inputNumber){
//			outputJTextArea.append("you guessed to low try again");
//		}
//		else if (number<inputNumber) {
//			outputJTextArea.append("you guessed to high try again");
//		}
//		else{outputJTextArea.append("you guessed correct. The right number was " + number);
//     	}	
//	}            
}

private void checkNumber() {
	try {
		Integer.parseInt(inputString);
	}
	catch (NumberFormatException e) {
		outputJTextArea.append("Only number are valid entries" + "\n");
		inputTextField.setText("Enter a number");
		inputTextField.selectAll();
	}
	
	inputNumber = Integer.parseInt(inputString);
	
	guessThis();
	
}
 
private void guessThis() {

	if (inputNumber > number) {
		outputJTextArea.append("Guessed high" + "\n");
	}
	else if (inputNumber < number) {
		outputJTextArea.append("Guessed low" + "\n");
	}
	else {
		outputJTextArea.append("You have guessed right" + "\n");
	}
	
	
}
private static int randomNumber(int x) {
                Random rand = new Random();
                int numberToGuess = rand.nextInt(x);
         
                System.out.print(numberToGuess);
                return numberToGuess;
}
 
 
 public static void main(String[] args) {

     javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
        	 new GuessTheNumber();
        	 
        	 appendToTextArea();
        	 
        	 inputTextField.requestFocusInWindow();
         }
     });
	 
     
     
      
 } 
}