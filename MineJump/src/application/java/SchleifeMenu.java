package application.java;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.animation.AnimationTimer;

public class SchleifeMenu {

	public int PosX = 120;
	public int PosY = 280;
	public int bgPosX = 0;
	public int bgPoY = -220;
	private int TempoX = 0;
	private int TempoY = 0;
	private boolean Gesprungen = false;

	public void spiel(Stage primaryStage) throws IOException {

		// Spiel initialisieren

		Pane rootPane;

		// Erstellt das Neue RootPane
		rootPane = new Pane();

		Image HintergrundImage = new Image(
				Main.class.getResource("/application/ressources/pictures/Hintergrundtest.png").openStream());
		ImageView HintergrundImageAufruf = new ImageView(HintergrundImage);
		HintergrundImageAufruf.setX(bgPosX);
		HintergrundImageAufruf.setY(bgPoY);
		rootPane.getChildren().add(HintergrundImageAufruf);

		Image SpielerBild = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Skin.png").openStream());
		ImageView Bildaufruf = new ImageView(SpielerBild);
		Bildaufruf.setX(PosX);
		Bildaufruf.setY(PosY);
		rootPane.getChildren().add(Bildaufruf);

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

				Halt();
				break;
			case RIGHT:

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

	}

	public void Links() {
		TempoX = -6;

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

			if (PosY + TempoY >= 280) {
				PosY = 280;
				TempoY = 0;
				Gesprungen = false;
			}

		}

		if (PosX + TempoX <= 50) {
			PosX = 51;
		}
	}

}
