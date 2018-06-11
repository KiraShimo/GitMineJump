package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu{
	public void level(Stage primaryStage) {
		
		
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("ressources/Level.fxml"));
			Pane pane = root.load();
			Scene level = new Scene(pane);
			
 			primaryStage.setScene(level);
 			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void spiel(Stage primaryStage) {
		try {
			
			Spieler Test = new Spieler();
			int X = Test.getSpielerposX();
			int Y = Test.getSpielerposY();
			
			ProgrammStartKlasse Spiel = new ProgrammStartKlasse( X, Y);
			Scene game = new Scene(Spiel.getRootPane());
			
			game.getStylesheets().add(getClass().getResource("ressources/application.css").toExternalForm());
			
 			primaryStage.setScene(game);
 			primaryStage.show();
			Spieler Steve = new Spieler();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
