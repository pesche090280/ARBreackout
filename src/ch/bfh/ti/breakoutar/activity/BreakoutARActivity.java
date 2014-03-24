package ch.bfh.ti.breakoutar.activity;

import ch.bfh.ti.breakoutar.andar.*;
import ch.bfh.ti.breakoutar.controller.GameController;
import edu.dhbw.andar.AndARActivity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;

/**
 * This class activates the camera of
 * the phone and starts the game
 *
 */
public class BreakoutARActivity extends AndARActivity {
	
	// Instance variables
	public static SoundPool soundPool;
	public static int hitBrickTrack;
	public static int hitWallTrack;
	public static int hitPaddleTrack;
	private GameController gameController;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setNonARRenderer(new GameRenderer());
		// Create a Sound Pool
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		int maxStreams = 10;
		soundPool = new SoundPool(maxStreams, AudioManager.STREAM_MUSIC, 0);
	    hitBrickTrack = soundPool.load(this, R.raw.hit_brick, 0);
	    hitWallTrack = soundPool.load(this, R.raw.hit_wall, 0);
	   
	    gameController = GameController.getInstance();
	    gameController.init(getArtoolkit(), getAssets());
	    gameController.startGame();
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		Log.d("Ex", ex.getMessage());
	}


    @Override
	protected void onPause() {
	   super.onPause();
	   gameController.finishGame();
	   soundPool.release();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		gameController.finishGame();
		soundPool.release();
	}

	@Override
	protected void onStop() {
		super.onStop();
		gameController.finishGame();
		soundPool.release();
	}
}
