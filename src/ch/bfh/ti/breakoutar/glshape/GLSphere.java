package ch.bfh.ti.breakoutar.glshape;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
import ch.bfh.ti.breakoutar.common.GLShape;

/**
 * This class draws a Sphere
 *
 */
public class GLSphere implements GLShape {
	// instance variables
	private FloatBuffer sphereVertex;  
    private static final double  M_STEP = 4;
    private static double DEGREES = Math.PI / 180;
    private int mPoints;
	private float radius;
	
	/**
	 * The Constructor of the class GLSphere
	 * @param radius: Radius of the sphere
	 */
	public GLSphere(float radius) {
		sphereVertex = ByteBuffer.allocateDirect( 400000 ).order(
                        ByteOrder.nativeOrder() ).asFloatBuffer();
		this.radius = radius;
        mPoints = build();
 	
	}

	@Override
	public void draw(GL10 gl) {
		gl.glPushMatrix();
		gl.glColor4f(1.0f, 0.0f, 0.0f, 0.5f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, sphereVertex);
        gl.glDrawArrays(GL10.GL_POINTS, 0, mPoints);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPopMatrix();
       
	}
	
	/**
	 * Method to set the points on the surface of the sphere
	 * @return The points of the GLSphere
	 */
    private int build() {
        /**
         * x = p * sin(phi) * cos(theta)
         * y = p * sin(phi) * sin(theta)
         * z = p * cos(phi)
         */
        double dTheta = M_STEP * DEGREES;
        double dPhi = dTheta;
        int points = 0;
        for(double phi = -(Math.PI); phi <= Math.PI; phi+=dPhi) {
            //for each stage calculating the slices
            for(double theta = 0.0; theta <= (Math.PI * 2); theta+=dTheta) {
                sphereVertex.put((float) (radius * Math.sin(phi) * Math.cos(theta)) );
                sphereVertex.put((float) (radius * Math.sin(phi) * Math.sin(theta)) );
                sphereVertex.put((float) (radius * Math.cos(phi)) );
                points++;
            }
        }
        sphereVertex.position(0);
        return points;
    }

	@Override
	public void setTextureName(String textureName) {} //Do nothing here

	@Override
	public void setVertex(float x, float y, float z) {} //Do nothing here
}
