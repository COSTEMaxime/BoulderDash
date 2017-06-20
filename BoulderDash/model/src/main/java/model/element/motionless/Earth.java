package model.element.motionless;

import model.Sprite;
import model.SpritesPositions;

public class Earth extends Motionless {

	private static final Sprite sprite = new Sprite('.', SpritesPositions.EARTH.ordinal(), 1);
	
	public Earth() {
		super(sprite, model.Permeability.BLOCKING);
	}
}
