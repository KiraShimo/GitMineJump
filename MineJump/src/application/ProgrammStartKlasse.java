package application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class ProgrammStartKlasse extends Application implements Runnable, KeyListener {

	// public void init(Stage primaryStage) throws Exception {
	// super.init();
	// try {
	// Scene SPIEL = new Scene(null, 700,700);
	// primaryStage.setScene(SPIEL);
	// primaryStage.show();
	// setFocusable(true);
	// }
	// catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	
	AnchorPane rootPane;

	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setResizable(false);

		VBox SpielBox = new VBox(30);
		SpielBox.setBackground(new Background(new BackgroundImage(new Image(""), null, null, null,
				new BackgroundSize(45, 45, true, true, true, true))));
	}

	@Override
	public void stop() throws Exception {
		super.init();
	}

	public void exit() throws Exception {
		super.init();
	}

	@Override
	public void run() {
		while (true) {

			// repaint();
			// Hearbeat
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void Tastendruck(KeyEvent e) {

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

	public void KeinTastendruck(KeyEvent e) {

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
	
	public void SpielFX() {
		rootPane = new AnchorPane();
	}
	
	public Pane getRootPane() {
		return rootPane;
	}
}
