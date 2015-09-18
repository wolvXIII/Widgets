/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.outline;

import ej.microui.display.GraphicsContext;
import ej.style.util.Size;

/**
 * Outline that have the same thickness for all edges.
 */
public class SimpleOutline implements Outline {

	private int thickness;

	/**
	 * Sets the thickness.
	 *
	 * @param thickness
	 *            the thickness to set.
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	/**
	 * Gets the thickness.
	 *
	 * @return the thickness.
	 */
	public int getThickness() {
		return this.thickness;
	}

	@Override
	public Size wrap(Size dimension) {
		dimension.increment(this.thickness * 2, this.thickness * 2);
		return dimension;
	}

	@Override
	public Size unwrap(Size dimension) {
		dimension.decrement(this.thickness * 2, this.thickness * 2);
		return dimension;
	}

	@Override
	public Size apply(GraphicsContext g, Size dimension) {
		g.translate(this.thickness, this.thickness);
		unwrap(dimension);
		g.clipRect(0, 0, dimension.getWidth(), dimension.getHeight());
		return dimension;
	}

}
