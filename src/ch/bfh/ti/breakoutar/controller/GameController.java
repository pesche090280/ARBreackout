package ch.bfh.ti.breakoutar.controller;

import android.content.res.AssetManager;
import ch.bfh.ti.breakoutar.andar.GameARObject;
import ch.bfh.ti.breakoutar.common.Level;
import ch.bfh.ti.breakoutar.level.FirstLevel;
import ch.bfh.ti.breakoutar.utile.Constant;
import edu.dhbw.andar.ARToolkit;
/**
 * Controller of the game
 *
 */
public class GameController {

	// Instance variables
	private static GameController instance;
	public Level level;
	public AssetManager assetMang;	
	public GameARObjectController arObjectController;
	public int lives = 2; 

	private GameController(){} 
	
	/**
	 * Return the only one instance of game controller of the game
	 * @return instance of game controller
	 */
	public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }
	
	/**
	 * Initialize the instance of the game controller
	 * @param arToolkit ARToolkit
	 * @param assetMang AssetManager
	 */
	public void init(ARToolkit arToolkit, AssetManager assetMang) {
		this.assetMang = assetMang;
		arObjectController = new GameARObjectController();
		arObjectController.setArToolKit(arToolkit);
		
		// Creates the GameARObject for the paddle and for the main marker. Register both in the arObjectController 
		GameARObject paddleMarker = new GameARObject(Constant.PADDLE_MARKER_ID, Constant.PADDLE_MARKER, 100, new double[]{0,0});
		arObjectController.registerBreakoutARObject(Constant.PADDLE_MARKER_ID, paddleMarker);
		GameARObject mainMarker = new GameARObject(Constant.BOARD_MARKER_ID, Constant.BOARD_MARKER , 100, new double[]{0, 0});
		arObjectController.registerBreakoutARObject(Constant.BOARD_MARKER_ID, mainMarker);
	}
	
	/**
	 * Start the game
	 */
	public void startGame(){
		loadLevel();		
	}
	
	/**
	 * Load the first level
	 */
	private void loadLevel() {
		level = new FirstLevel(arObjectController, assetMang, lives);
	}
	
	/**
	 * Finish the game
	 */
	public void finishGame(){
	  // let resources frei 
	  level = null;
	  arObjectController = null;
	  assetMang = null;
	  instance = null;
	}
	
	/**
	 * Update the game 
	 * @param deltaTime the deltaTime
	 */
	public void updateGame(float deltaTime){
		Level l = level.update(deltaTime);
		// when the returned level not null is,
		// then there was a level change
		if(l != null) {
			level = l;
		}
	}

}
