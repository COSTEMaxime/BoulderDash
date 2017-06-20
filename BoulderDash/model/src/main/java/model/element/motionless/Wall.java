package model.element.motionless;

import model.Sprite;
import model.SpritesPositions;

public class Wall extends Motionless {

	private static final Sprite sprite = new Sprite('W', SpritesPositions.WALL.ordinal(), 1);
	
	public Wall() {
		super(sprite, model.Permeability.BLOCKING);
	}
}
