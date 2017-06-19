package model;

import java.awt.Point;
import java.sql.SQLException;
import java.util.List;

import model.dao.ExampleDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel {

	private IMap map;

	private IMobile myCharacter;

	/**
	 * Instantiates a new model facade.
	 */
	public ModelFacade(final String nomMap) {
		this.setMap(new Map(nomMap));
		//TODO récupèrer les coordonnées de départ dans la BDD
		//this.setMyCharacter(new Character(,, this.getMap()));
	}
	
	@Override
	public IMobile getMyCharacter() {
		return this.myCharacter;
	}
	
	private void setMyCharacter(final IMobile character)	{
		this.myCharacter = character;
	}

	@Override
	public IMap getMap() {
		return this.map;
	}

	private void setMap(final Map map) {
		this.map = map;
	}

}
