package plat.blocks;

import java.awt.Color;

import janus.engine.pens.SimplestPen;
import plat.physics.Point;
import plat.physics.Vector;

public class Block {
	
	Vector speed;
	Point location;
	
	Color color;
	
	public Block(SimplestPen pen, int x, int y){
		
		this.location = new Point(x,y);
		this.speed = new Vector (0,0);
		
		this.color = new Color(0,200,0);
		
	}
	
	public void update(SimplestPen pen){
		
		this.location.move(this.speed);
	}
	
	public void draw(SimplestPen pen){
		pen.setColor(this.color);
		pen.fillRectangle((int)this.location.x, (int)this.location.y, 40, 40);
	}

}
