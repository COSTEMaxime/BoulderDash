package model.element.mobile.gravity;

import model.IMap;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public interface Gravity {


	public boolean isFalling();
	
	public void setFalling(final boolean falling);
}
