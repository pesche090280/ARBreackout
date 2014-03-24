package ch.bfh.ti.breakoutar.model;

import ch.bfh.ti.breakoutar.common.Bound;
/**
 * This class describes the bounding box
 *
 */
public class BoundBox implements Bound {
	// instance variables
	private Vector2 position;
	private float width, height;
	
	/**
	 * 
	 * @param xCoordinate: x-Coordinate of the Position of the bounding rectangle
	 * @param yCoordinate: y-Coordinate of the Position of the bounding rectangle
	 * @param width: Width of the bounding rectangle
	 * @param height: Height of the bounding rectangle
	 */
	public BoundBox(float xCoordinate, float yCoordinate, float width, float height){
		this.position = new Vector2(xCoordinate, yCoordinate);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public Vector2 getPosition() {
		return position;
	}

	@Override
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	
	/**
	* Getter for the width
	* @return: The with of the bounding rectangle
	*/
	public float getWidth() {
		return width;
	}
	
	/**
	 * Setter for the width
	 * @param width: The width of the bounding rectangle
	 */
	public void setWidth(float width) {
		this.width = width;
	}
	
	/**
	 * Getter for the height of the bounding rectangle
	 * @return: The height as a float value
	 */
	public float getHeight() {
		return height;
	}
	
	/**
	 * Setter for the height of the bounding rectangle
	 * @param height: The height of the bounding rectangle
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(height);
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + Float.floatToIntBits(width);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoundBox other = (BoundBox) obj;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (Float.floatToIntBits(width) != Float.floatToIntBits(other.width))
			return false;
		return true;
	}
	
}

