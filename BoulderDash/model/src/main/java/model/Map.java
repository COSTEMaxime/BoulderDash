package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

public class Map extends Observable implements IMap {
	
	private int width;
	private int height;
	private IElement[][] onTheMap;
	
	public Map (final String mapName)	{
		loadFromBDD(mapName);
	}

	private void loadFromBDD(final String nomMap) {
		
//		JDBC jdbc = new JDBC();

//		ResultSet result = jdbc.lireLigneBDD(nomMap);
//
//		try {
//			result.next();
//			this.setWidth(result.getInt(2));
//			setHeight(result.getInt(3));
//			String roadString = result.getString(4);
//
//			roadString = roadString.replaceAll("[\\r\\n]", "");
//
//			this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
//
//			for (int y = 0; y < this.getHeight(); y++) {
//				for (int x = 0; x <this.getWidth(); x++) {
////					this.setOnTheRoadXY(MotionlessElementsFactory.getFromFileSymbol(roadString.charAt(x + (y * this.getWidth()))), x, y);
//				}
//			}
//
//		} catch (SQLException e) {
//			System.err.println("La table " + nomMap + " n'a pas pu etre lue correctment");
//			e.printStackTrace();
//		}

//		jdbc.closeConnexion();
		
		
	}

	private void setWidth(final int width) {
		this.width = width;
	}
	
	private void setHeight(final int height)	{
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
	
	private void setOnTheRoadXY(final IElement element, final int x, final int y) {
        this.onTheMap[x][y] = element;
    }

	@Override
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}
}
