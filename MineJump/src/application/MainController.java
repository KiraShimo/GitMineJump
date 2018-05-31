package application;

import application.ProgrammStartKlasse;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController{
	
	public Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	private void BtnStartAction(ActionEvent actionevent) {
		/*@Override
		public void start(Stage primaryStage) {
			try {
				SpielFX Spiel = new SpielFX();
				Scene game = new Scene(Spiel.getRootPane());
		        primaryStage.setScene(game); 
		        primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}*/
	}
	
	@FXML
	private void BtnExitAction(ActionEvent actionEvent) {
		Platform.exit();
	}
	
}
