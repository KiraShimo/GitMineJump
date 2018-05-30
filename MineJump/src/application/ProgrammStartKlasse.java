package application;


import java.awt.event.KeyListener;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class ProgrammStartKlasse extends Application implements Runnable, KeyListener {

	
	public void init(Stage primaryStage) throws Exception {
		super.init();
		try {
		Scene SPIEL = new Scene(null, 700,700);
		primaryStage.setScene(SPIEL);
		primaryStage.show();
		//setFocusable(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() throws Exception {
		super.init();
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

			//repaint();
			//Hearbeat
			try {
			Thread.sleep(17);
			} catch(InterruptedException e) {
				e.printStackTrace();
			} 

		}
	}
}
