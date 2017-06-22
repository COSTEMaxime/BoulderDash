package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

import model.cad.JDBC;
import model.element.mobile.Player;
import model.element.mobile.gravity.Diamond;
import model.element.mobile.gravity.Gravity;
import model.element.mobile.gravity.Rock;
import model.element.mobile.monster.Monster_Diamond;
import model.element.mobile.monster.Monster_Score;
import model.element.motionless.MotionlessFactory;

public class Map extends Observable implements IMap {

	private int width;
	private int height;
	private IElement[][] onTheMap;
	private ArrayList<IElement> updateList;

	public Map(final String mapName) {
		this.updateList = new ArrayList<IElement>();
		loadMap(mapName);
	}

	private void loadMap(final String nomMap) {

		ICAD cad = new JDBC();

		LinkedList<?> result = cad.load(nomMap);

		this.setHeight((int) result.get(0));
		this.setWidth((int) result.get(1));
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];

		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];

		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {

				this.setOnMapXY(MotionlessFactory
						.getFromFileSymbol(((String) result.get(2)).charAt(x + (y * (this.getWidth())))), x, y);
			}
		}
	}

	@Override
	public void update() {

		// améliorable en prenant en compte les bordures
		for (int y = this.getHeight() - 2; y >= 0; y--) {
			for (int x = 0; x < this.getWidth(); x++) {

				// si l'objet est un objet soumit à la gravité
				if (this.getMapXY(x, y).getClass() == Diamond.class || this.getMapXY(x, y).getClass() == Rock.class) {

					// si il y a de l'air juste en dessous alors l'objet tombe
					if (this.getMapXY(x, y + 1).equals(MotionlessFactory.createAir())) {
						((Gravity) this.getMapXY(x, y)).setFalling(true);
						this.setOnMapXY(this.getMapXY(x, y), x, y + 1);
						this.setOnMapXY(MotionlessFactory.createAir(), x, y);
						continue;

						// si il y a le joueur en dessous et que l'objet est
						// déjà en train de tomber
					} else if (this.getMapXY(x, y + 1).getClass() == Player.class
							&& ((Gravity) this.getMapXY(x, y)).isFalling()) {

						((Player) this.getMapXY(x, y + 1)).die();
						this.setOnMapXY(this.getMapXY(x, y), x, y + 1);
						this.setOnMapXY(MotionlessFactory.createAir(), x, y);
						continue;
						// si il y a un rocher en dessous
					} else if (this.getMapXY(x, y + 1).getClass() == Rock.class
							|| this.getMapXY(x, y + 1).getClass() == Diamond.class) {

						// si il peut aller sur la gauche
						if (this.getMapXY(x - 1, y).equals(MotionlessFactory.createAir())
								&& this.getMapXY(x - 1, y + 1).equals(MotionlessFactory.createAir())) {

							((Gravity) this.getMapXY(x, y)).setFalling(true);
							this.setOnMapXY(this.getMapXY(x, y), x - 1, y);
							this.setOnMapXY(MotionlessFactory.createAir(), x, y);
							continue;

							// si il peut aller sur la droite
						} else if (this.getMapXY(x + 1, y).equals(MotionlessFactory.createAir())
								&& this.getMapXY(x + 1, y + 1).equals(MotionlessFactory.createAir())) {

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
				if (this.getMapXY(x, y).getClass() == Monster_Diamond.class
						|| this.getMapXY(x, y).getClass() == Monster_Score.class) {

					// check sa direction + position joueur

				}

			}
		}
		this.setMobileHasChanged();
	}

	private void setWidth(final int width) {
		this.width = width;
	}

	private void setHeight(final int height) {
		this.height = height;
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
