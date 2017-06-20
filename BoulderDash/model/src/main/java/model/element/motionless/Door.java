package model.element.motionless;

import model.Sprite;
import model.SpritesPositions;

public class Door extends Motionless {

	private static final Sprite sprite = new Sprite('D', SpritesPositions.DOOR.ordinal(), 1);
	
	public Door() {
		super(sprite, model.Permeability.PENETRABLE);
	}
}
