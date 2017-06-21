package model;

import java.util.Observable;

public interface IMap {

	int getWidth();
	
	int getHeight();

	IElement getMapXY(int x, int y);

	Observable getObservable();

    void setMobileHasChanged();

	void update();

}
