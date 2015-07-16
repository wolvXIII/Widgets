/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.font;

public class FontProfile {

	/**
	 * @see http://www.w3schools.com/cssref/pr_font_font-size.asp
	 */
	public enum FontSize {
		XX_SMALL, X_SMALL, SMALL, MEDIUM/* default */, LARGE, X_LARGE, XX_LARGE, SMALLER, LARGER, LENGTH/* custom */,
		PERCENT, INITIAL, INHERIT;
	};

	private String family;
	private FontSize size;
	private int sizeValue; // used only for LENGTH & PERCENT
	private int style; // MicroUI DisplayFont styles

	/**
	 * Gets the font family.
	 *
	 * @return the family.
	 */
	public String getFamily() {
		return this.family;
	}

	/**
	 * Gets the font size.
	 *
	 * @return the size.
	 */
	public FontSize getSize() {
		return this.size;
	}

	/**
	 * Gets the font size value.
	 * <p>
	 * Used only if size is one of {@link FontSize#LENGTH} or {@link FontSize#PERCENT}.
	 *
	 * @return the size value.
	 */
	public int getSizeValue() {
		return this.sizeValue;
	}

	/**
	 * Gets the font style.
	 *
	 * @return the style.
	 */
	public int getStyle() {
		return this.style;
	}

}
