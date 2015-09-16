/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.background;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;

/**
 *
 */
public class ImageBackground extends PlainBackground {

	private Image image;
	private int alignment;

	/**
	 * Sets the image.
	 *
	 * @param image
	 *            the image to set.
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image.
	 */
	public Image getImage() {
		return this.image;
	}

	/**
	 * Sets the alignment.
	 *
	 * @param alignment
	 *            the alignment to set.
	 */
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

	/**
	 * Gets the alignment.
	 *
	 * @return the alignment.
	 */
	public int getAlignment() {
		return this.alignment;
	}

	@Override
	public void draw(GraphicsContext g, int width, int height) {
		super.draw(g, width, height);
		// TODO alignment management
		g.drawImage(this.image, 0, 0, GraphicsContext.LEFT | GraphicsContext.TOP);
	}
}
