package plat.enemies;

import plat.interfaces.*;
import plat.physics.*;

class Conner_Enemy implements EntityInterface {
	Point position;
	Vector velocity;
	Conner_Enemy (int xStart, int yStart) {
		position = new Point (xStart, yStart);
	}
	public update (SimplestPen pen) {
		
	}
}