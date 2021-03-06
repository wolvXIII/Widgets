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
 * Complex outline that have a different thickness for each edge.
 */
public class ComplexOutline implements Outline {

	private int top;
	private int bottom;
	private int left;
	private int right;

	/**
	 * Gets the top.
	 *
	 * @return the top.
	 */
	public int getTop() {
		return this.top;
	}

	/**
	 * Sets the top.
	 *
	 * @param top
	 *            the top to set.
	 */
	public void setTop(int top) {
		this.top = top;
	}

	/**
	 * Gets the bottom.
	 *
	 * @return the bottom.
	 */
	public int getBottom() {
		return this.bottom;
	}

	/**
	 * Sets the bottom.
	 *
	 * @param bottom
	 *            the bottom to set.
	 */
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	/**
	 * Gets the left.
	 *
	 * @return the left.
	 */
	public int getLeft() {
		return this.left;
	}

	/**
	 * Sets the left.
	 *
	 * @param left
	 *            the left to set.
	 */
	public void setLeft(int left) {
		this.left = left;
	}

	/**
	 * Gets the right.
	 *
	 * @return the right.
	 */
	public int getRight() {
		return this.right;
	}

	/**
	 * Sets the right.
	 *
	 * @param right
	 *            the right to set.
	 */
	public void setRight(int right) {
		this.right = right;
	}

	@Override
	public Rectangle wrap(Rectangle rectangle) {
		rectangle.update(-this.left, -this.top, this.left + this.right, this.top + this.bottom);
		return rectangle;
	}

	@Override
	public Rectangle unwrap(Rectangle rectangle) {
		rectangle.update(this.left, this.top, -(this.left + this.right), -(this.top + this.bottom));
		return rectangle;
	}

	@Override
	public Rectangle apply(GraphicsContext g, Rectangle rectangle) {
		g.translate(this.left, this.top);
		unwrap(rectangle);
		g.clipRect(0, 0, rectangle.getWidth(), rectangle.getHeight());
		return rectangle;
	}

}
