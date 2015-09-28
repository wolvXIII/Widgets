/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.util;


/**
 * Represents a rectangle.
 */
public class Rectangle {

	private int x;
	private int y;
	private int width;
	private int height;

	public Rectangle() {
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
	}

	/**
	 * Gets the x coordinate.
	 *
	 * @return the x.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Sets the x coordinate.
	 *
	 * @param x
	 *            the x to set.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y coordinate.
	 *
	 * @return the y.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Sets the y coordinate.
	 *
	 * @param y
	 *            the y to set.
	 */
	public void setY(int y) {
		this.y = y;
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
	 * Sets the location of the rectangle.
	 *
	 * @param x
	 *            the x to set.
	 * @param y
	 *            the y to set.
	 */
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
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
	 * Sets the bounds of the rectangle.
	 *
	 * @param x
	 *            the x to set.
	 * @param y
	 *            the y to set.
	 * @param width
	 *            the width to set.
	 * @param height
	 *            the height to set.
	 */
	public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Shifts the location of the rectangle.
	 *
	 * @param xShift
	 *            the x shift.
	 * @param yShift
	 *            the y shift.
	 */
	public void move(int xShift, int yShift) {
		this.x += xShift;
		this.y += yShift;
	}

	/**
	 * Increments the size of the rectangle.
	 *
	 * @param widthIncrement
	 *            the width to add.
	 * @param heightIncrement
	 *            the height to add.
	 */
	public void incrementSize(int widthIncrement, int heightIncrement) {
		this.width += widthIncrement;
		this.height += heightIncrement;
	}

	/**
	 * Decrements the size of the rectangle.
	 *
	 * @param widthDecrement
	 *            the width to remove.
	 * @param heightDecrement
	 *            the height to remove.
	 */
	public void decrementSize(int widthDecrement, int heightDecrement) {
		this.width -= widthDecrement;
		this.height -= heightDecrement;
	}

	/**
	 * Updates the rectangle bounds.
	 *
	 * @param xShift
	 *            the x shift.
	 * @param yShift
	 *            the y shift.
	 * @param widthIncrement
	 *            the width to add.
	 * @param heightIncrement
	 *            the height to add.
	 */
	public void update(int xShift, int yShift, int widthIncrement, int heightIncrement) {
		this.x += xShift;
		this.y += yShift;
		this.width += widthIncrement;
		this.height += heightIncrement;
	}

}
