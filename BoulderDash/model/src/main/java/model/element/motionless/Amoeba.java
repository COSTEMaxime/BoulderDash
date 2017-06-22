package model.element.motionless;

import java.awt.Point;

import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

public class Amoeba extends Mobile {

	private static final Sprite sprite = new Sprite('A', SpritesPositions.AMOEBA.ordinal(), 1);
	
	public Amoeba() {
		super(sprite, model.Permeability.BLOCKING);
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
}
