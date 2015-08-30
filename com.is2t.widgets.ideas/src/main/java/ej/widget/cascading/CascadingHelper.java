/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.cascading;

import ej.widget.Style;

/*package*/class CascadingHelper {

	private CascadingHelper() {
	}

	public static boolean isComplete(Style style) {
		return isSetForeground(style) && isSetBackground(style) && isSetFontProfile(style) && isSetTextAlign(style)
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

	public static boolean isSetTextAlign(Style style) {
		return style.getTextAlign() != -1;
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
