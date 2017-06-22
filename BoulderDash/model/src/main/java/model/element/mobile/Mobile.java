package model.element.mobile;

import java.awt.Point;

import model.IBoard;
import model.IMap;
import model.IMobile;
import model.Sprite;
import model.element.Element;

public abstract class Mobile extends Element implements IMobile {

	/** Alive */
	private boolean alive = true;
	private IMap map;
	private IBoard board;

	/**
	 * Instantiates a new Mobile element
	 * 
	 * @param sprite
	 * @param permeability
	 */
	public Mobile(Sprite sprite, model.Permeability permeability) {
		super(sprite, permeability);
	}

	/**
	 * Instantiates a new mobile element
	 * 
	 * @param sprite
	 * @param map
	 * @param permeability
	 */
	public Mobile(Sprite sprite, IMap map, model.Permeability permeability) {
		super(sprite, permeability);
	}

	/**
	 * Instantiates a new Mobile element
	 * 
	 * @param x
	 * @param y
	 * @param sprite
	 * @param map
	 * @param permeability
	 */
	public Mobile(int x, int y, Sprite sprite, model.Permeability permeability) {
		super(sprite, permeability);
	}

	/**
	 * Increments the Y coordinate of the element
	 * 
	 */
	public void moveUp() {
		this.setY(getY() - 1);
	}

	/**
	 * Increments the Y coordinate of the element
	 * 
	 */
	public void moveDown() {
		this.setY(getY() + 1);
	}

	/**
	 * Increments the X coordinate of the element
	 * 
	 */

	public void moveLeft() {
		this.setX(this.getX() - 1);
	}

	/**
	 * Increments the X coordinate of the element
	 * 
	 */
	public void moveRight() {
		this.setX(this.getX() + 1);
	}

	/**
	 * Does absolutly nothing ... 
	 * (Used when the player does not hit any key)
	 * 
	 */
	public void doNothing() {

	}

	/**
	 * Changes the player state (Alvive / Dead)
	 * 
	 * @param b
	 */

	public void setAlive(boolean b) {
		this.alive = b;
	}

	/**
	 * Changes the players state to dead
	 * 
	 */

	public void die() {
		this.alive = false;
	}

	/**
	 * Returns the map
	 * 
	 * @return
	 */
	public IMap getMap() {
		return map;
	}

	/**
	 * Sets the map
	 * 
	 * @param map
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	/**
	 * Returns the player state (Alive / Dead)
	 * 
	 */
	public Boolean isAlive() {
		return alive;
	}

	/**
	 * Returns the game board
	 * 
	 */
	public IBoard getBoard() {
		return board;
	}
}
