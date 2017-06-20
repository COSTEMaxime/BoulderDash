package model.element;

import java.awt.Image;

import model.IElement;
import model.Sprite;

public class Element implements IElement {

	private Sprite[] sprite;
	private model.Permeability permeability;
	
	public Element(Sprite[] sprite, model.Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	public Sprite getSprite(int position) {
		return sprite[position];
	}

	public void setSprite(Sprite[] sprite) {
		this.sprite = sprite;
	}

	public model.Permeability getPermeability() {
		return permeability;
	}

	public void setPermeability(model.Permeability permeability) {
		this.permeability = permeability;
	}
	
	public Image getImage() {
		return null;
	}
}
