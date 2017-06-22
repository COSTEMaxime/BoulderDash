package model.element.mobile.gravity;

import java.awt.Point;

import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

public class Diamond extends Mobile implements Gravity {

	/** Contains the sprite */
	private static final Sprite sprite = new Sprite('X', SpritesPositions.DIAMOND.ordinal(), 1);
	private boolean falling;
	
	/**
	 * Instantiates a new Diamond Object
	 * 
	 */
	public Diamond() {
		super(sprite, model.Permeability.PENETRABLE);
		this.setFalling(false);
	}

	/**
	 * Returns if the object is falling
	 * 
	 */
	@Override
	public boolean isFalling() {
		return this.falling;
	}

	/**
	 * Changes the falling state of the object
	 * 
	 */
	@Override
	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	/**
	 * Returns the position of the object
	 * 
	 */
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
