package model;

import java.util.Observable;

import model.element.mobile.Player;
import model.element.mobile.gravity.Gravity;
import model.element.motionless.MotionlessFactory;

public class Map extends Observable implements IMap {

	public static final int borderSize = 2;

	private int width;
	private int height;
	private IElement[][] onTheMap;

	public Map(final String mapName) {
		loadFromBDD(mapName);
	}

	private void loadFromBDD(final String nomMap) {

		// TEST
		this.setHeight(10);
		this.setWidth(10);
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];

		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				if (y < borderSize || y >= this.getHeight() - borderSize || x < borderSize
						|| x >= this.getWidth() - borderSize) {
					this.setOnMapXY(MotionlessFactory.createEarth(), x, y);
				} else {
					this.setOnMapXY(MotionlessFactory.getFromFileSymbol('X'), x, y);
				}
			}
		}

		this.setOnMapXY(MotionlessFactory.createAir(), 5, 5);
	}

	@Override
	public void update() {

		// améliorable en prenant en compte les bordures
		for (int y = this.getHeight() - 2; y >= 0; y--) {
			for (int x = 0; x < this.getWidth(); x++) {

				// si l'objet est un objet soumit à la gravité
				if (this.getMapXY(x, y).equals(MotionlessFactory.createDiamond())
						|| this.getMapXY(x, y).equals(MotionlessFactory.createRock())) {

					// si il y a de l'air juste en dessous alors l'objet tombe
					if (this.getMapXY(x, y + 1).equals(MotionlessFactory.createAir())) {

						((Gravity) this.getMapXY(x, y)).setFalling(true);
						this.setOnMapXY(this.getMapXY(x, y), x, y + 1);
						this.setOnMapXY(MotionlessFactory.createAir(), x, y);
						continue;

						// si il y a le joueur en dessous et que l'objet est
						// déjà en train de tomber
					} else if (this.getMapXY(x, y + 1).equals(MotionlessFactory.createPlayer())
							&& ((Gravity) this.getMapXY(x, y)).isFalling()) {

						((Player) this.getMapXY(x, y + 1)).die();
						this.setOnMapXY(this.getMapXY(x, y), x, y + 1);
						this.setOnMapXY(MotionlessFactory.createAir(), x, y);
						continue;
						// si il y a un rocher en dessous
					} else if (this.getMapXY(x, y + 1).equals(MotionlessFactory.createRock())) {

						// si il peut aller sur la gauche
						if (this.getMapXY(x - 1, y).equals(MotionlessFactory.createAir())
								&& this.getMapXY(x - 1, y + 1).equals(MotionlessFactory.createAir())) {

							((Gravity) this.getMapXY(x, y)).setFalling(true);
							;
							this.setOnMapXY(this.getMapXY(x, y), x - 1, y);
							this.setOnMapXY(MotionlessFactory.createAir(), x, y);
							continue;

							// si il peut aller sur la droite
						} else if (this.getMapXY(x + 1, y).equals(MotionlessFactory.createAir())
								&& this.getMapXY(x + 1, y + 1).getClass().equals(MotionlessFactory.createAir())) {

							((Gravity) this.getMapXY(x, y)).setFalling(true);
							this.setOnMapXY(this.getMapXY(x, y), x + 1, y);
							this.setOnMapXY(MotionlessFactory.createAir(), x, y);
							continue;
						}
					}
					// si on arrive ici c'est que l'objet n'a pas bougé
					((Gravity) this.getMapXY(x, y)).setFalling(false);
				}

				// si l'objet est un monstre
				if (this.getMapXY(x, y).equals(MotionlessFactory.createMonsterDiamond())
						|| this.getMapXY(x, y).equals(MotionlessFactory.createMonsterScore())) {
					
					//check sa direction + position joueur

				}

			}
		}
		this.setMobileHasChanged();
	}

	private void setWidth(final int width) {
		this.width = width + 2 * borderSize;
	}

	private void setHeight(final int height) {
		this.height = height + 2 * borderSize;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

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
