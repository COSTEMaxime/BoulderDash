package model;

import java.awt.Image;

public interface IElement {
	
	Sprite getSprite();
	
	model.Permeability getPermeability();
	
	Image getImage();
}
