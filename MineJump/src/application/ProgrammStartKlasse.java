package application;

import java.io.IOException;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class ProgrammStartKlasse extends Canvas {

	private Pane rootPane;

	public ProgrammStartKlasse(int Y, int X) throws IOException {

		// Erstellt das Neue RootPane
		rootPane = new Pane();
		Image SpielerBild = new Image(Main.class.getResource("ressources/Steve_Skin.png").openStream());
		ImageView Bildaufruf = new ImageView(SpielerBild);
		Bildaufruf.setX(Y);
		Bildaufruf.setY(X);
		rootPane.getChildren().add(Bildaufruf);

		// Hintergrund

		Image imgBackground = new Image(
				getClass().getResource("ressources/Title_screen_logo_edited.png").toExternalForm());
		BackgroundImage backgroundImage = new BackgroundImage(imgBackground, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		rootPane.setBackground(background);

	}

	public Pane getRootPane() {
		// gibt rootPane an obere Funktion
		return rootPane;
	}

}
