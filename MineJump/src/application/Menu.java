package application;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {

	public void level(Stage primaryStage) {
		try {
			//Levelmenü laden und anzeigen
			FXMLLoader root = new FXMLLoader(getClass().getResource("ressources/Level.fxml"));
			Pane pane = root.load();
			Scene level = new Scene(pane);
			primaryStage.setScene(level);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spiel(Stage primaryStage) {
		try {
			//Spiel initialisieren
			
			Spieler Steve = new Spieler();
			int X = Steve.getSpielerPosX();
			int Y = Steve.getSpielerPosY();

			ProgrammStartKlasse Spiel = new ProgrammStartKlasse(X, Y);
			Scene game = new Scene(Spiel.getRootPane());
			Steve.NeuLaden();
			// Eventhandler

			game.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					switch (event.getCode()) {
					case SPACE:
						System.out.println("HOCH");
						Steve.Spring();
						Steve.NeuLaden();
						Menu spiel = new Menu();
						spiel.spiel(primaryStage);
						System.out.println("X = " + X);
						break;
					case LEFT:
						System.out.println("LINKS");
						Steve.Links();
						Steve.NeuLaden();
						Menu spiel1 = new Menu();
						spiel1.spiel(primaryStage);
						System.out.println("X = " + X);
						break;
					case RIGHT:
						System.out.println("RECHTS");
						Steve.Rechts();
						Steve.NeuLaden();
						Menu spiel2 = new Menu();
						spiel2.spiel(primaryStage);
						System.out.println("X = " + X);
						break;
					case ESCAPE:
						System.out.println("ESC");
						//Hier bitte main menu wieder einbinden (als Aufruf ^^)
						break;
					default:
						break;
					}
				}
			});

			game.setOnKeyReleased(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					switch (event.getCode()) {
					case SPACE:
						System.out.println("STOP");
						Steve.Halt();
						
						break;
					case LEFT:
						System.out.println("STOP");
						Steve.Halt();
						
						break;
					case RIGHT:
						System.out.println("STOP");
						Steve.Halt();
						
						break;
					default:
						break;
					}
				}
			});
			

			game.getStylesheets().add(getClass().getResource("ressources/application.css").toExternalForm());
			
			primaryStage.setScene(game);
			primaryStage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
