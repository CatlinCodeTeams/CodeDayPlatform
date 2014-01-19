<<<<<<< HEAD
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
	
	public Player(int x, int y){
		location = new Point(x,y);
		speed = new Vector(0,0);
		width = 10;
		height = 20;
	}
	public void update(SimplestPen pen){
		this.location.move(this.speed);
	}
	public void draw(SimplestPen pen) {
		pen.drawImage("player_front.png",(int)this.location.x, (int)this.location.y,40,40);
		
	}
	@Override
	public void left_key_press() {
		this.speed.add(new Vector(-5,0));
		
	}
	@Override
	public void right_key_press() {
		this.speed.add(new Vector(5,0));
	}
	@Override
	public void up_key_press() {
		this.speed.add(new Vector(0,-5));
		
	}
	@Override
	public void down_key_pess() {
		this.speed.add(new Vector(0,5));
	}
}
=======
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
	
	public Player(int x, int y){
		location = new Point(x,y);
		speed = new Vector(0,0);
		width = 10;
		height = 20;
	}
	public void update(SimplestPen pen){
		this.location.move(this.speed);
	}
	public void draw(SimplestPen pen) {

		pen.setColor(new Color(0,0,0));
		pen.drawRectangle((int)this.location.x, (int)this.location.y, (int)this.width,(int)this.height);
		
	}
	@Override
	public void left_key_press() {
		this.speed.add(new Vector(-5,0));
		
	}
	@Override
	public void right_key_press() {
		this.speed.add(new Vector(5,0));
	}
	@Override
	public void up_key_press() {
		this.speed.add(new Vector(0,-5));
		
	}
	@Override
	public void down_key_pess() {
		
	}
}
>>>>>>> branch 'master' of https://github.com/Others/CodeDayPlatform.git
