package ch.bfh.ti.breakoutar.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
/**
 * This class is used to show the
 * help screen of the game 
 *
 */
public class BreakoutHelpActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.help);
		
	
	}
	
	
	
}
