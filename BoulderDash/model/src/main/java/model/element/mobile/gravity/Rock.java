package model.element.mobile.gravity;

import model.Sprite;
import model.SpritesPositions;
import model.element.mobile.Mobile;

<<<<<<< HEAD
public class Rock extends Mobile implements Gravity {

	public Rock() {
		super(sprite, model.Permeability.BLOCKING);
	}
=======
public class Rock implements Gravity{
>>>>>>> branch 'master' of https://github.com/COSTEMaxime/BoulderDash.git

	private static final Sprite sprite = new Sprite('O', SpritesPositions.ROCK.ordinal(), 1);
<<<<<<< HEAD

	@Override
	public boolean isFalling() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFalling(boolean falling) {
		// TODO Auto-generated method stub

=======
	
	private boolean falling;
	
	public Rock() {
		this.setFalling(false);
>>>>>>> branch 'master' of https://github.com/COSTEMaxime/BoulderDash.git
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
