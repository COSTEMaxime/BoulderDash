package model.element.mobile.gravity;

import model.Sprite;
import model.SpritesPositions;

public class Rock implements Gravity{

	private static final Sprite sprite = new Sprite('O', SpritesPositions.ROCK.ordinal(), 1);
	
	private boolean falling;
	
	public Rock() {
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
