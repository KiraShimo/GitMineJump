package application.java;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController {
	// Variablen

	public double volume = 0.2;

	// Objekte
	public Stage primaryStage;
	public Main main;
	Menu menu = new Menu();
	Media media = new Media(getClass().getResource("/application/ressources/music/07_Boo.mp3").toExternalForm());
	MediaPlayer musicplayer = new MediaPlayer(media);

	// @FXML
	// Slider SliderMusic;
	Slider slider;

	public void setMain(Main main) {
		this.main = main;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void startmusic() {

		// Musik initialisieren

		musicplayer.setAutoPlay(true);
		musicplayer.setVolume(volume); // zwischen 0 und 1

		// Musik loopen
		musicplayer.setOnEndOfMedia(new Runnable() {
			public void run() {
				musicplayer.seek(Duration.ZERO);
			}
		});
	}


	public void setvolume() {
		musicplayer.stop();
		System.out.println(volume);
		musicplayer.setVolume(volume);
		musicplayer.setAutoPlay(true);
	}

	// Aufruf Levelauswahl
	@FXML
	private void BtnStartAction(ActionEvent actionEvent) throws InterruptedException {
		menu.level(primaryStage);
	}

	// Aufruf Einstellungsmenü
	@FXML
	private void BtnOptionsAction(ActionEvent actionEvent) throws InterruptedException {
		menu.settings(primaryStage);
		//slider.setValue(volume * 100);
	}

	// Einstellungen ohne Speichern der Änderungen Verlassen
	@FXML
	private void BtnSettingsAbortAction(ActionEvent actionEvent) throws InterruptedException {
		menu.mainmenu(primaryStage);
	}

	// Einstellungen verlassen mit Speicherung der Änderungen -------- geht nicht
	@FXML
	private void BtnSettingsSaveAction(ActionEvent actionEvent) throws InterruptedException {
		volume = slider.getValue() / 100;
		System.out.println(volume);
		// musicplayer.setVolume(volume);
		musicplayer.setVolume(volume);
		setvolume();
		menu.mainmenu(primaryStage);
	}

	// Level 1 starten - Spielaufruf in Menu.java
	@FXML
	private void BtnLevel1Action(ActionEvent actionEvent) throws IOException {
		menu.spiel(primaryStage);
	}

	// Level 2 starten - Spielaufruf in Menu.java
	@FXML
	private void BtnLevel2Action(ActionEvent actionEvent) throws IOException {
		menu.spiel2(primaryStage);
	}

	// Level 3 starten - Spielaufruf in Menu.java
	@FXML
	private void BtnLevel3Action(ActionEvent actionEvent) throws IOException {
		menu.spiel3(primaryStage);
	}

	// Level 4 starten - Spielaufruf in Menu.java
	@FXML
	private void BtnLevel4Action(ActionEvent actionEvent) throws IOException {
		menu.spiel4(primaryStage);
	}

	// Hauptmenü erneut aufrufen - Aufruf in Menu.java
	@FXML
	private void BtnLevelBackAction(ActionEvent actionEvent) throws IOException {
		menu.mainmenu(primaryStage);
	}

	// Spiel beenden
	@FXML
	private void BtnExitAction(ActionEvent actionEvent) {
		Platform.exit();
	}

}
