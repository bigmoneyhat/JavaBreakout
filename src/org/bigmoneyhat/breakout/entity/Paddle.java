package org.bigmoneyhat.breakout.entity;

import java.io.File;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Paddle extends Entity {

	public Paddle(int x, int y, File image) {
		super(x, y, image);
		this.id = 10;
	}

	@Override
	public void update() {
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			move(Entity.LEFT);
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			move(Entity.RIGHT);
		
		if(this.x > 660)
			this.x = 660;
		if(this.x < 0)
			this.x = 0;
	}

	@Override
	public void draw() {
		GL11.glColor3f(0, 1, 0);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(0, 0);
			GL11.glVertex2f(0, 10);
			GL11.glVertex2f(140, 10);
			GL11.glVertex2f(140, 0);
		GL11.glEnd();
	}

	@Override
	public void collision(Ball b) {
		// TODO Auto-generated method stub
		
	}

}
