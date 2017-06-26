package controller;

import java.io.IOException;
import model.IModel;
import model.UserOrder;
import view.IOrderPerformer;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, IOrderPerformer {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	private UserOrder stackOrder;

	public static final int delay = 200;

	/**
	 * Instantiates a new controller facade.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public ControllerFacade(final IView view, final IModel model) {
		this.setModel(model);
		this.setView(view);
		this.clearStackOrder();
	}

	@Override
	public void play() throws InterruptedException {

		while (this.getModel().getPlayer().isAlive()) {
			Thread.sleep(delay);

			switch (this.getStackOrder()) {

			case DOWN:
				this.getModel().getPlayer().moveDown();
				break;
			case UP:
				this.getModel().getPlayer().moveUp();
				break;
			case LEFT:
				this.getModel().getPlayer().moveLeft();
				break;
			case RIGHT:
				this.getModel().getPlayer().moveRight();
				break;
			case NOP:
			default:
				break;
			}
			this.clearStackOrder();
			this.getModel().getMap().update();
			this.getView().syncWithMap();
			this.getView().followMyCharacter();
			this.getModel().getMap().setMobileHasChanged();
		}
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private IView getView() {
		return this.view;
	}

	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	private IModel getModel() {
		return this.model;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	@Override
	public void orderPerform(UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}

	@Override
	public IOrderPerformer getOrderPerformer() {
		return this;
	}

	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	private void setStackOrder(UserOrder userOrder) {
		this.stackOrder = userOrder;
	}

	private void clearStackOrder() {
		this.setStackOrder(UserOrder.NOP);
	}
}
