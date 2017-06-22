package model.element.motionless;

import java.awt.Point;

import model.Sprite;
import model.element.Element;
import model.element.mobile.Mobile;

public class Motionless extends Mobile {

	public Motionless(Sprite sprite, model.Permeability permeability) {
		super(sprite, permeability);
	}

	/**
	 * Not Used
	 * 
	 */
	@Override
	public Point getPosition() {
		return null;
	}
}
