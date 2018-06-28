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
	private int TempoX = 0;
	private int TempoY = 0;
	private boolean Gesprungen = false;

	public void spiel(Stage primaryStage) throws IOException {

		// Spiel initialisieren

		Pane rootPane;

		// Erstellt das Neue RootPane
		rootPane = new Pane();
		Image SpielerBild = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Skin.png").openStream());
		ImageView Bildaufruf = new ImageView(SpielerBild);
		Bildaufruf.setX(PosX);
		Bildaufruf.setY(PosY);
		rootPane.getChildren().add(Bildaufruf);

		// Hintergrund

		Image Wald = new Image(getClass().getResource("/application/ressources/pictures/Title_screen_logo_edited.png")
				.toExternalForm());
		BackgroundImage HintergrundBild = new BackgroundImage(Wald, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background Hintergrund = new Background(HintergrundBild);

		rootPane.setBackground(Hintergrund);

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
				System.out.println("HOCH");
				Spring();
				System.out.println("testup");
				break;
			case LEFT:
				System.out.println("LINKS");
				Links();
				System.out.println("testleft");
				break;
			case RIGHT:
				System.out.println("RECHTS");
				Rechts();
				System.out.println("testright");
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
				System.out.println("STOP");
				Halt();
				break;
			case LEFT:
				System.out.println("STOP");
				Halt();
				break;
			case RIGHT:
				System.out.println("STOP");
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

			TempoY = -10;
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
			// System.out.println("Hintergrund nicht bewegen.");

		} else {
			if (PosX <= 280) {
				PosX += TempoX;
			} else {
				// System.out.println("Hintergrund bewegen");
			}
		}
		if (PosY + TempoY >= 280) {
			PosY = 280;
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
