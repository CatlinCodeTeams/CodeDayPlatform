package plat.physics;

public abstract class Fallable {
	public abstract int getLowerLeft();
	public abstract int getLowerRight();
	public abstract int bottom();
	public abstract int height();
	public abstract Vector getVector();
	public boolean falling=false;
	public Vector gravitate(Hitable[] h){
		Vector v=this.getVector();
		for(Hitable e:h){
			if(this.bottom()>=e.top() && !(this.getLowerRight()<e.getTopLeft() || this.getLowerLeft()>e.getTopRight())){
				v.vertical=0;
				falling=false;
				return v;
			}
		}
		falling=true;
		v.add(new Vector(0,.01));
		return v;
	}
}
