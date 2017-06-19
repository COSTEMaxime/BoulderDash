package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.ControllerFacade;
import model.IModel;
import model.ModelFacade;
import view.IView;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException 
     */
    public static void main(final String[] args) throws IOException {
    	
    	final IModel model = new ModelFacade("level1");
    	final IView view = new ViewFacade(model.getMap(), model.getMyCharacter());
        final ControllerFacade controller = new ControllerFacade(view, model);

        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

}
