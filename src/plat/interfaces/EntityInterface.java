import plat.physics;

public interface EntityInterface {
  public Point get_Point ();
  public Vector get_Vector ();
  
  public void update (SimplestPen pen);
  public void draw (SimplestPen pen);
}