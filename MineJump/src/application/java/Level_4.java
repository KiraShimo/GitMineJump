package application.java;

import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level_4 {

	// Variablen
	// Spieler und Hintergrundvariablen
	private int PosX = 120;
	private int PosXAlt = 0;
	private int PosY = 252;
	public int SPosXR = PosX + 64;
	public int SPosYH = PosY + 128;
	private int BGPosX = 0;
	private int BGPosY = -100;
	private int UPosX = 0;
	private int UPosY = 380;
	private int RLN = 0;
	private int TempoX = 0;
	private int TempoY = 0;
	private int RealPosX = 0;
	private int ZPosX01 = 2425;
	private int ZPosY01 = 166;
	private int ZPosX02 = 2425;
	private int ZPosY02 = -20;
	private int LPosX = 0;
	private int LPosY = 0;
	private int HP = 3;

	// Bedingungsvariablen
	private int GewonnenTest = 1;
	private boolean Gesprungen = false;
	private boolean Gewonnen = false;
	private boolean Exit = false;
	private boolean Gefallen = false;
	private boolean Stillstand = false;
	private boolean Speicherpunkt01 = false;
	private boolean Speicherpunkt02 = false;
	private boolean Speicherpunkt03 = false;
	private boolean Verloren = false;
	private boolean Interaction = false;
	private boolean Haltzustand02 = false;
	private boolean Wasserfall = false;
	private boolean WasserFaellt = false;
	private boolean WasserBewegung01 = false;
	private boolean WasserBewegung02 = false;
	private boolean Obsidian = false;
	private boolean Check = false;
	private boolean Abbruch = false;;

	// Blockvariablen
	private int B01PosX = 500;
	private int B01PosY = 310;
	private int B02PosX = 1000;
	private int B02PosY = 310;
	private int B03PosX = 1400;
	private int B03PosY = 310;
	private int B04PosX = 1750;
	private int B04PosY = 310;

	// Lavavariablen
	private int L01PosX = 1470;
	private int L01PosY = 310;
	private int L02PosX = 1540;
	private int L02PosY = 310;
	private int L03PosX = 1610;
	private int L03PosY = 310;
	private int L04PosX = 1680;
	private int L04PosY = 310;

	// Wassertankvariablen
	private int W01PosX = 1400;
	private int W01PosY = -20;
	private int W02PosX = 1400;
	private int W02PosY = 50;
	private int W03PosX = 1470;
	private int W03PosY = 50;
	private int W04PosX = 1540;
	private int W04PosY = 50;
	private int W05PosX = 1610;
	private int W05PosY = 50;
	private int W06PosX = 1680;
	private int W06PosY = 50;
	private int W07PosX = 1750;
	private int W07PosY = 50;
	private int W08PosX = 1750;
	private int W08PosY = -20;

	// Wasservariablen
	private int WA01PosX = 1470;
	private int WA01PosY = -20;
	private int WA02PosX = 1540;
	private int WA02PosY = -20;
	private int WA03PosX = 1610;
	private int WA03PosY = -20;
	private int WA04PosX = 1680;
	private int WA04PosY = -20;

	// Schaltervariablen
	private int H01PosX = 1330;
	private int H01PosY = 310;

	// Tutorialtext
	private int T01PosX = 1300;
	private int T01PosY = 250;
	private String T01Text = "Um mit einem Hebel zu interagieren\ndrücken Sie 'E' oder 'ENTER'.";

	// Gegnervariablen
	private int E01PosX = 750;
	private int E01StartX = 750;
	private int E01PosY = 250;
	private boolean V01 = false;

	public void spiel(Stage primaryStage) throws IOException {

		// Spiel initialisieren
		Pane RootPane;
		
		// Erstellt das Neue RootPane
		RootPane = new Pane();

		// Bilder einbinden
		Image SpielerRechts = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Rechts.png").openStream());
		Image SpielerLinks = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Links.png").openStream());
		Image SpielerSchaden = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Vorne_Schaden.png").openStream());
		Image HintergrundImage = new Image(
				Main.class.getResource("/application/ressources/pictures/Level_4_BG.png").openStream());
		Image Untergrund = new Image(
				Main.class.getResource("/application/ressources/pictures/Level_4_UG.png").openStream());
		Image Ziel01BG = new Image(Main.class.getResource("/application/ressources/pictures/Ziel01.png").openStream());
		Image SpielerBild = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Vorne.png").openStream());
		Image Ziel02VG = new Image(Main.class.getResource("/application/ressources/pictures/Ziel02.png").openStream());
		Image Leben3 = new Image(Main.class.getResource("/application/ressources/pictures/Herz03f.png").openStream());
		Image Leben2 = new Image(Main.class.getResource("/application/ressources/pictures/Herz02f.png").openStream());
		Image Leben1 = new Image(Main.class.getResource("/application/ressources/pictures/Herz01f.png").openStream());
		Image B01 = new Image(Main.class.getResource("/application/ressources/pictures/Level_4_B03.png").openStream());
		Image L01 = new Image(Main.class.getResource("/application/ressources/pictures/Lava.png").openStream());
		Image B02 = new Image(Main.class.getResource("/application/ressources/pictures/Level_4_B02.png").openStream());
		Image B03 = new Image(Main.class.getResource("/application/ressources/pictures/Level_4_B03.png").openStream());
		Image E01 = new Image(Main.class.getResource("/application/ressources/pictures/Level_4 _E01.png").openStream());
		Image H01 = new Image(Main.class.getResource("/application/ressources/pictures/Hebel_An.png").openStream());
		Image H02 = new Image(Main.class.getResource("/application/ressources/pictures/Hebel_aus.png").openStream());
		Image WA01 = new Image(Main.class.getResource("/application/ressources/pictures/Wasser.png").openStream());

		// Bilder aufrufen und anzeigen
		// Hintergrund / Untergrund aufrufen und anzeigen
		ImageView HintergrundImageAufruf = new ImageView(HintergrundImage);
		HintergrundImageAufruf.setX(BGPosX);
		HintergrundImageAufruf.setY(BGPosY);
		RootPane.getChildren().add(HintergrundImageAufruf);

		ImageView UntergrundAnzeigen = new ImageView(Untergrund);
		UntergrundAnzeigen.setX(UPosX);
		UntergrundAnzeigen.setY(UPosY);
		RootPane.getChildren().add(UntergrundAnzeigen);

		// Blöcke aufrufen und anzeigen
		ImageView B01_Anzeigen = new ImageView(B01);
		B01_Anzeigen.setX(B01PosX);
		B01_Anzeigen.setY(B01PosY);
		RootPane.getChildren().add(B01_Anzeigen);
		ImageView B02_Anzeigen = new ImageView(B01);
		B02_Anzeigen.setX(B02PosX);
		B02_Anzeigen.setY(B02PosY);
		RootPane.getChildren().add(B02_Anzeigen);
		ImageView B03_Anzeigen = new ImageView(B02);
		B03_Anzeigen.setX(B03PosX);
		B03_Anzeigen.setY(B03PosY);
		RootPane.getChildren().add(B03_Anzeigen);
		ImageView B04_Anzeigen = new ImageView(B02);
		B04_Anzeigen.setX(B04PosX);
		B04_Anzeigen.setY(B04PosY);
		RootPane.getChildren().add(B04_Anzeigen);

		// Wassertank aufrufen und anzeigen
		ImageView W01_Anzeigen = new ImageView(B03);
		W01_Anzeigen.setX(W01PosX);
		W01_Anzeigen.setY(W01PosY);
		RootPane.getChildren().add(W01_Anzeigen);
		ImageView W02_Anzeigen = new ImageView(B03);
		W02_Anzeigen.setX(W02PosX);
		W02_Anzeigen.setY(W02PosY);
		RootPane.getChildren().add(W02_Anzeigen);
		ImageView W03_Anzeigen = new ImageView(B03);
		W03_Anzeigen.setX(W03PosX);
		W03_Anzeigen.setY(W03PosY);
		RootPane.getChildren().add(W03_Anzeigen);
		ImageView W04_Anzeigen = new ImageView(B03);
		W04_Anzeigen.setX(W03PosX);
		W04_Anzeigen.setY(W03PosY);
		RootPane.getChildren().add(W04_Anzeigen);
		ImageView W05_Anzeigen = new ImageView(B03);
		W05_Anzeigen.setX(W05PosX);
		W05_Anzeigen.setY(W05PosY);
		RootPane.getChildren().add(W05_Anzeigen);
		ImageView W06_Anzeigen = new ImageView(B03);
		W06_Anzeigen.setX(W06PosX);
		W06_Anzeigen.setY(W06PosY);
		RootPane.getChildren().add(W06_Anzeigen);
		ImageView W07_Anzeigen = new ImageView(B03);
		W07_Anzeigen.setX(W07PosX);
		W07_Anzeigen.setY(W07PosY);
		RootPane.getChildren().add(W07_Anzeigen);
		ImageView W08_Anzeigen = new ImageView(B03);
		W08_Anzeigen.setX(W08PosX);
		W08_Anzeigen.setY(W08PosY);
		RootPane.getChildren().add(W08_Anzeigen);

		// Wasser aufrufen und anzeigen
		ImageView WA01_Anzeigen = new ImageView(WA01);
		WA01_Anzeigen.setX(WA01PosX);
		WA01_Anzeigen.setY(WA01PosY);
		RootPane.getChildren().add(WA01_Anzeigen);
		ImageView WA02_Anzeigen = new ImageView(WA01);
		WA02_Anzeigen.setX(WA02PosX);
		WA02_Anzeigen.setY(WA02PosY);
		RootPane.getChildren().add(WA02_Anzeigen);
		ImageView WA03_Anzeigen = new ImageView(WA01);
		WA03_Anzeigen.setX(WA03PosX);
		WA03_Anzeigen.setY(WA03PosY);
		RootPane.getChildren().add(WA03_Anzeigen);
		ImageView WA04_Anzeigen = new ImageView(WA01);
		WA04_Anzeigen.setX(WA04PosX);
		WA04_Anzeigen.setY(WA04PosY);
		RootPane.getChildren().add(WA04_Anzeigen);

		// Lava aufrufen und anzeigen
		ImageView L01_Anzeigen = new ImageView(L01);
		L01_Anzeigen.setX(L01PosX);
		L01_Anzeigen.setY(L01PosY);
		RootPane.getChildren().add(L01_Anzeigen);
		ImageView L02_Anzeigen = new ImageView(L01);
		L02_Anzeigen.setX(L02PosX);
		L02_Anzeigen.setY(L02PosY);
		RootPane.getChildren().add(L02_Anzeigen);
		ImageView L03_Anzeigen = new ImageView(L01);
		L03_Anzeigen.setX(L03PosX);
		L03_Anzeigen.setY(L03PosY);
		RootPane.getChildren().add(L03_Anzeigen);
		ImageView L04_Anzeigen = new ImageView(L01);
		L04_Anzeigen.setX(L04PosX);
		L04_Anzeigen.setY(L04PosY);
		RootPane.getChildren().add(L04_Anzeigen);

		// Gegner aufrufen und anzeigen
		ImageView E01_Anzeigen = new ImageView(E01);
		E01_Anzeigen.setX(E01PosX);
		E01_Anzeigen.setY(E01PosY);
		RootPane.getChildren().add(E01_Anzeigen);

		// Hebel aufrufen und anzeigen
		ImageView H01_Anzeigen = new ImageView(H02);
		H01_Anzeigen.setX(H01PosX);
		H01_Anzeigen.setY(H01PosY);
		RootPane.getChildren().add(H01_Anzeigen);

		// Tutorialtext aufrufen und anzeigen
		Text text = new Text();
		text.setFont(new Font(18));
		text.setX(T01PosX);
		text.setY(T01PosY);
		text.setText(T01Text);
		text.setFill(Color.WHITE);
		RootPane.getChildren().add(text);

		// Ziel hinten aufrufen und anzeigen
		ImageView Ziel01BGAnzeiger = new ImageView(Ziel01BG);
		Ziel01BGAnzeiger.setX(ZPosX01);
		Ziel01BGAnzeiger.setY(ZPosY01);
		RootPane.getChildren().add(Ziel01BGAnzeiger);

		// Spieler aufrufen und anzeigen
		ImageView Bildaufruf = new ImageView(SpielerBild);
		Bildaufruf.setX(PosX);
		Bildaufruf.setY(PosY);
		RootPane.getChildren().add(Bildaufruf);

		// ZielVorne aufrufen und anzeigen
		ImageView Ziel02VGAnzeiger = new ImageView(Ziel02VG);
		Ziel02VGAnzeiger.setX(ZPosX02);
		Ziel02VGAnzeiger.setY(ZPosY02);
		RootPane.getChildren().add(Ziel02VGAnzeiger);

		// Leben aufrufen und anzeigen
		ImageView LebenAnzeiger = new ImageView(Leben3);
		LebenAnzeiger.setX(LPosX);
		LebenAnzeiger.setY(LPosY);
		RootPane.getChildren().add(LebenAnzeiger);

		Scene game = new Scene(RootPane);

		final Box Listener = new Box();
		Listener.setFocusTraversable(true);
		Listener.requestFocus();
		Listener.setOnKeyPressed(keyEventHandler);
		Listener.setOnKeyReleased(TasteLoslassen);

		RootPane.getChildren().add(Listener);

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
				if (Haltzustand02 == true) {
					H01_Anzeigen.setImage(H01);
				}

				// Ziel updaten
				Ziel01BGAnzeiger.setX(ZPosX01);
				Ziel02VGAnzeiger.setX(ZPosX02);

				// Blöcke updaten
				B01_Anzeigen.setX(B01PosX);
				B01_Anzeigen.setY(B01PosY);
				B02_Anzeigen.setX(B02PosX);
				B02_Anzeigen.setY(B02PosY);
				B03_Anzeigen.setX(B03PosX);
				B03_Anzeigen.setY(B03PosY);
				B04_Anzeigen.setX(B04PosX);
				B04_Anzeigen.setY(B04PosY);

				// Wassertank updaten
				W01_Anzeigen.setX(W01PosX);
				W01_Anzeigen.setY(W01PosY);
				W02_Anzeigen.setX(W02PosX);
				W02_Anzeigen.setY(W02PosY);
				W03_Anzeigen.setX(W03PosX);
				W03_Anzeigen.setY(W03PosY);
				W04_Anzeigen.setX(W04PosX);
				W04_Anzeigen.setY(W04PosY);
				W05_Anzeigen.setX(W05PosX);
				W05_Anzeigen.setY(W05PosY);
				W06_Anzeigen.setX(W06PosX);
				W06_Anzeigen.setY(W06PosY);
				W07_Anzeigen.setX(W07PosX);
				W07_Anzeigen.setY(W07PosY);
				W08_Anzeigen.setX(W08PosX);
				W08_Anzeigen.setY(W08PosY);

				if (Wasserfall == true) {
					W04_Anzeigen.setImage(null);
					W05_Anzeigen.setImage(null);
					WasserFaellt = true;
				}

				// Wasser updaten
				WA01_Anzeigen.setX(WA01PosX);
				WA01_Anzeigen.setY(WA01PosY);
				WA02_Anzeigen.setX(WA02PosX);
				WA02_Anzeigen.setY(WA02PosY);
				WA03_Anzeigen.setX(WA03PosX);
				WA03_Anzeigen.setY(WA03PosY);
				WA04_Anzeigen.setX(WA04PosX);
				WA04_Anzeigen.setY(WA04PosY);

				// Lava updaten
				L01_Anzeigen.setX(L01PosX);
				L01_Anzeigen.setY(L01PosY);
				L02_Anzeigen.setX(L02PosX);
				L02_Anzeigen.setY(L02PosY);
				L03_Anzeigen.setX(L03PosX);
				L03_Anzeigen.setY(L03PosY);  
				L04_Anzeigen.setX(L04PosX);
				L04_Anzeigen.setY(L04PosY);

				if (Obsidian == true) {
					L01_Anzeigen.setImage(B02);
					L02_Anzeigen.setImage(B02);
					L03_Anzeigen.setImage(B02);
					L04_Anzeigen.setImage(B02);

					WA01_Anzeigen.setImage(null);
					WA02_Anzeigen.setImage(null);
					WA03_Anzeigen.setImage(null);
					WA04_Anzeigen.setImage(null);

					Wasserfall = false;
				}

				// Gegner updaten
				E01_Anzeigen.setX(E01PosX);
				E01_Anzeigen.setY(E01PosY);

				// Hebel updaten
				H01_Anzeigen.setX(H01PosX);
				H01_Anzeigen.setY(H01PosY);

				text.setX(T01PosX);

				Menu menu = new Menu();

				// Gewonnen test / ESC test
				if (Gewonnen == true && Abbruch == false) {
					Gewonnen = false;
					Exit = false;
					Gefallen = false;
					GewonnenTest = 1;
					Stillstand = false;
					Speicherpunkt01 = false;
					Speicherpunkt02 = false;
					Speicherpunkt03 = false;
					Verloren = false;
					Interaction = false;
					Haltzustand02 = false;
					Wasserfall = false;
					WasserFaellt = false;
					WasserBewegung01 = false;
					WasserBewegung02 = false;
					Obsidian = false;
					Check = false;
					Abbruch = true;
					RealPosX = 0;
					menu.win(primaryStage);
					PauseTransition delay = new PauseTransition(Duration.seconds(5));
					delay.setOnFinished(event -> menu.level(primaryStage));
					delay.play();
				}
				if (Exit == true && Abbruch == false) {

					Gewonnen = false;
					Exit = false;
					Gefallen = false;
					GewonnenTest = 1;
					Stillstand = false;
					Speicherpunkt01 = false;
					Speicherpunkt02 = false;
					Speicherpunkt03 = false;
					Verloren = false;
					Interaction = false;
					Haltzustand02 = false;
					Wasserfall = false;
					WasserFaellt = false;
					WasserBewegung01 = false;
					WasserBewegung02 = false;
					Obsidian = false;
					Check = false;
					RealPosX = 0;
					PosX = 0;
					TempoX = 0;
					Abbruch = true;
					menu.level(primaryStage);
				}
				if (Verloren == true && Abbruch == false) {
					Gewonnen = false;
					Exit = false;
					Gefallen = false;
					GewonnenTest = 1;
					Stillstand = false;
					Speicherpunkt01 = false;
					Speicherpunkt02 = false;
					Speicherpunkt03 = false;
					Verloren = false;
					Interaction = false;
					Haltzustand02 = false;
					Wasserfall = false;
					WasserFaellt = false;
					WasserBewegung01 = false;
					WasserBewegung02 = false;
					Obsidian = false;
					Check = false;
					RealPosX = 0;
					PosX = 0;
					TempoX = 0;
					HP = 3;
					Abbruch = true;
					menu.level(primaryStage);
				}
			}
		};

		Spielschleife.start();

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
			case I:
				Interaction = true;
				break;
			case E:
				Interaction = true;
				break;
			case ENTER:
				Interaction = true;
				break;
			case ESCAPE:
				Exit = true;
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
				Halt();
				break;
			case W:
				Halt();
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
			case I:
				Interaction = false;
				break;
			case E:
				Interaction = false;
				break;
			case ENTER:
				Interaction = false;
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
		if (Wasserfall == false) {
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
				if (RealPosX > 2500) {
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
			// Wassertank anpassen

			if (TempoX >= 0 && PosX >= 300) {
				W01PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				W02PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				W03PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				W04PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				W05PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				W06PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				W07PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				W08PosX -= TempoX;
			}
			// Wasser anpassen

			if (TempoX >= 0 && PosX >= 300) {
				WA01PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				WA02PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				WA03PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				WA04PosX -= TempoX;
			}
			// Lava anpassen
			if (TempoX >= 0 && PosX >= 300) {
				L01PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				L02PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				L03PosX -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				L04PosX -= TempoX;
			}
			// GegnerPosition anpassen

			if (TempoX >= 0 && PosX >= 300) {
				E01PosX -= TempoX;
				E01StartX -= TempoX;
			}
			if (V01 == false) {
				E01PosX -= 3;
				if (E01PosX < E01StartX - 180) {
					V01 = true;
				}
			}
			if (V01 == true) {
				E01PosX += 3;
				if (E01PosX > E01StartX + 180) {
					V01 = false;
				}
			}

			// Hebel anpassen
			if (TempoX >= 0 && PosX >= 300) {
				H01PosX -= TempoX;
			}

			// Text anpassen

			if (TempoX >= 0 && PosX >= 300) {
				T01PosX -= TempoX;
			}

			// Ziel anpassen

			if (TempoX >= 0 && PosX >= 300) {
				ZPosX01 -= TempoX;
			}
			if (TempoX >= 0 && PosX >= 300) {
				ZPosX02 -= TempoX;
			}
		}
	}

	public void Kollisionsdetektion() throws InterruptedException {

		PauseTransition pause = new PauseTransition(Duration.seconds(1));

		// Kollision mit B01
		if (PosX >= B01PosX - 64 && PosX <= B01PosX + 69 && PosY >= 183 && PosXAlt <= PosX) {
			PosX = B01PosX - 53;
			RealPosX -= 6;
		}
		if (PosX >= B01PosX - 30 && PosX <= B01PosX + 70 && PosY >= 183 && PosXAlt >= PosX) {
			PosX = B01PosX + 71;
			RealPosX += 6;
		}

		if (PosX >= B01PosX - 49 && PosX <= B01PosX + 70) {
			if (PosY + TempoY >= 182) {
				PosY = 182;
				TempoY = 0;
				Gesprungen = false;
			}
		}
		if (PosX <= B01PosX - 65 && Gesprungen == false) {
			Gesprungen = true;
		}
		if (PosX >= B01PosX + 70 && PosX <= B01PosX + 80 && Gesprungen == false) {
			Gesprungen = true;

		}
		// Kollision mit B02
		if (PosX >= B02PosX - 64 && PosX <= B02PosX + 69 && PosY >= 183 && PosXAlt <= PosX) {
			PosX = B02PosX - 53;
			RealPosX -= 6;
		}
		if (PosX >= B02PosX - 30 && PosX <= B02PosX + 70 && PosY >= 183 && PosXAlt >= PosX) {
			PosX = B02PosX + 71;
			RealPosX += 6;
		}

		if (PosX >= B02PosX - 49 && PosX <= B02PosX + 70) {
			if (PosY + TempoY >= 182) {
				PosY = 182;
				TempoY = 0;
				Gesprungen = false;
			}
		}
		if (PosX >= B02PosX - 70 && PosX <= B02PosX - 65 && Gesprungen == false) {
			Gesprungen = true;
		}
		if (PosX >= B02PosX + 70 && PosX <= B02PosX + 80 && Gesprungen == false) {
			Gesprungen = true;

		}

		// Kollision mit B03

		if (PosX >= B03PosX - 64 && PosX <= B03PosX + 69 && PosY >= 183 && PosXAlt <= PosX) {
			PosX = B03PosX - 53;
			RealPosX -= 6;
		}
		if (PosX >= B03PosX - 30 && PosX <= B03PosX + 70 && PosY >= 183 && PosXAlt >= PosX) {
			PosX = B03PosX + 71;
			RealPosX += 6;
		}

		if (PosX >= B03PosX - 49 && PosX <= B03PosX + 70) {
			if (PosY + TempoY >= 182) {
				PosY = 182;
				TempoY = 0;
				Gesprungen = false;
			}
		}
		if (PosX >= B03PosX - 70 && PosX <= B03PosX - 65 && Gesprungen == false) {
			Gesprungen = true;
		}
		if (PosX >= B03PosX + 70 && PosX <= B03PosX + 80 && Gesprungen == false) {
			Gesprungen = true;

		}
		if (PosX >= B03PosX && PosX <= B03PosX + 20) {
			Speicherpunkt02 = true;
		}
		// Kollision mit B04

		if (PosX >= B04PosX - 64 && PosX <= B04PosX + 69 && PosY >= 183 && PosXAlt <= PosX) {
			PosX = B04PosX - 53;
			RealPosX -= 6;
		}
		if (PosX >= B04PosX - 30 && PosX <= B04PosX + 70 && PosY >= 183 && PosXAlt >= PosX) {
			PosX = B04PosX + 71;
			RealPosX += 6;
		}

		if (PosX >= B04PosX - 49 && PosX <= B04PosX + 70) {
			if (PosY + TempoY >= 182) {
				PosY = 182;
				TempoY = 0;
				Gesprungen = false;
			}
		}
		if (PosX >= B04PosX - 70 && PosX <= B04PosX - 65 && Gesprungen == false) {
			Gesprungen = true;
		}
		if (PosX >= B04PosX + 70 && PosX <= B04PosX + 80 && Gesprungen == false) {
			Gesprungen = true;

		}

		if (PosX >= B04PosX && PosX <= B04PosX + 20) {
			RealPosX = 1650;
			Speicherpunkt02 = false;
			Speicherpunkt03 = true;
		}
		// Kollision mit Gegner
		Timeline Timer = new Timeline(new KeyFrame(Duration.millis(2500), ae -> Flag()));
		if (Check == true && Speicherpunkt01 == true) {
			Timer.play();
			Check = false;
		}

		if (PosX >= E01PosX - 64 && PosX <= E01PosX + 69 && PosY >= 153 && PosXAlt <= PosX
				&& Speicherpunkt01 == false) {
			PosX = E01PosX - 53;
			Gefallen = true;
			Speicherpunkt01 = true;

		}
		if (PosX >= E01PosX - 30 && PosX <= E01PosX + 70 && PosY >= 153 && PosXAlt >= PosX
				&& Speicherpunkt01 == false) {
			PosX = E01PosX + 71;
			Gefallen = true;
			Speicherpunkt01 = true;

		}

		if (Gefallen == true && Speicherpunkt01 == true) {
			Gefallen = false;
			RLN = 3;
			Thread.sleep(200);
			HP -= 1;
			Check = true;
		}

		// Interaktion mit dem Hebel
		if (PosX >= B03PosX - 140 && PosX <= B03PosX - 20 && Interaction == true) {
			Haltzustand02 = true;
			Wasserfall = true;
		}
		if (WasserFaellt == true) {
			if (WA02PosY <= 260) {
				WA02PosY += 8;
			}
			if (WA03PosY <= 260) {
				WA03PosY += 8;
			}
			if (WA01PosX <= WA02PosX) {
				WA01PosX += 7;
				if (W01PosX == W02PosX) {
					WasserBewegung02 = true;
				}
			}
			if (WA04PosX >= WA03PosX) {
				WA04PosX -= 7;
				if (WA04PosX == WA03PosX) {
					WasserBewegung01 = true;
				}
			}
			if (WasserBewegung01 == true && WA04PosY <= 260) {
				WA04PosY += 8;

			}
			if (WasserBewegung02 == true && WA01PosY <= 260) {
				WA01PosY += 8;

			}
			if (WA01PosY >= 250 && WA04PosY >= 250) {
				Obsidian = true;
			}

		}
		if (Obsidian == false) {
			if (PosX >= L01PosX - 64 && PosX <= L04PosX + 69 && PosY >= 183) {
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
			if (Gefallen == true && Speicherpunkt02 == true) {
				RLN = 0;
				PosX = B03PosX;
				PosY = 112;
				RealPosX = 1400;
				Gefallen = false;
				HP -= 1;
			}
			if (Gefallen == true && Speicherpunkt03 == true) {
				RLN = 0;
				PosX = B04PosX;
				PosY = 112;
				RealPosX = 1650;
				Gefallen = false;
				HP -= 1;
			}
			if (PosX >= L01PosX - 110 && PosX <= L04PosX + 69) {
				if (PosY <= 130) {
					PosY = 131;
				}
			}
		}
		if (Obsidian == true) {
			if (PosX >= B03PosX - 49 && PosX <= B04PosX + 70) {
				if (PosY + TempoY >= 182) {
					PosY = 182;
					TempoY = 0;
					Gesprungen = false;
				}
			}
			if (PosX >= L01PosX - 110 && PosX <= L02PosX || PosX >= L03PosX + 20 && PosX <= L04PosX + 110) {
				if (PosY <= 130) {
					PosY = 131;
				}
			}
		}

		// Endkollision
		if (RealPosX >= 2200) {
			if (PosY <= 220) {
				PosY = 221;
			}
		}
	}

	public void Flag() {
		Speicherpunkt01 = false;
	}

}
