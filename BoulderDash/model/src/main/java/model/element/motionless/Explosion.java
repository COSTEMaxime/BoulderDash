package model.element.motionless;

import java.awt.Point;

import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

public class Explosion extends Mobile {
	
	private static final Sprite sprite = new Sprite('E', SpritesPositions.EXPLOSION.ordinal(), 1);
	
	public Explosion() {
		super(sprite, model.Permeability.PENETRABLE);
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
}
