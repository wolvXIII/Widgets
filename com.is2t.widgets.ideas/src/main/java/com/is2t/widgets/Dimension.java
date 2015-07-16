/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets;

import ej.mwt.MWT;

/**
 *
 */
public class Dimension {

	public static final Dimension NO_DIMENSION = new Dimension();

	private int width;
	private int height;

	public Dimension() {
		this.width = MWT.NONE;
		this.height = MWT.NONE;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width.
	 */
	public int getWidth() {
		return this.width;
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
	 * Gets the height.
	 *
	 * @return the height.
	 */
	public int getHeight() {
		return this.height;
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

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void increment(int width, int height) {
		this.width += width;
		this.height += height;
	}

	public Dimension getDimension() {
		Dimension dimension = new Dimension();
		dimension.width = this.width;
		dimension.height = this.height;
		return dimension;
	}

}
