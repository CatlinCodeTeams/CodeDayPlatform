package plat.enemies;

import plat.interfaces.*;
import plat.physics.*;
import plat.blocks.*;
import janus.engine.pens.SimplestPen;
import janus.engine.pens.SimplestPen.*;

class Conner_Enemy implements EntityInterface {
	Point position;
	Vector velocity;
	Conner_Enemy (int xStart, int yStart) {
		position = new Point (xStart, yStart);
	}
	public Point get_Point() {
		return position;
	}

	public Vector get_Vector() {
		return velocity;
	}

	public void update(SimplestPen pen, ArrayList<Block> blockList) {
		
	}

	public void draw(SimplestPen pen);
}