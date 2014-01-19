package plat.blocks;

import java.awt.Color;
import java.util.ArrayList;

import janus.engine.pens.SimplestPen;
import plat.physics.Point;
import plat.physics.Vector;



public class Block {
	
	Vector speed;
	Point location;
	
	Color color;
	
	boolean[] neighbors = new boolean[9];
	
	public Block(SimplestPen pen, int x, int y){
		
		this.location = new Point(x,y);
		this.speed = new Vector (0,0);
		
		this.color = new Color(0,200,0);
		
	}
	
	public void update(SimplestPen pen){
		
		this.location.move(this.speed);
	}
	
	public void draw(SimplestPen pen){

		pen.drawImage("main.png", (int)this.location.x, (int)this.location.y, 40, 40);
	}
	
	private void render(SimplestPen pen, ArrayList<Block> block_list){
		
		for (Block b: block_list){
			if (b != this){
				if ((b.location.x == this.location.x-40)&&(b.location.y == this.location.y-40))
				{
					neighbors[0] = true;
				}
				if ((b.location.x == this.location.x)&&(b.location.y == this.location.y-40))
				{
					neighbors[1] = true;
				}
				if ((b.location.x == this.location.x+40)&&(b.location.y == this.location.y-40))
				{
					neighbors[2] = true;
				}
				if ((b.location.x == this.location.x-40)&&(b.location.y == this.location.y))
				{
					neighbors[3] = true;
				}
				if ((b.location.x == this.location.x)&&(b.location.y == this.location.y))
				{
					neighbors[4] = true;
				}
				if ((b.location.x == this.location.x+40)&&(b.location.y == this.location.y))
				{
					neighbors[5] = true;
				}
				if ((b.location.x == this.location.x-40)&&(b.location.y == this.location.y+40))
				{
					neighbors[6] = true;
				}
				if ((b.location.x == this.location.x)&&(b.location.y == this.location.y+40))
				{
					neighbors[7] = true;
				}
				if ((b.location.x == this.location.x+40)&&(b.location.y == this.location.y+40))
				{
					neighbors[8] = true;
				}
					
			}	
		}
		
	}

}
