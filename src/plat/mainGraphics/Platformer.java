package plat.mainGraphics;

import janus.engine.SimpleGraphics;
import janus.engine.pens.SimplestPen;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import plat.blocks.Block;
import plat.enemies.*;
import plat.interfaces.EntityInterface;
import plat.player.Player;
import plat.resource.sprites.ImgRegulator;

public class Platformer extends SimpleGraphics {
	public static int level;

	public Platformer() {
		super(800, 600, "Plat");
	}

	Random rand = new Random();

	ArrayList<EntityInterface> enemy_list = new ArrayList<EntityInterface>();
	ArrayList<Block> block_list = new ArrayList<Block>();
	Player player;

	private void loadImage(String name) {
		try {
			this.imgs.put(name,
					ImageIO.read(ImgRegulator.class.getResource(name)));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void start(SimplestPen pen) {

		load_images();
		
		pen.setBackground(new Color(25,150,255));

		loadImage("main.png");
		player = new Player(100,100);

		level=1;
		for (int i = 0; i < 10; i++) {
			enemy_list.add(new Basic_Enemy(pen, 400, 300));
			enemy_list.add(new Conner_Enemy(400, 400));

			block_list.add(new Block((40 * i)+80, 300, 0, block_list));

		}
		
		for (int i=0; i<3; i++){
			block_list.add(new Block(160+(i*40), 340, 0, block_list));
		}
		
		for (Block b: block_list){
			b.render(block_list);
		}

	}

	
	private void load_images(){
		loadImage("main.png");
		loadImage("grass_bottom.png");
		loadImage("grass_corner.png");
		loadImage("grass_side.png");
		loadImage("grass_side1.png");
		loadImage("grass_side2.png");
		loadImage("grass_top.png");
		loadImage("player_front.png");
		loadImage("player_jumping.png");
		loadImage("player_left.png");
		loadImage("player_right.png");
	}
	
	@Override
	public void update(SimplestPen pen) {
		for (EntityInterface e : enemy_list) {
			e.update(pen, block_list);
		}

		for (Block b : block_list) {
			b.update(pen);
		}
		player.update(pen);
		
		if (pen.isKeyPressed('r')){
			pen.restart();
		}
		Block[] b=new Block[block_list.size()];
		block_list.toArray(b);
		player.gravitate(b);
	}

	@Override
	public void draw(SimplestPen pen) {

		for (EntityInterface e : enemy_list) {
			e.draw(pen);
		}
		for (Block b : block_list) {
			b.draw(pen);
		}
		player.draw(pen);

	}
}
