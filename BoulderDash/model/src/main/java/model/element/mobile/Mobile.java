package model.element.mobile;

import java.awt.Point;

import model.IBoard;
import model.IMap;
import model.IMobile;
import model.Sprite;
import model.element.Element;

public abstract class Mobile extends Element implements IMobile {

	private boolean alive = true;
	private IMap map;
	private IBoard board;
	
	// NEW
	public Mobile(Sprite sprite, model.Permeability permeability) {
		super(sprite, permeability);
	}
	
	public Mobile(Sprite sprite, IMap map, model.Permeability permeability) {
		super(sprite, permeability);
		this.map = map;
	}
	
	public Mobile(int x, int y, Sprite sprite, IMap map, model.Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
	}
	
	// TO CHECK
		public void moveUp() {
			this.setY(getY() + 1);
		}

		// TO CHECK
		public void moveDown() {
			this.setY(getY() - 1);
		}

		// TO CHECK
		public void moveLeft() {
			this.setX(this.getX() - 1);
		}

		// TO CHECK
		public void moveRight() {
			this.setX(this.getX() + 1);
		}

		public void doNothing() {

		}
	
	
	
	// Add in UML
	public void setAlive(boolean b) {
		this.alive = b;
	}
	
	// Add in UML
	public void die() {
		this.alive = false;
	}
	
	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	public Boolean isAlive() {
		return alive;
	}

	public IBoard getBoard() {
		return board;
	}
}
