package model.element.motionless;

import model.element.Permeability;

public class Air extends Motionless {

	public Air() {
		super(null, Permeability.PENETRABLE);
	}
}
