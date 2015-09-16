/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.font;

import ej.microui.display.DisplayFont;

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
	// FIXME distinguish font-style & font-weight?
	private int style; // MicroUI DisplayFont styles

	public FontProfile() {
		this.family = "";
		this.size = FontSize.MEDIUM;
		this.style = DisplayFont.STYLE_PLAIN;
	}

	/**
	 * Gets the font family.
	 *
	 * @return the family.
	 */
	public String getFamily() {
		return this.family;
	}

	/**
	 * Sets the family.
	 *
	 * @param family
	 *            the family to set.
	 */
	public void setFamily(String family) {
		this.family = family;
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
	 * Sets the size.
	 *
	 * @param size
	 *            the size to set.
	 */
	public void setSize(FontSize size) {
		this.size = size;
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
	 * Sets the size value.
	 *
	 * @param sizeValue
	 *            the size value to set.
	 */
	public void setSizeValue(int sizeValue) {
		this.sizeValue = sizeValue;
	}

	/**
	 * Gets the font style.
	 *
	 * @return the style.
	 */
	public int getStyle() {
		return this.style;
	}

	/**
	 * Sets the style.
	 *
	 * @param style
	 *            the style to set.
	 */
	public void setStyle(int style) {
		this.style = style;
	}

}
