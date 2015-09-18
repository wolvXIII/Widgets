/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.font;

import ej.microui.display.DisplayFont;

/**
 * A font profile represents a font with a family, a size and a style.
 */
public class FontProfile {

	/**
	 * Font sizes.
	 */
	public enum FontSize {
		/**
		 * Extra extra small.
		 */
		XX_SMALL,
		/**
		 * Extra small.
		 */
		X_SMALL,
		/**
		 * Small.
		 */
		SMALL,
		/**
		 * Medium.
		 */
		MEDIUM,
		/**
		 * Large.
		 */
		LARGE,
		/**
		 * Extra large.
		 */
		X_LARGE,
		/**
		 * Extra extra large.
		 */
		XX_LARGE,
		/**
		 * Manual fixed size length.
		 */
		LENGTH/* custom */,
		/*
		 * PERCENT,SMALLER, LARGER, INITIAL, INHERIT
		 */;
	}

	private String family;
	private FontSize size;
	private int sizeValue; // used only for LENGTH & PERCENT
	// FIXME distinguish font-style & font-weight?
	private int style; // MicroUI DisplayFont styles

	/**
	 * Creates a new font profile.
	 */
	public FontProfile() {
		this.family = ""; //$NON-NLS-1$
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
	 * Used only if size is one of {@link FontSize#LENGTH}.
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
