package model.element.mobile;

import java.awt.Image;

import model.IMap;
import model.Sprite;
import model.SpritesPositions;

// Add sprite instances

public class Player extends Mobile {

	private static Sprite spriteDef = new Sprite('#', SpritesPositions.PLAYER.ordinal(), 1);
	private static Sprite spriteUp = new Sprite('#', SpritesPositions.PLAYER.ordinal(), 1);
	private static Sprite spriteDown = new Sprite('#', SpritesPositions.PLAYER.ordinal(), 1);
	private static Sprite spriteLeft = new Sprite('#', SpritesPositions.PLAYER.ordinal(), 1);
	private static Sprite spriteRight = new Sprite('#', SpritesPositions.PLAYER.ordinal(), 1);
	private static Sprite spriteDie = new Sprite('#', SpritesPositions.PLAYER.ordinal(), 1);
	
	private int score = 0;
	private int diamondCount = 0;
	private int lives = 4;
	
	public Player(int x, int y, IMap map) {
		super(x, y, spriteDef, map, model.Permeability.BLOCKING);
		this.lives = 4;
		this.score = 0;
		this.diamondCount = 0;
	}
	
	public Player() {
		super(sprite, model.Permeability.PENETRABLE);
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}

	public int getDiamondCount() {
		return diamondCount;
	}

	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}
	
	public void addDiamond(int diamond) {
		this.diamondCount += diamond;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public void addLives(int lives) {
		this.lives = lives;
	}
	
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
}
