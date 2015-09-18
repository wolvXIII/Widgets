/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.font;

import ej.microui.display.DisplayFont;

/**
 * A font loader is responsible of loading the fonts.
 */
public interface FontLoader {

	/**
	 * Gets the MicroUI display font matching the given font profile.
	 *
	 * @param fontProfile
	 *            the font profile to match.
	 * @return the display font.
	 */
	DisplayFont getFont(FontProfile fontProfile);

}
