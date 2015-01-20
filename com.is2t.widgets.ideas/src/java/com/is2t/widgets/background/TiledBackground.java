/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.background;

import com.is2t.widgets.laf.ColorProfile;

import ej.microui.io.GraphicsContext;
import ej.microui.io.Image;

/**
 *
 */
public class TiledBackground extends PlainBackground {

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
	public void draw(GraphicsContext g, ColorProfile colorProfile, int width,
			int height) {
		super.draw(g, colorProfile, width, height);
		// TODO alignment management
		// TODO repeat management
		g.drawImage(this.image, 0, 0, GraphicsContext.LEFT
				| GraphicsContext.TOP);
	}
}
