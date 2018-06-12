package application;

//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyEvent;
//import javafx.stage.Stage;

public class SchleifeMenu {

	/*public static void spiel(Stage primaryStage) {
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
						Spieler.Spring();
						Menu.spiel(primaryStage);
						break;
					case DOWN:
						System.out.println("RUNTER");    //brauchen wir das wirklich? - ja ... ducken evtl. 
						break;
					case LEFT:
						Spieler.geheLinks();
						Menu.spiel(primaryStage);
						break;
					case RIGHT:
						Spieler.geheRechts();
						Menu.spiel(primaryStage);
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
						break;
					case DOWN:
						System.out.println("STOP");
						break;
					case LEFT:
						Spieler.Stop();
						break;
					case RIGHT:
						Spieler.Stop();
						break;
					default:
						break;
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */
}
