package model.element.mobile.gravity;

import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

public class Diamond extends Mobile implements Gravity {

	private static final Sprite sprite = new Sprite('X', SpritesPositions.DIAMOND.ordinal(), 1);
	private boolean falling;
	
	public Diamond() {
		super(sprite, model.Permeability.PENETRABLE);
		this.setFalling(false);
	}

	@Override
	public boolean isFalling() {
		return this.falling;
	}

	@Override
	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	
}
