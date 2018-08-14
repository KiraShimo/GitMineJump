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
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level_4 {
	// Spieler und Hintergrundvariablen
	public int PosX = 120;
	private int PosXAlt = 0;
	public int PosY = 252;
	public int SPosXR = PosX + 64;
	public int SPosYH = PosY + 128;
	public int BGPosX = 0;
	public int BGPosY = -100;
	public int UPosX = 0;
	public int UPosY = 380;
	public int RLN = 0;
	private int TempoX = 0;
	private int TempoY = 0;
	private int RealPosX = 0;
	private boolean Gesprungen = false;
	private int ZPosX01 = 2425;
	private int ZPosY01 = 166;
	private int ZPosX02 = 2425;
	private int ZPosY02 = -20;
	private int LPosX = 0;
	private int LPosY = 0;
	private int HP = 3;
	// Bedingungsvariablen
	private int T = 1;
	private int Laufen = 0;
	private boolean Umdrehen = false;
	private boolean Gewonnen = false;
	private boolean Exit = false;
	private boolean Gefallen = false;
	private boolean S = false;
	private boolean Flag1 = false;
	private boolean Flag2 = false;
	private boolean Flag3 = false;
	private boolean V = false;
	private boolean Interaction = false;
	private boolean H2 = false;
	private boolean Wasserfall = false;
	private boolean Drop = false;
	private boolean W04T = false;
	private boolean W01T = false;
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

	// Gegnervariablen
	private int E01PosX = 750;
	private int E01StartX = 750;
	private int E01PosY = 250;
	private boolean V01 = false;

	public void spiel(Stage primaryStage) throws IOException {

		// Spiel initialisieren

		Pane rootPane;

		// Erstellt das Neue RootPane
		rootPane = new Pane();

		// Bilder einbinden
		Image SpielerRechts = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Rechts.png").openStream());
		Image SpielerRechts_2 = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Rechts_2.png").openStream());
		Image SpielerLinks = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Links.png").openStream());
		Image SpielerLinks_2 = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Links_2.png").openStream());
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
		Image H02 = new Image(Main.class.getResource("/application/ressources/pictures/Hebel_Aus.png").openStream());
		Image WA01 = new Image(Main.class.getResource("/application/ressources/pictures/Wasser.png").openStream());

		// Bilder aufrufen
		// Hintergrund / Untergrund aufrufen
		ImageView HintergrundImageAufruf = new ImageView(HintergrundImage);
		HintergrundImageAufruf.setX(BGPosX);
		HintergrundImageAufruf.setY(BGPosY);
		rootPane.getChildren().add(HintergrundImageAufruf);

		ImageView UntergrundAnzeigen = new ImageView(Untergrund);
		UntergrundAnzeigen.setX(UPosX);
		UntergrundAnzeigen.setY(UPosY);
		rootPane.getChildren().add(UntergrundAnzeigen);

		// BlÃ¶cke aufrufen
		ImageView B01_Anzeigen = new ImageView(B01);
		B01_Anzeigen.setX(B01PosX);
		B01_Anzeigen.setY(B01PosY);
		rootPane.getChildren().add(B01_Anzeigen);
		ImageView B02_Anzeigen = new ImageView(B01);
		B02_Anzeigen.setX(B02PosX);
		B02_Anzeigen.setY(B02PosY);
		rootPane.getChildren().add(B02_Anzeigen);
		ImageView B03_Anzeigen = new ImageView(B02);
		B03_Anzeigen.setX(B03PosX);
		B03_Anzeigen.setY(B03PosY);
		rootPane.getChildren().add(B03_Anzeigen);
		ImageView B04_Anzeigen = new ImageView(B02);
		B04_Anzeigen.setX(B04PosX);
		B04_Anzeigen.setY(B04PosY);
		rootPane.getChildren().add(B04_Anzeigen);
		// Wassertank aufrufen
		ImageView W01_Anzeigen = new ImageView(B03);
		W01_Anzeigen.setX(W01PosX);
		W01_Anzeigen.setY(W01PosY);
		rootPane.getChildren().add(W01_Anzeigen);
		ImageView W02_Anzeigen = new ImageView(B03);
		W02_Anzeigen.setX(W02PosX);
		W02_Anzeigen.setY(W02PosY);
		rootPane.getChildren().add(W02_Anzeigen);
		ImageView W03_Anzeigen = new ImageView(B03);
		W03_Anzeigen.setX(W03PosX);
		W03_Anzeigen.setY(W03PosY);
		rootPane.getChildren().add(W03_Anzeigen);
		ImageView W04_Anzeigen = new ImageView(B03);
		W04_Anzeigen.setX(W03PosX);
		W04_Anzeigen.setY(W03PosY);
		rootPane.getChildren().add(W04_Anzeigen);
		ImageView W05_Anzeigen = new ImageView(B03);
		W05_Anzeigen.setX(W05PosX);
		W05_Anzeigen.setY(W05PosY);
		rootPane.getChildren().add(W05_Anzeigen);
		ImageView W06_Anzeigen = new ImageView(B03);
		W06_Anzeigen.setX(W06PosX);
		W06_Anzeigen.setY(W06PosY);
		rootPane.getChildren().add(W06_Anzeigen);
		ImageView W07_Anzeigen = new ImageView(B03);
		W07_Anzeigen.setX(W07PosX);
		W07_Anzeigen.setY(W07PosY);
		rootPane.getChildren().add(W07_Anzeigen);
		ImageView W08_Anzeigen = new ImageView(B03);
		W08_Anzeigen.setX(W08PosX);
		W08_Anzeigen.setY(W08PosY);
		rootPane.getChildren().add(W08_Anzeigen);

		// Wasser aufrufen
		ImageView WA01_Anzeigen = new ImageView(WA01);
		WA01_Anzeigen.setX(WA01PosX);
		WA01_Anzeigen.setY(WA01PosY);
		rootPane.getChildren().add(WA01_Anzeigen);
		ImageView WA02_Anzeigen = new ImageView(WA01);
		WA02_Anzeigen.setX(WA02PosX);
		WA02_Anzeigen.setY(WA02PosY);
		rootPane.getChildren().add(WA02_Anzeigen);
		ImageView WA03_Anzeigen = new ImageView(WA01);
		WA03_Anzeigen.setX(WA03PosX);
		WA03_Anzeigen.setY(WA03PosY);
		rootPane.getChildren().add(WA03_Anzeigen);
		ImageView WA04_Anzeigen = new ImageView(WA01);
		WA04_Anzeigen.setX(WA04PosX);
		WA04_Anzeigen.setY(WA04PosY);
		rootPane.getChildren().add(WA04_Anzeigen);

		// Lava aufrufen
		ImageView L01_Anzeigen = new ImageView(L01);
		L01_Anzeigen.setX(L01PosX);
		L01_Anzeigen.setY(L01PosY);
		rootPane.getChildren().add(L01_Anzeigen);
		ImageView L02_Anzeigen = new ImageView(L01);
		L02_Anzeigen.setX(L02PosX);
		L02_Anzeigen.setY(L02PosY);
		rootPane.getChildren().add(L02_Anzeigen);
		ImageView L03_Anzeigen = new ImageView(L01);
		L03_Anzeigen.setX(L03PosX);
		L03_Anzeigen.setY(L03PosY);
		rootPane.getChildren().add(L03_Anzeigen);
		ImageView L04_Anzeigen = new ImageView(L01);
		L04_Anzeigen.setX(L04PosX);
		L04_Anzeigen.setY(L04PosY);
		rootPane.getChildren().add(L04_Anzeigen);

		// Gegner anzeigen
		ImageView E01_Anzeigen = new ImageView(E01);
		E01_Anzeigen.setX(E01PosX);
		E01_Anzeigen.setY(E01PosY);
		rootPane.getChildren().add(E01_Anzeigen);

		// Hebel anzeigen

		ImageView H01_Anzeigen = new ImageView(H02);
		H01_Anzeigen.setX(H01PosX);
		H01_Anzeigen.setY(H01PosY);
		rootPane.getChildren().add(H01_Anzeigen);

		// Ziel hinten
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

				try {
					Kollisionsdetektion();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				NeuLaden();

				// Position Updaten
				if (RLN == 0) {
					Bildaufruf.setImage(SpielerBild);
					Laufen = 5;
				}
				if (RLN == 1 && Laufen <= 2) {
					Bildaufruf.setImage(SpielerLinks);
					System.out.println(Laufen);
				}
				if (RLN == 1 && Laufen >= 3) {
					Bildaufruf.setImage(SpielerLinks_2);
					System.out.println(Laufen);
				}
				if (RLN == 2 && Laufen <= 2) {
					Bildaufruf.setImage(SpielerRechts);
					System.out.println(Laufen);
				}
				if (RLN == 2 && Laufen >= 3) {
					Bildaufruf.setImage(SpielerRechts_2);
					System.out.println(Laufen);
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
				if (H2 == true) {
					H01_Anzeigen.setImage(H01);
				}
				// Ziel Aktuallisieren

				Ziel01BGAnzeiger.setX(ZPosX01);
				Ziel02VGAnzeiger.setX(ZPosX02);

				// BlÃ¶cke updaten

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
					Drop = true;
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

				Menu menu = new Menu();

				// Gewonnen test / ESC test
				if (Gewonnen == true && Abbruch == false) {
					Gewonnen = false;
					Exit = false;
					Gefallen = false;
					T = 1;
					S = false;
					Flag1 = false;
					Flag2 = false;
					Flag3 = false;
					V = false;
					Interaction = false;
					H2 = false;
					Wasserfall = false;
					Drop = false;
					W04T = false;
					W01T = false;
					Obsidian = false;
					Check = false;
					Abbruch = true;
					RealPosX = 0;
					Laufen = 0;
					Umdrehen = false;
					menu.win(primaryStage);
					PauseTransition delay = new PauseTransition(Duration.seconds(5));
					delay.setOnFinished(event -> menu.level(primaryStage));
					delay.play();
					System.out.println("Sieg");
				}
				if (Exit == true && Abbruch == false) {

					Gewonnen = false;
					Exit = false;
					Gefallen = false;
					T = 1;
					S = false;
					Flag1 = false;
					Flag2 = false;
					Flag3 = false;
					V = false;
					Interaction = false;
					H2 = false;
					Wasserfall = false;
					Drop = false;
					W04T = false;
					W01T = false;
					Obsidian = false;
					Check = false;
					RealPosX = 0;
					PosX = 0;
					TempoX = 0;
					Abbruch = true;
					Laufen = 0;
					Umdrehen = false;
					menu.level(primaryStage);
					System.out.println("Willraus");
				}
				if (V == true && Abbruch == false) {
					System.out.println("Verloren");
					Gewonnen = false;
					Exit = false;
					Gefallen = false;
					T = 1;
					S = false;
					Flag1 = false;
					Flag2 = false;
					Flag3 = false;
					V = false;
					Interaction = false;
					H2 = false;
					Wasserfall = false;
					Drop = false;
					W04T = false;
					W01T = false;
					Obsidian = false;
					Check = false;
					RealPosX = 0;
					PosX = 0;
					TempoX = 0;
					HP = 3;
					Abbruch = true;
					Laufen = 0;
					Umdrehen = false;
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
			case I:
				Interaction = true;
				break;
			case E:
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
		if (Laufen >= 0) {
			Laufen = Laufen + 1;
			if(Laufen >= 5) {
				Umdrehen = true;
			}
		}
		if (Umdrehen == true) {
			Laufen = Laufen - 2;
			if (Laufen <= 0) {
				Umdrehen = false;
			}
		}
		RLN = 2;
	}

	public void Links() {
		TempoX = -6;
		if (Laufen >= 0) {
			Laufen = Laufen + 1;
			if(Laufen >= 5) {
				Umdrehen = true;
			}
		}
		if (Umdrehen == true) {
			Laufen = Laufen - 2;
			if (Laufen <= 0) {
				Umdrehen = false;
			}
		}
		RLN = 1;

	}

	public void Halt() {
		TempoX = 0;
		Laufen = 0;
	}

	public void NeuLaden() {
		if (Wasserfall == false) {
			PosXAlt = PosX;
			if (HP == 0) {
				V = true;
			}
			// Kollisiondetektion -extra-
			if (S == true) {
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
			if (T == 1) {
				if (RealPosX > 2500) {
					Gewonnen = true;
					T = 0;
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
			Flag2 = true;
			System.out.println(RealPosX);
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
			Flag2 = false;
			Flag3 = true;
			System.out.println(RealPosX);
		}
		// Kollision mit Gegner
		Timeline Timer = new Timeline(new KeyFrame(Duration.millis(2500), ae -> Flag()));
		if (Check == true && Flag1 == true) {
			Timer.play();
			Check = false;
		}

		if (PosX >= E01PosX - 64 && PosX <= E01PosX + 69 && PosY >= 153 && PosXAlt <= PosX && Flag1 == false) {
			PosX = E01PosX - 53;
			Gefallen = true;
			Flag1 = true;

		}
		if (PosX >= E01PosX - 30 && PosX <= E01PosX + 70 && PosY >= 153 && PosXAlt >= PosX && Flag1 == false) {
			PosX = E01PosX + 71;
			Gefallen = true;
			Flag1 = true;

		}

		if (Gefallen == true && Flag1 == true) {
			Gefallen = false;
			RLN = 3;
			Thread.sleep(200);
			HP -= 1;
			Check = true;
		}

		// Interaktion mit dem Hebel
		if (PosX >= B03PosX - 140 && PosX <= B03PosX - 20 && Interaction == true) {
			H2 = true;
			Wasserfall = true;
		}
		if (Drop == true) {
			if (WA02PosY <= 260) {
				WA02PosY += 8;
			}
			if (WA03PosY <= 260) {
				WA03PosY += 8;
			}
			if (WA01PosX <= WA02PosX) {
				WA01PosX += 7;
				if (W01PosX == W02PosX) {
					W01T = true;
				}
			}
			if (WA04PosX >= WA03PosX) {
				WA04PosX -= 7;
				if (WA04PosX == WA03PosX) {
					W04T = true;
				}
			}
			if (W04T == true && WA04PosY <= 260) {
				WA04PosY += 8;

			}
			if (W01T == true && WA01PosY <= 260) {
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

				S = true;
				PosY += 8;
				RLN = 3;
				Gesprungen = true;
				pause.play();

			} else {
				S = false;
			}
			if (PosY >= 253) {
				Gefallen = true;
				Gesprungen = true;
			}
			if (Gefallen == true && Flag2 == true) {
				RLN = 0;
				PosX = B03PosX;
				PosY = 112;
				RealPosX = 1400;
				Gefallen = false;
				HP -= 1;
			}
			if (Gefallen == true && Flag3 == true) {
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
		Flag1 = false;
	}

}

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
			case I:
				Interaction = false;
				break;
			case E:
				Interaction = false;
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
		if (Wasserfall == false) {
			PosXAlt = PosX;
			if (HP == 0) {
				V = true;
			}
			// Kollisiondetektion -extra-
			if (S == true) {
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
			if (T == 1) {
				if (RealPosX > 2500) {
					Gewonnen = true;
					T = 0;
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
			Flag2 = true;
			System.out.println(RealPosX);
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
			Flag2 = false;
			Flag3 = true;
			System.out.println(RealPosX);
		}
		// Kollision mit Gegner
		Timeline Timer = new Timeline(new KeyFrame(Duration.millis(2500), ae -> Flag()));
		if (Check == true && Flag1 == true) {
			Timer.play();
			Check = false;
		}

		if (PosX >= E01PosX - 64 && PosX <= E01PosX + 69 && PosY >= 153 && PosXAlt <= PosX && Flag1 == false) {
			PosX = E01PosX - 53;
			Gefallen = true;
			Flag1 = true;

		}
		if (PosX >= E01PosX - 30 && PosX <= E01PosX + 70 && PosY >= 153 && PosXAlt >= PosX && Flag1 == false) {
			PosX = E01PosX + 71;
			Gefallen = true;
			Flag1 = true;

		}

		if (Gefallen == true && Flag1 == true) {
			Gefallen = false;
			RLN = 3;
			Thread.sleep(200);
			HP -= 1;
			Check = true;
		}

		// Interaktion mit dem Hebel
		if (PosX >= B03PosX - 140 && PosX <= B03PosX - 20 && Interaction == true) {
			H2 = true;
			Wasserfall = true;
		}
		if (Drop == true) {
			if (WA02PosY <= 260) {
				WA02PosY += 8;
			}
			if (WA03PosY <= 260) {
				WA03PosY += 8;
			}
			if (WA01PosX <= WA02PosX) {
				WA01PosX += 7;
				if (W01PosX == W02PosX) {
					W01T = true;
				}
			}
			if (WA04PosX >= WA03PosX) {
				WA04PosX -= 7;
				if (WA04PosX == WA03PosX) {
					W04T = true;
				}
			}
			if (W04T == true && WA04PosY <= 260) {
				WA04PosY += 8;

			}
			if (W01T == true && WA01PosY <= 260) {
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

				S = true;
				PosY += 8;
				RLN = 3;
				Gesprungen = true;
				pause.play();

			} else {
				S = false;
			}
			if (PosY >= 253) {
				Gefallen = true;
				Gesprungen = true;
			}
			if (Gefallen == true && Flag2 == true) {
				RLN = 0;
				PosX = B03PosX;
				PosY = 112;
				RealPosX = 1400;
				Gefallen = false;
				HP -= 1;
			}
			if (Gefallen == true && Flag3 == true) {
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
		Flag1 = false;
	}

}
