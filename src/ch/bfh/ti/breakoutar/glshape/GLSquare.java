package ch.bfh.ti.breakoutar.glshape;

import java.io.IOException;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
import android.util.Log;

import ch.bfh.ti.breakoutar.common.GLShape;
//import ch.bfh.ti.breakoutar.utile.FPSCounter;
import edu.dhbw.andar.util.GraphicsUtil;

/**
 * This class draws a square
 *
 */
public class GLSquare implements GLShape {
	// instance variables
	private AssetManager assets;
	private FloatBuffer mVertexBuffer;
	private FloatBuffer mTextureBuffer;
	private int textureId;
	private Bitmap bitmap;
	
	/**
	 * Constructor of the class GLSquare
	 * @param textureName: The name of the texture as a String
	 * @param x: The size of the edge in x direction
	 * @param y: The size of the edge in y direction
	 * @param z: The size of the edge in z direction
	 * @param assets: The AssetManager gives us a link to the texture
	 */
	public GLSquare(String textureName, float x, float y, float z, AssetManager assets) {
		this.assets = assets;

		setVertex(x, y, z);
		
		float[] textures = {

				0.0f, 1.0f, // A. left-bottom
				1.0f, 1.0f, // B. right-bottom
				0.0f, 0.0f, // C. left-top
				1.0f, 0.0f, // D. right-top

				0.0f, 1.0f,
				1.0f, 1.0f,
				0.0f, 0.0f,
				1.0f, 0.0f,	

				0.0f, 1.0f,
				1.0f, 1.0f,
				0.0f, 0.0f,
				1.0f, 0.0f,

				0.0f, 1.0f,
				1.0f, 1.0f,
				0.0f, 0.0f,
				1.0f, 0.0f,

				0.0f, 1.0f,
				1.0f, 1.0f,
				0.0f, 0.0f,
				1.0f, 0.0f,

				0.0f, 1.0f,
				1.0f, 1.0f,
				0.0f, 0.0f,
				1.0f, 0.0f,
		};
		
		mTextureBuffer = GraphicsUtil.makeFloatBuffer(textures);
		setTextureName(textureName);	
	}
	
	@Override
	public void setVertex(float x, float y, float z){
		float squareVertices[] =  {
				// FRONT
				-x, -y,  z, 
				x, -y,  z, 
				-x,  y,  z,
				x,  y,  z,
				// BACK
				-x, -y,  z,
				-x,  y, -z,
				x, -y, -z,
				x,  y, -z,
				// LEFT
				-x, -y,  z,
				-x,  y,  z,
				-x, -y, -z,
				-x,  y, -z,
				// RIGHT
				x, -y, -z,
				x,  y, -z,
				x, -y,  z,
				x,  y,  z,
				// TOP
				-x,  y,  z,
				x,  y,  z,
				-x,  y, -z,
				x,  y, -z,
				// BOTTOM
				-x, -y,  z,
				-x, -y, -z,
				x, -y,  z,
				x, -y, -z

		};
		mVertexBuffer = GraphicsUtil.makeFloatBuffer(squareVertices);
	}
	
	@Override
	public void setTextureName(String textureName) {
		if(bitmap != null) {bitmap.recycle();}
		
		// get picture for texture
		try {
			 bitmap = BitmapFactory.decodeStream(this.assets.open(textureName));
		} 
		catch (IOException e) {
			Log.d("Texture", "couldn't load asset Square-Texture!");
		}
	}

	@Override
	public void draw(GL10 gl) { 
		gl.glPushMatrix();		
		gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);	
		gl.glEnable(GL10.GL_TEXTURE_2D);	
		loadGLTexture(gl);
		
		// Point to our buffers
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

		// Point to our vertex buffer
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);
				
		for(int face = 0 ; face < 6; face++){
			// Draw the vertices as triangle strip
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, face* 4, 4);
		}

		//Disable the client state before leaving
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glPopMatrix();
		
//		fpsCounter.logFrame();

	}

	/**
	 * Method to load the texture
	 * @param gl Object
	 */
	private void loadGLTexture(GL10 gl) {
		if(bitmap != null){
			int textureIds[] = new int[1];
			// generate one texture pointer
			gl.glGenTextures(1, textureIds, 0);
			textureId = textureIds[0];
			//bind it to our array
			gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);
			// create nearest filtered texture
			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
			// Use Android GLUtils to specify a two-dimensional texture image from our bitmap 
			GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
			GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
		}
		
	}
}
