package application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class ProgrammStartKlasse implements KeyListener {

	private Pane rootPane;
	
	
	//private Spieler Horst;
	
	

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("Hoch");
			break;

		case KeyEvent.VK_DOWN:
			System.out.println("Runter");
			break;

		case KeyEvent.VK_LEFT:
			System.out.println("Links");
			break;

		case KeyEvent.VK_RIGHT:
			System.out.println("Rechts");
			break;

		case KeyEvent.VK_SPACE:
			System.out.println("Sprung");
			break;
		}
	}

	public void keyReleased(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("STOP");
			break;

		case KeyEvent.VK_DOWN:
			System.out.println("STOP");
			break;

		case KeyEvent.VK_LEFT:
			System.out.println("STOP");
			break;

		case KeyEvent.VK_RIGHT:
			System.out.println("STOP");
			break;

		case KeyEvent.VK_SPACE:
			System.out.println("STOP");
			break;

		}
	}

	public void keyTyped(KeyEvent e) {}
	
	
	public ProgrammStartKlasse() throws IOException {
		//Erstellt das Neue RootPane
		rootPane = new Pane();
		Image SpielerBild = new Image(Main.class.getResource("Steve_Skin.png").openStream());
        ImageView Bildaufruf = new ImageView(SpielerBild);
		rootPane.getChildren().add(Bildaufruf); 
		//Hintergrund
		Image imgBackground = new Image(getClass().getResource("Title_screen_logo_edited.png").toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(
                imgBackground,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        rootPane.setBackground(background);
	}

	public Pane getRootPane() {
		//gibt rootPane an obere Funktion
		return rootPane;
	}
	
}
