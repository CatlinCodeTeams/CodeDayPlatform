package Basic_Enemy;

import java.util.Random;

import janus.engine.pens.SimplestPen;
import plat.interfaces.EntityInterface;
import plat.physics.Point;
import plat.physics.Vector;

public class Basic_Enemy implements EntityInterface{
	
	Random rand = new Random();
	
	Point location;
	Vector speed;
	int radius;

	public Basic_Enemy(SimplestPen pen, int x, int y){
		
		int vx = rand.nextInt(3)+1;
		int vy = rand.nextInt(3)+1;
		
		this.location = new Point(x,y);
		this.speed = new Vector(vx,vy);
		
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
	public void update(SimplestPen pen) {
		
		this.location.move(this.speed);
		
	}

	@Override
	public void draw(SimplestPen pen) {


		pen.drawCircle((int)this.location.x, (int)this.location.y, this.radius);
		
	}

}
