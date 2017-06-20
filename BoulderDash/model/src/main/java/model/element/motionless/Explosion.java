package model.element.motionless;

import model.Sprite;
import model.SpritesPositions;

public class Explosion extends Motionless {
	
	private static final Sprite sprite = new Sprite('E', SpritesPositions.EXPLOSION.ordinal(), 1);
	
	public Explosion() {
		super(sprite, model.Permeability.PENETRABLE);
	}
}
