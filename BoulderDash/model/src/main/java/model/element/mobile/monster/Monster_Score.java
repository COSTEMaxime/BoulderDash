package model.element.mobile.monster;

import model.IMonster;
import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

public class Monster_Score extends Mobile implements IMonster {

	private static final Sprite sprite = new Sprite('1', SpritesPositions.MONSTER_SCORE.ordinal(), 1);
	
	public Monster_Score() {
		super(sprite, model.Permeability.PENETRABLE);
	}

	@Override
	public int loot() {
		return 100;
	}
}
