package model.element.mobile.gravity;

import model.IMap;
import model.Permeability;
import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

<<<<<<< HEAD
public class Diamond extends Mobile implements Gravity {
=======
public class Diamond implements Gravity{
>>>>>>> branch 'master' of https://github.com/COSTEMaxime/BoulderDash.git

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
