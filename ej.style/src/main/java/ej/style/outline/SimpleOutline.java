/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.outline;

import ej.microui.display.GraphicsContext;
import ej.style.util.Rectangle;

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
	public Rectangle wrap(Rectangle rectangle) {
		int thickness = this.thickness;
		rectangle.update(-thickness, -thickness, thickness << 1, thickness << 1);
		return rectangle;
	}

	@Override
	public Rectangle unwrap(Rectangle rectangle) {
		int thickness = this.thickness;
		rectangle.update(thickness, thickness, -thickness << 1, -thickness << 1);
		return rectangle;
	}

	@Override
	public Rectangle apply(GraphicsContext g, Rectangle rectangle) {
		g.translate(this.thickness, this.thickness);
		unwrap(rectangle);
		g.clipRect(0, 0, rectangle.getWidth(), rectangle.getHeight());
		return rectangle;
	}

}
