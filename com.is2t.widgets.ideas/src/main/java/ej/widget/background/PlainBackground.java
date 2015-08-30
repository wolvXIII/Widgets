/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.background;

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
	public int getColor() {
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
		g.setColor(getColor());
		g.fillRect(0, 0, width, height);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PlainBackground) {
			PlainBackground other = (PlainBackground) obj;
			return this.backgroundColor == other.getColor();
		}
		return false;
	}

	@Override
	public String toString() {
		return "Plain background: " + Integer.toHexString(this.backgroundColor);
	}

}
