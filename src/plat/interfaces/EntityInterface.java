
package plat.interfaces;
import janus.engine.pens.SimplestPen;
import plat.physics.Point;
import plat.physics.Vector;

public interface EntityInterface {
	
  public Point get_Point ();
  public Vector get_Vector ();
  
  public void update (SimplestPen pen);
  public void draw (SimplestPen pen);
}