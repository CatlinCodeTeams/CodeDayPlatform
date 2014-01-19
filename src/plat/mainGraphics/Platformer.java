package plat.mainGraphics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import Basic_Enemy.Basic_Enemy;
import plat.blocks.Block;
import plat.interfaces.EntityInterface;
import janus.engine.SimpleGraphics;
import janus.engine.pens.SimplestPen;

public class Platformer extends SimpleGraphics{
	public static int level;
	public Platformer() {
		super(800, 600, "Plat");
	}
	
	Random rand = new Random();
	
	ArrayList<EntityInterface> enemy_list = new ArrayList<EntityInterface>();
	ArrayList<Block> block_list = new ArrayList<Block>();
	

	@Override
	public void start(SimplestPen pen) {
		
		pen.setBackground(new Color(25,150,255));

		
		level=1;
		for (int i = 0; i<10; i++){
			enemy_list.add(new Basic_Enemy(pen, 400, 300));
			
			block_list.add(new Block(pen, 40*i, 0));
			
		}
		
		
	}

	@Override
	public void update(SimplestPen pen) {
		
		for (EntityInterface e: enemy_list){
			e.update(pen);
		}
		
		for (Block b: block_list){
			b.update(pen);
		}
		
	}
	@Override
	public void draw(SimplestPen pen) {
		
		for (EntityInterface e: enemy_list){
			e.draw(pen);
		}
		for (Block b: block_list){
			b.draw(pen);
		}


}}
