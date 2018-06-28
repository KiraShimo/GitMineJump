package application.java;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class SchleifeMenu {

	public int PosX = 120;
	public int PosY = 252;
	public int bgPosX = 0;
	public int bgPoY = -220;
	public int UPosX = 0;
	public int UPosY = 380;
	public int RLN = 0;
	private int TempoX = 0;
	private int TempoY = 0;
	private boolean Gesprungen = false;

	public void spiel(Stage primaryStage) throws IOException {

		// Spiel initialisieren

		Pane rootPane;

		// Erstellt das Neue RootPane
		rootPane = new Pane();

		Image SpielerRechts = new Image(Main.class.getResource("/application/ressources/pictures/Steve_Rechts.png").openStream());
		Image SpielerLinks = new Image(Main.class.getResource("/application/ressources/pictures/Steve_Links.png").openStream());
		Image HintergrundImage = new Image(
				Main.class.getResource("/application/ressources/pictures/Hintergrundtest.png").openStream());
		ImageView HintergrundImageAufruf = new ImageView(HintergrundImage);
		HintergrundImageAufruf.setX(bgPosX);
		HintergrundImageAufruf.setY(bgPoY);
		rootPane.getChildren().add(HintergrundImageAufruf);

		Image SpielerBild = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Vorne.png").openStream());
		ImageView Bildaufruf = new ImageView(SpielerBild);
		Bildaufruf.setX(PosX);
		Bildaufruf.setY(PosY);
		rootPane.getChildren().add(Bildaufruf);
		
		Image Untergrund = new Image(
				Main.class.getResource("/application/ressources/pictures/Untergrund2.png").openStream());
		ImageView UntergrundAnzeigen = new ImageView(Untergrund);
		UntergrundAnzeigen.setX(UPosX);
		UntergrundAnzeigen.setY(UPosY);
		rootPane.getChildren().add(UntergrundAnzeigen);

		// Hintergrund

		/*
		 * Image Wald = new Image(
		 * getClass().getResource("/application/ressources/pictures/Hintergrundtest.png"
		 * ).toExternalForm()); BackgroundImage HintergrundBild = new
		 * BackgroundImage(Wald, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
		 * BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT); Background Hintergrund =
		 * new Background(HintergrundBild);
		 * 
		 * rootPane.setBackground(Hintergrund);
		 */

		Scene game = new Scene(rootPane);

		final Box Listener = new Box();
		Listener.setFocusTraversable(true);
		Listener.requestFocus();
		Listener.setOnKeyPressed(keyEventHandler);
		Listener.setOnKeyReleased(TasteLoslassen);

		rootPane.getChildren().add(Listener);

		primaryStage.setScene(game);
		primaryStage.show();

		AnimationTimer animator = new AnimationTimer() {
			// Spielschleife
			@Override
			public void handle(long arg0) {

				NeuLaden();

				// Position Updaten
				if(RLN == 0) {
				Bildaufruf.setImage(SpielerBild);	
				}
				if(RLN == 1) {
				Bildaufruf.setImage(SpielerLinks);	
				}
				if(RLN == 2) {
				Bildaufruf.setImage(SpielerRechts);	
				}
				HintergrundImageAufruf.setX(bgPosX);
				HintergrundImageAufruf.setY(bgPoY);
				Bildaufruf.setX(PosX);
				Bildaufruf.setY(PosY);
			}
		};

		animator.start();

	}

	final EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {

		public void handle(KeyEvent event) {
			switch (event.getCode()) {
			case UP:

				Spring();

				break;
			case SPACE:

				Spring();

				break;
			case LEFT:
				
				Links();
				
				break;
			case RIGHT:

				Rechts();

				break;
			case ESCAPE:
				System.out.println("ESC");
				// Hier bitte main menu wieder einbinden (als Aufruf ^^)
				break;
			default:
				break;
			}
		}
	};

	final EventHandler<KeyEvent> TasteLoslassen = new EventHandler<KeyEvent>() {

		public void handle(KeyEvent event) {
			switch (event.getCode()) {
			case UP:

				break;
			case SPACE:

				break;
			case LEFT:
				RLN = 0;
				Halt();
				break;
			case RIGHT:
				RLN = 0;
				Halt();
				break;
			case ESCAPE:
				System.out.println("ESC");
				// Hier bitte main menu wieder einbinden (als Aufruf ^^)
				break;
			default:
				break;
			}
		}
	};

	public void Spring() {
		if (Gesprungen == false) {

			TempoY = -15;
			Gesprungen = true;

		}
	}

	public void Rechts() {
		TempoX = 6;
		RLN = 2;
	}

	public void Links() {
		TempoX = -6;
		RLN = 1;

	}

	public void Halt() {
		TempoX = 0;
	}

	public void NeuLaden() {
		// Bewegen und Anpassen
		if (TempoX < 0) {
			PosX += TempoX;
		} else if (TempoX == 0) {
			System.out.println("Hintergrund nicht bewegen.");

		} else {
			if (PosX <= 300) {
				PosX += TempoX;
			} else {
				System.out.println("Hintergrund bewegen");
			}
		}
		if (PosY + TempoY >= 382) {
			PosY = 382;
		} else {
			PosY += TempoY;
		}

		if (Gesprungen == true) {
			TempoY += 1;

			if (PosY + TempoY >= 252) {
				PosY = 252;
				TempoY = 0;
				Gesprungen = false;
			}

		}

		if (PosX + TempoX <= 50) {
			PosX = 51;
		}
		
	}

}
