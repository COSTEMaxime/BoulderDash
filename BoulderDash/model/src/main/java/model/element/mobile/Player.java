package model.element.mobile;

import java.awt.Image;

import model.IMap;
import model.Sprite;

// Add sprite instances

public class Player extends Mobile {

	private static Sprite spriteDef;// = new Sprite('@', );
	private static Sprite spriteUp;
	private static Sprite spriteDown;
	private static Sprite spriteLeft;
	private static Sprite spriteRight;
	private static Sprite spriteDie;
	
	private int score;
	
	public Player(int x, int y, IMap map) {
		super(x, y, spriteDef, map, model.Permeability.BLOCKING);
	}
	
	public void moveUp() {
		super.moveUp();
		this.setSprite(spriteUp);
	}
	
	public void moveDown() {
		super.moveDown();
		this.setSprite(spriteDown);
	}

	public void moveLeft() {
		super.moveLeft();
		this.setSprite(spriteLeft);
	}

	public void moveRight() {
		super.moveRight();
		this.setSprite(spriteRight);
	}
	
	public void doNothing() {
		super.doNothing();
		this.setSprite(spriteDef);
	}
	
	public void die() {
		super.die();
		this.setSprite(spriteDie);
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
}
