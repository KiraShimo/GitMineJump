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
	
	// Variablen
	// Spieler und Hintergrundvariablen
	private int PosX = 120;
	private int PosXAlt = 0;
	private int PosY = 252;
	public int SPosXR = PosX + 64;
	public int SPosYH = PosY + 128;
	private int BGPosX = 0;
	private int BGPosY = -220;
	private int UPosX = 0;
	private int UPosY = 380;
	private int RLN = 0;
	private int TempoX = 0;
	private int TempoY = 0;
	private int RealPosX = 0;
	private int ZPosX01 = 2625;
	private int ZPosY01 = 166;
	private int ZPosX02 = 2625;
	private int ZPosY02 = -20;
	private int LPosX = 0;
	private int LPosY = 0;
	private int HP = 3;
	
	// Bedingungsvariablen
	private int GewonnenTest = 1;
	private boolean Gesprungen = false;
	private boolean Gewonnen = false;
	private boolean WillRaus = false;
	private boolean SpeerOben01 = true;
	private boolean SpeerOben02 = true;
	private boolean Stillstand = false;
	private boolean Verloren = false;
	private boolean Speicherpunkt01 = false;
	private boolean Speicherpunkt02 = false;
	private boolean Speicherpunkt03 = false;
	private boolean Speicherpunkt04 = false;
	private boolean Speicherpunkt05 = false;
	private boolean Speicherpunkt06 = false;
	private boolean Gefallen = false;
	private boolean Abgestochen = false;

	// Blockvariablen
	private int B00PosX = 700;
	private int B00PosY = 310;
	private int B01PosX = 840;
	private int B01PosY = 240;
	private int B02PosX = 980;
	private int B02PosY = 240;
	private int B03PosX = 1120;
	private int B03PosY = 240;
	private int B04PosX = 1330;
	private int B04PosY = 170;
	private int B05PosX = 1750;
	private int B05PosY = 240;

	// Speervariablen
	private int SP01PosX = 910;
	private int SP01PosY = 100;
	private int SP02PosX = 1050;
	private int SP02PosY = 300;
	
	// Spikevariablen
	private int SP03PosX = 1260;
	private int SP03PosY = 310;

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
		Image BT01 = new Image(Main.class.getResource("/application/ressources/pictures/ICENorm01.png").openStream());
		Image BT02 = new Image(Main.class.getResource("/application/ressources/pictures/ICEBT02.png").openStream());
		Image BT03 = new Image(Main.class.getResource("/application/ressources/pictures/ICEBT03.png").openStream());
		Image BT04 = new Image(Main.class.getResource("/application/ressources/pictures/ICEBT04.png").openStream());
		Image BT05 = new Image(Main.class.getResource("/application/ressources/pictures/ICEBT05.png").openStream());
		Image Spikes = new Image(Main.class.getResource("/application/ressources/pictures/Spikes.png").openStream());
		Image Speer = new Image(Main.class.getResource("/application/ressources/pictures/Speer01.png").openStream());
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

		// Bilder aufrufen und anzeigen
		ImageView HintergrundImageAufruf = new ImageView(HintergrundImage);
		HintergrundImageAufruf.setX(BGPosX);
		HintergrundImageAufruf.setY(BGPosY);
		rootPane.getChildren().add(HintergrundImageAufruf);

		// Speere aufrufen und anzeigen
		ImageView Speer01 = new ImageView(Speer);
		Speer01.setX(SP01PosX);
		Speer01.setY(SP01PosY);
		rootPane.getChildren().add(Speer01);

		ImageView Speer02 = new ImageView(Speer);
		Speer02.setX(SP02PosX);
		Speer02.setY(SP02PosY);
		rootPane.getChildren().add(Speer02);

		// Untergrund aufrufen und anzeigen
		ImageView UntergrundAnzeigen = new ImageView(Untergrund);
		UntergrundAnzeigen.setX(UPosX);
		UntergrundAnzeigen.setY(UPosY);
		rootPane.getChildren().add(UntergrundAnzeigen);

		// Spikes aufrufen und anzeigen
		ImageView Spikes01 = new ImageView(Spikes);
		Spikes01.setX(SP03PosX);
		Spikes01.setY(SP03PosY);
		rootPane.getChildren().add(Spikes01);

		// Bl�cke aufrufen und anzeigen
		ImageView B00Anzeigen = new ImageView(BT01);
		B00Anzeigen.setX(B00PosX);
		B00Anzeigen.setY(B00PosX);
		rootPane.getChildren().add(B00Anzeigen);

		ImageView B01Anzeigen = new ImageView(BT02);
		B01Anzeigen.setX(B01PosX);
		B01Anzeigen.setY(B01PosX);
		rootPane.getChildren().add(B01Anzeigen);

		ImageView B02Anzeigen = new ImageView(BT02);
		B02Anzeigen.setX(B02PosX);
		B02Anzeigen.setY(B02PosX);
		rootPane.getChildren().add(B02Anzeigen);

		ImageView B03Anzeigen = new ImageView(BT03);
		B03Anzeigen.setX(B03PosX);
		B03Anzeigen.setY(B03PosX);
		rootPane.getChildren().add(B03Anzeigen);

		ImageView B04Anzeigen = new ImageView(BT04);
		B04Anzeigen.setX(B04PosX);
		B04Anzeigen.setY(B04PosX);
		rootPane.getChildren().add(B04Anzeigen);

		ImageView B05Anzeigen = new ImageView(BT05);
		B05Anzeigen.setX(B05PosX);
		B05Anzeigen.setY(B05PosX);
		rootPane.getChildren().add(B05Anzeigen);

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

		AnimationTimer Spielschleife = new AnimationTimer() {
			
			// Spielschleife
			@Override
			public void handle(long arg0) {

				try {
					Kollisionsdetektion();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				NeuLaden();

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
				B00Anzeigen.setX(B00PosX);
				B00Anzeigen.setY(B00PosY);
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

				// Speere updaten
				Speer01.setX(SP01PosX);
				Speer01.setY(SP01PosY);
				Speer02.setX(SP02PosX);
				Speer02.setY(SP02PosY);

				// Spikes updaten
				Spikes01.setX(SP03PosX);
				Spikes01.setY(SP03PosY);

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

	// Springen solange nicht schon gesprungen wird
	public void Spring() {
		if (Gesprungen == false) {
			TempoY = -15;
			Gesprungen = true;
		}
	}

	// nach rechts gehen
	public void Rechts() {
		TempoX = 6;
		RLN = 2;
	}

	// nach Links gehen
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
		if (BGPosX <= -2880)
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
			if (RealPosX > 2700) {
				Gewonnen = true;
				GewonnenTest = 0;
				RealPosX = 0;
			}
		}
		// BlockPositionen anpassen
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B00PosX -= TempoX;
		}
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

		// Ziel anpassen
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				ZPosX01 -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				ZPosX02 -= TempoX;
		}

		// Speerpositionen anpassen
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				SP01PosX -= TempoX;
		}
		if (SP01PosY <= 310 && SpeerOben01 == false && SP01PosY >= 100) {
			SP01PosY -= 1;
			if (SP01PosY <= 100) {
				SpeerOben01 = true;
			}
		}
		if (SP01PosY >= 100 && SpeerOben01 == true && SP01PosY <= 310) {
			SP01PosY += 1;
			if (SP01PosY >= 310) {
				SpeerOben01 = false;
			}

		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				SP02PosX -= TempoX;
		}
		if (SP02PosY <= 310 && SpeerOben02 == false && SP02PosY >= 100) {
			SP02PosY -= 1;
			if (SP02PosY <= 100) {
				SpeerOben02 = true;
			}
		}
		if (SP02PosY >= 100 && SpeerOben02 == true && SP02PosY <= 310) {
			SP02PosY += 1;
			if (SP02PosY >= 310) {
				SpeerOben02 = false;
			}
		}
		// Spikes anpassen
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				SP03PosX -= TempoX;
		}
	}

	public void Kollisionsdetektion() throws InterruptedException {
		
		// Pause wenn Schaden
		PauseTransition pause = new PauseTransition(Duration.seconds(1));

		// Kollision mit 1. Block (B00)
		if (PosX >= B00PosX - 50 && PosX <= B00PosX + 65 && PosY >= 183 && PosXAlt <= PosX) {
			PosX = B00PosX - 53;
			RealPosX -= 6;
		}
		if (PosX >= B00PosX - 50 && PosX <= B00PosX + 65 && PosY >= 183 && PosXAlt > PosX) {
			PosX = B00PosX + 66;
			RealPosX += 6;
		}
		if (PosX >= B00PosX - 50 && PosX <= B00PosX + 65) {
			if (PosY + TempoY >= 182) {
				PosY = 182;
				TempoY = 0;
				Gesprungen = false;
			}
		}
		if (PosX <= B00PosX - 65 && Gesprungen == false) {
			Gesprungen = true;

		}
		if (PosX >= B00PosX + 70 && PosX <= B00PosX + 80 && Gesprungen == false) {
			Gesprungen = true;

		}
		
		// Kollision mit 2.Block (B01)
		if (PosX >= B01PosX - 50 && PosX <= B01PosX + 70 && PosY >= 115 && PosXAlt <= PosX) {
			PosX = B01PosX - 51;
			RealPosX -= 6;
		}
		if (PosX >= B01PosX - 50 && PosX <= B01PosX + 70 && PosY >= 115 && PosXAlt > PosX) {
			PosX = B01PosX + 71;
			RealPosX += 6;
		}

		if (PosX >= B01PosX - 50 && PosX <= B01PosX + 70) {
			if (PosY + TempoY >= 112) {
				PosY = 112;
				TempoY = 0;
				Gesprungen = false;
			}
		}

		if (PosX >= B01PosX + 70 && PosX <= B01PosX + 90 && Gesprungen == false) {
			Gesprungen = true;

		}
		if (PosX >= B01PosX && PosX <= B01PosX + 10) {
			Speicherpunkt01 = true;
		}

		// Kollision mit 3.Block (B02)
		if (PosX >= B02PosX - 50 && PosX <= B02PosX + 70 && PosY >= 115 && PosXAlt <= PosX) {
			PosX = B02PosX - 51;
			RealPosX -= 6;
		}
		if (PosX >= B02PosX - 50 && PosX <= B02PosX + 70 && PosY >= 115 && PosXAlt > PosX) {
			PosX = B02PosX + 71;
			RealPosX += 6;
		}

		if (PosX >= B02PosX - 50 && PosX <= B02PosX + 70) {
			if (PosY + TempoY >= 112) {
				PosY = 112;
				TempoY = 0;
				Gesprungen = false;
			}
		}

		if (PosX >= B02PosX + 70 && PosX <= B02PosX + 90 && Gesprungen == false) {
			Gesprungen = true;

		}
		if (PosX >= B02PosX && PosX <= B02PosX + 10) {
			Speicherpunkt01 = false;
			Speicherpunkt02 = true;

		}

		// Kollision mit 4.Block (B03)
		if (PosX >= B03PosX - 50 && PosX <= B03PosX + 140) {
			if (PosY + TempoY >= 112) {
				PosY = 112;
				TempoY = 0;
				Gesprungen = false;
			}
		}

		if (PosX >= B03PosX + 135 && PosX <= B03PosX + 160 && Gesprungen == false) {
			Gesprungen = true;

		}
		if (PosX >= B03PosX && PosX <= B03PosX + 10) {
			Speicherpunkt02 = false;
			Speicherpunkt03 = true;

		}

		// Kollision mit 5.Block (B04)
		if (PosX >= B04PosX - 60 && PosX <= B04PosX + 210 && PosY >= 45 && PosY <= 181 && PosXAlt <= PosX) {
			PosX = B04PosX - 61;
			RealPosX -= 6;
		}
		if (PosX >= B04PosX - 20 && PosX <= B04PosX + 210 && PosY >= 45 && PosY <= 181 && PosXAlt > PosX) {
			PosX = B04PosX + 211;
			RealPosX += 6;
		}

		if (PosX >= B04PosX - 50 && PosX <= B04PosX + 210 && PosY <= 111) {
			if (PosY + TempoY >= 44) {
				PosY = 44;
				TempoY = 0;
				Gesprungen = false;
			}
		}

		if (PosX >= B04PosX + 210 && PosX <= B04PosX + 380 && Gesprungen == false) {
			Gesprungen = true;

		}
		if (PosX >= B04PosX && PosX <= B04PosX + 10) {
			Speicherpunkt03 = false;
			Speicherpunkt04 = true;

		}
		if (PosX >= B04PosX + 140 && PosX <= B04PosX + 150) {
			Speicherpunkt04 = false;
			Speicherpunkt05 = true;

		}

		// Kollision mit 6.Block (B05)
		if (PosX >= B05PosX - 40 && PosX <= B05PosX + 70 && PosY >= 115 && PosXAlt <= PosX) {
			PosX = B05PosX - 51;
			RealPosX -= 6;
		}
		if (PosX >= B05PosX - 30 && PosX <= B05PosX + 70 && PosY >= 120 && PosXAlt > PosX) {
			PosX = B05PosX + 71;
			RealPosX += 6;
		}

		if (PosX >= B05PosX - 50 && PosX <= B05PosX + 70) {
			if (PosY + TempoY >= 112) {
				PosY = 112;
				TempoY = 0;
				Gesprungen = false;
			}
		}

		if (PosX >= B05PosX + 70 && PosX <= B05PosX + 85 && Gesprungen == false) {
			PosY = 182;

		}
		if (PosX >= B05PosX && PosX <= B05PosX + 10) {
			Speicherpunkt05 = false;
			Speicherpunkt06 = true;

		}

		if (PosX >= B05PosX + 20 && PosX <= B05PosX + 135 && PosY >= 183 && PosXAlt > PosX) {
			PosX = B05PosX + 136;
			RealPosX += 6;
		}
		if (PosX >= B05PosX + 20 && PosX <= B05PosX + 130) {
			if (PosY + TempoY >= 182) {
				PosY = 182;
				TempoY = 0;
				Gesprungen = false;
			}
		}

		if (PosX >= B05PosX + 140 && PosX <= B05PosX + 150 && Gesprungen == false) {
			PosY = 252;

		}

		// Kollisionen mit Schadensfolgen Spikes
		if (PosX >= B03PosX + 136 && PosX <= B04PosX && PosY >= 200) {

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
			pause.play();

		} else {
			Stillstand = false;
		}
		if (PosX >= B04PosX + 1 && PosX <= B05PosX && PosY >= 150) {

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
			pause.play();

		} else {
			Stillstand = false;
		}
		if (PosY >= 253) {
			Gefallen = true;
			Gesprungen = true;

		}
		if (Gefallen == true && Speicherpunkt03 == true) {
			RLN = 0;
			PosX = B03PosX;
			PosY = 112;
			RealPosX = 1120;
			Gefallen = false;
			HP -= 1;
		}
		if (Gefallen == true && Speicherpunkt04 == true) {
			PosX = B04PosX;
			PosY = 42;
			RealPosX = 1330;
			Gefallen = false;
			RLN = 0;
			HP -= 1;
		}
		if (Gefallen == true && Speicherpunkt05 == true) {
			PosX = B04PosX + 140;
			PosY = 42;
			RealPosX = 1470;
			Gefallen = false;
			RLN = 0;
			HP -= 1;
		}
		if (Gefallen == true && Speicherpunkt06 == true) {
			PosX = B05PosX;
			PosY = 112;
			RealPosX = 1750;
			Gefallen = false;
			RLN = 0;
			HP -= 1;
		}

		// Kollision mit Speeren
		if (PosX >= B01PosX + 70 && PosX <= B02PosX - 20 && PosY >= SP01PosY - 130
				|| PosX >= B02PosX + 70 && PosX <= B03PosX - 20 && PosY >= SP02PosY - 130
				|| PosX + 20 >= B01PosX + 70 && PosX + 20 <= B02PosX - 20 && PosY >= SP01PosY - 130
				|| PosX + 20 >= B02PosX + 70 && PosX + 20 <= B03PosX - 20 && PosY >= SP02PosY - 130) {

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
			RLN = 3;
			Gesprungen = true;
			Abgestochen = true;
			pause.play();

		} else {
			Stillstand = false;
		}

		if (Abgestochen == true && Speicherpunkt01 == true) {
			PosX = B01PosX - 30;
			PosY = 80;
			RealPosX = 840;
			Abgestochen = false;
			RLN = 0;
			HP -= 1;
		}

		if (Abgestochen == true && Speicherpunkt02 == true) {
			PosX = B02PosX + 5;
			PosY = 80;
			RealPosX = 985;
			Abgestochen = false;
			RLN = 3;
			HP -= 1;
		}

		// Zielkollision mit Burg
		if (RealPosX >= 2550) {
			if (PosY <= 220) {
				PosY = 221;
			}
		}

	}

}
