/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.dimension;

import ej.mwt.MWT;
import ej.style.util.Size;

/**
 * Dimension with fixed width and/or height.
 */
public class FixedDimension implements Dimension {

	private int width;
	private int height;

	/**
	 * Creates a new fixed dimension without constraint.
	 */
	public FixedDimension() {
		this.width = MWT.NONE;
		this.height = MWT.NONE;
	}

	/**
	 * Sets the width.
	 *
	 * @param width
	 *            the width to set.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Sets the height.
	 *
	 * @param height
	 *            the height to set.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Sets the width and height.
	 * 
	 * @param width
	 *            the width to set.
	 * @param height
	 *            the height to set.
	 */
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void apply(Size currentSize, int widthHint, int heightHint) {
		currentSize.setSize(Math.max(this.width, currentSize.getWidth()),
				Math.max(this.height, currentSize.getHeight()));
	}

}
