package model;

import java.awt.Image;

public interface IElement {
	
	Sprite getSprite(int position);
	
	model.Permeability getPermeability();
	
	Image getImage();
}
