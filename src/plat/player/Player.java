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
	int last_der;
	int top_speed;
	int lx;
	int lx2;
	int ly;
	
	public Player(int x, int y){
		last_der = 2;
		top_speed = 5;
		location = new Point(x,y);
		speed = new Vector(0,0);
		moving = false;
		width = 10;
		height = 20;
		pic = "player_front.png";
	}
	public void update(SimplestPen pen){
		ly=(int) location.y;
		lx=(int) location.x;
		lx2=(int) location.x+40;
		this.location.move(this.speed);
		this.moving = false;
		if (this.falling == false){
			this.top_speed = 5;
		}
		else{
			this.top_speed = 2;}
			if(pen.isKeyPressed('a')){
				this.left_key_press();
				this.pic = "player_left.png";
				this.last_der = 1;
			}
			if(pen.isKeyPressed('d')){
				this.right_key_press();
				this.pic = "player_right.png";
				this.last_der = 2;
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
	public void shoot(){
		
	}
	@Override
	public void left_key_press() {
		this.speed.add(new Vector(-this.top_speed,0));
		this.moving = true;
		
	}
	@Override
	public void right_key_press() {
		this.speed.add(new Vector(this.top_speed,0));
		this.moving = true;
	}
	@Override
	public void up_key_press() {
		if (this.falling == false){
		this.speed.add(new Vector(0,-2));
		this.moving = true;}
		
	}
	@Override
	public void down_key_pess() {
		this.speed.add(new Vector(0,this.top_speed));
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
	@Override
	public int lastLowerLeft() {
		return lx;
	}
	@Override
	public int lastLowerRight() {
		return lx2;
	}
	@Override
	public int lastY() {
		return ly;
	}
	@Override
	public void setX(int x) {
		location.x=x;
	}
	@Override
	public void setY(int y) {
		location.y=y;
	}
}
