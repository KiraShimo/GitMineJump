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

public class Level_1 {
	// Spieler und Hintergrundvariablen
	public int PosX = 120;
	public int PosY = 252;
	public int SPosXR = PosX + 64;
	public int SPosYH = PosY + 128;
	public int bgPosX = 0;
	public int bgPoY = -220;
	public int UPosX = 0;
	public int UPosY = 380;
	public int RLN = 0;
	private int TempoX = 0;
	private int TempoY = 0;
	private int RealPosX = 0;
	private boolean Gesprungen = false;
	// Bedingungsvariablen
	private boolean Gewonnen = false;
	private boolean WillRaus = false;
	private int t = 1;
	// Blockvariablen
	private int B01PosX = 1000;
	private int B01PosY = 310;
	private int B02PosX = 1070;
	private int B02PosY = 310;
	private int B03PosX = 1140;
	private int B03PosY = 310;
	private int B04PosX = 1070;
	private int B04PosY = 240;
	private int B05PosX = 1070;
	private int B05PosY = 180;
	private int B06PosX = 1070;
	private int B06PosY = 40;
	private int B07PosX = 1000;
	private int B07PosY = 40;
	private int B08PosX = 1140;
	private int B08PosY = 40;
	private int B09PosX = 1070;
	private int B09PosY = 110;

