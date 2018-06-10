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
			ProgrammStartKlasse Spiel = new ProgrammStartKlasse();
			Scene game = new Scene(Spiel.getRootPane());
			
 			primaryStage.setScene(game);
 			primaryStage.show();
			Spieler Steve = new Spieler();
			
			//run();
			//run funktioniert irgendwie noch nicht ... wenn kein Kommentar -> Absturz
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
