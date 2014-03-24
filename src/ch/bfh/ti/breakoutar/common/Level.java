package ch.bfh.ti.breakoutar.common;

import ch.bfh.ti.breakoutar.controller.GameARObjectController;
import android.content.res.AssetManager;

/**
 * Level Abstract class. 
 *
 */
public abstract class Level {
	
	//Instance variables
	protected GameARObjectController gameARObjectController;
	protected AssetManager assetMang;
	protected int lives;    // lives in this level(from the player)
    protected int shapesToDestroy; //
	
	public LevelState levelState;
	
	// States of the level
	public enum LevelState {
		BEGIN, PAUSE, RUN, FINISH, WIN, LOST;
	}

	/**
	 * Construct the level
	 * @param gameARObjectController the controller of the ARObjects
	 * @param assetMang object to set the texture
	 * @param lives lives in this level.
	 */
	public Level(GameARObjectController gameARObjectController, AssetManager assetMang, int lives) {
		this.gameARObjectController = gameARObjectController;
		this.assetMang = assetMang;
		this.lives = lives;
		levelState = LevelState.BEGIN;
		createLevel();
		levelState = LevelState.RUN;
	}
	
	/**
	 * Create the level
	 */
	protected abstract void createLevel();
	
	/**
	 * Update the level
	 * @param deltaTime delta time to update the level
	 * @return a new level if the current is finished, else return null
	 */
	public abstract Level update(float deltaTime);

}
