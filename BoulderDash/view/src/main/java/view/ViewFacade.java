package view;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.IMap;
import model.IMobile;
import model.UserOrder;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, Runnable, KeyListener {

	private static final int squareSize = 50;

	private static final int widthView = 20;

	private static final int heightView = 20;

	private Rectangle closeView;

	private IMap map;

	private IMobile character;

	private int xView;

	private int yView;

	private UserOrder orderPerformer;

	/**
	 * Instantiates a new view facade.
	 * @throws IOException 
	 */
	public ViewFacade(final IMap map, final IMobile character) throws IOException {
		this.setMap(map);
		this.setMyCharacter(character);
		this.followMyCharacter();
		this.getMyCharacter().getSprite().loadImage();
		this.setCloseView(new Rectangle(xView, yView, widthView, heightView));
		SwingUtilities.invokeLater(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IView#displayMessage(java.lang.String)
	 */
	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public final void show(final int yStart, final int xStart) {

	}

	public final void followMyCharacter() {
		if (getMyCharacter().getX() >= ViewFacade.widthView / 2
				&& getMyCharacter().getX() <= this.getMap().getWidth() - ViewFacade.widthView / 2)
			this.setXView(getMyCharacter().getX() - ViewFacade.widthView / 2);
		if (getMyCharacter().getY() >= ViewFacade.heightView / 2
				&& getMyCharacter().getY() <= this.getMap().getHeight() - ViewFacade.heightView / 2)
			this.setYView(getMyCharacter().getY() - ViewFacade.heightView / 2);

	}

	private static UserOrder keyCodeToUserOrder(final int keyCode) {
		switch (keyCode) {

		case KeyEvent.VK_RIGHT:
			return UserOrder.RIGHT;
		case KeyEvent.VK_LEFT:
			return UserOrder.LEFT;
		case KeyEvent.VK_UP:
			return UserOrder.UP;
		case KeyEvent.VK_DOWN:
			return UserOrder.DOWN;
		}
		return UserOrder.NOP;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	private IMobile getMyCharacter() {
		return this.character;
	}

	private void setMyCharacter(IMobile character) {
		this.character = character;
	}

	private void setMap(IMap map) {
		this.map = map;
	}

	private void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}

	private IMap getMap() {
		return this.map;
	}

	private void setYView(final int yView) {
		this.yView = yView;
	}

	private void setXView(final int xView) {
		this.xView = xView;
	}

}
