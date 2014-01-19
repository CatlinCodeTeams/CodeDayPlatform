package plat.physics;

public abstract class Fallable {
	public abstract int getLowerLeft();
	public abstract int getLowerRight();
	public abstract int lastLowerLeft();
	public abstract int lastLowerRight();
	public abstract int lastY();
	public abstract int bottom();
	public abstract int height();
	public abstract int top();
	public abstract void setX(int x);
	public abstract void setY(int y);
	public abstract Vector getVector();
	public boolean falling=false;
	public int getX(){
		return getLowerLeft();
	}
	public int getY(){
		return top();
	}
	public int lastX(){
		return lastLowerLeft();
	}
	public boolean connorFall(Hitable[] h){
		for(Hitable e:h){
			if(this.bottom()>=e.top()&& this.top()<e.bottom() && !(this.getLowerRight()<e.getTopLeft() || this.getLowerLeft()>e.getTopRight())){
				return false;
			}
		}
		return true;
	}
	public Vector gravitate(Hitable[] h){
		Vector v=this.getVector();
		for(Hitable e:h){
			if(this.bottom()>=e.top()&& this.top()<e.bottom() && !(this.getLowerRight()<e.getTopLeft() || this.getLowerLeft()>e.getTopRight())){
				if(v.vertical>0){
					v.vertical=0;
				}
				falling=false;
				return v;
			}
		}
		falling=true;
		v.add(new Vector(0,.1));
		return v;
	}
	
	public boolean hit(Hitable[]  ha, int x, int y){
		boolean hit = false;
		
		for (Hitable h: ha){
			if ((x+41>h.getTopLeft())&&(x-39<h.getTopLeft())){
				if ((y+41>h.top())&&(y-39<h.top())){
					hit = true;
				}
			}
		}
		return hit;
		
	}
	
	public void collide(Hitable[] h){
		
		if (hit(h, getX(), getY())){
		
			int old_x = this.lastX();
			int old_y = this.lastY();
			
			int new_x = getX();
			int new_y = getY();
					
			boolean x_hit = hit(h, getX(), lastY());
			boolean y_hit = hit(h, this.lastX(), getY());
		
			
			if ((x_hit==false)&&(y_hit==true)){
				this.setY(old_y);
			}
			if ((y_hit==false)&&(x_hit==true)){
				this.setX(old_x);
			}
			if ((x_hit)&&(y_hit)){
				this.setX(old_x);
				this.setY(old_y);
			}

		}
	}
}
