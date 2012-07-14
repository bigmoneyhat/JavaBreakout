package org.bigmoneyhat.breakout;

import org.bigmoneyhat.breakout.gamestate.GameState;
import org.bigmoneyhat.breakout.gamestate.InGameState;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class JavaBreakout {

	public GameState state;
	public GameState nextState;
	
	public void run() throws LWJGLException {
		Display.setDisplayMode(new DisplayMode(800, 600));
		Display.create();
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		
		changeState(new InGameState());
		
		while(!Display.isCloseRequested()) {
			if(nextState != null) {
				state = nextState;
				nextState.initialize();
				nextState = null;
			}
			
			state.update();
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			state.draw();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	public void changeState(GameState state) {
		this.nextState = state;
	}
	
	public static void main(String[] args) throws LWJGLException {
		JavaBreakout game = new JavaBreakout();
		game.run();
	}
	
}
