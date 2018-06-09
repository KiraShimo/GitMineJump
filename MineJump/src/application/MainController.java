package application;

import application.Spieler;
import application.ProgrammStartKlasse;
import javafx.application.Platform;
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
	
	public void run() {
		while (true) {
			try {
				//UpdateSpieler();
				//UpdateUmgebung();
				//Repaint();
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start(Stage primaryStage) {
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
	
	@FXML
	private void BtnStartAction(ActionEvent actionEvent) {
		start(primaryStage);
		
	}
	
	@FXML
	private void BtnExitAction(ActionEvent actionEvent) {
		Platform.exit();
	}
	
}
