/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.font;

import ej.microui.display.DisplayFont;

/**
 *
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
