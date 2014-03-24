package ch.bfh.ti.breakoutar.controller;
import ch.bfh.ti.breakoutar.model.BoundBox;
import ch.bfh.ti.breakoutar.model.BoundCircle;

/**
 * 
 * Controls the collisions between the Shapes
 *
 */
public final class CollisionController {
	
	/**
	 * If the circle and the rectangle collide it returns true. Otherwise false. 
	 * @param bCircle: The bounding circle of the ball
	 * @param bBox: The bounding box of the bar or brick
	 * @return boolean
	 */
	public static boolean overloapCircleAndRectangle(BoundCircle bCircle, BoundBox bBox){
				
		// Stores the x, y coordinates of the position of the bounding circle
		// which are the middle point of the circle
		float bCircleXCoordinate = bCircle.getPosition().xCoordinate;
		float bCircleYCoordinate = bCircle.getPosition().yCoordinate;
		
		// Sets the coordinates of the position of the bounding circle as x, y coordinates
		// of the searched point in the bounding box. The point is the nearest point to the
		// center of the bounding circle.
		float closestX = bCircleXCoordinate;
		float closestY = bCircleYCoordinate;

		// Stores the x, y coordinates of the position at the bottom left corner of the bounding 
		// box and the width and height of the box.
		float bBoxXCoordinate = bBox.getPosition().xCoordinate;
		float bBoxYCoordinate = bBox.getPosition().yCoordinate;
		float bBoxWidth = bBox.getWidth();
		float bBoxHeight = bBox.getHeight();

		// If the x coordinate of the Bounding circles position is smaller
		// than the x coordinate of the position of the bounding Box, the x coordinate
		// of the searched point is the same than the x coordinate of 
		// the bounding box.
		if(bCircleXCoordinate < bBoxXCoordinate){
			closestX = bBoxXCoordinate;
		}
		
		// Here is tested, if the x coordinate of the position of the bounding circle
		// is bigger than the x coordinate of the bounding box in addition of the width.
		else if(bCircleXCoordinate > bBoxXCoordinate + bBoxWidth){
			closestX = bBoxXCoordinate + bBoxWidth;
		}

		// The following two conditions make the same than the 
		// previous two but for the y coordinates
		// of the searched point
		if(bCircleYCoordinate < bBoxYCoordinate){
			closestY = bBoxYCoordinate;
		}
		else if(bCircleYCoordinate > bBoxYCoordinate + bBoxHeight){
			closestY = bBoxYCoordinate + bBoxHeight;
		}
		
		// Because the x, y coordinates of the searched point are known, we can test
		// if the circle with the bounding box collides. 
		return bCircle.getPosition().getDistance(closestX, closestY) <= bCircle.getRadius();
	}



}
