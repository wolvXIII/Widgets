/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.boxmodel;

import ej.microui.display.GraphicsContext;
import ej.widget.Dimension;

/**
 *
 */
public class SimpleBoxing implements Boxing {

	private int size;

	/**
	 * Sets the size.
	 *
	 * @param size
	 *            the size to set.
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size.
	 */
	public int getSize() {
		return this.size;
	}

	@Override
	public Dimension applySize(Dimension dimension) {
		dimension.increment(this.size * 2, this.size * 2);
		return dimension;
	}

	@Override
	public Dimension apply(GraphicsContext g, Dimension dimension) {
		g.translate(this.size, this.size);
		dimension.increment(-this.size * 2, -this.size * 2);
		g.clipRect(0, 0, dimension.getWidth(), dimension.getHeight());
		return dimension;
	}

}
