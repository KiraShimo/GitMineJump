package application.java;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Music {

	private MediaPlayer musicplayer;
	
	public void startmusic() {
		
		//Musik initialisieren
		Media media = new Media(getClass().getResource("/application/ressources/music/07_Boo.mp3").toExternalForm());
		musicplayer = new MediaPlayer(media);
		musicplayer.setAutoPlay(true);
		musicplayer.setVolume(0.5);   //zwischen 0 und 1 
		
		//Musik loopen 
		musicplayer.setOnEndOfMedia(new Runnable() {    
			public void run() {
		        musicplayer.seek(Duration.ZERO); 
		    }
		});  
	}
}
