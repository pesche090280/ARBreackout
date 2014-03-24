package ch.bfh.ti.breakoutar.model;

/**
 * This class describes a movement vector
 *
 */
public class Vector2 {
	// instance variables
	public static float TO_RADIANS= (1 / 180.0f) * (float) Math.PI;
	public static float TO_DEGREES= (1 / (float) Math.PI) * 180;
	public float xCoordinate, yCoordinate;
	
	/**
	 * Constructor of the class Vector2
	 * @param xCoordinate describes movement in x-direction
	 * @param yCoordinate describes movement in y-direction
	 */
	public Vector2(float xCoordinate, float yCoordinate){
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	/**
	 * Constructor of the class Vector2
	 * @param vector: An Object of Vector2
	 */
	public Vector2(Vector2 vector){
		this(vector.xCoordinate, vector.yCoordinate);
	}
	
	/**
	 * This method subtracts the chosen x and y value from the current movement vector
	 * @param xCoordinate: x-value to subtract
	 * @param yCoordinate: y-value to subtract
	 * @return
	 */
	public Vector2 substract(float xCoordinate, float yCoordinate) {
		this.xCoordinate -= xCoordinate;
		this.yCoordinate -= yCoordinate;
		return this;
	}
	
	/**
	 * This method subtracts a movement vector from the current movement vector
	 * @param otherVector: Vector2 to subtract
	 * @return
	 */
	public Vector2 substract(Vector2 otherVector) {
		xCoordinate -= otherVector.xCoordinate;
		yCoordinate -= otherVector.yCoordinate;
		return this;
		
	}
	
	/**
	 * This method adds the chosen x and y value to the current movement vector
	 * @param xCoordinate: The x value to add
	 * @param yCoordinate: The y value to add
	 * @return a Vector2 object
	 */
	public Vector2 add(float xCoordinate, float yCoordinate) {
		this.xCoordinate += xCoordinate;
		this.yCoordinate += yCoordinate;
		return this;
	}
	
	/**
	 * This method adds a movement vector to the current movement vector
	 * @param otherVector: The added vector as an Vector2 Object
	 * @return a Vector2 object
	 */
	public Vector2 add(Vector2 otherVector) {
		xCoordinate += otherVector.xCoordinate;
		yCoordinate += otherVector.yCoordinate;
		return this;
		
	}
	
	/**
	 * Multiplies the movement vector with a float number
	 * @param scalar: Float number
	 * @return a Vector2 object
	 */
	public Vector2 multiply(float scalar) {
		this.xCoordinate *= scalar;
		this.yCoordinate *= scalar;
		return this;
	}
	
	/**
	 * Method returns the Length of the current movement vector
	 * @return Float number describes the length of vector
	 */
	public float getVectorLength() {
		return (float)Math.sqrt(xCoordinate * xCoordinate + yCoordinate * yCoordinate);
	}
	
	/**
	 * Gets the Distance between the two vectors
	 * @param otherVector: A Vector2 Object
	 * @return float value with the distance
	 */
	public float getDistance(Vector2 otherVector) {
		float xDistance = this.xCoordinate - otherVector.xCoordinate;
		float yDistance = this.yCoordinate - otherVector.yCoordinate;
		return (float)Math.sqrt(xDistance * xDistance + xDistance * yDistance);
	}
	
	/**
	 * Gets the Distance between the two vectors
	 * @param xCoordinate: x-Coordinate of the vector
	 * @param yCoordinate: y-Coordinate of the vector
	 * @return float value with the distance
	 */
	public float getDistance(float xCoordinate, float yCoordinate) {
		float xDistance = this.xCoordinate - xCoordinate;
		float yDistance = this.yCoordinate - yCoordinate;
		return (float)Math.sqrt(xDistance * xDistance + yDistance * yDistance);
	}
	
	/**
	 * Returns the angle in degrees
	 * @return The angle as a float number
	 */
	public float getAngleInDegrees() {
		float angleInDregrees = (float) Math.atan2(yCoordinate, xCoordinate) * TO_DEGREES;
		if(angleInDregrees < 0){
			angleInDregrees += 360;
		}
		return angleInDregrees;
	}
	
	/**
	 * Turns around the given angle
	 * @param angle: The angle in degrees 
	 * @return the new Vector2
	 */
	public Vector2 rotate(float angle) {
		float angleInRadian = angle * TO_RADIANS;
		float cosinus = (float) Math.cos(angleInRadian);
		float sinus = (float) Math.sin(angleInRadian);
		float newXCoordinate = xCoordinate * cosinus - yCoordinate * sinus;
		float newYCoordinate = xCoordinate * sinus + yCoordinate * cosinus;
		xCoordinate = newXCoordinate;
		yCoordinate = newYCoordinate;
		return this;
	}
	
	/**
	 * Calculates the normal vector
	 */
	public void nor(){
		float length = getVectorLength();
		if(length != 0){
			this.xCoordinate /=length;
			this.yCoordinate /= length;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(xCoordinate);
		result = prime * result + Float.floatToIntBits(yCoordinate);
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
		Vector2 other = (Vector2) obj;
		if (Float.floatToIntBits(xCoordinate) != Float
				.floatToIntBits(other.xCoordinate))
			return false;
		if (Float.floatToIntBits(yCoordinate) != Float
				.floatToIntBits(other.yCoordinate))
			return false;
		return true;
	}
		
}
