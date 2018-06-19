package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.animation.AnimationTimer;

public class SchleifeMenu {

	Spieler Steve = new Spieler();

	@SuppressWarnings("unchecked")
	public void spiel(Stage primaryStage) throws IOException {

		// Spiel initialisieren

		Pane rootPane;

		int X = Steve.getSpielerPosX();
		int Y = Steve.getSpielerPosY();

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

		Scene game = new Scene(rootPane);

		game.getStylesheets().add(getClass().getResource("ressources/application.css").toExternalForm());

		// need to attach KeyEvent caller to a Node of some sort.
		// How about an invisible Box?
		final Box keyboardNode = new Box();
		keyboardNode.setFocusTraversable(true);
		keyboardNode.requestFocus();
		keyboardNode.setOnKeyPressed((EventHandler<? super KeyEvent>) this);

		rootPane.getChildren().add(keyboardNode);

		primaryStage.setScene(game);
		primaryStage.show();

		AnimationTimer animator = new AnimationTimer() {

			@Override
			public void handle(long arg0) {

				// UPDATE
				
				// RENDER
				Bildaufruf.setX(Y);
				Bildaufruf.setY(X);
			}
		};

		animator.start();

	}

	public void handle(KeyEvent event) {
		switch (event.getCode()) {
		case SPACE:
			System.out.println("HOCH");
			Steve.Spring();
			Steve.NeuLaden();
			break;
		case LEFT:
			System.out.println("LINKS");
			Steve.Links();
			Steve.NeuLaden();
			break;
		case RIGHT:
			System.out.println("RECHTS");
			Steve.Rechts();
			Steve.NeuLaden();
			break;
		case ESCAPE:
			System.out.println("ESC");
			// Hier bitte main menu wieder einbinden (als Aufruf ^^)
			break;
		default:
			break;
		}
	}
}
