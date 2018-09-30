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
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level_1 {
	
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
	private int RPosX = 0;
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
	private boolean Gefallen = false;
	private boolean Stillstand = false;
	private boolean Speicherpunkt01 = false;
	private boolean Verloren = false;

	// Blockvariablen
	// Baum01
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
	private int B10PosX = 1140;
	private int B10PosY = -30;
	private int B11PosX = 1000;
	private int B11PosY = -30;
	private int B12PosX = 1210;
	private int B12PosY = 40;
	private int B13PosX = 930;
	private int B13PosY = 40;
	private int B14PosX = 1070;
	private int B14PosY = -30;

	// Lochvariablen
	private int B15PosX = 2000;
	private int B15PosY = 380;
	private int B16PosX = 2070;
	private int B16PosY = 380;

	// Baumvariablen
	private int BA01PosX = 1600;
	private int BA01PosY = 100;
	private int BA02PosX = 2200;
	private int BA02PosY = 100;

	// Tutorialtextvariablen
	private int T01PosX = 200;
	private int T01PosY = 120;
	private int T02PosX = 950;
	private int T02PosY = 75;
	private int T03PosX = 1900;
	private int T03PosY = 100;
	private int T04PosX = 2400;
	private int T04PosY = 200;

	private String T01Text = "Um Ihren Charakter zu bewegen drücken Sie 'A' oder 'D'\n oder benutzen sie die Pfeiltasten. ";
	private String T02Text = "Um zu springen drücken Sie 'W', 'SPACE' \noder die Pfeiltaste nach oben";
	private String T03Text = "       Springen Sie über Löcher wie dieses! \nWenn Sie hineinfallen, verlieren Sie ein Herz. \nWenn Sie keine Herzen mehr haben,\nmüssen sie den gesamten Level erneut spielen.";
	private String T04Text = "Erreichen Sie die Burg und gehen Sie durch den Eingang\num das Level erfolgreich Abzuschließen.";

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
		Image Laub = new Image(Main.class.getResource("/application/ressources/pictures/LaubBG.png").openStream());

		Image Loch = new Image(Main.class.getResource("/application/ressources/pictures/DirtOGBG.png").openStream());
		Image BaumBG = new Image(
				Main.class.getResource("/application/ressources/pictures/HolzHint2.0.png").openStream());
		Image HintergrundImage = new Image(
				Main.class.getResource("/application/ressources/pictures/Hintergrund2.0.png").openStream());
		Image Untergrund = new Image(
				Main.class.getResource("/application/ressources/pictures/Untergrund1.0.png").openStream());
		Image Block01 = new Image(
				Main.class.getResource("/application/ressources/pictures/HolzNorm2.0.png").openStream());
		Image Baum02 = new Image(Main.class.getResource("/application/ressources/pictures/Baum01BG.png").openStream());
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

		ImageView UntergrundAnzeigen = new ImageView(Untergrund);
		UntergrundAnzeigen.setX(UPosX);
		UntergrundAnzeigen.setY(UPosY);
		rootPane.getChildren().add(UntergrundAnzeigen);

		// Baum 01 aufrufen und anzeigen
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
		B05Anzeigen.setX(B05PosX);
		B05Anzeigen.setY(B05PosY);
		rootPane.getChildren().add(B05Anzeigen);

		ImageView B06Anzeigen = new ImageView(Laub);
		B06Anzeigen.setX(B06PosX);
		B06Anzeigen.setY(B06PosY);
		rootPane.getChildren().add(B06Anzeigen);

		ImageView B07Anzeigen = new ImageView(Laub);
		B07Anzeigen.setX(B07PosX);
		B07Anzeigen.setY(B07PosY);
		rootPane.getChildren().add(B07Anzeigen);

		ImageView B08Anzeigen = new ImageView(Laub);
		B08Anzeigen.setX(B08PosX);
		B08Anzeigen.setY(B08PosY);
		rootPane.getChildren().add(B08Anzeigen);

		ImageView B09Anzeigen = new ImageView(BaumBG);
		B09Anzeigen.setX(B09PosX);
		B09Anzeigen.setY(B09PosY);
		rootPane.getChildren().add(B09Anzeigen);

		ImageView B10Anzeigen = new ImageView(Laub);
		B10Anzeigen.setX(B10PosX);
		B10Anzeigen.setY(B10PosY);
		rootPane.getChildren().add(B10Anzeigen);

		ImageView B11Anzeigen = new ImageView(Laub);
		B11Anzeigen.setX(B11PosX);
		B11Anzeigen.setY(B11PosY);
		rootPane.getChildren().add(B11Anzeigen);

		ImageView B12Anzeigen = new ImageView(Laub);
		B12Anzeigen.setX(B12PosX);
		B12Anzeigen.setY(B12PosY);
		rootPane.getChildren().add(B12Anzeigen);

		ImageView B13Anzeigen = new ImageView(Laub);
		B13Anzeigen.setX(B13PosX);
		B13Anzeigen.setY(B13PosY);
		rootPane.getChildren().add(B13Anzeigen);

		ImageView B14Anzeigen = new ImageView(Laub);
		B14Anzeigen.setX(B14PosX);
		B14Anzeigen.setY(B14PosY);
		rootPane.getChildren().add(B14Anzeigen);

		// Baum02 aufrufen und anzeigen
		ImageView Baum02Anzeigen = new ImageView(Baum02);
		Baum02Anzeigen.setX(BA01PosX);
		Baum02Anzeigen.setY(BA01PosY);
		rootPane.getChildren().add(Baum02Anzeigen);

		// Baum03 aufrufen und anzeigen
		ImageView Baum03Anzeigen = new ImageView(Baum02);
		Baum03Anzeigen.setX(BA02PosX);
		Baum03Anzeigen.setY(BA02PosY);
		rootPane.getChildren().add(Baum03Anzeigen);

		// Loch 01 aufrufen und anzeigen
		ImageView B15Anzeigen = new ImageView(Loch);
		B15Anzeigen.setX(B15PosX);
		B15Anzeigen.setY(B15PosY);
		rootPane.getChildren().add(B15Anzeigen);

		ImageView B16Anzeigen = new ImageView(Loch);
		B16Anzeigen.setX(B16PosX);
		B16Anzeigen.setY(B16PosY);
		rootPane.getChildren().add(B16Anzeigen);

		// Tutorialtexte aufrufen und anzeigen
		Text Text = new Text();
		Text.setFont(new Font(18));
		Text.setX(T01PosX);
		Text.setY(T01PosY);
		Text.setText(T01Text);
		Text.setFill(Color.WHITE);
		rootPane.getChildren().add(Text);

		Text Text2 = new Text();
		Text2.setFont(new Font(18));
		Text2.setX(T02PosX);
		Text2.setY(T02PosY);
		Text2.setText(T02Text);
		Text2.setFill(Color.WHITE);
		rootPane.getChildren().add(Text2);

		Text Text3 = new Text();
		Text3.setFont(new Font(18));
		Text3.setX(T03PosX);
		Text3.setY(T03PosY);
		Text3.setText(T03Text);
		Text3.setFill(Color.WHITE);
		rootPane.getChildren().add(Text3);

		Text Text4 = new Text();
		Text4.setFont(new Font(18));
		Text4.setX(T04PosX);
		Text4.setY(T04PosY);
		Text4.setText(T04Text);
		Text4.setFill(Color.WHITE);
		rootPane.getChildren().add(Text4);

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
				// Blöcke updaten
				// Baum 01 updaten
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
				B10Anzeigen.setX(B10PosX);
				B10Anzeigen.setY(B10PosY);
				B11Anzeigen.setX(B11PosX);
				B11Anzeigen.setY(B11PosY);
				B12Anzeigen.setX(B12PosX);
				B12Anzeigen.setY(B12PosY);
				B13Anzeigen.setX(B13PosX);
				B13Anzeigen.setY(B13PosY);
				B14Anzeigen.setX(B14PosX);
				B14Anzeigen.setY(B14PosY);

				// Loch 01 updaten
				B15Anzeigen.setX(B15PosX);
				B15Anzeigen.setY(B15PosY);
				B16Anzeigen.setX(B16PosX);
				B16Anzeigen.setY(B16PosY);

				// Bäume 02/03 updaten
				Baum02Anzeigen.setX(BA01PosX);
				Baum02Anzeigen.setY(BA01PosY);
				Baum03Anzeigen.setX(BA02PosX);
				Baum03Anzeigen.setY(BA02PosY);

				// Ziel updaten
				Ziel01BGAnzeiger.setX(ZPosX01);
				Ziel02VGAnzeiger.setX(ZPosX02);

				// Tutorial updaten
				Text.setX(T01PosX);
				Text2.setX(T02PosX);
				Text3.setX(T03PosX);
				Text4.setX(T04PosX);

				Menu menu = new Menu();

				// Gewonnen test / ESC test
				if (Gewonnen == true) {
					Gewonnen = false;
					RPosX = 0;
					PosX = 0;
					TempoX = 0;
					menu.win(primaryStage);
					PauseTransition delay = new PauseTransition(Duration.seconds(3));
					delay.setOnFinished(event -> menu.level(primaryStage));
					delay.play();
				}
				if (WillRaus == true) {
					WillRaus = false;
					RPosX = 0;
					PosX = 0;
					TempoX = 0;
					menu.level(primaryStage);
				}
				if (Verloren == true) {
					System.out.println("Verloren");
					Verloren = false;
					RPosX = 0;
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
			RPosX += TempoX;
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
			if (RPosX > 3000) {
				Gewonnen = true;
				GewonnenTest = 0;
				RPosX = 0;
			}
		}
		// BlockPositionen anpassen
		// Baum 01
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
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B10PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B11PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B12PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B13PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B14PosX -= TempoX;
		}

		// Loch 01 anpassen

		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B15PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				B16PosX -= TempoX;
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

		// Bäume 02/03 anpassen

		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				BA01PosX -= TempoX;
		}
		if (TempoX >= 0 && PosX >= 300) {
			if (PosX >= 51)
				BA02PosX -= TempoX;
		}

		// Texte anpassen

		if (TempoX >= 0 && PosX >= 300) {
			T01PosX -= TempoX;
		}

		if (TempoX >= 0 && PosX >= 300) {
			T02PosX -= TempoX;
		}

		if (TempoX >= 0 && PosX >= 300) {
			T03PosX -= TempoX;
		}

		if (TempoX >= 0 && PosX >= 300) {
			T04PosX -= TempoX;
		}

	}

	public void Kollisionsdetektion() throws InterruptedException {

		// Kollision mit Baum01

		if (PosX >= B01PosX - 50 && PosX <= B01PosX + 70 && PosY >= 183 && PosXAlt <= PosX) {
			PosX = B01PosX - 53;
			RPosX -= 6;
		}
		if (PosX >= B01PosX + 20 && PosX <= B01PosX + 120 && PosY >= 123 && PosXAlt <= PosX) {
			PosX = B01PosX + 19;
			RPosX -= 6;
		}
		if (PosX >= B01PosX + 20 && PosX <= B01PosX + 151 && PosY >= 123 && PosXAlt > PosX) {
			PosX = B01PosX + 152;
			RPosX += 6;
		}
		if (PosX >= B01PosX + 20 && PosX <= B01PosX + 221 && PosY >= 183 && PosXAlt > PosX) {
			PosX = B01PosX + 222;
			RPosX += 6;
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
			if (PosY + TempoY >= 122) {
				PosY = 122;
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

		// Kollision mit Loch

		if (PosX >= B15PosX - 20 && PosX <= B16PosX + 30 && PosY >= 249) {

			if (TempoX >= 0) {
				RPosX -= 6;
			}
			if (TempoX <= 0) {
				RPosX += 6;
			}
			if (TempoX == 0) {
				// tue nichts
			}
			RLN = 3;
			Stillstand = true;

			PosY += 30;
		} else {
			Stillstand = false;
		}
		if (PosY >= 370) {
			Gefallen = true;

		}
		if (Gefallen == true && Speicherpunkt01 == false) {
			PosX = B15PosX - 70;
			PosY = 252;
			RPosX = 1800;
			Gefallen = false;
			RLN = 0;
			Thread.sleep(200);
			HP -= 1;
		}

		if (PosX >= B16PosX + 71) {
			Speicherpunkt01 = true;
		}
		if (Gefallen == true && Speicherpunkt01 == true) {
			PosX = B16PosX + 72;
			PosY = 252;
			RPosX = 2002;
			Gefallen = false;
			RLN = 0;
			Thread.sleep(200);
			HP -= 1;
		}
		
		// Kollision mit der Burg
		if (RPosX >= 2750) {
			if (PosY <= 220) {
				PosY = 221;
			}
		}
	}

}
