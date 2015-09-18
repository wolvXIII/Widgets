/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style;

import ej.style.background.Background;
import ej.style.dimension.Dimension;
import ej.style.font.FontProfile;
import ej.style.outline.Border;
import ej.style.outline.Outline;
import ej.style.text.TextManager;

/**
 * Represents a style.
 */
public interface Style {

	/**
	 * Gets the foreground color.
	 *
	 * @return the foreground color.
	 */
	int getForegroundColor();

	/**
	 * Gets the background.
	 *
	 * @return the background.
	 */
	Background getBackground();

	/**
	 * Gets the font profile.
	 *
	 * @return the font profile.
	 */
	FontProfile getFontProfile();

	/**
	 * Gets the text manager.
	 *
	 * @return the text manager
	 */
	TextManager getTextManager();

	/**
	 * Gets the dimension.
	 *
	 * @return the dimension
	 */
	Dimension getDimension();

	/**
	 * Gets the padding.
	 *
	 * @return the padding
	 */
	Outline getPadding();

	/**
	 * Gets the border.
	 *
	 * @return the border
	 */
	Border getBorder();

	/**
	 * Gets the margin.
	 *
	 * @return the margin
	 */
	Outline getMargin();

}
