package application.java;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {

	// Hauptmenü laden
	public void mainmenu(Stage primaryStage) {
		
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ressources/Main.fxml"));
			Pane pane = root.load();
			Scene mainmenu = new Scene(pane);
			MainController mainController = root.getController();
			mainController.setPrimaryStage(primaryStage);
			primaryStage.setScene(mainmenu);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Levelmenü laden und anzeigen
	public void level(Stage primaryStage) {
		
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ressources/Level.fxml"));
			Pane pane = root.load();
			Scene level = new Scene(pane);
			MainController mainController = root.getController();
			mainController.setPrimaryStage(primaryStage);
			primaryStage.setScene(level);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Level geschafft laden und anzeigen
	public void win(Stage primaryStage) {
		
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ressources/Win.fxml"));
			Pane pane = root.load();
			Scene level = new Scene(pane);
			MainController mainController = root.getController();
			mainController.setPrimaryStage(primaryStage);
			primaryStage.setScene(level);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Einstellungsmenü laden und anzeigen
	public void settings(Stage primaryStage) {
		
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ressources/Settings.fxml"));
			Pane pane = root.load();
			Scene level = new Scene(pane);
			MainController mainController = root.getController();
			mainController.setPrimaryStage(primaryStage);
			primaryStage.setScene(level);
			primaryStage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Level 1 laden und anzeigen
	public void spiel(Stage primaryStage) throws IOException {

		Level_1 Spiel = new Level_1();
		Spiel.spiel(primaryStage);

	}

	// Level 2 laden und anzeigen
	public void spiel2(Stage primaryStage) throws IOException {

		Level_2 Spiel = new Level_2();
		Spiel.spiel(primaryStage);

	}

	// Level 3 laden und anzeigen
	public void spiel3(Stage primaryStage) throws IOException {

		Level_3 Spiel = new Level_3();
		Spiel.spiel(primaryStage);

	}

	// Level 4 laden und anzeigen
	public void spiel4(Stage primaryStage) throws IOException {

		Level_4 Spiel = new Level_4();
		Spiel.spiel(primaryStage);

	}

}
