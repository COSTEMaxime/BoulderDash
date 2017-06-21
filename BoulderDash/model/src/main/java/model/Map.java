package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

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
