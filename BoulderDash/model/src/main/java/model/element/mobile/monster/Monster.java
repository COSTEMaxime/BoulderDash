package model.element.mobile.monster;

import model.IMonster;

public class Monster {
	private IMonster strategy;
	
	public Monster(IMonster strategy) {
		this.strategy = strategy;
	}
	
	public void executeStrategy() {
		strategy.loot();
	}
}
