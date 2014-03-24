package ch.bfh.ti.breakoutar.common;
import ch.bfh.ti.breakoutar.model.Vector2;
/**
 * 
 * Bound Interface
 */
public interface Bound {

	/**
	 * Get the position of the bound
	 * @return the vector2
	 */
	public Vector2 getPosition();
	
	/**
	 * Set the position of the bound
	 * @param position position of the bound
	 */
	public void setPosition(Vector2 position);
	
	/**
	 * Get the hashCode of the bound 
	 * @return
	 */
	public int hashCode();

	/**
	 * Test if the bound are equals
	 * @param obj the bound
	 * @return true if the are equals or false if not.
	 */
	public boolean equals(Object obj);
}
