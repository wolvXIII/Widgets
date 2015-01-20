/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.laf;

public class ColorProfile {

	private final int backgroundColor;
	private final int foregroundColor;
	private final int borderColor;

	/**
	 * @param backgroundColor
	 *            the background color.
	 * @param foregroundColor
	 *            the foreground color.
	 * @param borderColor
	 *            the border color.
	 */
	public ColorProfile(int backgroundColor, int foregroundColor, int borderColor) {
		super();
		this.backgroundColor = backgroundColor;
		this.foregroundColor = foregroundColor;
		this.borderColor = borderColor;
	}

	/**
	 * Gets the foreground color.
	 *
	 * @return the foreground color.
	 */
	public int getForegroundColor() {
		return this.foregroundColor;
	}

	/**
	 * Gets the background color.
	 *
	 * @return the background color.
	 */
	public int getBackgroundColor() {
		return this.backgroundColor;
	}

	/**
	 * Gets the border color.
	 *
	 * @return the border color.
	 */
	public int getBorderColor() {
		return this.borderColor;
	}

}
