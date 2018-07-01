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
	// Bedingungsvariablen
	private boolean Gewonnen = false;
	private boolean WillRaus = false;
	private boolean Gefallen = false;
	private int t = 1;
	private boolean STILL = false;
	private boolean STILL02 = false;
	private boolean Flag1 = false;
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

	// Loch 01
	private int B15PosX = 2000;
	private int B15PosY = 380;
	private int B16PosX = 2070;
	private int B16PosY = 380;

	// Bäume
	private int BA01PosX = 1600;
	private int BA01PosY = 100;
	private int BA02PosX = 2200;
	private int BA02PosY = 100;

	public void spiel(Stage primaryStage) throws IOException {

		// Spiel initialisieren

		Pane rootPane;

		// Erstellt das Neue RootPane
		rootPane = new Pane();

		Image SpielerRechts = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Rechts.png").openStream());
		Image SpielerLinks = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Links.png").openStream());
		Image Laub = new Image(Main.class.getResource("/application/ressources/pictures/LaubBG.png").openStream());
		// Image LaubBG = new
		// Image(Main.class.getResource("/application/ressources/pictures/LaubBG.png").openStream());
		Image Loch = new Image(Main.class.getResource("/application/ressources/pictures/DirtOGBG.png").openStream());
		Image BaumBG = new Image(
				Main.class.getResource("/application/ressources/pictures/HolzHint2.0.png").openStream());
		Image HintergrundImage = new Image(
				Main.class.getResource("/application/ressources/pictures/Hintergrund2.0.png").openStream());
		ImageView HintergrundImageAufruf = new ImageView(HintergrundImage);
		HintergrundImageAufruf.setX(bgPosX);
		HintergrundImageAufruf.setY(bgPosY);
		rootPane.getChildren().add(HintergrundImageAufruf);

		Image Untergrund = new Image(
				Main.class.getResource("/application/ressources/pictures/Untergrund1.0.png").openStream());
		ImageView UntergrundAnzeigen = new ImageView(Untergrund);
		UntergrundAnzeigen.setX(UPosX);
		UntergrundAnzeigen.setY(UPosY);
		rootPane.getChildren().add(UntergrundAnzeigen);

		Image Block01 = new Image(
				Main.class.getResource("/application/ressources/pictures/HolzNorm2.0.png").openStream());
		// Baum 01
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

		// Baum02

		Image Baum02 = new Image(Main.class.getResource("/application/ressources/pictures/Baum01BG.png").openStream());
		ImageView Baum02Anzeigen = new ImageView(Baum02);
		Baum02Anzeigen.setX(BA01PosX);
		Baum02Anzeigen.setY(BA01PosY);
		rootPane.getChildren().add(Baum02Anzeigen);

		// Baum03

		ImageView Baum03Anzeigen = new ImageView(Baum02);
		Baum03Anzeigen.setX(BA02PosX);
		Baum03Anzeigen.setY(BA02PosY);
		rootPane.getChildren().add(Baum03Anzeigen);

		// Loch 01

		ImageView B15Anzeigen = new ImageView(Loch);
		B15Anzeigen.setX(B15PosX);
		B15Anzeigen.setY(B15PosY);
		rootPane.getChildren().add(B15Anzeigen);

		ImageView B16Anzeigen = new ImageView(Loch);
		B16Anzeigen.setX(B16PosX);
		B16Anzeigen.setY(B16PosY);
		rootPane.getChildren().add(B16Anzeigen);
		// ZielHinten

		Image Ziel01BG = new Image(Main.class.getResource("/application/ressources/pictures/Ziel01.png").openStream());
		ImageView Ziel01BGAnzeiger = new ImageView(Ziel01BG);
		Ziel01BGAnzeiger.setX(ZPosX01);
		Ziel01BGAnzeiger.setY(ZPosY01);
		rootPane.getChildren().add(Ziel01BGAnzeiger);

		// Spieler
		Image SpielerBild = new Image(
				Main.class.getResource("/application/ressources/pictures/Steve_Vorne.png").openStream());
		ImageView Bildaufruf = new ImageView(SpielerBild);
		Bildaufruf.setX(PosX);
		Bildaufruf.setY(PosY);
		rootPane.getChildren().add(Bildaufruf);
		// ZielVorne

		Image Ziel02VG = new Image(Main.class.getResource("/application/ressources/pictures/Ziel02.png").openStream());
		ImageView Ziel02VGAnzeiger = new ImageView(Ziel02VG);
		Ziel02VGAnzeiger.setX(ZPosX02);
		Ziel02VGAnzeiger.setY(ZPosY02);
		rootPane.getChildren().add(Ziel02VGAnzeiger);

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
				HintergrundImageAufruf.setX(bgPosX);
				UntergrundAnzeigen.setX(UPosX);
				Bildaufruf.setX(PosX);
				Bildaufruf.setY(PosY);
				// Blöcke updaten
				// Baum 01 Aktualisieren
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

				// Loch 01 aktualisieren

				B15Anzeigen.setX(B15PosX);
				B15Anzeigen.setY(B15PosY);
				B16Anzeigen.setX(B16PosX);
				B16Anzeigen.setY(B16PosY);

				// Bäume 02/03 aktualisieren

				Baum02Anzeigen.setX(BA01PosX);
				Baum02Anzeigen.setY(BA01PosY);
				Baum03Anzeigen.setX(BA02PosX);
				Baum03Anzeigen.setY(BA02PosY);

				// Ziel Aktuallisieren

				Ziel01BGAnzeiger.setX(ZPosX01);
				Ziel02VGAnzeiger.setX(ZPosX02);

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
		PosXAlt = PosX;
		// Kollisiondetektion -extra-
		if (STILL == true || STILL02 == true) {
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

	}

	public void Kollisionsdetektion() {
		
		//Kollision mit Baum01
		
		if (PosX >= B01PosX - 50 && PosX <= B01PosX + 70 && PosY >= 183 && PosXAlt <= PosX) {
			PosX = B01PosX - 53;
			RealPosX -= 6;
		}
		if (PosX >= B01PosX + 20 && PosX <= B01PosX + 120 && PosY >= 123 && PosXAlt <= PosX) {
			PosX = B01PosX + 19;
			RealPosX -= 6;
		}
		if (PosX >= B01PosX + 20 && PosX <= B01PosX + 151 && PosY >= 123 && PosXAlt > PosX) {
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

		if (PosX >= B15PosX -20 && PosX <= B16PosX + 30 && PosY >= 249 ) {

			if (TempoX >= 0) {
				RealPosX -= 6;
			}
			if (TempoX <= 0) {
				RealPosX += 6;
			}
			if (TempoX == 0) {
				// tue nichts
			}
			STILL02 = true;

			PosY += 16;
		} else {
			STILL02 = false;
		}
		if (PosY >= 370) {
			Gefallen = true;

		}
		if (Gefallen == true && Flag1 == false) {
			PosX = B15PosX - 70;
			PosY = 252;
			RealPosX = 1800;
			Gefallen = false;
		}
		
		if(PosX >= B16PosX +71) {
			Flag1 = true;
		} 
		if(Gefallen == true && Flag1 == true) {
			PosX = B16PosX + 72;
			PosY = 252;
			RealPosX = 2002;
			Gefallen = false;
		}

	}

	// Getters und Setters
	public void setGewonnen(boolean gewonnen) {
		Gewonnen = gewonnen;
	}
}
