package plat.debugTools;

import janus.engine.pens.SimplestPen;

import java.util.ArrayList;

public class AddDebug {
	private static ArrayList<Debug> dso=new ArrayList<Debug>();
	private static ArrayList<Debug> dsr=new ArrayList<Debug>();
	public static void addDebugOneTime(Debug d){
		dso.add(d);
	}
	public static void addDebugRepeatTime(Debug d){
		dsr.add(d);
	}
	public static void runOne(SimplestPen p){
		for(Debug d:dso){
			d.call(p);
		}
	}
	public static void runMult(SimplestPen p){
		for(Debug d:dsr){
			d.call(p);
		}
	}
}
