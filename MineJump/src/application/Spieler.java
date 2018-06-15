package application;

import java.io.IOException;

public class Spieler {
	int X,Y;
	public Spieler() throws IOException {
		super();
		
	}
	public int SpielerPosX = 120;
	public int SpielerPosY = 280;
	private int TempoX = 1;
	private int TempoY = 0;
	private boolean Gesprungen = false;

	public void NeuLaden() {
		//Bewegen und Anpassen
		if (TempoX > 0) {
			SpielerPosX = SpielerPosX + TempoX;
		} else {
			if (SpielerPosX <= 110) {
				SpielerPosX += TempoX;
			} else {
				System.out.println("Beweg Background");
			}
		}
		if (SpielerPosY + TempoY >= 300) {
			SpielerPosY = 300;
		} else {
			SpielerPosY += TempoY;
		}
		//Kontrolle über das Springen
		
		if (Gesprungen == true) {
			TempoY += 1;

			if (SpielerPosY + TempoY >= 300) {
				SpielerPosY = 300;
				TempoY = 0;
				Gesprungen = false;
			}

		}
		
		if(SpielerPosX + TempoX < 50) {
			SpielerPosX = 51;
		}
	}
	//regelt den Sprung
	public void Spring() {
		if(Gesprungen == false) {
			TempoY = -20;
			Gesprungen = true;
		}
	}
	
	public void Rechts() {
		TempoX = 10;
	}
	public void Links() {
		TempoX = 10;
	}
	public void Halt() {
		TempoX = 0;
	}
	
	// get und set methoden 
	
	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public int getSpielerPosX() {
		return SpielerPosX;
	}

	public int getSpielerPosY() {
		return SpielerPosY;
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

	public void setSpielerPosX(int spielerPosX) {
		SpielerPosX = spielerPosX;
	}

	public void setSpielerPosY(int spielerPosY) {
		SpielerPosY = spielerPosY;
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
