package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SchleifeMenu {
//dient momentan zu nichts ...
	//wird bald wieder entfehrnt einfach ignorieren
	public static void spiel(Stage primaryStage) {
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
						System.out.println("HOCH");
						Steve.Spring();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
}
