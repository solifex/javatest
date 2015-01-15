package guessthenumber;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sun.security.krb5.internal.PAData;
import javafx.application.Application;
import javafx.beans.property.SetProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
	
	static TextArea outputTextArea;
	static TextField inputTextField;
	static Button sendButton;
	
   @Override
   public void start(final Stage gameStage) throws Exception
   {
	   gameStage.setTitle("FxDemo");
	   
	   
	   outputTextArea = new TextArea();
	   inputTextField = new TextField();
	   sendButton = new Button();
	   
	   outputTextArea.setEditable(false);
	   outputTextArea.setFocusTraversable(false);
	   
	   inputTextField.isFocused();
	   inputTextField.setOnKeyPressed(new EventHandler<Event>() {

		@Override
		public void handle(Event event) {
			
			String text = inputTextField.getText();
			showText(text);
			
		}
	});
	   
	   BorderPane bpane = new BorderPane();
	   bpane.setPadding(new Insets(15,15,15,15));

	   bpane.setCenter(outputTextArea);
	   bpane.setBottom(inputTextField);
	   //bpane.setBottom(sendButton);
	   
	   Scene gameScene = new Scene(bpane,500,500);
	  
	   
       gameStage.setScene(gameScene);
       gameStage.show();
	   
   }
   
   public static void showText(String text) {
	   outputTextArea.appendText(text + "\n");
   }

 
   
   /**
    * Main JavaFX application launching method.
    * 
    * @param arguments Command-line arguments: none expected.
    */
   public static void main(final String[] arguments)
   {
      Application.launch(arguments);
      
      showText("This is some test text");
   }


}