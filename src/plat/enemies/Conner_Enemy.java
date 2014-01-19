package plat.enemies;

import java.awt.Color;
import java.util.ArrayList;

import plat.interfaces.*;
import plat.physics.*;
import plat.blocks.*;
import janus.engine.pens.SimplestPen;
import janus.engine.pens.SimplestPen.*;

//position is at the top left

class Conner_Enemy extends Fallable implements EntityInterface {
	Point position;
	Vector velocity;
	int height;
	int width;
	
	Conner_Enemy (int xStart, int yStart) {
		position = new Point (xStart, yStart);
		height = 40;
		width = 40;
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

	public void update(SimplestPen pen, ArrayList<Block> blockList) {
		Block[] b = new Block[blockList.size()];
		blockList.toArray(b);
		velocity = gravitate (b);
	}

	public void draw(SimplestPen pen) {
		pen.setColor(new Color(255, 255, 255));
		pen.fillCircle((int) this.position.x, (int) this.position.y,
		20);
	}
}