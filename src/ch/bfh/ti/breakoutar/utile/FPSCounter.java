package ch.bfh.ti.breakoutar.utile;

import android.util.Log;

//Diese Klasse dient dazu,
//die Anzahl Frames pro Sekunde zu berechnen
public class FPSCounter {
	
	private long startTime = System.nanoTime();
	private int frames = 0;
	//Gibt die Anzahl Frames pro Sekunde aus
	public void logFrame() {
		frames++;
		if(System.nanoTime() - startTime >= 1000000000) {
			Log.d("FPSCounter", "fps: " + frames);
			frames = 0;
			startTime = System.nanoTime();
		}
	}
}