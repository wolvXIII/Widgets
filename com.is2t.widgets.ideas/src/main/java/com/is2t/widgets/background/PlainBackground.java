/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.background;

import ej.microui.display.GraphicsContext;

/**
 *
 */
public class PlainBackground implements Background {

	private int backgroundColor;

	/**
	 * Gets the background color.
	 * 
	 * @return the background color.
	 */
	public int getBackgroundColor() {
		return this.backgroundColor;
	}

	/**
	 * Sets the background color.
	 * 
	 * @param backgroundColor
	 *            the background color to set.
	 */
	public void setColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	public void draw(GraphicsContext g, int width, int height) {
		g.setColor(getBackgroundColor());
		g.fillRect(0, 0, width, height);
	}

}
