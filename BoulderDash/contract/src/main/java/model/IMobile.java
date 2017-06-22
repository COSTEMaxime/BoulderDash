package model;

import java.awt.Point;

import fr.exia.showboard.IPawn;

public interface IMobile extends IPawn, IElement {
	

    /**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Do nothing.
     */
    void doNothing();

  
    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();


    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    @Override
    Point getPosition();
}
