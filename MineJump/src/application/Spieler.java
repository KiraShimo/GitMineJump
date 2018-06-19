package application;

import java.io.IOException;

public class Spieler {
	
	public int SpielerPosX = 120;
	public int SpielerPosY = 280;
	private int TempoX = 1;
	private int TempoY = 0;
	private boolean Gesprungen = false;
	int X,Y;
	
	public Spieler() throws IOException {
		super();
		
	}
	

	public void Spring() {
		if(Gesprungen == false) {
			for( int i = 1; i <= 20; i ++ ) {
				TempoY = -1;
				SpielerPosY += TempoY;
			}
			Gesprungen = true;
		}
	}
	
	public void Rechts() {
		TempoX = 10;
	}
	public void Links() {
		TempoX = -10;
	}
	public void Halt() {
		TempoX = 0;
	}
	
	public void NeuLaden(int TempoX , int TempoY) {
		//Bewegen und Anpassen
		//Anpassen X
		if (TempoX != 0) {
			setSpielerPosX(SpielerPosX + TempoX);
		} else {
			System.out.println("Stillstand X");
		}
		//Anpassen Y
		if (Gesprungen == true) {
			for(int i = 1; i < 20; i++) {
				TempoY = 1;
				setSpielerPosY( SpielerPosY + TempoY);
			}
				TempoY = 0;
				Gesprungen = false;
		}
		if(SpielerPosX + TempoX < 50) {
			SpielerPosX = 51;
		}
	}

		
	
	// get und set methoden 
	

	public int getSpielerPosY() {
		return SpielerPosY;
	}
	
	public int getSpielerPosX() {
		return SpielerPosX;
	}

	public int getTempoX() {
		return TempoX;
	}

	public int getTempoY() {
		return TempoY;
	}

	public boolean isGesprungen() {
		return Gesprungen;
	}

	public void setX(int x) {
		X = x;
	}

	public void setY(int y) {
		Y = y;
	}

	public int setSpielerPosX(int spielerPosX) {
		SpielerPosX = spielerPosX;
		return SpielerPosX;
	}

	public int setSpielerPosY(int spielerPosY) {
		SpielerPosY = spielerPosY;
		return SpielerPosY;
	}

	public void setTempoX(int tempoX) {
		TempoX = tempoX;
	}

	public void setTempoY(int tempoY) {
		TempoY = tempoY;
	}

	public void setGesprungen(boolean gesprungen) {
		Gesprungen = gesprungen;
	}

}
