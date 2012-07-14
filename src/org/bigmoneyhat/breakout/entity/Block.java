package org.bigmoneyhat.breakout.entity;

import java.awt.Rectangle;
import java.io.File;

import org.lwjgl.opengl.GL11;

public class Block extends Entity {

	public Rectangle topRect;
	public Rectangle bottomRect;
	public Rectangle leftRect;
	public Rectangle rightRect;

	public Block(int x, int y, File image) {
		super(x, y, image);
		topRect = new Rectangle(x, y + 25, 80, 5);
		bottomRect = new Rectangle(x, y, 80, 5);
		leftRect = new Rectangle(x, y, 5, 30);
		rightRect = new Rectangle(x + 75, y, 5, 30);
		id = 20;
	}

	@Override
	public void update() {

	}

	@Override
	public void draw() {
		GL11.glColor3f(0, 0, 0);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(0, 0);
		GL11.glVertex2f(0, 30);
		GL11.glVertex2f(80, 30);
		GL11.glVertex2f(80, 0);
		GL11.glEnd();
		GL11.glColor3f(0, 0, 1);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(0, 0);
		GL11.glVertex2f(0, 28);
		GL11.glVertex2f(78, 28);
		GL11.glVertex2f(78, 0);
		GL11.glEnd();
	}

	public void collision(Ball b) {
		if(topRect.intersects(b.ballRect) || bottomRect.intersects(b.ballRect)) {
			b.vel_y *= -1;
			this.destroy = true;
		}
		if(leftRect.intersects(b.ballRect) || rightRect.intersects(b.ballRect)) {
			b.vel_x *= -1;
			this.destroy = true;
		}
	}
}
