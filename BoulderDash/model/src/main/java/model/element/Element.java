package model.element;

import java.awt.Image;

import model.IElement;
import model.Sprite;

public class Element implements IElement {

	// Coordinates relative to the element
	private int x;
	private int y;

	// Sprite (Contains images) of the element
	private Sprite sprite;
	
	// Blocks or not the player
	private model.Permeability permeability;
	
	private int index = 0;

	/**
     * Instantiates a new element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
	public Element(Sprite sprite, model.Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	/**
	 * Returns the sprite related to the element
	 * 
	 */
	public Sprite getSprite() {
		return sprite;
	}

	/**
	 * Sets the sprite of an element
	 * 
	 * @param sprite
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Returns the permeability of an element
	 * 
	 */
	public model.Permeability getPermeability() {
		return permeability;
	}

	/**
	 * Sets the permeability of an element
	 * 
	 * @param permeability
	 */
	public void setPermeability(model.Permeability permeability) {
		this.permeability = permeability;
	}

	/**
	 * Returns the 4 images contained in the sprite
	 * 
	 */
	@Override
	public Image getImage() {

		if (index > this.getSprite().getSize() - 1)
			index = 0;

		return this.sprite.getImage(index++);
	}

	/**
	 * Returns the x coordinate of the element
	 * 
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x coordinate of the element
	 * 
	 * @param x
	 */
	public void setX(final int x) {
		this.x = x;
	}

	/**
	 * Returns the y coordinate of the element
	 * 
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y coordinate of the element
	 * 
	 * @param y
	 */
	public void setY(final int y) {
		this.y = y;
	}
}
