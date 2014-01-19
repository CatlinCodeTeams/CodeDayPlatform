package plat.physics;

public abstract class Fallable {
	public abstract int getLowerLeft();
	public abstract int getLowerRight();
	public abstract int height();
	public abstract Vector getVector();
	public Vector gravitate(Hitable[] h){
		Vector v=this.getVector();
		for(Hitable e:h){
			if((e.getTopLeft()+e.getTopRight())/2>=(this.getLowerLeft()+this.getLowerRight())/2 && (this.getLowerLeft()>e.getTopLeft() ||this.getLowerRight()<e.getTopRight())){
				//On top so quit
				return v;
			}
			else{
				v.add(new Vector(0,.01));
			}
		}
		return v;
	}
}
