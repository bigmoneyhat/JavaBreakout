package org.bigmoneyhat.breakout.entity;

import java.io.File;

public abstract class Entity {

	public int y;
	public int x;
	public File texture;
	public int id;
	public boolean destroy = false;
	
	//These integers were added simply to make movement easier to understand.
	public static int LEFT = 0;
	public static int RIGHT = 1;
	
	//The super constructor for the class. File image is the texture file, and x and y are self-explanatory.
	public Entity(int x, int y, File image) {
		this.x = x;
		this.y = y;
		this.texture = image;
	}
	
	//The update for the Entity. Will be used to change position, detect collisions, and much more
	public abstract void update();
	
	//The draw function for the Entity. Will draw the entity
	public abstract void draw();
	
	//Check for collisions(only for certain entities)
	public abstract void collision(Ball b);
	
	//The move function changes the x and y position of the entity based upon what direction is given.
	public void move(int dir) {
		switch(dir) {
		case 0:
			this.x -= 10;
			break;
		case 1:
			this.x += 10;
			break;
		}
	}
	
}
