package application.java;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.media.MediaPlayer;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController {
	
	public Stage primaryStage;
	public Main main;
	public MediaPlayer musicplayer;
	Menu menu = new Menu();
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void setMediaPlayer(MediaPlayer musicplayer) {
		this.musicplayer = musicplayer;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	}
	
	//Aufruf Levelauswahl
	@FXML
	private void BtnStartAction(ActionEvent actionEvent) throws InterruptedException {
		menu.level(primaryStage);
	}
	
	//Aufruf Einstellungsmenü
	@FXML
	private void BtnOptionsAction(ActionEvent actionEvent) throws InterruptedException {
		//Scene scene = primaryStage.getScene();
		//Slider slider= (Slider) scene.lookup("#SliderMusic");
		//final double volume = musicplayer.getVolume();
		//slider.setValue(volume);
		menu.settings(primaryStage);
	}

	//Einstellungen ohne Speichern der Änderungen Verlassen
	@FXML
	private void BtnSettingsAbortAction(ActionEvent actionEvent) throws InterruptedException {
		//main.start(primaryStage);
		menu.mainmenu(primaryStage);
	}

	//Einstellungen verlassen mit Speicherung der Änderungen
	@FXML
	private void BtnSettingsSaveAction(ActionEvent actionEvent) throws InterruptedException {
		//main.start(primaryStage);
		Scene scene = primaryStage.getScene();
		Slider slider= (Slider) scene.lookup("#SliderMusic");
		double volume = slider.getValue();
		System.out.println(volume);
		main.setvolume(volume);
		menu.mainmenu(primaryStage);
	}
	
	//Level starten - Spielaufruf in Menu.java
	@FXML
	private void BtnLevel1Action(ActionEvent actionEvent) throws IOException {
		menu.spiel(primaryStage);
	}
	
	//Level 2 starten - Spielaufruf in Menu.java
	@FXML
	private void BtnLevel2Action(ActionEvent actionEvent) throws IOException {
		menu.spiel2(primaryStage);
	}
	
	//Level 3 starten - Spielaufruf in Menu.java     - - - - - - - - zurzeit Test für Win-Screen
	@FXML
	private void BtnLevel3Action(ActionEvent actionEvent) throws IOException {
//		menu.win(primaryStage);
//		PauseTransition delay = new PauseTransition(Duration.seconds(5));     //Test für WinScreen
//		delay.setOnFinished( event -> menu.level(primaryStage) );
//		delay.play();
		menu.spiel3(primaryStage);
	}

	//Level starten - Spielaufruf in Menu.java
	@FXML
	private void BtnLevelBackAction(ActionEvent actionEvent) throws IOException {
		menu.mainmenu(primaryStage);
	}
	
	//Spiel beenden
	@FXML
	private void BtnExitAction(ActionEvent actionEvent) {
		Platform.exit();
	}
}
