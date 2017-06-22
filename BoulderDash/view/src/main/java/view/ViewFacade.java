package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import fr.exia.showboard.BoardFrame;
import fr.exia.showboard.IPawn;
import model.IMap;
import model.IMobile;
import model.UserOrder;
import view.IOrderPerformer;
import view.IView;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, Runnable, KeyListener {

	private static final int squareSize = 50;

	private static final int borderOffset = 6;

	private static final int widthView = 14;

	private static final int heightView = 14;

	private Rectangle closeView;

	private IMap map;

	private IMobile character;

	private int xView;
  
	private int yView;

	private IOrderPerformer orderPerformer;

	/**
	 * Instantiates a new view facade.
	 * 
	 * @throws IOException
	 */
	public ViewFacade(final IMap map, final IMobile character) throws IOException {
		this.setMap(map);
		this.setMyCharacter(character);
		this.setXView(0);
		this.setYView(0);

		//changer méthode pour le personnage
		//this.getMyCharacter().getSprite().loadImage();
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
		
		final BoardFrame boardFrame = new BoardFrame("Boulderdash");
        boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
        System.out.println(this.getMap().getWidth() + " " + this.getMap().getHeight());
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(true);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        
        boardFrame.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		/*	à changer	*/
        		/*
        		for (int y = 0; y < getMap().getHeight(); y++) {
                    for (int x = 0; x < getMap().getWidth(); x++) {
                        boardFrame.addSquare(getMap().getMapXY(x, y), x, y);
                    }
                }*/
        		boardFrame.repaint();
        		show();
        	}
		});
        
        
        for (int y = 0; y < this.getMap().getHeight(); y++) {
            for (int x = 0; x < this.getMap().getWidth(); x++) {
                //boardFrame.addSquare(this.getMap().getMapXY(x, y), x, y);
                boardFrame.addPawn((IPawn) this.getMap().getMapXY(x, y));
            }
        } 
        
        //this.show();
        
        //boardFrame.addPawn(this.getMyCharacter());
        this.getMap().getObservable().addObserver(boardFrame.getObserver());
        //this.followMyCharacter();
        
        boardFrame.setVisible(true);

	}
	
	public final void show() {
		
        for (int y = 0; y < this.getMap().getHeight(); y++) {
            for (int x = 0; x < this.getMap().getWidth(); x++) {
                    System.out.print(this.getMap().getMapXY(x, y).getSprite().getConsoleImage());
                }
            System.out.print("\n");
            }
            
        }

	public final void followMyCharacter() {
		
		/*	à revoir	*/
		if (getMyCharacter().getX() < ViewFacade.borderOffset)
			this.setXView(this.getXView() + 1);

		if (getMyCharacter().getX() > this.getMap().getWidth() - ViewFacade.borderOffset)
			this.setXView(getXView() - 1);

		if (getMyCharacter().getY() < ViewFacade.borderOffset)
			this.setYView(this.getYView() + 1);

		if (getMyCharacter().getY() > this.getMap().getHeight() - ViewFacade.borderOffset)
			this.setYView(getYView() - 1);
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
	public void keyPressed(KeyEvent keyEvent) {
		try {
			System.out.println(keyEvent.getKeyCode());
			System.out.println(keyCodeToUserOrder(keyEvent.getKeyCode())); 
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {

	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {

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

	public void setYView(final int yView) {
		this.yView = yView;
	}

	public void setXView(final int xView) {
		this.xView = xView;
	}

	public int getXView() {
		return this.xView;
	}

	public int getYView() {
		return this.yView;
	}
	
	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}
	
	public void setOrderPerformer(IOrderPerformer orderPerformer)	{
		this.orderPerformer = orderPerformer;
	}
}