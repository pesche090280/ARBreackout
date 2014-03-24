package ch.bfh.ti.breakoutar.model;

import ch.bfh.ti.breakoutar.common.Bound;

/**
 * This class describes the bounding circle
 *
 */
public class BoundCircle implements Bound {
	// instance variables
	private Vector2 position;
	private float radius;
	
	/**
	 * 
	 * @param XCoordinate: x-Coordinate of the Position of the bounding circle
	 * @param YCoordinate: y-Coordinate of the Position of the bounding circle
	 * @param radius: Radius of the bounding circle
	 */
	public BoundCircle(float XCoordinate, float YCoordinate, float radius){
		this.position = new Vector2(XCoordinate, YCoordinate);
		this.radius = radius;
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
	 * Gets the radius of the bounding circle 
	 * @return radius
	 */
	public float getRadius() {
		return radius;
	}
	
	/**
	 * Sets the radius of the bounding circle
	 * @param radius
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + Float.floatToIntBits(radius);
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
		BoundCircle other = (BoundCircle) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (Float.floatToIntBits(radius) != Float.floatToIntBits(other.radius))
			return false;
		return true;
	}

}
