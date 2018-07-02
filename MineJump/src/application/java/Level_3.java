package application.java;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level_3 {
	// Spieler und Hintergrundvariablen
	public int PosX = 120;
	private int PosXAlt = 0;
	public int PosY = 252;
	public int SPosXR = PosX + 64;
	public int SPosYH = PosY + 128;
	public int bgPosX = 0;
	public int bgPosY = -220;
	public int UPosX = 0;
	public int UPosY = 380;
	public int RLN = 0;
	private int TempoX = 0;
	private int TempoY = 0;
	private int RealPosX = 0;
	private boolean Gesprungen = false;
	private int ZPosX01 = 2925;
	private int ZPosY01 = 166;
	private int ZPosX02 = 2925;
	private int ZPosY02 = -20;
	private int LPosX = 0;
	private int LPosY = 0;
	private int HP = 3;
	// Bedingungsvariablen
	private boolean Gewonnen = false;
	private boolean WillRaus = false;
	private int t = 1;
	private boolean STILL = false;
	private boolean Verloren = false;
	// Blockvariablen
	

	public void spiel(Stage primaryStage) throws IOException {

		// Spiel initialisieren

		Pane rootPane;

		// Erstellt das Neue RootPane
		rootPane = new Pane();

		// Bilder einbinden
		Image SpielerRechts = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Rechts.png").openStream());
		Image SpielerLinks = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Links.png").openStream());
		Image SpielerSchaden = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Vorne_Schaden.png").openStream());
		Image HintergrundImage = new Image(
				Main.class.getResource("/application/ressources/pictures/HintergrundEIS.png").openStream());
		Image Untergrund = new Image(
				Main.class.getResource("/application/ressources/pictures/UntergrundEIS.png").openStream());
		Image Ziel01BG = new Image(Main.class.getResource("/application/ressources/pictures/Ziel01.png").openStream());
		Image SpielerBild = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Vorne.png").openStream());
		Image Ziel02VG = new Image(Main.class.getResource("/application/ressources/pictures/Ziel02.png").openStream());
		Image Leben3 = new Image(Main.class.getResource("/application/ressources/pictures/Herz03f.png").openStream());
		Image Leben2 = new Image(Main.class.getResource("/application/ressources/pictures/Herz02f.png").openStream());
		Image Leben1 = new Image(Main.class.getResource("/application/ressources/pictures/Herz01f.png").openStream());

		// Bilder aufrufen
		ImageView HintergrundImageAufruf = new ImageView(HintergrundImage);
		HintergrundImageAufruf.setX(bgPosX);
		HintergrundImageAufruf.setY(bgPosY);
		rootPane.getChildren().add(HintergrundImageAufruf);

		ImageView UntergrundAnzeigen = new ImageView(Untergrund);
		UntergrundAnzeigen.setX(UPosX);
		UntergrundAnzeigen.setY(UPosY);
		rootPane.getChildren().add(UntergrundAnzeigen);

		// ZielHinten

		ImageView Ziel01BGAnzeiger = new ImageView(Ziel01BG);
		Ziel01BGAnzeiger.setX(ZPosX01);
		Ziel01BGAnzeiger.setY(ZPosY01);
		rootPane.getChildren().add(Ziel01BGAnzeiger);

		// Spieler

		ImageView Bildaufruf = new ImageView(SpielerBild);
		Bildaufruf.setX(PosX);
		Bildaufruf.setY(PosY);
		rootPane.getChildren().add(Bildaufruf);
		// ZielVorne

		ImageView Ziel02VGAnzeiger = new ImageView(Ziel02VG);
		Ziel02VGAnzeiger.setX(ZPosX02);
		Ziel02VGAnzeiger.setY(ZPosY02);
		rootPane.getChildren().add(Ziel02VGAnzeiger);
		// Leben
		ImageView LebenAnzeiger = new ImageView(Leben3);
		LebenAnzeiger.setX(LPosX);
		LebenAnzeiger.setY(LPosY);
		rootPane.getChildren().add(LebenAnzeiger);

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

				Kollisionsdetektion();

				NeuLaden();

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
				if (RLN == 3) {
					Bildaufruf.setImage(SpielerSchaden);
				}
				HintergrundImageAufruf.setX(bgPosX);
				UntergrundAnzeigen.setX(UPosX);
				Bildaufruf.setX(PosX);
				Bildaufruf.setY(PosY);
				LebenAnzeiger.setX(LPosX);
				LebenAnzeiger.setY(LPosY);
				if (HP == 3) {
					LebenAnzeiger.setImage(Leben3);
				}
				if (HP == 2) {
					LebenAnzeiger.setImage(Leben2);
				}
				if (HP == 1) {
					LebenAnzeiger.setImage(Leben1);
				}
				// Blöcke updaten
				// Ziel aktualisieren
				Ziel01BGAnzeiger.setX(ZPosX01);
				Ziel02VGAnzeiger.setX(ZPosX02);

				Menu menu = new Menu();

				// Gewonnen test / ESC test
				if (Gewonnen == true) {
					Gewonnen = false;
					RealPosX = 0;
					PosX = 0;
					TempoX = 0;
					menu.win(primaryStage);
					PauseTransition delay = new PauseTransition(Duration.seconds(5));
					delay.setOnFinished(event -> menu.level(primaryStage));
					delay.play();
				}
				if (WillRaus == true) {
					WillRaus = false;
					RealPosX = 0;
					PosX = 0;
					TempoX = 0;
					menu.level(primaryStage);
				}
				if (Verloren == true) {
					System.out.println("Verloren");
					Verloren = false;
					RealPosX = 0;
					PosX = 0;
					TempoX = 0;
					HP = 3;
					menu.level(primaryStage);
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
			case W:
				Spring();
				break;
			case LEFT:
				Links();
				break;
			case RIGHT:
				Rechts();
				break;
			case A:
				Links();
				break;
			case D:
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
			case W:
				break;
			case LEFT:
				RLN = 0;
				Halt();
				break;
			case RIGHT:
				RLN = 0;
				Halt();
				break;
			case A:
				RLN = 0;
				Halt();
				break;
			case D:
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
		PosXAlt = PosX;
		if (HP == 0) {
			Verloren = true;
		}
		// Kollisiondetektion -extra-
		if (STILL == true) {
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
		if (bgPosX <= -2880)
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
				RealPosX = 0;
			}
		}
		// BlockPositionen anpassen
		
		
		// Ziel anpassen
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				ZPosX01 -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				ZPosX02 -= TempoX;
		}
	}

	public void Kollisionsdetektion() {

		if (RealPosX >= 2750) {
			if (PosY <= 220) {
				PosY = 221;
			}
		}
	}

	//BLABLABLA
}
