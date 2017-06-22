package model.element.motionless;

import java.awt.Point;

import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;


public class Air extends Mobile {

	/**
	 * 
	 * For the sake of time saving, the following classes of the same package will NOT be explained
	 * 
	 * 
	 */
	
	
	private static final Sprite sprite = new Sprite(' ', SpritesPositions.AIR.ordinal(), 1);
	
	public Air() {
		super(sprite, model.Permeability.PENETRABLE);
	}

	@Override
	public Point getPosition() {
		return null;
	}
}