package plat.enemies;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import janus.engine.pens.SimplestPen;
import plat.blocks.Block;
import plat.interfaces.EntityInterface;
import plat.physics.Point;
import plat.physics.Vector;

public class Basic_Enemy implements EntityInterface {

	Point location;
	Vector speed;
	int radius;

	public Basic_Enemy(SimplestPen pen, int x, int y) {

		Random rand = new Random();

		int vx = rand.nextInt(10) - 10;
		int vy = rand.nextInt(10) - 10;

		location = new Point(x, y);
		speed = new Vector(vx, vy);

		this.radius = 15;

	}

	@Override
	public Point get_Point() {
		return this.location;
	}

	@Override
	public Vector get_Vector() {
		return this.speed;
	}

	@Override
	public void update(SimplestPen pen, ArrayList<Block> block_list) {

		this.location.move(this.speed);

	}

	@Override
	public void draw(SimplestPen pen) {

		pen.setColor(new Color(255, 255, 255));
		pen.fillCircle((int) this.location.x, (int) this.location.y,
				this.radius);

	}

}
