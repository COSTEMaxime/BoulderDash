package model.element.motionless;

import model.element.Permeability;

public class SpecialWall extends Motionless {

	public SpecialWall() {
		super(null, Permeability.BLOCKING);
	}
}
