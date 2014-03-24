package ch.bfh.ti.breakoutar.andar;

import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

import ch.bfh.ti.breakoutar.common.Level.LevelState;
import ch.bfh.ti.breakoutar.controller.GameController;
import ch.bfh.ti.breakoutar.utile.Constant;
import edu.dhbw.andar.interfaces.OpenGLRenderer;
import edu.dhbw.andar.util.GraphicsUtil;
/**
 * Render the game
 *
 */
public class GameRenderer implements OpenGLRenderer {
		
	private float[] ambientlight1 = {.3f, .3f, .3f, 1f};
	private float[] diffuselight1 = {.7f, .7f, .7f, 1f};
	private float[] lightposition1 = {0f,-40.0f,100.0f,1f};

	private FloatBuffer lightPositionBuffer1 =  GraphicsUtil.makeFloatBuffer(lightposition1);
	private FloatBuffer diffuseLightBuffer1 = GraphicsUtil.makeFloatBuffer(diffuselight1);
	private FloatBuffer ambientLightBuffer1 = GraphicsUtil.makeFloatBuffer(ambientlight1);
	
	private float startTime;
	

	@Override
	public void draw(GL10 gl) {
		float deltaTime = startTime == 0 ? 0 : (System.nanoTime() - startTime) / 1000000000.0f;
		startTime = System.nanoTime();
		
		//update the game
		GameController gameController = GameController.getInstance();
		GameARObject fromBoardMarker = gameController.arObjectController.breakoutARObjects.get(Constant.BOARD_MARKER_ID);
		GameARObject fromPaddleMarker = gameController.arObjectController.breakoutARObjects.get(Constant.PADDLE_MARKER_ID);
		// if both GameARObject not null and visible are and the level is running too, update the game
		if(fromBoardMarker != null && fromBoardMarker.isVisible() && fromPaddleMarker != null && fromPaddleMarker.isVisible() && gameController.level.levelState == LevelState.RUN)
			gameController.updateGame(deltaTime);
		
		
	}

	@Override
	public void initGL(GL10 gl) {
	    gl.glDisable(GL10.GL_COLOR_MATERIAL);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_LIGHTING);
        gl.glEnable(GL10.GL_NORMALIZE);
        gl.glEnable(GL10.GL_RESCALE_NORMAL);
        
        gl.glClearDepthf(1.0f);
        gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthMask(true);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
	}

	
	@Override
	public void setupEnv(GL10 gl) {
		     gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_AMBIENT, ambientLightBuffer1);
             gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_DIFFUSE, diffuseLightBuffer1); 
             gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_POSITION, lightPositionBuffer1);
             gl.glEnable(GL10.GL_LIGHT1);
             gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
             gl.glDisable(GL10.GL_TEXTURE_2D);               
		 }
		 
	}
