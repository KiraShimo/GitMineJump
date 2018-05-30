package application;

import javafx.application.Application;

public abstract class ProgrammStartKlasse extends Application implements Runnable {

	@Override
	public void init() throws Exception {
		super.init();
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

			repaint();
			  //Kommentare
			//sind cool
			
			try {
			Thread.sleep(17);
			} catch(InterruptedException e) {
				e.printStackTrace();
			} 

		}
	}
}
