package janus.engine;

import janus.engine.pens.SimplestPen;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SimpleGraphicsAbsorber extends SimpleGraphics {

	protected SimpleGraphicalInterface graphics;

	@Override
	public void draw(SimplestPen pen) {
		graphics.draw(pen);
	}

	public void onKeyPressed(KeyEvent event) {
		graphics.onKeyPressed(event,myPen);
	}

	public void onKeyReleased(KeyEvent event) {
		graphics.onKeyReleased(event,myPen);
	}

	public void onKeyTyped(KeyEvent event) {
		graphics.onKeyTyped(event,myPen);
	}

	public void onMouseClicked(MouseEvent event) {
		graphics.onMouseClicked(event,myPen);
	}

	public void onMouseEntered(MouseEvent event) {
		graphics.onMouseEntered(event,myPen);
	}

	public void onMouseExited(MouseEvent event) {
		graphics.onMouseExited(event,myPen);
	}

	public void onMousePressed(MouseEvent event) {
		graphics.onMousePressed(event,myPen);
	}

	public void onMouseReleased(MouseEvent event) {
		graphics.onMouseReleased(event,myPen);
	}

	@Override
	public void onResize(SimplestPen pen) {
		graphics.onResize(pen);
	}

	@Override
	public void start(SimplestPen pen) {
		graphics.start(pen);
	}

	@Override
	public void update(SimplestPen pen) {
		graphics.update(pen);
	}

	public SimpleGraphicsAbsorber(int width, int height, String name,
			int frames, SimpleGraphicalInterface simp) {
		super(width, height, name, frames);
		graphics = simp;
	}

	public SimpleGraphicsAbsorber(int width, int height, String name,
			SimpleGraphicalInterface simp) {
		super(width, height, name);
		graphics = simp;
	}
}
