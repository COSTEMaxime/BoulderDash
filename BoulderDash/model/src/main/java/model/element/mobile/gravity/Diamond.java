package model.element.mobile.gravity;

import model.IMap;
import model.Permeability;
import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

public class Diamond extends Mobile implements Gravity {

	private static final Sprite sprite = new Sprite('X', SpritesPositions.DIAMOND.ordinal(), 1);

	public Diamond() {
		super(sprite, model.Permeability.PENETRABLE);
	}
	
	@Override
	public boolean isFalling() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFalling(boolean falling) {
		// TODO Auto-generated method stub
		
	}
	
}
