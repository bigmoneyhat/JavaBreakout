package org.bigmoneyhat.breakout.gamestate;

import java.util.LinkedList;

import org.bigmoneyhat.breakout.entity.Ball;
import org.bigmoneyhat.breakout.entity.Block;
import org.bigmoneyhat.breakout.entity.Entity;
import org.bigmoneyhat.breakout.entity.Paddle;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class InGameState implements GameState {

	public LinkedList<Entity> entities = new LinkedList<Entity>();
	public boolean ballOut = false;
	public int ballButton = 0;
	public Paddle paddle;
	public Ball ball;
	
	@Override
	public void initialize() {
		paddle = new Paddle(330, 10, null);
		ball = new Ball(100, 100, null);
		entities.add(paddle);
		for(int i = 300; i < 600; i += 31) {
			for(int z = 0; z < 800; z += 81 ) {
				entities.add(new Block(z, i, null));
			}
		}
	}

	@Override
	public void update() {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
			if(entities.get(i).id == 20) {
				entities.get(i).collision(ball);
			}
			if(entities.get(i).destroy) {
				entities.remove(i);
			}
		}
		if(ball.y < 20) {
			if(ball.x < paddle.x + 140 && ball.x > paddle.x) {
				ball.vel_y *= -1;
			} else {
				entities.remove(ball);
				ballOut = false;
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			if(ballButton == 0 && !ballOut) {
				ball.x = paddle.x + 65;
				ball.y = paddle.y + 10;
				entities.add(ball);
				ballOut = true;
				ballButton = 2;
			}
			if(ballButton == 2) {
				ballButton = 1;
			}
		} else {
			ballButton = 0;
		}
	}

	@Override
	public void draw() {
		for(Entity e : entities) {
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glTranslatef(e.x, e.y, 0);
			e.draw();
			GL11.glLoadIdentity();
		}
	}

}
