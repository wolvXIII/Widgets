/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.ideas;

import ej.microui.io.Image;

/**
 *
 */
public class ImageBackground extends PlainBackground {

	private Image image;

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

}
