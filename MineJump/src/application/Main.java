package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader; 

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("Main.fxml"));
			AnchorPane pane = root.load();
			primaryStage.setTitle("MineJump");
			
			MainController mainController = root.getController();
			mainController.setMain(this);
			
			Scene mainmenu = new Scene(pane);
			mainmenu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setScene(mainmenu); 
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
