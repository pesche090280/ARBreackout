package ch.bfh.ti.breakoutar.model;

import ch.bfh.ti.breakoutar.common.Bound;
import ch.bfh.ti.breakoutar.common.GLShape;

/**
 * Describes a Shape of the game
 *
 */
public class GameShape {
	// instance variables
	public final String id;
	public Vector2 position;
	public Bound bound;
	public GLShape glShape;
	public int liveQuantity = 1;  // how many times muss a shape be hitting to disappear  
	public Vector2 velocity;
	public boolean collided;
	
	/**
	 * Constructor of the GameShape Object
	 * @param id: Id of the Shape Object
	 * @param xCoordinate: x-Coordinate of the GameShape Object
	 * @param yCoordinate: y-Coordinate of the GameShape Object
	 * @param bound: Bound Interface
	 * @param glShape: GLShape interface 
	 */
	public GameShape(String id, float xCoordinate, float yCoordinate, Bound bound, GLShape glShape) {
		this.id = id;
		this.position = new Vector2(xCoordinate, yCoordinate);
		this.bound = bound;
		this.glShape = glShape;
	}
	
	/**
	 * Constructor of the GameShape Object
	 * @param id: Id of the GameShape Object
	 * @param xCoordinate: x-Coordinate of the GameShape Object
	 * @param yCoordinate: y-Coordinate of the GameShape Object
	 * @param bound: Bound Interface
	 * @param liveQuantity: How many lives the shape has to disappear after being hitting
	 * @param glShape: GLShape interface 
	 */
	public GameShape(String id, float xCoordinate, float yCoordinate, Bound bound, int liveQuantity ,GLShape glShape) {
		this(id, xCoordinate, yCoordinate, bound , glShape);
		this.liveQuantity = liveQuantity;
	}
	
	/**
	 * Constructor of the GameShape Object
	 * @param id: Id of the GameShape Object
	 * @param xCoordinate: x-Coordinate of the GameShape Object
	 * @param yCoordinate: y-Coordinate of the GameShape Object
	 * @param bound: Bound Interface
	 * @param velocity: Vector2 with the velocity of the GameShape
	 * @param glShape: GLShape interface 
	 */
	public GameShape(String id, float xCoordinate, float yCoordinate, Bound bound, Vector2 velocity, GLShape glShape) {
		this(id, xCoordinate, yCoordinate, bound , glShape);
		this.velocity = velocity;
	}
	
	/**
	 * 
	 * @param id: Id of the GameShape Object
	 * @param xCoordinate: x-Coordinate of the GameShape Object
	 * @param yCoordinate: y-Coordinate of the GameShape Object
	 * @param bound: Bound Interface
	 * @param liveQuantity: How many lives the shape has to disappear after being hitting
	 * @param velocity: Vector2 with the velocity of the GameShape
	 * @param glShape: GLShape interface 
	 */
	public GameShape(String id, float xCoordinate, float yCoordinate, Bound bound, int liveQuantity, Vector2 velocity, GLShape glShape) {
		this(id, xCoordinate, yCoordinate, bound ,liveQuantity , glShape);
		this.velocity = velocity;
	}
	
	/**
	 * Subtracts one live of the shape
	 */
	public void removeLive(){
		liveQuantity--;
	}
	
	/**
	 * Updates the position of the GameShape
	 * @param deltaTime
	 */
	public void update(float deltaTime){
		if(velocity != null){
			position.add(velocity.xCoordinate * deltaTime, velocity.yCoordinate * deltaTime);
			bound.getPosition().add(velocity.xCoordinate * deltaTime, velocity.yCoordinate * deltaTime);
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bound == null) ? 0 : bound.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + liveQuantity;
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result
				+ ((velocity == null) ? 0 : velocity.hashCode());
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
		GameShape other = (GameShape) obj;
		if (bound == null) {
			if (other.bound != null)
				return false;
		} else if (!bound.equals(other.bound))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (liveQuantity != other.liveQuantity)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (velocity == null) {
			if (other.velocity != null)
				return false;
		} else if (!velocity.equals(other.velocity))
			return false;
		return true;
	}
}
