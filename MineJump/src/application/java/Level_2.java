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

public class Level_2 {
	// Spieler und Hintergrundvariablen
	public int PosX = 120;
	public int PosXAlt = 0;
	public int PosY = 252;
	public int SPosXR = PosX + 64;
	public int SPosYH = PosY + 128;
	public int bgPosX = 0;
	public int bgPoY = -40;
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
	private boolean Verloren = false;
	private boolean Flag1 = false;
	private boolean Flag2 = false;
	private boolean Flag3 = false;
	private boolean Flag4 = false;
	// Blockvariablen
	private int B01PosX = 1000;
	private int B01PosY = 310;
	private int B02PosX = 1070;
	private int B02PosY = 310;
	private int B03PosX = 1140;
	private int B03PosY = 310;
	private int B04PosX = 1070;
	private int B04PosY = 240;
	private int B05PosX = 1700;
	private int B05PosY = 310;
	private int B06PosX = 1840;
	private int B06PosY = 240;
	private int B07PosX = 2050;
	private int B07PosY = 240;
	private int B08PosX = 2260;
	private int B08PosY = 240;
	private int B09PosX = 2400;
	private int B09PosY = 310;
	// Kakteen1
	private int K01PosX = 1300;
	private int K01PosY = 180;
	private int K02PosX = 2500;
	private int K02PosY = 180;
	private int K03PosX = 400;
	private int K03PosY = 180;

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
				Main.class.getResource("/application/ressources/pictures/Wüste.png").openStream());
		Image Untergrund = new Image(
				Main.class.getResource("/application/ressources/pictures/UntergrundWueste.png").openStream());
		Image Block01 = new Image(
				Main.class.getResource("/application/ressources/pictures/SandsteinBG.png").openStream());
		Image Ziel01BG = new Image(Main.class.getResource("/application/ressources/pictures/Ziel01.png").openStream());
		Image SpielerBild = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Vorne.png").openStream());
		Image Ziel02VG = new Image(Main.class.getResource("/application/ressources/pictures/Ziel02.png").openStream());
		Image Leben3 = new Image(Main.class.getResource("/application/ressources/pictures/Herz03f.png").openStream());
		Image Leben2 = new Image(Main.class.getResource("/application/ressources/pictures/Herz02f.png").openStream());
		Image Leben1 = new Image(Main.class.getResource("/application/ressources/pictures/Herz01f.png").openStream());

		Image KaktusBG = new Image(
				Main.class.getResource("/application/ressources/pictures/KaktusBG.png").openStream());

		// Bilder aufrufen
		ImageView HintergrundImageAufruf = new ImageView(HintergrundImage);
		HintergrundImageAufruf.setX(bgPosX);
		HintergrundImageAufruf.setY(bgPoY);
		rootPane.getChildren().add(HintergrundImageAufruf);

		ImageView UntergrundAnzeigen = new ImageView(Untergrund);
		UntergrundAnzeigen.setX(UPosX);
		UntergrundAnzeigen.setY(UPosY);
		rootPane.getChildren().add(UntergrundAnzeigen);

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

		ImageView B05Anzeigen = new ImageView(Block01);
		B05Anzeigen.setX(B05PosX);
		B05Anzeigen.setY(B05PosY);
		rootPane.getChildren().add(B05Anzeigen);

		ImageView B06Anzeigen = new ImageView(Block01);
		B06Anzeigen.setX(B06PosX);
		B06Anzeigen.setY(B06PosY);
		rootPane.getChildren().add(B06Anzeigen);

		ImageView B07Anzeigen = new ImageView(Block01);
		B07Anzeigen.setX(B07PosX);
		B07Anzeigen.setY(B07PosY);
		rootPane.getChildren().add(B07Anzeigen);

		ImageView B08Anzeigen = new ImageView(Block01);
		B08Anzeigen.setX(B08PosX);
		B08Anzeigen.setY(B08PosY);
		rootPane.getChildren().add(B08Anzeigen);
		
		ImageView B09Anzeigen = new ImageView(Block01);
		B09Anzeigen.setX(B09PosX);
		B09Anzeigen.setY(B09PosY);
		rootPane.getChildren().add(B09Anzeigen);

		// Kakteen

		ImageView K01Anzeigen = new ImageView(KaktusBG);
		B04Anzeigen.setX(K01PosX);
		B04Anzeigen.setY(K01PosY);
		rootPane.getChildren().add(K01Anzeigen);
		
		ImageView K02Anzeigen = new ImageView(KaktusBG);
		K02Anzeigen.setX(K02PosX);
		K02Anzeigen.setY(K02PosY);
		rootPane.getChildren().add(K02Anzeigen);
		
		ImageView K03Anzeigen = new ImageView(KaktusBG);
		K03Anzeigen.setX(K03PosX);
		K03Anzeigen.setY(K03PosY);
		rootPane.getChildren().add(K03Anzeigen);

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

		AnimationTimer animator = new AnimationTimer() {
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

				// Kakteen anpassen

				K01Anzeigen.setX(K01PosX);
				K01Anzeigen.setY(K01PosY);
				K02Anzeigen.setX(K02PosX);
				K02Anzeigen.setY(K02PosY);
				K03Anzeigen.setX(K03PosX);
				K03Anzeigen.setY(K03PosY);

				// Ziel anpassen

				Ziel01BGAnzeiger.setX(ZPosX01);
				Ziel02VGAnzeiger.setX(ZPosX02);

				Menu menu = new Menu();

				// Gewonnen test / ESC test
				if (Gewonnen == true) {
					Gewonnen = false;
					RealPosX = 0;
					PosX = 0;
					TempoX = 0;
					Menu menu1 = new Menu();
					menu1.win(primaryStage);
					PauseTransition delay = new PauseTransition(Duration.seconds(5)); // Test für WinScreen
					delay.setOnFinished(event -> menu1.level(primaryStage));
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
		PosXAlt = PosX;
		if (HP == 0) {
			Verloren = true;
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
				t = 0;//**
				RealPosX = 0;
			}
		}
		// BlockPositionen anpassen

		if (TempoX >= 0 && PosX >= 300) {
			B01PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			B02PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			B03PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			B04PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			B05PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			B06PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			B07PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			B08PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			B09PosX -= TempoX;
		}
		// Kakteen anpassen

		if (TempoX >= 0 && PosX >= 300) {
			K01PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			K02PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			K03PosX -= TempoX;
		}

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

		// Kollision mit Baum

		if (PosX >= B01PosX - 50 && PosX <= B01PosX + 70 && PosY >= 183 && PosXAlt <= PosX) {
			PosX = B01PosX - 53;
			RealPosX -= 6;
		}
		if (PosX >= B01PosX + 20 && PosX <= B01PosX + 120 && PosY >= 113 && PosXAlt <= PosX) {
			PosX = B01PosX + 19;
			RealPosX -= 6;
		}
		if (PosX >= B01PosX + 20 && PosX <= B01PosX + 151 && PosY >= 113 && PosXAlt > PosX) {
			PosX = B01PosX + 152;
			RealPosX += 6;
		}
		if (PosX >= B01PosX + 20 && PosX <= B01PosX + 221 && PosY >= 183 && PosXAlt > PosX) {
			PosX = B01PosX + 222;
			RealPosX += 6;
		}

		if (PosX >= B01PosX - 49 && PosX <= B01PosX + 70) {
			if (PosY + TempoY >= 182) {
				PosY = 182;
				TempoY = 0;
				Gesprungen = false;
			}
		}
		if (PosX >= B01PosX + 141 && PosX <= B01PosX + 211) {
			if (PosY + TempoY >= 182) {
				PosY = 182;
				TempoY = 0;
				Gesprungen = false;
			}
		}

		if (PosX >= B01PosX + 21 && PosX <= B01PosX + 130) {
			if (PosY + TempoY >= 112) {
				PosY = 112;
				TempoY = 0;
				Gesprungen = false;
			}
		}

		if (PosX >= B01PosX + 210 && PosX <= B03PosX + 211 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B01PosX - 60 && PosX <= B03PosX - 191 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B01PosX - 10 && PosX <= B03PosX - 121 && Gesprungen == false) {
			PosY = 182;

		}
		if (PosX >= B01PosX + 130 && PosX <= B03PosX + 51 && Gesprungen == false) {
			PosY = 182;

		}
		if (RealPosX >= 2750) {
			if (PosY <= 220) {
				PosY = 221;
			}
		}

		// Kollision mit 1. Block der 2. Hürde
		if (PosX >= B05PosX - 50 && PosX <= B05PosX + 70 && PosY >= 183 && PosXAlt <= PosX) {
			PosX = B05PosX - 53;
			RealPosX -= 6;
		}
		if (PosX >= B05PosX - 50 && PosX <= B05PosX + 70 && PosY >= 183 && PosXAlt > PosX) {
			PosX = B05PosX + 71;
			RealPosX += 6;
		}
		if (PosX >= B05PosX - 49 && PosX <= B05PosX + 70) {
			if (PosY + TempoY >= 182) {
				PosY = 182;
				TempoY = 0;
				Gesprungen = false;
			}
		}
		if (PosX >= B01PosX + 250 && PosX <= B05PosX - 49 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B01PosX + 770 && PosX <= B05PosX + 75 && Gesprungen == false) {
			PosY = 252;

		}
		// Kollision mit 2. Block der 2. Hürde
		if (PosX >= B05PosX + 90 && PosX <= B05PosX + 210 && PosY >= 113 && PosXAlt <= PosX) {
			PosX = B05PosX + 89;
			RealPosX -= 6;
		}
		if (PosX >= B05PosX + 90 && PosX <= B05PosX + 210 && PosY >= 113 && PosXAlt > PosX) {
			PosX = B05PosX + 211;
			RealPosX += 6;
		}
		if (PosX >= B05PosX + 90 && PosX <= B05PosX + 210) {
			if (PosY + TempoY >= 112) {
				PosY = 112;
				TempoY = 0;
				Gesprungen = false;
			}
		}
		if (PosX >= B01PosX + 800 && PosX <= B05PosX + 100 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B01PosX + 915 && PosX <= B05PosX + 220 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B06PosX - 20) {
			Flag1 = true;
		}
		// Kollision mit 3. Block der 2. Hürde
		if (PosX >= B05PosX + 300 && PosX <= B05PosX + 420 && PosY >= 113 && PosXAlt <= PosX) {
			PosX = B05PosX + 299;
			RealPosX -= 6;
		}
		if (PosX >= B05PosX + 300 && PosX <= B05PosX + 420 && PosY >= 113 && PosXAlt > PosX) {
			PosX = B05PosX + 421;
			RealPosX += 6;
		}
		if (PosX >= B05PosX + 300 && PosX <= B05PosX + 420) {
			if (PosY + TempoY >= 112) {
				PosY = 112;
				TempoY = 0;
				Gesprungen = false;
			}
		}
		if (PosX >= B06PosX + 139 && PosX <= B05PosX + 311 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B06PosX + 279 && PosX <= B05PosX + 451 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B07PosX - 20) {
			Flag2 = true;
		}
		// Kollision mit 4. Block der 2. Hürde
		if (PosX >= B05PosX + 510 && PosX <= B05PosX + 630 && PosY >= 113 && PosXAlt <= PosX) {
			PosX = B05PosX + 509;
			RealPosX -= 6;
		}
		if (PosX >= B05PosX + 510 && PosX <= B05PosX + 630 && PosY >= 113 && PosXAlt > PosX) {
			PosX = B05PosX + 631;
			RealPosX += 6;
		}
		if (PosX >= B05PosX + 510 && PosX <= B05PosX + 630) {
			if (PosY + TempoY >= 112) {
				PosY = 112;
				TempoY = 0;
				Gesprungen = false;
			}
		}
		if (PosX >= B06PosX + 319 && PosX <= B05PosX + 531 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B06PosX + 489 && PosX <= B05PosX + 661 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B08PosX - 20) {
			Flag3 = true;
		}
		// Kollision mit 5. Block der 2. Hürde
//		if (PosX >= B05PosX + 510 && PosX <= B05PosX + 630 && PosY >= 113 && PosXAlt <= PosX) {
//			PosX = B05PosX + 509;
//			RealPosX -= 6;
//		}
//		if (PosX >= B05PosX + 510 && PosX <= B05PosX + 630 && PosY >= 113 && PosXAlt > PosX) {
//			PosX = B05PosX + 631;
//			RealPosX += 6;
//		}
//		if (PosX >= B05PosX + 510 && PosX <= B05PosX + 630) {
//			if (PosY + TempoY >= 112) {
//				PosY = 112;
//				TempoY = 0;
//				Gesprungen = false;
//			}
//		}
//		if (PosX >= B06PosX + 319 && PosX <= B05PosX + 531 && Gesprungen == false) {
//			PosY = 252;
//
//		}
//		if (PosX >= B06PosX + 489 && PosX <= B05PosX + 661 && Gesprungen == false) {
//			PosY = 252;
//
//		}
//		if (PosX >= B08PosX - 20) {
//			Flag3 = true;
//		}
	}

}