package model.element;

import java.awt.Image;

import model.Sprite;

public class Element {

	private Sprite sprite;
	private Permeability permeability;
	
	public Element(Sprite sprite, Permeability permeability) {
		super();
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return permeability;
	}

	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}
	
	public Image getImage() {
		return null;
	}
}
