package model.element.mobile.gravity;

import model.IMap;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

abstract class Gravity extends Mobile {

	public Gravity(Sprite sprite, IMap map, Permeability permeability) {
		super(sprite, map, permeability);
	}
	
	protected boolean falling;
	
	public boolean isFalling() {
		return this.falling;
	}
	
	public void setFalling(final boolean falling)	{
		this.falling = falling;
	}
}
