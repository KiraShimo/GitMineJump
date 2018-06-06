package application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ProgrammStartKlasse implements KeyListener {

	private AnchorPane rootPane;
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
	
	
	public ProgrammStartKlasse() {
		rootPane = new AnchorPane();
		//Erstellt das Neue RootPane
	}

	public Pane getRootPane() {
		return rootPane;
		//gibt rootPane an obere Funktion
	}
	
}
