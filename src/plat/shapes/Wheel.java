package plat.shapes;

import janus.engine.pens.SimplestPen;

import java.awt.Color;
import java.util.Random;

import plat.physics.Point;



public class Wheel{
	
	Random rand = new Random();

	Color color;
	double angle;
	double length;
	int width;
	int speed;
	Point location;

	public Wheel(int size, int start_angle, int section_width, int spd, int x_loc, int y_loc, Color color){
		this.location = new Point(x_loc, y_loc);
		angle = start_angle;
		length = size;

		speed = spd;
		width = section_width;
		this.color = color;
		
		
	}
	public void update(SimplestPen pen){

		angle +=this.speed;
	}
	public void draw(SimplestPen pen){

		pen.setColor(this.color);
		pen.simplePen.fillArc((int)(location.x-(length/2)), (int)(location.y-(length/2)), (int)length, (int)length, (int)this.angle, width);


	}

}
