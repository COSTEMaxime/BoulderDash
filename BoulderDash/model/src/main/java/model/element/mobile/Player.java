package model.element.mobile;

import model.IMap;
import model.Sprite;

public class Player extends Mobile {

	private static Sprite sprite;
	private int score;
	
	public Player(int x, int y, IMap map) {
		super(x, y, sprite, map, model.Permeability.BLOCKING);
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
	
	public void die() {
		
	}
}
