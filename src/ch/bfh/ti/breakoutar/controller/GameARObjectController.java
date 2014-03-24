package ch.bfh.ti.breakoutar.controller;

import java.util.HashMap;
import java.util.Map;
import ch.bfh.ti.breakoutar.andar.GameARObject;
import edu.dhbw.andar.ARToolkit;
import edu.dhbw.andar.exceptions.AndARException;

/**
 * This class controls all GameARObject. 
 *
 */
public class GameARObjectController {
	
	//Instance variable
	private ARToolkit arToolKit;
	public Map<String, GameARObject> breakoutARObjects = new HashMap<String, GameARObject>();

	/**
	 * Get the ARToolkit
	 * @return ARToolkit
	 */
	public ARToolkit getArToolKit() {
		return arToolKit;
	}

	/**
	 * Set the ARToolkit
	 * @param arToolKit ARToolkit
	 */
	public void setArToolKit(ARToolkit arToolKit) {
		this.arToolKit = arToolKit;
	}	
	
	/**
	 * Register the GameARObject with its name
	 * @param name the name of the GameARObject
	 * @param arObject the GameARObject
	 */
	public void registerBreakoutARObject(String name, GameARObject arObject){
		try {
			this.arToolKit.registerARObject(arObject);
			this.breakoutARObjects.put(name, arObject);
		} 
		catch (AndARException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Unregister the GameARObject
	 * @param arObject the GameARObject
	 */
	public void unRegisterBreakoutARObject(GameARObject arObject){
		try{
			this.arToolKit.unregisterARObject(arObject);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