	public void spiel(Stage primaryStage) throws IOException {

		// Spiel initialisieren

		Pane rootPane;

		// Erstellt das Neue RootPane
		rootPane = new Pane();

		Image SpielerRechts = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Rechts.png").openStream());
		Image SpielerLinks = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Links.png").openStream());
		Image Laub = new Image(Main.class.getResource("/application/ressources/pictures/LaubNorm.png").openStream());
		Image LaubBG = new Image(Main.class.getResource("/application/ressources/pictures/LaubBG.png").openStream());
		Image BaumBG = new Image(
				Main.class.getResource("/application/ressources/pictures/HolzHint2.0.png").openStream());
		Image HintergrundImage = new Image(
				Main.class.getResource("/application/ressources/pictures/Hintergrund2.0.png").openStream());
		ImageView HintergrundImageAufruf = new ImageView(HintergrundImage);
		HintergrundImageAufruf.setX(bgPosX);
		HintergrundImageAufruf.setY(bgPoY);
		rootPane.getChildren().add(HintergrundImageAufruf);

		Image Untergrund = new Image(
				Main.class.getResource("/application/ressources/pictures/Untergrund1.0.png").openStream());
		ImageView UntergrundAnzeigen = new ImageView(Untergrund);
		UntergrundAnzeigen.setX(UPosX);
		UntergrundAnzeigen.setY(UPosY);
		rootPane.getChildren().add(UntergrundAnzeigen);

		Image Block01 = new Image(
				Main.class.getResource("/application/ressources/pictures/HolzNorm2.0.png").openStream());
		ImageView B01Anzeigen = new ImageView(Block01);
		B01Anzeigen.setX(B01PosX);
		B01Anzeigen.setY(B01PosY);
		rootPane.getChildren().add(B01Anzeigen);

		ImageView B02Anzeigen = new ImageView(Block01);
		B02Anzeigen.setX(B02PosX);
		B02Anzeigen.setY(B02PosY);
		rootPane.getChildren().add(B02Anzeigen);

		ImageView B03Anzeigen = new ImageView(Block01);
		B03Anzeigen.setX(B03PosX);
		B03Anzeigen.setY(B03PosY);
		rootPane.getChildren().add(B03Anzeigen);

		ImageView B04Anzeigen = new ImageView(Block01);
		B04Anzeigen.setX(B04PosX);
		B04Anzeigen.setY(B04PosY);
		rootPane.getChildren().add(B04Anzeigen);

		ImageView B05Anzeigen = new ImageView(BaumBG);
		B04Anzeigen.setX(B05PosX);
		B04Anzeigen.setY(B05PosY);
		rootPane.getChildren().add(B05Anzeigen);

		ImageView B09Anzeigen = new ImageView(BaumBG);
		B04Anzeigen.setX(B09PosX);
		B04Anzeigen.setY(B09PosY);
		rootPane.getChildren().add(B09Anzeigen);

		ImageView B06Anzeigen = new ImageView(Laub);
		B04Anzeigen.setX(B06PosX);
		B04Anzeigen.setY(B06PosY);
		rootPane.getChildren().add(B06Anzeigen);

		ImageView B07Anzeigen = new ImageView(Laub);
		B04Anzeigen.setX(B07PosX);
		B04Anzeigen.setY(B07PosY);
		rootPane.getChildren().add(B07Anzeigen);

		ImageView B08Anzeigen = new ImageView(Laub);
		B04Anzeigen.setX(B08PosX);
		B04Anzeigen.setY(B08PosY);
		rootPane.getChildren().add(B08Anzeigen);

		Image SpielerBild = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Vorne.png").openStream());
		ImageView Bildaufruf = new ImageView(SpielerBild);
		Bildaufruf.setX(PosX);
		Bildaufruf.setY(PosY);
		rootPane.getChildren().add(Bildaufruf);

		Scene game = new Scene(rootPane);

		final Box Listener = new Box();
		Listener.setFocusTraversable(true);
		Listener.requestFocus();
		Listener.setOnKeyPressed(keyEventHandler);
		Listener.setOnKeyReleased(TasteLoslassen);

		rootPane.getChildren().add(Listener);

		primaryStage.setScene(game);
		primaryStage.show();

		AnimationTimer Spielschleife = new AnimationTimer() {
			// Spielschleife
			@Override
			public void handle(long arg0) {

				NeuLaden();
				Kollisionsdetektion();
				// Position Updaten
				if (RLN == 0) {
					Bildaufruf.setImage(SpielerBild);
				}
				if (RLN == 1) {
					Bildaufruf.setImage(SpielerLinks);
				}
				if (RLN == 2) {
					Bildaufruf.setImage(SpielerRechts);
				}
				HintergrundImageAufruf.setX(bgPosX);
				UntergrundAnzeigen.setX(UPosX);
				Bildaufruf.setX(PosX);
				Bildaufruf.setY(PosY);
				// Bl�cke updaten
				B01Anzeigen.setX(B01PosX);
				B01Anzeigen.setY(B01PosY);
				B02Anzeigen.setX(B02PosX);
				B02Anzeigen.setY(B02PosY);
				B03Anzeigen.setX(B03PosX);
				B03Anzeigen.setY(B03PosY);
				B04Anzeigen.setX(B04PosX);
				B04Anzeigen.setY(B04PosY);
				B05Anzeigen.setX(B05PosX);
				B05Anzeigen.setY(B05PosY);
				B06Anzeigen.setX(B06PosX);
				B06Anzeigen.setY(B06PosY);
				B07Anzeigen.setX(B07PosX);
				B07Anzeigen.setY(B07PosY);
				B08Anzeigen.setX(B08PosX);
				B08Anzeigen.setY(B08PosY);
				B09Anzeigen.setX(B09PosX);
				B09Anzeigen.setY(B09PosY);

				// Gewonnen test / ESC test
				if (Gewonnen == true) {
					Gewonnen = false;
					RealPosX = 0;
					PosX = 0;
					TempoX = 0;
					Main test = new Main();
					test.start(primaryStage);
				}
				if (WillRaus == true) {
					WillRaus = false;
					RealPosX = 0;
					PosX = 0;
					TempoX = 0;
					Main test = new Main();
					test.start(primaryStage);

				}
			}
		};

		Spielschleife.start();

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
				WillRaus = true;
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
		// Kollisiondetektion -extra-
		if (PosX >= B01PosX - 10 && TempoX < 0 && PosX <= B01PosX + 230) {
			TempoX = 0;
		}
		// Bewegen und Anpassen
		if (PosX > 51) {
			RealPosX += TempoX;
		}
		if (TempoX < 0) {
			PosX += TempoX;
		} else if (TempoX == 0) {
			// tue nichts

		} else {
			if (PosX <= 300) {
				PosX += TempoX;
			} else {
				// Bewege Hintergrund
				UPosX -= TempoX;
				bgPosX -= (TempoX / 2);

			}
		}
		// Hintergrund Loop
		if (bgPosX <= -2382)
			bgPosX = 0;
		if (UPosX <= -1200)
			UPosX = 0;
		if (PosY + TempoY >= 382) {
			PosY = 382;
		} else {
			PosY += TempoY;
		}
		// Sprungregelung
		if (Gesprungen == true) {
			TempoY += 1;

			if (PosY + TempoY >= 252) {
				PosY = 252;
				TempoY = 0;
				Gesprungen = false;
			}

		}
		// Nach links laufen unterbinden
		if (PosX + TempoX <= 50) {
			PosX = 51;

		}
		// Siegbedingung
		if (t == 1) {
			if (RealPosX > 3000) {
				Gewonnen = true;
				t = 0;
				System.out.println("gewonnen");
				RealPosX = 0;
			}
		}
		// BlockPositionen anpassen

		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B01PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B02PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B03PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B04PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B05PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B06PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B07PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B08PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B09PosX -= TempoX;
		}

	}

	public void Kollisionsdetektion() {
		// Kollisionsdetektion *FUNKTIONIERT MEHR ODER WENIGER* *MACHT PROBLEME MIT
		// SIEGBEDINGUNG* probier mal ein bisschen am ersten block im ersten lv
		// Kollision erster Block
		if ((B01PosX - 50) <= PosX && PosX <= (B01PosX + 70)) {
			if (PosY >= 200) {
				PosX = B01PosX - 51;
				RealPosX -= 6;
			} else {

				if (PosY + TempoY >= 182) {
					PosY = 182;
					TempoY = 0;
					Gesprungen = false;
				}

			}

		}
		if (B01PosX + 40 <= PosX && PosX <= (B01PosX + 130)) {
			if (PosY >= 140) {
				PosX = B01PosX + 39;
				RealPosX -= 6;
			} else {

				if (PosY + TempoY >= 112) {
					PosY = 112;
					TempoY = 0;
					Gesprungen = false;
				}

			}

		}

		if (PosX >= B01PosX + 140 && PosX <= B03PosX + 141 && Gesprungen == false) {
			PosY = 182;
		}
		if (PosX >= B01PosX + 210 && PosX <= B03PosX + 211 && Gesprungen == false) {
			PosY = 252;

		}

	}

	// Getters und Setters
	public void setGewonnen(boolean gewonnen) {
		Gewonnen = gewonnen;
	}
}
