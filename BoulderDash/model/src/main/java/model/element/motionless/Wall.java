package model.element.motionless;

import model.element.Permeability;

public class Wall extends Motionless {

	public Wall() {
		super(null, Permeability.BLOCKING);
	}
}
