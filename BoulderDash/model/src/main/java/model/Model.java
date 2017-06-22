package model;

import model.element.mobile.Player;

public class Model implements IModel {
	
	private IMap map;
	private IMobile player;
	
	// startX and startY = player starting point
	public Model(String fileName) {
		
		// Create new map
		this.setMap(new Map(fileName));
		
		// Set player start point
		this.setPlayer(new Player(0, 0));
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	public IMobile getPlayer() {
		return this.player;
	}

	public void setPlayer(IMobile player) {
		this.player = player;
	}
}
