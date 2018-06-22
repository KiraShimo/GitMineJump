package application.java;

public class Hintergrund {

	private int HPosY, HPosX, HTempX;

	public Hintergrund(int x, int y) {
		HPosX = x;
		HPosY = y;
		HTempX = 0;
	}

	public void HNeuLaden() {
		HPosX += HTempX;

		if (HPosX == 2160) {
			HPosX += 4320;
		}
	}
// Get und Set Methoden 
	
	public int getHPosY() {
		return HPosY;
	}

	public int getHPosX() {
		return HPosX;
	}

	public int getHTempX() {
		return HTempX;
	}

	public void setHPosY(int hPosY) {
		HPosY = hPosY;
	}

	public void setHPosX(int hPosX) {
		HPosX = hPosX;
	}

	public void setHTempX(int hTempX) {
		HTempX = hTempX;
	}

}
