package model.element.mobile.gravity;

import model.IMap;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public interface Gravity {

	boolean falling = false;
		
	public boolean isFalling();
	public void setFalling(boolean falling);
}
