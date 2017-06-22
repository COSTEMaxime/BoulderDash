package model.element.mobile.gravity;

import java.awt.Point;

import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;


public class Rock extends Mobile implements Gravity {

	private static final Sprite sprite = new Sprite('O', SpritesPositions.ROCK.ordinal(), 1);
	private boolean falling;
	
	public Rock() {
		super(sprite, model.Permeability.BLOCKING);
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
	
	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}
}
