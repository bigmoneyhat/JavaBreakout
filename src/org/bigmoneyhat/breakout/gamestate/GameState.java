package org.bigmoneyhat.breakout.gamestate;

public interface GameState {
	
	//Initialize the gamestate. Basically all the shit to do when the gamestate is started
	public void initialize();
	
	//Update all of the contents inside of the gamestate
	public void update();
	
	//Draw all of the contents to the gamestate.
	public void draw();
	
}
