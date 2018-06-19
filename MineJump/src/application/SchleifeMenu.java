package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class SchleifeMenu {
	
	Spieler Steve = new Spieler();
	
	public void spiel(Stage primaryStage) {
		try {
			//Spiel initialisieren
			
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
						break;
					case LEFT:
						System.out.println("LINKS");
						Steve.Links();
						Steve.NeuLaden();
						break;
					case RIGHT:
						System.out.println("RECHTS");
						Steve.Rechts();
						Steve.NeuLaden();
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
