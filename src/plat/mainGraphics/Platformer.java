package plat.mainGraphics;

import janus.engine.SimpleGraphics;
import janus.engine.pens.SimplestPen;

public class Platformer extends SimpleGraphics{
	public static int level;
	public Platformer() {
		super(800, 600, "Plat");
	}

	@Override
	public void start(SimplestPen pen) {
		level=1;
	}

	@Override
	public void update(SimplestPen pen) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw(SimplestPen pen) {
		// TODO Auto-generated method stub
		
	}


}
