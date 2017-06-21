package model.element.mobile;

import java.awt.Point;

import model.IBoard;
import model.IMap;
import model.IMobile;
import model.Sprite;
import model.element.Element;

public abstract class Mobile extends Element implements IMobile {

	private boolean alive = true;
	private Point position;
	private IMap map;
	private IBoard board;
	
	// NEW
	public Mobile(Sprite sprite, model.Permeability permeability) {
		super(sprite, permeability);
	}
	
	public Mobile(Sprite sprite, IMap map, model.Permeability permeability) {
		super(sprite, permeability);
		this.map = map;
		this.position = new Point(0,0);
	}
	
	public Mobile(int x, int y, Sprite sprite, IMap map, model.Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		this.position = new Point(x,y);
	}
	
	
	// TO CHECK
	public void moveUp() {
		this.position.y = getY() + 1;
	}
	
	// TO CHECK
	public void moveDown() {
		this.position.y = getY() - 1;
	}

	// TO CHECK
	public void moveLeft() {
		this.position.x = getX() + 1;
	}

	// TO CHECK
	public void moveRight() {
		this.position.x = getX() - 1;
	}
	
	public void doNothing() {
		
	}
	
	public void setHasMoved() {
		
	}
	
	// Add in UML
	public void setAlive(boolean b) {
		this.alive = b;
	}
	
	// Add in UML
	public void die() {
		this.alive = false;
	}
	
	public int getX() {
		return position.x;
	}
	
	public int getY() {
		return position.y;
	}

	public void setX(int x) {
		this.position.x = x;
	}
	
	public void setY(int y) {
		this.position.y = y;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
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
