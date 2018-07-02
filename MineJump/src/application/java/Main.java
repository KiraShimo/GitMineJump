package application.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
	private MediaPlayer musicplayer;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		//Zufallswiedergabe muss noch eingef�gt werden
		
		//Musik initialisieren
		Media media = new Media(getClass().getResource("/application/ressources/music/07_Boo.mp3").toExternalForm());
		musicplayer = new MediaPlayer(media);
        musicplayer.setAutoPlay(true);
        musicplayer.setVolume(0.2);   //zwischen 0 und 1 
        
        //Musik loopen 
        musicplayer.setOnEndOfMedia(new Runnable() {    
        	public void run() {
        		musicplayer.seek(Duration.ZERO); 
        	}
         });  
        
        try {
			//Hauptmen� laden
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ressources/Main.fxml"));
			Pane pane = root.load();

			//Initialisierung des MainControllers
			MainController mainController = root.getController();
			mainController.setMain(this);
			mainController.setPrimaryStage(primaryStage);
			mainController.setMediaPlayer(musicplayer);
			
			//Initialisierung Scene und Stage
			Scene mainmenu = new Scene(pane);
			primaryStage.setTitle("MineJump");
			primaryStage.setWidth(854);
			primaryStage.setHeight(480);
			primaryStage.setResizable(false);
			primaryStage.setScene(mainmenu);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	public void setvolume(double volume) {
    	System.out.println(musicplayer);
    	System.out.println(volume);
		musicplayer.setVolume(volume);
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
