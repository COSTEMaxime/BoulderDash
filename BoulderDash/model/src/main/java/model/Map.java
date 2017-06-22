package model;

import java.util.LinkedList;
import java.util.Observable;

import model.cad.JDBC;
import model.element.ElementFactory;
import model.element.mobile.Mobile;
import model.element.mobile.Player;
import model.element.mobile.gravity.Diamond;
import model.element.mobile.gravity.Gravity;
import model.element.mobile.gravity.Rock;
import model.element.mobile.monster.Monster_Diamond;
import model.element.mobile.monster.Monster_Score;
import model.element.motionless.Air;

/**
 * The class that represents the map
 * 
 * 
 * @author Coste Maxime
 *
 */

public class Map extends Observable implements IMap {

	/* The width of the map */
	private int width;

	/* The height of the map */
	private int height;

	/* Double dimension array to store the Elements */
	private IElement[][] onTheMap;

	/**
	 * Constructor
	 * 
	 * @param mapName
	 *            the name of the map to be load
	 */

	public Map(final String mapName) {
		loadMap(mapName);
	}

	/**
	 * Load the map
	 * 
	 * @param nomMap
	 *            the name of the map to be load
	 */
	private void loadMap(final String nomMap) {

		ICAD cad = new JDBC();

		LinkedList<?> result = cad.load(nomMap);

		this.setHeight((int) result.get(0));
		this.setWidth((int) result.get(1));
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];

		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];

		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				this.setOnMapXY(
						ElementFactory.getFromFileSymbol(((String) result.get(2)).charAt(x + (y * (this.getWidth())))),
						x, y);
			}
		}
	}

	/**
	 * The update function Called at each game tick, apply physics on the map
	 * 
	 */

	@Override
	public void update() {

		// améliorable en prenant en compte les bordures
		for (int y = this.getHeight() - 2; y >= 0; y--) {
			for (int x = 0; x < this.getWidth(); x++) {

				// si l'objet est un objet soumit à la gravité
				if (this.getMapXY(x, y).getClass() == Diamond.class || this.getMapXY(x, y).getClass() == Rock.class) {

					// si il y a de l'air juste en dessous alors l'objet tombe
					if (this.getMapXY(x, y + 1).getClass() == Air.class) {
						((Gravity) this.getMapXY(x, y)).setFalling(true);
						((Mobile) this.getMapXY(x, y)).moveDown();
						// System.out.println(this.getMapXY(x, y));
						this.setOnMapXY(this.getMapXY(x, y), x, y + 1);

						System.out.println(this.getMapXY(x, y + 1));
						this.setOnMapXY(ElementFactory.createAir(), x, y);
						System.out.println(this.getMapXY(x, y));
						continue;

						// si il y a le joueur en dessous et que l'objet est
						// déjà en train de tomber
					} else if (this.getMapXY(x, y + 1).getClass() == Player.class
							&& ((Gravity) this.getMapXY(x, y)).isFalling()) {

						((Player) this.getMapXY(x, y + 1)).die();
						((Mobile) this.getMapXY(x, y)).moveDown();
						this.setOnMapXY(ElementFactory.createAir(), x, y);
						continue;
						// si il y a un rocher en dessous
					} else if (this.getMapXY(x, y + 1).getClass() == Rock.class
							|| this.getMapXY(x, y + 1).getClass() == Diamond.class) {

						// si il peut aller sur la gauche
						if (this.getMapXY(x - 1, y).getClass() == Air.class
								&& this.getMapXY(x - 1, y + 1).getClass() == Air.class) {

							((Gravity) this.getMapXY(x, y)).setFalling(true);
							((Mobile) this.getMapXY(x, y)).moveLeft();
							this.setOnMapXY(ElementFactory.createAir(), x, y);
							continue;

							// si il peut aller sur la droite
						} else if (this.getMapXY(x + 1, y).getClass() == Air.class
								&& this.getMapXY(x + 1, y + 1).getClass() == Air.class) {

							((Gravity) this.getMapXY(x, y)).setFalling(true);
							((Mobile) this.getMapXY(x, y)).moveRight();
							this.setOnMapXY(ElementFactory.createAir(), x, y);
							continue;
						}
					}
					// si on arrive ici c'est que l'objet n'a pas bougé
					((Gravity) this.getMapXY(x, y)).setFalling(false);
				}

				// si l'objet est un monstre
				if (this.getMapXY(x, y).getClass() == Monster_Diamond.class
						|| this.getMapXY(x, y).getClass() == Monster_Score.class) {

					// check sa direction + position joueur

				}

			}
		}
		this.setMobileHasChanged();
	}

	/**
	 * Set the width of the map
	 * 
	 * @param width
	 *            the width
	 */
	private void setWidth(final int width) {
		this.width = width;
	}

	/**
	 * Set the height of the map
	 * 
	 * @param height
	 *            the height
	 */

	private void setHeight(final int height) {
		this.height = height;
	}

	/**
	 * Return the width of the map
	 * 
	 * @return the width
	 */

	@Override
	public int getWidth() {
		return this.width;
	}

	/**
	 * Return the height of the map
	 * 
	 * @return the height
	 */

	@Override
	public int getHeight() {
		return this.height;
	}

	/**
	 * Return an Element at a specific coordinate on the map
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 * 
	 * @return the Element
	 */

	@Override
	public IElement getMapXY(int x, int y) {
		return this.onTheMap[x][y];
	}

	@Override
	public Observable getObservable() {
		return this;
	}

	private void setOnMapXY(final IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}

	@Override
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}
}
