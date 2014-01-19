package plat.player;
import janus.engine.pens.SimplestPen;
import plat.physics.Fallable;
import plat.physics.Point;
import plat.physics.Vector;

public class Player extends Fallable implements PlayerInterface{
	Point location;
	Vector speed;
	int width;
	int height;
	int health;
	boolean in_air;
	boolean moving;
	String pic;
	
	public Player(int x, int y){
		location = new Point(x,y);
		speed = new Vector(0,0);
		moving = false;
		width = 10;
		height = 20;
		pic = "player_front.png";
	}
	public void update(SimplestPen pen){
		
		this.location.move(this.speed);
		this.moving = false;
		if (this.falling == false){
			if(pen.isKeyPressed('a')){
				this.left_key_press();
				this.pic = "player_left.png";
			}
			if(pen.isKeyPressed('d')){
				this.right_key_press();
				this.pic = "player_right.png";
			}
			if(pen.isKeyPressed('w')){
				this.up_key_press();
				this.pic = "player_jumping.png";
			}
			if (this.moving == false){
				if (this.speed.horizontal >= 1 && this.speed.horizontal >=0.5){
					
				this.speed.horizontal = this.speed.horizontal*.5;
				}
				else{
					this.speed.horizontal = 0;
					this.pic = "player_front.png";
				}
			}

			
		}
		if (this.speed.horizontal>5.0){
			this.speed.horizontal = 5;
		}
		else if (this.speed.horizontal < -5){
			this.speed.horizontal = -5;
		}
	}
	public void draw(SimplestPen pen) {
		pen.drawImage((String)this.pic,(int)this.location.x, (int)this.location.y,40,40);
		
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
		this.speed.add(new Vector(0,-2));
		this.moving = true;
		
	}
	@Override
	public void down_key_pess() {
		this.speed.add(new Vector(0,5));
		this.moving = true;
	}

	@Override
	public int getLowerLeft() {
		return (int) location.getIntX();
	}
	@Override
	public int getLowerRight() {
		return (int) location.getIntX()+40;
	}
	@Override
	public int height() {
		return 40;
	}
	@Override
	public Vector getVector() {
		return this.speed;
	}
	public int bottom(){
		return (int)location.y+40;
	}
	@Override
	public int top() {
		return (int)location.y;
	}
}
