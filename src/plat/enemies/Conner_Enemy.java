package plat.enemies;

import java.awt.Color;
import java.util.ArrayList;

import plat.interfaces.*;
import plat.physics.*;
import plat.blocks.*;
import janus.engine.pens.SimplestPen;

//position is at the top left

public class Conner_Enemy extends Fallable implements EntityInterface {
	Point position;
	Vector velocity;
	int height;
	int width;
	
	public Conner_Enemy (int xStart, int yStart) {
		position = new Point (xStart, yStart);
		velocity = new Vector (.4, 0);
		height = 40;
		width = 40;
		falling = true;
	}
	public Point get_Point() {
		return position;
	}

	public Vector get_Vector() {
		return velocity;
	}
	
	public int getLowerLeft() {
		return (int) position.x;
	}
	public int getLowerRight() {
		return (int) position.x + width;
	}
	
	public int height() {
		return height;
	}
	
	public Vector getVector() {
		return velocity;
	}
	
	public int bottom() {
		return (int) position.y + height;
	}

	public void update(SimplestPen pen, ArrayList<Block> blockList) {
		Block[] b = new Block[blockList.size()];
		blockList.toArray(b);
		if (!falling) {
			Point oldPosition = position;
			Vector oldVelocity = velocity;
			position.move(velocity);
			velocity = gravitate (b);
			if (falling) {
				position = oldPosition;
				velocity = oldVelocity;
				//velocity.horizontal = -1 * velocity.horizontal;
				velocity.vertical -= 3;
			}
		} else {
			velocity = gravitate (b);
			position.move(velocity);
		}
		position.move(velocity);
	}

	public void draw(SimplestPen pen) {
		pen.setColor(new Color(0, 255, 255));
		pen.fillCircle((int) this.position.x, (int) this.position.y + height/2,
		20);
	}
	@Override
	public int top() {
		return (int) position.y;
	}
}
