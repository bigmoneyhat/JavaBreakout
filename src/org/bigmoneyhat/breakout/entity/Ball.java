package org.bigmoneyhat.breakout.entity;

import java.awt.Rectangle;
import java.io.File;

import org.lwjgl.opengl.GL11;

public class Ball extends Entity {
	
	public Rectangle ballRect;
	public int vel_x = 5;
	public int vel_y = 5;
	Paddle paddle;
	
	public Ball(int x, int y, File image) {
		super(x, y, image);
		id = 30;
		ballRect = new Rectangle(x, y, 10, 10);
	}

	@Override
	public void update() {
		if(x > 790 || x < 0)
			vel_x *= -1;
		if(y > 590 || y < 0)
			vel_y *= -1;
		
		this.x += vel_x;
		this.y += vel_y;
		ballRect.x = this.x;
		ballRect.y = this.y;
	}

	@Override
	public void draw() {
		GL11.glColor3f(1, 0, 0);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(0, 0);
			GL11.glVertex2f(0, 10);
			GL11.glVertex2f(10, 10);
			GL11.glVertex2f(10, 0);
		GL11.glEnd();
	}

	@Override
	public void collision(Ball b) {
		// TODO Auto-generated method stub
		
	}
	
}
