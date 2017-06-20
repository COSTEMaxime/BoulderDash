package model.element.motionless;

import model.Sprite;
import model.SpritesPositions;

public class Amoeba extends Motionless {

	private static final Sprite sprite = new Sprite('A', SpritesPositions.AMOEBA.ordinal(), 1);
	
	public Amoeba() {
		super(sprite, model.Permeability.BLOCKING);
	}
}
