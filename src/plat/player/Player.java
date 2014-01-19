package plat.player;
import janus.engine.pens.SimplestPen;
import java.awt.Color;

import plat.physics.Point;
import plat.physics.Vector;

public class Player implements PlayerInterface {
	Point location;
	Vector speed;
	int width;
	int height;
	int health;
	boolean in_air;
	boolean moving;
	
	public Player(int x, int y){
		location = new Point(x,y);
		speed = new Vector(0,0);
		moving = false;
		width = 10;
		height = 20;
	}
	public void update(SimplestPen pen){
		
		this.location.move(this.speed);
		this.moving = false;
		if(pen.isKeyPressed('a')){
			this.left_key_press();
		}
		if(pen.isKeyPressed('d')){
			this.right_key_press();
		}
		if (this.moving == false){
			if (this.speed.length() >= 1 && this.speed.length() >=0.5){
				
			this.speed.multiply(.5);
			}
			else{
				this.speed.multiply(0);
			}

			
		}
		if (this.speed.length()>5.0){
			this.speed.normalize();
			this.speed.multiply(5.0);
		}
	}
	public void draw(SimplestPen pen) {
		pen.drawImage("player_front.png",(int)this.location.x, (int)this.location.y,40,40);
		
	}
	@Override
	public void left_key_press() {
		this.speed.add(new Vector(-5,0));
		this.moving = true;
		
	}
	@Override
	public void right_key_press() {
		this.speed.add(new Vector(5,0));
		this.moving = true;
	}
	@Override
	public void up_key_press() {
		this.speed.add(new Vector(0,-5));
		this.moving = true;
		
	}
	@Override
	public void down_key_pess() {
		this.speed.add(new Vector(0,5));
		this.moving = true;
	}
}

