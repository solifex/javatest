package guessthenumber;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * JavaFX simple text input ui
 * 
 * @author Andersson
 */
public class FxDemo extends Application {
	
	
	
	/**
    * Start demonstration of JavaFX text capabilities.
    * 
    * @param stage Stage for JavaFX application.
    * @throws Exception Exception in JavaFX application.
    */
   @Override
   public void start(final Stage primaryStage) throws Exception
   {
	   primaryStage.setTitle("FxDemo");
	   
	   BorderPane componentLayout = new BorderPane();	componentLayout.setPadding(new Insets(20,0,20,20));
	   
	   Scene appScene = new Scene(componentLayout,500,500);
       primaryStage.setScene(appScene);
       primaryStage.show();
	   
   }

   /**
    * Main JavaFX application launching method.
    * 
    * @param arguments Command-line arguments: none expected.
    */
   public static void main(final String[] arguments)
   {
      Application.launch(arguments);
   }
}