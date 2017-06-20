package model.element.mobile;

import java.awt.Point;

import model.IMap;
import model.Sprite;
import model.element.Element;
import model.element.Permeability;

public class Mobile extends Element {

	private boolean alive;
	private Point position;
	private IMap map;
	private IBoard board;
	
	public Mobile(Sprite sprite, IMap map, Permeability permeability) {
		super(sprite, );
	}
	
	public Mobile(int x, int y, Sprite sprite, IMap map, Permeability permeability) {
		
	}
	
	public void moveUp() {
		
	}
	
	public void moveDown() {
		
	}

	public void moveLeft() {
	
	}

	public void moveRight() {
	
	}
	
	public void doNothing() {
		
	}
	
	public void setHasMoved() {
		
	}
	
	public int getX() {
		return 0;
	}
	
	public int getY() {
		return 0;
	}

	public void setX(int x) {
		
	}
	
	public void setY(int y) {
		
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

	public boolean isAlive() {
		return alive;
	}

	public IBoard getBoard() {
		return board;
	}
}