package model.element;

import java.awt.Image;
import java.util.ArrayList;

import model.Sprite;

public class Element {

	private Sprite[] sprite;
	private Permeability permeability;
	
	public Element(Sprite[] sprite, Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	public Sprite getSprite(int position) {
		return sprite[position];
	}

	public void setSprite(Sprite[] sprite) {
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
