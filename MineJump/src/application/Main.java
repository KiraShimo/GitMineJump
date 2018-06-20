package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Hauptmenü laden
			FXMLLoader root = new FXMLLoader(getClass().getResource("/Main.fxml"));
			Pane pane = root.load();

			//Initialisierung des MainControllers
			MainController mainController = root.getController();
			mainController.setMain(this);
			mainController.setPrimaryStage(primaryStage);

			//Initialisierung Scene und Stage
			Scene mainmenu = new Scene(pane);
			//mainmenu.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setTitle("MineJump");
			primaryStage.setWidth(854);
			primaryStage.setHeight(480);
			//primaryStage.setMinWidth(800);
			//primaryStage.setMinHeight(600);
			primaryStage.setResizable(false);
			primaryStage.setScene(mainmenu);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Zufallswiedergabe muss noch eingefügt werden
		
		//Musik initialisieren
		Media media = new Media(getClass().getResource("/music/07_Boo.mp3").toExternalForm());
		MediaPlayer musicplayer = new MediaPlayer(media);
        musicplayer.setAutoPlay(true);
        musicplayer.setVolume(0.1);   // from 0 to 1      

        //Musik loopen
        musicplayer.setOnEndOfMedia(new Runnable() {    
        	public void run() {
        		musicplayer.seek(Duration.ZERO); 
        	}
         });  
	}

	public static void main(String[] args) {
		launch(args);
	}
}
