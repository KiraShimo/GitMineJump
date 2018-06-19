package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {

	public void level(Stage primaryStage) {
		try {
			//Levelmenü laden und anzeigen & MainController aktualisieren
			FXMLLoader root = new FXMLLoader(getClass().getResource("ressources/Level.fxml"));
			Pane pane = root.load();
			Scene level = new Scene(pane);
			level.getStylesheets().add(getClass().getResource("ressources/application.css").toExternalForm());
			MainController mainController = root.getController();
			mainController.setPrimaryStage(primaryStage);
			primaryStage.setScene(level);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spiel(Stage primaryStage) {
		
		Spieler Steve = new Spieler();
		int X = Steve.getSpielerPosX();
		int Y = Steve.getSpielerPosY();
		
		SchleifeMenu Spiel = new SchleifeMenu();
		Spiel.spiel(primaryStage);
		
	}
}
