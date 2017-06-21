package model.element.mobile.gravity;

import model.Sprite;
import model.SpritesPositions;

public class Diamond implements Gravity{

	private static final Sprite sprite = new Sprite('X', SpritesPositions.DIAMOND.ordinal(), 1);
	
	private boolean falling;
	
	public Diamond() {
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
