package application;

import application.ProgrammStartKlasse;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController{
	
	public Stage primaryStage;
	
	public Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	}

	public void start(Stage primaryStage) {
			try {
			ProgrammStartKlasse Spiel = new ProgrammStartKlasse();
			Scene game = new Scene(Spiel.getRootPane());
			
			primaryStage.setResizable(true);
			primaryStage.setWidth(800);
			primaryStage.setHeight(600);
			primaryStage.setMaxWidth(1200);
			primaryStage.setMaxHeight(1000);
			primaryStage.setMinWidth(800);
			primaryStage.setMinHeight(600);

			primaryStage.setScene(game);
			primaryStage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	private void BtnStartAction(ActionEvent actionEvent) {
		start(primaryStage);
	}
	
	@FXML
	private void BtnExitAction(ActionEvent actionEvent) {
		Platform.exit();
	}
	
}
