package main;

import java.io.IOException;
import controller.ControllerFacade;
import model.IElement;
import model.IModel;
import model.Model;
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
     * @throws InterruptedException 
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
    	
    	final IModel model = new Model("level1");
    	final IView view = new ViewFacade(model.getMap(), model.getPlayer());
        final ControllerFacade controller = new ControllerFacade(view, model);
        view.setOrderPerformer(controller.getOrderPerformer());
        controller.play();
    }
}
	
	