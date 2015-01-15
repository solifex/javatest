package guessthenumber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class GuessTheNumber implements ActionListener {
	
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
  
  JButton randomButton = new JButton();
  randomButton.setText("random Number");
  randomButton.setSize(200, 28);
              
  JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(3);
     frame.setVisible(true);
     frame.setSize(500, 500);
     frame.setLocation(500, 0);
     frame.setResizable(false);
     frame.add(inputTextField);
     frame.add(outputJTextArea);     
  
 
             
 }

private static void appendToTextArea()
{
	int number = randomNumber(100);
	outputJTextArea.append("random number " + number);

}


public void actionPerformed(ActionEvent evt) {
    String text = inputTextField.getText();
    outputJTextArea.append(text + "\n");
    inputTextField.selectAll();

    
    outputJTextArea.setCaretPosition(outputJTextArea.getDocument().getLength());
}
 
 public static int randomNumber(int x) {
	 	Random rand = new Random();
	 	int numberToGuess = rand.nextInt(x);
	  
	 	System.out.print(numberToGuess);
	 	return numberToGuess;
	 	
}
 
 
 public static void main(String[] args) {
  
 new GuessTheNumber();
 
 appendToTextArea();

 
 }


 
 

}