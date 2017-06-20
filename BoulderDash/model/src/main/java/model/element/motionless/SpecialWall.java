package model.element.motionless;

import model.Sprite;
import model.SpritesPositions;

public class SpecialWall extends Motionless {

	private static final Sprite sprite = new Sprite('S', SpritesPositions.SPECIAL_WALL.ordinal(), 1);
	
	public SpecialWall() {
		super(sprite, model.Permeability.BLOCKING);
	}
}
