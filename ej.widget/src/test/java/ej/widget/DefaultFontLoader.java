/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import ej.microui.display.DisplayFont;
import ej.style.font.FontLoader;
import ej.style.font.FontProfile;

/**
 * 
 */
public class DefaultFontLoader implements FontLoader {

	@Override
	public DisplayFont getFont(FontProfile fontProfile) {
		return DisplayFont.getDefaultFont();
	}

}
