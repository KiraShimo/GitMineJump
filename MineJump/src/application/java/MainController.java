package application.java;

import java.io.*;

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

	private double volume;

	// Objekte
	public Stage primaryStage;
	public Main main;
	Menu menu = new Menu();
	Media media = new Media(getClass().getResource("/application/ressources/music/07_Boo.mp3").toExternalForm());
	final MediaPlayer musicplayer = new MediaPlayer(media);
	String str;

	@FXML
	Slider SliderMusic;
	
	Slider slider;
						

	public void setMain(Main main) {
		this.main = main;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void startmusic() throws NumberFormatException, IOException {

		// Musik initialisieren
		FileReader Lautstaerke = new FileReader("src/application/ressources/Music.txt");
		BufferedReader Lautst�rkeausleser = new BufferedReader(Lautstaerke);
		volume = Double.parseDouble(Lautst�rkeausleser.readLine());
		Lautst�rkeausleser.close();
		System.out.println(musicplayer.statusProperty());
		musicplayer.isAutoPlay();
		System.out.println("musik l�uft villeich....");
		musicplayer.setVolume(volume); // zwischen 0 und 1
		System.out.println(musicplayer.statusProperty());

		// Musik loopen
		musicplayer.setOnEndOfMedia(new Runnable() {
			public void run() {
				musicplayer.seek(Duration.ZERO);
			}
		});
	}

	public void setvolume() throws NumberFormatException, IOException {

		musicplayer.pause();
		System.out.println("musik gestoppt");
		musicplayer.setVolume(volume/100);
		musicplayer.play();
	}

	// Aufruf Levelauswahl
	@FXML
	private void BtnStartAction(ActionEvent actionEvent) throws InterruptedException {
		menu.level(primaryStage);
	}

	// Aufruf Einstellungsmen�
	@FXML
	private void BtnOptionsAction(ActionEvent actionEvent)
			throws InterruptedException, NumberFormatException, IOException {
		// das muss noch ge�ndert werden
		FileReader Lautstaerke = new FileReader("src/application/ressources/Music.txt");
		BufferedReader Lautst�rkeausleser = new BufferedReader(Lautstaerke);
		volume = Double.parseDouble(Lautst�rkeausleser.readLine());
		Lautst�rkeausleser.close();
		System.out.println(volume);
		menu.settings(primaryStage);
	}

	// Einstellungen ohne Speichern der �nderungen Verlassen
	@FXML
	private void BtnSettingsAbortAction(ActionEvent actionEvent) throws InterruptedException {
		menu.mainmenu(primaryStage);
	}

	// Einstellungen verlassen mit Speicherung der �nderungen -------- geht noch
	// nicht
	@FXML
	private void BtnSettingsSaveAction(ActionEvent actionEvent)
		throws InterruptedException, NumberFormatException, IOException {
		System.out.println(volume);
		menu.mainmenu(primaryStage);
	}

	@FXML
	private void BtnSettingsSaveTake(ActionEvent actionEvent) throws NumberFormatException, IOException {
		System.out.println(SliderMusic.getValue());
		FileWriter Lautst�rkeschreiber = new FileWriter("src/application/ressources/Music.txt",
				false);
		BufferedWriter Schreib = new BufferedWriter(Lautst�rkeschreiber);
		str = String.valueOf(SliderMusic.getValue());
		Schreib.write(str);
		Schreib.close();
		startmusic();
		setvolume();
		System.out.println(musicplayer.statusProperty());

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

	// Hauptmen� erneut aufrufen - Aufruf in Menu.java
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
