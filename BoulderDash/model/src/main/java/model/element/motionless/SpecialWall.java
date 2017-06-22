package model.element.motionless;

import java.awt.Point;

import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

public class SpecialWall extends Mobile {

	private static final Sprite sprite = new Sprite('S', SpritesPositions.SPECIAL_WALL.ordinal(), 1);
	
	public SpecialWall() {
		super(sprite, model.Permeability.BLOCKING);
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
}
