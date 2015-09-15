/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.boxmodel;

import ej.microui.display.GraphicsContext;
import ej.widget.Size;

/**
 *
 */
public class Border implements Box {

	/**
	 * Singleton to use to avoid creating several instances.
	 */
	// FIXME make this singleton stateless
	public static final Border NO_BORDER = new Border();

	private int color;
	private int size;
	private int radius;

	/**
	 * Sets the color.
	 *
	 * @param color
	 *            the color to set.
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * Sets the width.
	 *
	 * @param width
	 *            the width to set.
	 */
	public void setWidth(int width) {
		this.size = width;
	}

	/**
	 * Sets the radius.
	 *
	 * @param radius
	 *            the radius to set.
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public Size box(Size dimension) {
		dimension.increment(this.size * 2, this.size * 2);
		return dimension;
	}

	@Override
	public Size unbox(Size dimension) {
		dimension.decrement(this.size * 2, this.size * 2);
		return dimension;
	}

	@Override
	public Size apply(GraphicsContext g, Size dimension) {
		g.setColor(this.color);
		// TODO apply radius
		int size = this.size;
		int currentWidth = dimension.getWidth() - 1;
		int currentHeight = dimension.getHeight() - 1;
		for (int i = -1; ++i < size;) {
			g.drawRect(i, i, currentWidth, currentHeight);
			currentWidth -= 2;
			currentHeight -= 2;
		}
		g.translate(size, size);
		dimension.increment(-this.size * 2, -this.size * 2);
		g.clipRect(0, 0, dimension.getWidth(), dimension.getHeight());
		return dimension;
	}

}
