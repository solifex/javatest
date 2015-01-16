package guessthenumber;



import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/**
 * JavaFX simple text input ui
 * 
 * @author Solifex
 */
public class FxDemo extends Application {
/**
 * Will rewrite complete ui	
 */
	
	static Label titleLabel;
	static TextArea outputTextArea;
	static TextField inputTextField;
	static Button sendButton;
	static Button restartButton;
	
	static String textContent;
	static String textLast;
	static int textNumber;
	static int genNumber;
	
	static Label triesLabel;
	static int tries;
	
	public final static String lb = "\n";
	
   @Override
   public void start(final Stage gameStage) throws Exception
   {
	   Group root = new Group();
	   gameStage.setTitle("FxDemo");
	   Scene gameScene = new Scene(root);
	  
	   titleLabel = new Label("Guess the Number");
	   titleLabel.setFont(Font.font(null, FontWeight.BOLD, 22));
	   triesLabel = new Label("Fails" + lb + tries);
	   triesLabel.setFont(Font.font(null, FontWeight.BOLD, 16));
	   triesLabel.setTextAlignment(TextAlignment.CENTER);
	   outputTextArea = new TextArea("Guess a number between 1-10" + lb);
	   inputTextField = new TextField();
	   sendButton = new Button();
	   restartButton = new Button();
	   
	   restartButton.setText("Reset Game");
	   restartButton.setMaxWidth(800);
	   restartButton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent reset) {
			outputTextArea.clear();
			outputTextArea.setText("GAME RESET" + lb);
			outputTextArea.appendText("Guess a number between 1-10" + lb);

			genNumber = randomNumber(10 + 1);
			
			tries = 0;
			triesLabel.setText("Fails" + lb + tries);
			
			inputTextField.setDisable(false);
			sendButton.setDisable(false);
			
			clearInput();
			
		}
	});
	   
	   sendButton.setText("Send");
	   sendButton.setMaxWidth(100);
	   sendButton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent sendinput) {
			String text = inputTextField.getText();
			showText(text);
			inputTextField.requestFocus();
		}
	});
	   
	   outputTextArea.setEditable(false);
	   outputTextArea.setFocusTraversable(false);
	   outputTextArea.setOnKeyPressed(new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent switchfocus) {
			inputTextField.requestFocus();
			
		}
	});
	   
	   inputTextField.isFocused();
	   inputTextField.setOnKeyReleased(new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent key) {
			String text = inputTextField.getText();
	
			 if(key.getCode().toString() == "ENTER") {
				 showText(text);
			 } else if(key.getCode().toString() == "RETURN") {
				 showText(text);
			 } else {
				 return;
			 }
		}
	});
	   GridPane grid = new GridPane();
	   grid.setPadding(new Insets(15, 15, 15, 15));
	   grid.setAlignment(Pos.CENTER);
	   grid.setHgap(15);
	   grid.setVgap(15);
	
	   grid.add(titleLabel, 0, 0);
	   grid.setColumnSpan(titleLabel, 2);
	   grid.setHalignment(titleLabel, HPos.CENTER);
	   grid.add(outputTextArea, 0, 1);
	   grid.add(triesLabel, 1, 1);
	   grid.setHalignment(triesLabel, HPos.CENTER);
	   grid.add(inputTextField, 0, 2);
	   grid.getColumnConstraints().add(new ColumnConstraints(250));	// ToDo correct later
	   grid.getColumnConstraints().add(new ColumnConstraints(100));
	   grid.add(sendButton, 1, 2);
	   grid.setHalignment(sendButton, HPos.RIGHT);
	   grid.add(restartButton, 0, 3);
	   grid.setColumnSpan(restartButton, 2);
	   grid.setHalignment(restartButton, HPos.CENTER);
	   
	   root.getChildren().addAll(grid);
	   
       gameStage.setScene(gameScene);
       gameStage.setResizable(false);
       gameStage.show();
       
       
      
	   
   }
   
   public static void showText(String text) {
	   textContent = text;
	   
	   if (genNumber == 0) {
		   genNumber = randomNumber(10 + 1);
	   }
	   
	   if (inputTextField.getText() != null && !inputTextField.getText().isEmpty()) {
		   checkNumber();
		   
	   } else {
		   return;
	   }
	   
   }
   
/**
 * Random Number Generator
 */
   public static int randomNumber(int x) {
       Random rand = new Random();
       int numberToGuess = rand.nextInt(x);
       return numberToGuess;
   }
 
/**
 * Checks and casts string to integer 
 */
   public static void checkNumber() {
		try {
			Integer.parseInt(textContent);
		}
		catch (NumberFormatException e) {

			outputTextArea.appendText("Only numbers are valid entries" + lb);
			clearInput();
		}
		textNumber = Integer.parseInt(textContent);
		guessThis();
		
	}
	 
/**
 * Compares integers
 */
	private static void guessThis() {
		if (textNumber > genNumber) {
			outputTextArea.appendText(textContent + " is HIGH" + lb);
			clearInput();
			tries = tries + 1;
			triesLabel.setText("Fails" + lb + tries);
		}
		else if (textNumber < genNumber) {
			outputTextArea.appendText(textContent + " is LOW" + lb);
			clearInput();
			tries = tries + 1;
			triesLabel.setText("Fails" + lb + tries);
		}
		else {
			outputTextArea.appendText("You have guessed right" + lb);
			outputTextArea.appendText("The number was: " + genNumber + lb);
			clearInput();
			inputTextField.setDisable(true);
			sendButton.setDisable(true);
		}
	}
	
/**
 * Lazyman clear input
 */
	public final static void clearInput() {
		inputTextField.clear();
		inputTextField.requestFocus();
	}
	
   /**
    * Main JavaFX application launching method.
    * 
    * @param arguments Command-line arguments: none expected.
    */
   public static void main(final String[] arguments)
   {
	  
      Application.launch();
      
     
   }


}