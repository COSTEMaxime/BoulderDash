package model.element.mobile.gravity;

import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

public class Rock extends Mobile implements Gravity {

	public Rock() {
		super(sprite, model.Permeability.BLOCKING);
	}

	private static final Sprite sprite = new Sprite('O', SpritesPositions.ROCK.ordinal(), 1);

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
