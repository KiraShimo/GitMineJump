package application.java;

import java.nio.file.Paths;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Music {

	private AudioClip musicplayer;
	
	public void startmusic() {
		//Musik initialisieren
		String source = "src/application/ressources/music/07_Boo.mp3";
		Media media = new Media(Paths.get(source).toUri().toString());
		musicplayer = new AudioClip(media.getSource());
		musicplayer.setVolume(0.2);   //zwischen 0 und 1 
		musicplayer.setCycleCount(-1);
		musicplayer.play();
		
		//Musik loopen 
		/*musicplayer.setOnEndOfMedia(new Runnable() {    
			public void run() {
				musicplayer.seek(Duration.ZERO); 
			}
		});  */
	}
	
	public AudioClip getmusicplayer() {
		return musicplayer;
	}
	
	public void setvolume(double volume) {
    	System.out.println(musicplayer);
    	System.out.println(volume);
		getmusicplayer().setVolume(volume);
    }
}
