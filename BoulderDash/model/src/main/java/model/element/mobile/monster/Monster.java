package model.element.mobile.monster;

import model.IMonster;

public class Monster {
	private IMonster strategy;
	
	/**
	 * Instantiates a monster object
	 * 
	 * @param strategy
	 */
	public Monster(IMonster strategy) {
		this.strategy = strategy;
	}
	
	public void executeStrategy() {
		strategy.loot();
	}
}
