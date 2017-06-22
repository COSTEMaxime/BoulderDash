package model;

import model.element.mobile.Player;

/**
 * 
 * @author Pierre Mazurier
 *
 */

public class Model implements IModel {
	
	private IMap map;
	private IMobile player;
	
	/**
	 * Instantiates new model
	 * 
	 * @param fileName
	 */
	public Model(String fileName) {
		
		// Create new map
		this.setMap(new Map(fileName));
		
		// Set player start point
		this.setPlayer(new Player(0, 0));
	}

	/**
	 * Returns map
	 * 
	 */
	public IMap getMap() {
		return map;
	}

	/**
	 * Sets map
	 * 
	 * @param map
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	/**
	 * Returns the player
	 * 
	 */
	public IMobile getPlayer() {
		return this.player;
	}

	/**
	 * Sets player
	 * 
	 * @param player
	 */
	public void setPlayer(IMobile player) {
		this.player = player;
	}
}
