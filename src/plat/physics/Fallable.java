package plat.physics;

public abstract class Fallable {
	public abstract int getLowerLeft();
	public abstract int getLowerRight();
	public abstract int bottom();
	public abstract int height();
	public abstract Vector getVector();
	public Vector gravitate(Hitable[] h){
		Vector v=this.getVector();
		for(Hitable e:h){
			if(this.bottom()>=e.top() && (this.getLowerLeft()>e.getTopLeft() || this.getLowerRight()<e.getTopRight())){
				v.vertical=0;
				return v;
			}
		}
		v.add(new Vector(0,.01));
		return v;
	}
}
