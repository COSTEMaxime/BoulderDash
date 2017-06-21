package model.element;

import java.awt.Image;

import model.IElement;
import model.Sprite;

public class Element implements IElement {

	private Sprite sprite;
	private model.Permeability permeability;
	private int index = 0;
	
	public Element(Sprite sprite, model.Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public model.Permeability getPermeability() {
		return permeability;
	}

	public void setPermeability(model.Permeability permeability) {
		this.permeability = permeability;
	}
	
	@Override
	public Image getImage() {
		
		if(index > this.getSprite().getSize() -1 )
			index = 0;
	
		return this.sprite.getImage(index++);
		
	}

}
