package application.java;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
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
		main.start(primaryStage);
	}

	@FXML
	private void BtnSettingsSaveAction(ActionEvent actionEvent) throws InterruptedException {
		main.start(primaryStage);
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
	
	
	/*final EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
		SchleifeMenu Spiel = new SchleifeMenu();
		
		public void handle(KeyEvent event) {
			switch (event.getCode()) {
			case UP:
				System.out.println("HOCH");
				Spiel.Spring();
				System.out.println("testup");
				break;
			case LEFT:
				System.out.println("LINKS");
				Spiel.Links();
				System.out.println("testleft");
				break;
			case RIGHT:
				System.out.println("RECHTS");
				Spiel.Rechts();
				System.out.println("testright");
				break;
			case ESCAPE:
				System.out.println("ESC");
				// Hier bitte main menu wieder einbinden (als Aufruf ^^)
				main.start(primaryStage);
				break;
			default:
				break;
			}
		}
	};

	final EventHandler<KeyEvent> TasteLoslassen = new EventHandler<KeyEvent>() {
		SchleifeMenu Spiel = new SchleifeMenu();
		
		public void handle(KeyEvent event) {
			switch (event.getCode()) {
			case UP:
				System.out.println("STOP");
				Spiel.Halt();
				break;
			case LEFT:
				System.out.println("STOP");
				Spiel.Halt();
				break;
			case RIGHT:
				System.out.println("STOP");
				Spiel.Halt();
				break;
			case ESCAPE:
				System.out.println("ESC");
				// Hier bitte main menu wieder einbinden (als Aufruf ^^)
				main.start(primaryStage);
				break;
			default:
				break;
			}
		}
	};*/
}
