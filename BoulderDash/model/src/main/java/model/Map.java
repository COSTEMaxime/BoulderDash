package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import model.element.mobile.Mobile;
import model.element.mobile.Player;
import model.element.mobile.gravity.Diamond;
import model.element.mobile.gravity.Gravity;
import model.element.mobile.gravity.Rock;
import model.element.motionless.Air;
import model.element.motionless.MotionlessFactory;

public class Map extends Observable implements IMap {

	private int width;
	private int height;
	private IElement[][] onTheMap;

	public Map(final String mapName) {
		loadFromBDD(mapName);
	}

	private void loadFromBDD(final String nomMap) {

		// TEST
		this.setHeight(10);
		this.setWidth(10);
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];

		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				this.setOnMapXY(MotionlessFactory.getFromFileSymbol('S'), x, y);
			}
		}
	}

	@Override
	public void update() {

		for (int y = this.getHeight() - 2; y >= 0; y--) {
			for (int x = 0; x < this.getWidth(); x++) {
				//si l'objet est un diamant ou un rocher
				if(this.getMapXY(x, y).getClass().isInstance(Diamond.class) || this.getMapXY(x, y).getClass().isInstance(Rock.class))
					//si il y a de l'air juste en dessous alors il tombe
					if(this.getMapXY(x, y+1).getClass().isInstance(Air.class))	{
						((Gravity) this.getMapXY(x, y)).setFalling(true);
						this.setOnMapXY(this.getMapXY(x, y), x, y+1);
						this.setOnMapXY(MotionlessFactory.createAir(), x, y);
					//si il y a le joueur en dessous et que l'objet est d�j� en train de tomber
					} else if (this.getMapXY(x, y+1).getClass().isInstance(Player.class) && ((Gravity) this.getMapXY(x, y)).isFalling())	{
						((Player) this.getMapXY(x, y+1)).die();
						this.setOnMapXY(this.getMapXY(x, y), x, y+1);
						this.setOnMapXY(MotionlessFactory.createAir(), x, y);
					} else if (this.getMapXY(x, y+1).getClass().isInstance(Rock.class))	{
						//si il peut aller sur la gauche
						
						//si il peut aller sur la droite
						
					} else	{
						((Gravity) this.getMapXY(x, y)).setFalling(false);
					}
			}
		}
	}

	private void setWidth(final int width) {
		this.width = width;
	}

	private void setHeight(final int height) {
		this.height = height;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public IElement getMapXY(int x, int y) {
		return this.onTheMap[x][y];
	}

	@Override
	public Observable getObservable() {
		return this;
	}

	private void setOnMapXY(final IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}

	@Override
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}
}
