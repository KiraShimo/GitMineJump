package application.java;

import java.io.IOException;

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
	
	@FXML
	private void BtnOptionsAction(ActionEvent actionEvent) throws InterruptedException {
		menu.settings(primaryStage);
	}

	@FXML
	private void BtnSettingsAbortAction(ActionEvent actionEvent) throws InterruptedException {
		//main.start(primaryStage);
		menu.mainmenu(primaryStage);
	}

	@FXML
	private void BtnSettingsSaveAction(ActionEvent actionEvent) throws InterruptedException {
		//main.start(primaryStage);
		menu.mainmenu(primaryStage);
	}
	
	@FXML
	private void SliderMusicAction(ActionEvent actionEvent) throws InterruptedException {
		
	}
	
	//Spiel beenden
	@FXML
	private void BtnExitAction(ActionEvent actionEvent) {
		Platform.exit();
	}
	
	//Level starten - Spielaufruf in Menu.java
	@FXML
	private void BtnLevel1Action(ActionEvent actionEvent) throws IOException {
		menu.spiel(primaryStage);
	}
	
	//Level 2 starten - Spielaufruf in Menu.java
	@FXML
	private void BtnLevel2Action(ActionEvent actionEvent) throws IOException {
		menu.spiel(primaryStage);
	}
}