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
	
	// Variablen
	// Spieler und Hintergrundvariablen
	private int PosX = 120;
	private int PosXAlt = 0;
	private int PosY = 252;
	public int SPosXR = PosX + 64;
	public int SPosYH = PosY + 128;
	private int BGPosX = 0;
	private int BGPoY = -40;
	private int UPosX = 0;
	private int UPosY = 380;
	private int RLN = 0;
	private int TempoX = 0;
	private int TempoY = 0;
	private int RealPosX = 0;
	private int ZPosX01 = 2925;
	private int ZPosY01 = 166;
	private int ZPosX02 = 2925;
	private int ZPosY02 = -20;
	private int LPosX = 0;
	private int LPosY = 0;
	private int HP = 3;
	
	// Bedingungsvariablen
	private int GewonnenTest = 1;
	private boolean Gesprungen = false;
	private boolean Gewonnen = false;
	private boolean WillRaus = false;
	private boolean Verloren = false;
	private boolean Speicherpunkt01 = false;
	private boolean Speicherpunkt02 = false;
	private boolean Speicherpunkt03 = false;
	private boolean Speicherpunkt04 = false;
	private boolean Stillstand = false;
	private boolean Gefallen = false;
	
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
	
	// Kakteenvariablen
	private int K01PosX = 1300;
	private int K01PosY = 174;
	private int K02PosX = 2500;
	private int K02PosY = 174;
	private int K03PosX = 400;
	private int K03PosY = 174;
	private int K04PosX = 60;
	private int K04PosY = 174;
	private int K05PosX = 900;
	private int K05PosY = 174;
	
	// Kakteenkleinvariablen
	private int KK01PosX = 1840;
	private int KK01PosY = 311;
	private int KK02PosX = 1910;
	private int KK02PosY = 311;
	private int KK03PosX = 1980;
	private int KK03PosY = 311;
	private int KK04PosX = 2050;
	private int KK04PosY = 311;
	private int KK05PosX = 2120;
	private int KK05PosY = 311;
	private int KK06PosX = 2190;
	private int KK06PosY = 311;
	private int KK07PosX = 2260;
	private int KK07PosY = 311;

	public void spiel(Stage primaryStage) throws IOException {

		// Spiel initialisieren
		Pane rootPane;

		// Erstellt das neue RootPane
		rootPane = new Pane();
		
		// Bilder einbinden
		Image SpielerRechts = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Rechts.png").openStream());
		Image SpielerLinks = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Links.png").openStream());
		Image SpielerSchaden = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Vorne_Schaden.png").openStream());
		Image HintergrundImage = new Image(
				Main.class.getResource("/application/ressources/pictures/W�ste.png").openStream());
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
		Image KaktusKlein = new Image(
				Main.class.getResource("/application/ressources/pictures/KaktusBlock.png").openStream());

		// Bilder aufrufen und anzeigen
		ImageView HintergrundImageAufruf = new ImageView(HintergrundImage);
		HintergrundImageAufruf.setX(BGPosX);
		HintergrundImageAufruf.setY(BGPoY);
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

		// Kakteen aufrufen und anzeigen
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

		ImageView K04Anzeigen = new ImageView(KaktusBG);
		K04Anzeigen.setX(K04PosX);
		K04Anzeigen.setY(K04PosY);
		rootPane.getChildren().add(K04Anzeigen);

		ImageView K05Anzeigen = new ImageView(KaktusBG);
		K05Anzeigen.setX(K05PosX);
		K05Anzeigen.setY(K05PosY);
		rootPane.getChildren().add(K05Anzeigen);

		// Kateenklein aufrufen und anzeigen 

		ImageView KK01Anzeigen = new ImageView(KaktusKlein);
		KK01Anzeigen.setX(KK01PosX);
		KK01Anzeigen.setY(KK01PosY);
		rootPane.getChildren().add(KK01Anzeigen);

		ImageView KK02Anzeigen = new ImageView(KaktusKlein);
		KK02Anzeigen.setX(KK02PosX);
		KK02Anzeigen.setY(KK02PosY);
		rootPane.getChildren().add(KK02Anzeigen);

		ImageView KK03Anzeigen = new ImageView(KaktusKlein);
		KK03Anzeigen.setX(KK03PosX);
		KK03Anzeigen.setY(KK03PosY);
		rootPane.getChildren().add(KK03Anzeigen);

		ImageView KK04Anzeigen = new ImageView(KaktusKlein);
		KK04Anzeigen.setX(KK04PosX);
		KK04Anzeigen.setY(KK04PosY);
		rootPane.getChildren().add(KK04Anzeigen);

		ImageView KK05Anzeigen = new ImageView(KaktusKlein);
		KK05Anzeigen.setX(KK05PosX);
		KK05Anzeigen.setY(KK05PosY);
		rootPane.getChildren().add(KK05Anzeigen);

		ImageView KK06Anzeigen = new ImageView(KaktusKlein);
		KK06Anzeigen.setX(KK06PosX);
		KK06Anzeigen.setY(KK06PosY);
		rootPane.getChildren().add(KK06Anzeigen);

		ImageView KK07Anzeigen = new ImageView(KaktusKlein);
		KK07Anzeigen.setX(KK07PosX);
		KK07Anzeigen.setY(KK07PosY);
		rootPane.getChildren().add(KK07Anzeigen);

		// ZielHinten aufrufen und anzeigen

		ImageView Ziel01BGAnzeiger = new ImageView(Ziel01BG);
		Ziel01BGAnzeiger.setX(ZPosX01);
		Ziel01BGAnzeiger.setY(ZPosY01);
		rootPane.getChildren().add(Ziel01BGAnzeiger);

		// Spieler aufrufen und anzeigen

		ImageView Bildaufruf = new ImageView(SpielerBild);
		Bildaufruf.setX(PosX);
		Bildaufruf.setY(PosY);
		rootPane.getChildren().add(Bildaufruf);
		
		// ZielVorne aufrufen und anzeigen
		ImageView Ziel02VGAnzeiger = new ImageView(Ziel02VG);
		Ziel02VGAnzeiger.setX(ZPosX02);
		Ziel02VGAnzeiger.setY(ZPosY02);
		rootPane.getChildren().add(Ziel02VGAnzeiger);

		// Leben aufrufen und anzeigen
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
				try {
					Kollisionsdetektion();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Position updaten
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
				HintergrundImageAufruf.setX(BGPosX);
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

				// Kakteen updaten
				K01Anzeigen.setX(K01PosX);
				K01Anzeigen.setY(K01PosY);
				K02Anzeigen.setX(K02PosX);
				K02Anzeigen.setY(K02PosY);
				K03Anzeigen.setX(K03PosX);
				K03Anzeigen.setY(K03PosY);
				K04Anzeigen.setX(K04PosX);
				K04Anzeigen.setY(K04PosY);
				K05Anzeigen.setX(K05PosX);
				K05Anzeigen.setY(K05PosY);

				// Kateenklein updaten
				KK01Anzeigen.setX(KK01PosX);
				KK01Anzeigen.setY(KK01PosY);
				KK02Anzeigen.setX(KK02PosX);
				KK02Anzeigen.setY(KK02PosY);
				KK03Anzeigen.setX(KK03PosX);
				KK03Anzeigen.setY(KK03PosY);
				KK04Anzeigen.setX(KK04PosX);
				KK04Anzeigen.setY(KK04PosY);
				KK05Anzeigen.setX(KK05PosX);
				KK05Anzeigen.setY(KK05PosY);
				KK06Anzeigen.setX(KK06PosX);
				KK06Anzeigen.setY(KK06PosY);
				KK07Anzeigen.setX(KK07PosX);
				KK07Anzeigen.setY(KK07PosY);

				// Ziel updaten
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
					PauseTransition delay = new PauseTransition(Duration.seconds(5)); // Test f�r WinScreen
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

		animator.start();

	}

	// Keylistener
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
	// Springen falls nicht schon gesprungen wurde
	public void Spring() {
		if (Gesprungen == false) {
			TempoY = -15;
			Gesprungen = true;
		}
	}
	
	// nach Rechts bewegen
	public void Rechts() {
		TempoX = 6;
		RLN = 2;
	}
	
	// nach Links bewegen
	public void Links() {
		TempoX = -6;
		RLN = 1;
	}

	// Anhalten
	public void Halt() {
		TempoX = 0;
	}
	
	public void NeuLaden() {
		
		PosXAlt = PosX;
		if (HP == 0) {
			Verloren = true;
		}
		// Kollisiondetektion -extra-
		if (Stillstand == true) {
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
				BGPosX -= (TempoX / 2);

			}
		}
		// Hintergrund Loop
		if (BGPosX <= -2382)
			BGPosX = 0;
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
		if (GewonnenTest == 1) {
			if (RealPosX > 3000) {
				Gewonnen = true;
				GewonnenTest = 0;
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
		if (TempoX >= 0 && PosX >= 300) {
			K04PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			K05PosX -= TempoX;
		}

		// Kakteen Klein anpassen

		if (TempoX >= 0 && PosX >= 300) {
			KK01PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			KK02PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			KK03PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			KK04PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			KK05PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			KK06PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			KK07PosX -= TempoX;
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

	public void Kollisionsdetektion() throws InterruptedException {

		// Kollision mit Pyramide

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

		// Kollision mit 1. Block der 2. H�rde
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
		// Kollision mit 2. Block der 2. H�rde
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
			Gesprungen = true;

		}

		if (PosX >= B06PosX && PosX <= B06PosX + 10) {
			Speicherpunkt01 = true;

		}
		// Kollision mit 3. Block der 2. H�rde
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

		if (PosX >= B07PosX && PosX <= B07PosX + 10) {
			Speicherpunkt01 = false;
			Speicherpunkt02 = true;

		}
		// Kollision mit 4. Block der 2. H�rde
		if (PosX >= B05PosX + 510 && PosX <= B05PosX + 600 && PosY >= 113 && PosXAlt <= PosX) {
			PosX = B05PosX + 509;
			RealPosX -= 6;
		}
		if (PosX >= B05PosX + 510 && PosX <= B05PosX + 630 && PosY >= 113 && PosXAlt > PosX) {
			PosX = B05PosX + 631;
			RealPosX += 6;
		}
		if (PosX >= B05PosX + 510 && PosX <= B05PosX + 619) {
			if (PosY + TempoY >= 112) {
				PosY = 112;
				TempoY = 0;
				Gesprungen = false;
			}
		}

		if (PosX >= B06PosX + 489 && PosX <= B05PosX + 661 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B08PosX && PosX <= B08PosX + 10) {
			Speicherpunkt02 = false;
			Speicherpunkt03 = true;

		}
		// Kollision mit 5. Block der 2. H�rde
		if (PosX >= B05PosX + 650 && PosX <= B05PosX + 769 && PosY >= 183 && PosXAlt <= PosX) {
			PosX = B05PosX + 649;
			RealPosX -= 6;
		}
		if (PosX >= B05PosX + 670 && PosX <= B05PosX + 770 && PosY >= 183 && PosXAlt > PosX) {
			PosX = B05PosX + 771;
			RealPosX += 6;
		}
		if (PosX >= B05PosX + 650 && PosX <= B05PosX + 770) {
			if (PosY + TempoY >= 182) {
				PosY = 182;
				TempoY = 0;
				Gesprungen = false;
			}
		}

		if (PosX >= B06PosX + 629 && PosX <= B05PosX + 801 && Gesprungen == false) {
			PosY = 252;

		}
		if (PosX >= B09PosX && PosX <= B09PosX + 10) {
			Speicherpunkt03 = false;
			Speicherpunkt04 = true;

		}

		// Kollision mit Kakteenklein
		if (PosX >= B06PosX + 70 && PosX <= B07PosX - 50 && PosY >= 110) {

			if (TempoX >= 0) {
				RealPosX -= 6;
			}
			if (TempoX <= 0) {
				RealPosX += 6;
			}
			if (TempoX == 0) {
				// tue nichts
			}

			Stillstand = true;
			PosY += 8;
			RLN = 3;
			Gesprungen = true;

		} else {
			Stillstand = false;
		}
		if (PosX >= B07PosX + 70 && PosX <= B08PosX - 50 && PosY >= 110) {

			if (TempoX >= 0) {
				RealPosX -= 6;
			}
			if (TempoX <= 0) {
				RealPosX += 6;
			}
			if (TempoX == 0) {
				// tue nichts
			}

			Stillstand = true;
			PosY += 8;
			RLN = 3;
			Gesprungen = true;

		} else {
			Stillstand = false;
		}
		if (PosY >= 253) {
			Gefallen = true;
			Gesprungen = true;

		}
		if (Gefallen == true && Speicherpunkt01 == true) {
			PosX = B06PosX;
			PosY = 112;
			RealPosX = 1700;
			Gefallen = false;
			RLN = 0;
			Thread.sleep(200);
			HP -= 1;

		}
		if (Gefallen == true && Speicherpunkt02 == true) {
			PosX = B07PosX;
			PosY = 112;
			RealPosX = 1910;
			Gefallen = false;
			RLN = 0;
			Thread.sleep(200);
			HP -= 1;

		}
		if (Gefallen == true && Speicherpunkt03 == true) {
			PosX = B08PosX;
			PosY = 112;
			RealPosX = 2120;
			Gefallen = false;
			RLN = 0;
			Thread.sleep(200);
			HP -= 1;
		}
		if (Gefallen == true && Speicherpunkt04 == true) {
			PosX = B09PosX;
			PosY = 182;
			RealPosX = 2260;
			Gefallen = false;
			RLN = 0;
			Thread.sleep(200);
			HP -= 1;
		}
	}

}