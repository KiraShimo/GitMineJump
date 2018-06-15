package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainController{
	
	public Stage primaryStage;
	public Main main;
	Menu menu = new Menu();
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	}
	
	//Aufruf Levelauswahl
	@FXML
	private void BtnStartAction(ActionEvent actionEvent) throws InterruptedException {
		menu.level(primaryStage);
	}
	
	//Level starten - Spielaufruf in Menu.java
	@FXML
	private void BtnLevel1Action(ActionEvent actionEvent) {
		menu.spiel(primaryStage);
	}
	
	//Spiel beenden
	@FXML
	private void BtnExitAction(ActionEvent actionEvent) {
		Platform.exit();
	}
}
