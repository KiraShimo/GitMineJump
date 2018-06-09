package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("Main.fxml"));
			Pane pane = root.load();
			primaryStage.setTitle("MineJump");

			MainController mainController = root.getController();
			mainController.setMain(this);
			mainController.setPrimaryStage(primaryStage);

			Scene mainmenu = new Scene(pane);
			mainmenu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
	}

	public static void main(String[] args) {
		launch(args);
	}
}
