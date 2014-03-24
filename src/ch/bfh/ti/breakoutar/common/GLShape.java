package ch.bfh.ti.breakoutar.common;

import javax.microedition.khronos.opengles.GL10;

/**
 * 
 * GLShape Interface
 *
 */
public interface GLShape {

	/**
	 * Draw the gl shape
	 * @param gl object to draw the shape 
	 */
	public void draw(GL10 gl);

	/**
	 * Set the texture to gl shape
	 * @param textureName
	 */
	public void setTextureName(String textureName);
	
	/**
	 * Set the vertexes to the gl shape 
	 * @param x width 
	 * @param y height
	 * @param z deep
	 */
	public void setVertex(float x, float y, float z);
}
