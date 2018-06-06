package application;

import application.ProgrammStartKlasse;
import application.Spieler;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;


// import com.oracle.deploy.update.UpdateCheck;


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
			
			//UpdateSpieler();
			//UpdateUmgebung();
			//Repaint();
			
			try {
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
			
			Spieler Horst = new Spieler();
			
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
