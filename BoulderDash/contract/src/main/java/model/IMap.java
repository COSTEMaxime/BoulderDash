package model;

import java.util.Observable;

import fr.exia.showboard.ISquare;

public interface IMap {

	int getWidth();
	
	int getHeight();

	IElement getMapXY(int x, int y);

	Observable getObservable();

    void setMobileHasChanged();

}
