package model.element.mobile.monster;

import java.awt.Point;

import model.IMonster;
import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

public class Monster_Diamond extends Mobile implements IMonster {

	private static final Sprite sprite = new Sprite('2', SpritesPositions.MONSTER_DIAMOND.ordinal(), 1);
	
	public Monster_Diamond() {
		super(sprite, model.Permeability.PENETRABLE);
	}

	@Override
	public int loot() {
		return 1;
	}
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
