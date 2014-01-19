package plat.shapes;

import janus.engine.pens.SimplestPen;

import java.awt.Color;
import java.util.ArrayList;

import plat.physics.Point;

//Need to add custom colors

public class Pinwheel{
	
	Wheel[] wheels;
	int num;
	double chunk_size;
	int length;
	Point location;
	
	public Pinwheel(int num_sections, int wheel_radius, int speed, int x_loc, int y_loc, ArrayList<Color>color_list, SimplestPen pen){

		
		this.location = new Point(x_loc, y_loc);
		length = wheel_radius;
		
		num = num_sections;
		chunk_size = (360.0/num_sections);
		
		wheels = new Wheel[num_sections];
		
		int color_counter = 0;
		int color_length = color_list.size();
		
		for (int x = 0; x<num; x++){
			double start_angle = chunk_size*x;

			Color i = color_list.get(color_counter);
			
			wheels[x] = new Wheel(length, (int)start_angle, (int)chunk_size, speed, (int)location.x, (int)location.y, i);
			
			color_counter ++;
			if (color_counter>(color_length-1))
				color_counter = 0;
		}
	}

	public void update(SimplestPen pen){

		for (int x = 0; x<num; x++){
			wheels[x].update(pen);
		}	
	}
	public void draw(SimplestPen pen){
		
		for (int x = 0; x<num; x++){
			wheels[x].draw(pen);
		}

	}
	
}
