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

	public Stage primaryStage;
	public Main main;
	Menu menu = new Menu();
	// public Music music;
	@FXML
	Slider SliderMusic;

	public void setMain(Main main) {
		this.main = main;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	/*
	 * public void setMusic(Music music) { this.music = music; }
	 */

	private MediaPlayer musicplayer;
	private double volume;

	public void startmusic() {

		// Musik initialisieren
		Media media = new Media(getClass().getResource("/application/ressources/music/07_Boo.mp3").toExternalForm());
		musicplayer = new MediaPlayer(media);
		musicplayer.setAutoPlay(true);
		musicplayer.setVolume(0.2); // zwischen 0 und 1

		// Musik loopen
		musicplayer.setOnEndOfMedia(new Runnable() {
			public void run() {
				musicplayer.seek(Duration.ZERO);
			}
		});
	}

	public double getvolume() {
		return musicplayer.getVolume();
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
		// double volume = music.getvolume();
		// main.getmusic().getvolume();
		// System.out.println(volume);
		// SliderMusic.adjustValue(volume*100);
		menu.settings(primaryStage);
	}

	// Einstellungen ohne Speichern der Änderungen Verlassen
	@FXML
	private void BtnSettingsAbortAction(ActionEvent actionEvent) throws InterruptedException {
		menu.mainmenu(primaryStage);
	}

	// Einstellungen verlassen mit Speicherung der Änderungen -------- geht nicht
	@FXML
	private void BtnSettingsSaveAction(ActionEvent actionEvent) throws InterruptedException {
		// volume = SliderMusic.getValue() / 100;
		System.out.println(volume);
		//	musicplayer.setVolume(volume);
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
