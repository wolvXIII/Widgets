/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.util;


/**
 * Represents a size.
 */
public class Size {

	private int width;
	private int height;

	public Size() {
		this.width = 0;
		this.height = 0;
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

	/**
	 * Sets the size of the rectangle.
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

	/**
	 * Increments the size of the rectangle.
	 *
	 * @param width
	 *            the width to add.
	 * @param height
	 *            the height to add.
	 */
	public void increment(int width, int height) {
		this.width += width;
		this.height += height;
	}

	/**
	 * Decrements the size of the rectangle.
	 *
	 * @param width
	 *            the width to remove.
	 * @param height
	 *            the height to remove.
	 */
	public void decrement(int width, int height) {
		this.width -= width;
		this.height -= height;
	}

}
