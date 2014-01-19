package plat.interfaces;

import janus.engine.pens.SimplestPen;
import plat.physics.Point;
import plat.physics.Vector;
import plat.blocks.*;
import java.util.ArrayList;

public extends plat.player.PlayerInterface interface EntityInterface {

	public Point get_Point();

	public Vector get_Vector();

	public void update(SimplestPen pen, ArrayList<Block> blockList);

	public void draw(SimplestPen pen);
}