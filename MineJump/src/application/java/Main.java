package application.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	Music music = new Music();

	@Override
	public void start(Stage primaryStage) {

		try {
			// Musik starten
			music.startmusic();

			// Hauptmenü laden
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ressources/Main.fxml"));
			Pane pane = root.load();

			// Initialisierung des MainControllers
			MainController mainController = root.getController();
			mainController.setMain(this);
			mainController.setPrimaryStage(primaryStage);
			mainController.setMusic(music);
			

			// Initialisierung Scene und Stage
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

	public static void main(String[] args) {
		launch(args);
	}
}
