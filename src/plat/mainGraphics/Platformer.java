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
import plat.shapes.Pinwheel;
import plat.xmltiles.ReadXML;

public class Platformer extends SimpleGraphics {
	public static int level;
	int fps;
	public Platformer() {
		super(800, 600, "Plat");
		this.endProgramOnClose=true;
	}

	Random rand = new Random();

	ArrayList<EntityInterface> enemy_list;
	ArrayList<Block> block_list;
	Player player;
	
	Pinwheel pin;

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
		ArrayList<Color> color_list= new ArrayList<Color>();
		color_list.add(new Color(255,255,255));
		color_list.add(new Color(0,0,100));
		pin = new Pinwheel(10,100, 1, 100, 100, color_list, pen);
		
		enemy_list = new ArrayList<EntityInterface>();
		block_list = new ArrayList<Block>();
		load_images();
		
		pen.setBackground(new Color(25,150,255));

		loadImage("main.png");
		player = new Player(100,100);

		level=1;
		for (int i = 0; i < 10; i++) {
			enemy_list.add(new Basic_Enemy(pen, 400, 300));
			enemy_list.add(new Conner_Enemy(400, 400));

			//block_list.add(new Block((40 * i)+80, 300, 0, block_list));

		}
		
	/*	for (int i=0; i<3; i++){
			block_list.add(new Block(160+(i*40), 340, 0, block_list));
		}
		

		}*/
		

		ReadXML.Read("box.xml", block_list,player);


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
		
		pin.update(pen);
		
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
		player.collide(b);
		fps = pen.getActualFrameRate();
		
	}

	@Override
	public void draw(SimplestPen pen) {
		
		pin.draw(pen);

		for (EntityInterface e : enemy_list) {
			e.draw(pen);
		}
		for (Block b : block_list) {
			b.draw(pen);
		}
		player.draw(pen);
		pen.drawString(fps+"",20,40, "comic sans", 30);

	}
}
