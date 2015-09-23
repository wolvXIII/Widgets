/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.util;

import ej.style.Style;

public class StyleHelper {

	private StyleHelper() {
	}

	public static boolean isComplete(Style style) {
		return isSetForeground(style) && isSetBackground(style) && isSetFontProfile(style) && isSetTextManager(style)
				&& isSetDimension(style) && isSetPadding(style) && isSetBorder(style) && isSetMargin(style);
	}

	public static boolean isSetForeground(Style style) {
		return style.getForegroundColor() != -1;
	}

	public static boolean isSetBackground(Style style) {
		return style.getBackground() != null;
	}

	public static boolean isSetFontProfile(Style style) {
		return style.getFontProfile() != null;
	}

	public static boolean isSetTextManager(Style style) {
		return style.getTextManager() != null;
	}

	public static boolean isSetDimension(Style style) {
		return style.getDimension() != null;
	}

	public static boolean isSetPadding(Style style) {
		return style.getPadding() != null;
	}

	public static boolean isSetBorder(Style style) {
		return style.getBorder() != null;
	}

	public static boolean isSetMargin(Style style) {
		return style.getMargin() != null;
	}

}
