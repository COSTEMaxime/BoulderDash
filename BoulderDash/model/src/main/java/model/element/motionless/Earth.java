package model.element.motionless;

import model.element.Permeability;

public class Earth extends Motionless {

	public Earth() {
		super(null, Permeability.BLOCKING);
	}
}
