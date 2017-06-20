package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>The Sprite Class.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public class Sprite {
	
	private static final int spriteSize = 16;

	/** The image. */
	private Image[] image;

	/** The console image. */
	private char consoleImage;

	/** The is image loaded. */
	private boolean imageLoaded;

	/**
	 * Instantiates a new sprite.
	 *
	 * @param character
	 *            the character
	 * @param imageName
	 *            the image name
	 */
	public Sprite(final char character, final int index, final int world) {
		this.initImageTab();
		this.setConsoleImage(character);
		this.setImageSet(index, world);
	}

	private void setImageSet(final int index, final int world) {

		int i = 0;
		while (i++ < 4) {
			try {
				this.loadImage(index, world * 4 + i, i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.setImageLoaded(true);
	}

	private void initImageTab() {
		this.image = new Image[4];
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public final Image getImage(int index) {
		return this.image[index];
	}

	/**
	 * Loads image.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public final void loadImage(final int x, final int y, final int index) throws IOException {
		this.setImage(ImageIO.read(new File("images/74359.png")).getSubimage(x * Sprite.spriteSize,
				y * Sprite.spriteSize, Sprite.spriteSize, Sprite.spriteSize), index);
	}

	/**
	 * Gets the console image.
	 *
	 * @return the consoleImage
	 */
	public final char getConsoleImage() {
		return this.consoleImage;
	}

	/**
	 * Sets the image.
	 *
	 * @param image
	 *            the new image
	 */
	private void setImage(final Image image, final int index) {
		this.image[index] = image;
	}

	/**
	 * Sets the console image.
	 *
	 * @param consoleImage
	 *            the consoleImage to set
	 */
	private void setConsoleImage(final char consoleImage) {
		this.consoleImage = consoleImage;
	}

	/**
	 * Checks if is image loaded.
	 *
	 * @return true, if is image loaded
	 */
	public final boolean isImageLoaded() {
		return this.imageLoaded;
	}

	/**
	 * Sets the image loaded.
	 *
	 * @param isImageLoaded
	 *            the new image loaded
	 */
	public final void setImageLoaded(final boolean isImageLoaded) {
		this.imageLoaded = isImageLoaded;
	}
}
