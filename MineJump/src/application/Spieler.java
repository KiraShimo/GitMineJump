package application;

import java.io.IOException;

// import java.awt.Graphics;

//pass die Variablen an !(an mich selbst)

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
		if (TempoX < 0) {
			SpielerPosX += TempoX;
		} else if (TempoX == 0) {
			System.out.println("Spieler steht still");
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
	
	public void Rechts() {
		TempoX = 10;
	}
	public void Links() {
		TempoX = 10;
	}
	public void Halt() {
		TempoX = 0;
	}
	public void Spring() {
		if(Gesprungen == false) {
			TempoY = -20;
			Gesprungen = true;
		}
	}
	
	
	public int getSpielerposY() {
		Y = SpielerPosY;
		return Y; 
		
	}
	
	public int getSpielerposX() {
		X = SpielerPosX;
		return X; 
		
	}

}
