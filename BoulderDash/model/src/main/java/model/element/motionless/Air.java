package model.element.motionless;

import model.Sprite;
import model.SpritesPositions;

public class Air extends Motionless {

	private static final Sprite sprite = new Sprite(' ', SpritesPositions.AIR.ordinal(), 1);
	
	public Air() {
		super(sprite, model.Permeability.PENETRABLE);
	}
}
