package ch.bfh.ti.breakoutar.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
/**
 * This class is used to show the start
 * screen of the game 
 *
 */
public class BreakoutLauncherActivity extends Activity  {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
	}
	
	/**
	 * Start the BreakoutARActivity class when the play button is clicked.
	 * @param view the view
	 */
	public void play(View view){
		Intent intent = new Intent(getApplicationContext(), BreakoutARActivity.class);
		intent.setAction(Intent.ACTION_VIEW);
		startActivity(intent);
	}
	
	/**
	 * Start the HeighScoreActivity class when the highScore button is clicked.
	 * @param view the view
	 */
	public void highScore(View view){
		//TODO 
	}
	
	/**
	 * Start the HelpActivity class when the highScore button is clicked.
	 * @param view the view
	 */
	public void help(View view){
		startActivity(new Intent(this, BreakoutHelpActivity.class));
	}

}