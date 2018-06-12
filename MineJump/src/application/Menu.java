package application;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {
	public void level(Stage primaryStage) {
		try {
			//Levelmen� laden und anzeigen
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

			// Eventhandler

			game.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					switch (event.getCode()) {
					case UP:
						System.out.println("HOCH");
						break;
					case DOWN:
						System.out.println("RUNTER");    //brauchen wir das wirklich?
						break;
					case LEFT:
						System.out.println("LINKS");
						break;
					case RIGHT:
						System.out.println("RECHTS");
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
					case UP:
						System.out.println("STOP");
						break;
					case DOWN:
						System.out.println("STOP");
						break;
					case LEFT:
						System.out.println("STOP");
						break;
					case RIGHT:
						System.out.println("STOP");
						break;
					case ESCAPE:
						System.out.println("STOP");   //brauchen wir ja eigentlich auch nicht
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
