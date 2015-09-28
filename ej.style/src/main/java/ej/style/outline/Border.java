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
 *
 */
public class Border implements Outline {

	/**
	 * Singleton to use to avoid creating several instances.
	 */
	// FIXME make this singleton stateless
	public static final Border NO_BORDER = new Border();

	protected int color;
	protected int size;

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

	@Override
	public Rectangle wrap(Rectangle rectangle) {
		rectangle.update(-this.size, -this.size, this.size * 2, this.size * 2);
		return rectangle;
	}

	@Override
	public Rectangle unwrap(Rectangle rectangle) {
		rectangle.update(this.size, this.size, -this.size * 2, -this.size * 2);
		return rectangle;
	}

	@Override
	public Rectangle apply(GraphicsContext g, Rectangle rectangle) {
		g.setColor(this.color);
		int size = this.size;
		int currentWidth = rectangle.getWidth() - 1;
		int currentHeight = rectangle.getHeight() - 1;
		for (int i = -1; ++i < size;) {
			g.drawRect(i, i, currentWidth, currentHeight);
			currentWidth -= 2;
			currentHeight -= 2;
		}
		g.translate(size, size);
		unwrap(rectangle);
		g.clipRect(0, 0, rectangle.getWidth(), rectangle.getHeight());
		return rectangle;
	}

}
