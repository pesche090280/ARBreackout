package ch.bfh.ti.breakoutar.andar;

import java.util.List;
import javax.microedition.khronos.opengles.GL10;

import ch.bfh.ti.breakoutar.model.BoundBox;
import ch.bfh.ti.breakoutar.model.GameShape;
import ch.bfh.ti.breakoutar.utile.FPSCounter;
//import ch.bfh.ti.breakoutar.utile.FPSCounter;

import edu.dhbw.andar.ARObject;
/**
 * In this class will be drawn all 
 * game shapes
 *
 */
public class GameARObject extends ARObject {

	private FPSCounter fps = new FPSCounter(); //  help class to count the frame per second of the game
	
	// Instance variable
 	public GameARObject paddleMarker;
	public List<GameShape> shapes; // the shapes to draw
	
	/**
	 * Construct the gameARObject 
	 * @param name name of the object
	 * @param patternName the pattern file name, where the game sahpes will be drawn 
	 * @param markerWidth marker width 
	 * @param markerCenter where is the center of the marker
	 */
	public GameARObject(String name, String patternName, double markerWidth, double[] markerCenter) {
		super(name, patternName, markerWidth, markerCenter);
	}
	
	@Override
	public void draw(GL10 gl){
		if(paddleMarker == null) // if this object is null, then is this GameARObject, it from the paddle marker.
			return;
		
		super.draw(gl);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		// draw the shapes
		for(GameShape shape : shapes) {
			gl.glPushMatrix();
			gl.glTranslatef(-shape.position.xCoordinate, -shape.position.yCoordinate, 0);
			shape.glShape.draw(gl);
			gl.glPopMatrix();
		}
		
		drawPaddle(gl);
		fps.logFrame();
	}
	
	private void drawPaddle(GL10 gl) {
		// Testen, ob der Marker des Balkens sichtbar ist
		if(paddleMarker.isVisible()) {
			// Abfragen der Werte durch die Funktion getTransMatrix()
			double[] matrixBoard = getTransMatrix();
			double[] matrixPaddle = paddleMarker.getTransMatrix();
			// Speichern der z-Koordinatenwerte der beiden Marker
			double board_z = matrixBoard[11];
			double paddle_z = matrixPaddle[11];
			// Der Faktor wird durch die Z-Koordinatenwerte berechnet.
			// Er dient dazu, den durch die unterschiedliche Grosse der Marker
			// entstandenen Fehler auszugleichen.
			double factor = paddle_z / board_z;
			// Setzen der neuen x und y Werte des Balkens
			float paddle_center_x = (float)((matrixPaddle[3] / factor)-matrixBoard[3]);
			float paddle_center_y = (float)-((matrixPaddle[7] / factor)-matrixBoard[7]);
			// Abfragen der Balken des Spiels. Diese Liste enthalt nur ein einziges Objekt, namlich
			// den Marker.
			for(GameShape shape : paddleMarker.shapes) {
				shape.position.xCoordinate = paddle_center_x;
				shape.position.yCoordinate = paddle_center_y;
				shape.bound.getPosition().xCoordinate =
						paddle_center_x - ((BoundBox)shape.bound).getWidth() /2;
				shape.bound.getPosition().yCoordinate =
						paddle_center_y - ((BoundBox)shape.bound).getHeight() /2;
				// Zeichnen des Balkens
				gl.glPushMatrix();
				gl.glTranslatef(-shape.position.xCoordinate, -shape.position.yCoordinate, 0);
				shape.glShape.draw(gl);
				gl.glPopMatrix();
			}
		}
	}

	@Override
	public void init(GL10 gl) {} //Do nothing here

}
