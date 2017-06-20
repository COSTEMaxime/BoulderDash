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
	
	public Mobile(Sprite[] sprite, IMap map, model.Permeability permeability) {
		super(sprite, permeability);
		this.map = map;
		this.position = new Point(0,0);
	}
	
	public Mobile(int x, int y, Sprite[] sprite, IMap map, model.Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		this.position = new Point(x,y);
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

	public Boolean isAlive() {
		return alive;
	}

	public IBoard getBoard() {
		return board;
	}
}
