package model.element.mobile;

import java.awt.Image;
import java.awt.Point;

import model.IMap;
import model.Sprite;

// Add sprite instances

public class Player extends Mobile {

	/** Sprite creation for all states of the player */
	private static Sprite spriteDef = new Sprite(model.UserOrder.NOP);
	private static Sprite spriteUp = new Sprite(model.UserOrder.UP);
	private static Sprite spriteDown = new Sprite(model.UserOrder.DOWN);
	private static Sprite spriteLeft = new Sprite(model.UserOrder.LEFT);
	private static Sprite spriteRight = new Sprite(model.UserOrder.RIGHT);
	private static Sprite spriteDie = new Sprite(model.UserOrder.NOP);

	/** Score of the player */
	private int score = 0;
	
	/** Diamond count of the player */
	private int diamondCount = 0;
	
	/** Lives of the player */
	private int lives = 4;

	/**
	 * Instantiates a new Player object
	 * 
	 * @param x
	 * @param y
	 */
	public Player(int x, int y) {
		super(x, y, spriteDef, model.Permeability.BLOCKING);
		this.lives = 4;
		this.score = 0;
		this.diamondCount = 0;
	}

	/**
	 * Instantiates a new Player object (Only use for factory)
	 * 
	 */
	public Player() {
		super(spriteDef, model.Permeability.PENETRABLE);
	}

	/**
	 * Calls super constructor and changes sprite
	 * 
	 */
	public void moveUp() {
		super.moveUp();
		this.setSprite(spriteUp);
	}

	/**
	 * Calls super constructor and changes sprite
	 * 
	 */
	public void moveDown() {
		super.moveDown();
		this.setSprite(spriteDown);
	}

	/**
	 * Calls super constructor and changes sprite
	 * 
	 */
	public void moveLeft() {
		super.moveLeft();
		this.setSprite(spriteLeft);
	}

	/**
	 * Calls super constructor and changes sprite
	 * 
	 */
	public void moveRight() {
		super.moveRight();
		this.setSprite(spriteRight);
	}

	/**
	 * Calls super constructor and changes sprite
	 * 
	 */
	public void doNothing() {
		super.doNothing();
		this.setSprite(spriteDef);
	}

	/**
	 * Calls super constructor and changes sprite
	 * 
	 */
	public void die() {
		super.die();
		this.setSprite(spriteDie);
	}

	/**
	 * Returns the score of the player
	 * 
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score of the player (Useful to reset)
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Increases the score of the player
	 * 
	 * @param score
	 */
	public void addScore(int score) {
		this.score += score;
	}

	/**
	 * Returns the diamond count of the player
	 * 
	 */
	public int getDiamondCount() {
		return diamondCount;
	}

	/**
	 * Sets the diamond count of the player (Usefull to reset it)
	 * 
	 * @param diamondCount
	 */
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}

	/**
	 * Increases the diamond count of the player
	 * 
	 * @param score
	 */
	public void addDiamond(int diamond) {
		this.diamondCount += diamond;
	}

	/**
	 * Gets the number of lives of the player
	 * 
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * Sets the number f lives of the player (Usefull to reset it)
	 * 
	 * @param lives
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}

	/**
	 * Increases the number of lives of the player
	 * 
	 * @param score
	 */
	public void addLives(int lives) {
		this.lives = lives;
	}

	/**
	 * Returns the position of the player
	 * 
	 */
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
