package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SchleifeMenu {
	
	
	public void spiel(Stage primaryStage) {
		try {
			//Spiel initialisieren
			
			Spieler Steve = new Spieler();
			int X = Steve.getSpielerPosX();
			int Y = Steve.getSpielerPosY();

			ProgrammStartKlasse Spiel = new ProgrammStartKlasse(X, Y);
			Scene game = new Scene(Spiel.getRootPane());
			int TempoX = Steve.getTempoX();
			int TempoY = Steve.getTempoY();
			Steve.NeuLaden(TempoX, TempoY);
			// Eventhandler

			game.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					switch (event.getCode()) {
					case SPACE:
						System.out.println("HOCH");
						Steve.Spring();
						Steve.getTempoX();
						Steve.getTempoY();
						Steve.NeuLaden(TempoX, TempoY);
						int X = Steve.getSpielerPosX();
						int Y = Steve.getSpielerPosY();
						Menu spiel = new Menu();
						spiel.spiel(primaryStage);
						System.out.println("X = " + X);
						
						break;
					case LEFT:
						System.out.println("LINKS");
						Steve.Links();
						Steve.NeuLaden(TempoX, TempoY);
						int X1 = Steve.getSpielerPosX();
						int Y1 = Steve.getSpielerPosY();
						Menu spiel1 = new Menu();
						spiel1.spiel(primaryStage);
						System.out.println("X = " + X1);
						break;
					case RIGHT:
						System.out.println("RECHTS");
						Steve.Rechts();
						Steve.NeuLaden(TempoX, TempoY);
						int X2 = Steve.getSpielerPosX();
						int Y2 = Steve.getSpielerPosY();
						Menu spiel2 = new Menu();
						spiel2.spiel(primaryStage);
						System.out.println("X = " + X2);
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
