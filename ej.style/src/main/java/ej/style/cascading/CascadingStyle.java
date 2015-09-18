/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.cascading;

import ej.style.Style;
import ej.style.util.AbstractStyle;

/*package*/class CascadingStyle extends AbstractStyle {

	CascadingStyle() {
		// set default values
		this.foregroundColor = -1;
		// others are null: VM DONE
	}

	/**
	 * Fills all missing attributes of this style with those in the given style.
	 */
	boolean merge(Style style) {
		if (!CascadingHelper.isSetForeground(this)) {
			this.foregroundColor = style.getForegroundColor();
		}
		if (!CascadingHelper.isSetBackground(this)) {
			this.background = style.getBackground();
		}
		if (!CascadingHelper.isSetFontProfile(this)) {
			this.fontProfile = style.getFontProfile();
		}
		if (!CascadingHelper.isSetTextManager(this)) {
			this.textManager = style.getTextManager();
		}
		if (!CascadingHelper.isSetDimension(this)) {
			this.dimension = style.getDimension();
		}
		if (!CascadingHelper.isSetPadding(this)) {
			this.padding = style.getPadding();
		}
		if (!CascadingHelper.isSetBorder(this)) {
			this.border = style.getBorder();
		}
		if (!CascadingHelper.isSetMargin(this)) {
			this.margin = style.getMargin();
		}
		return CascadingHelper.isComplete(this);
	}

	boolean inheritMerge(Style parentStyle) {
		if (!CascadingHelper.isSetForeground(this)) {
			this.foregroundColor = parentStyle.getForegroundColor();
		}
		if (!CascadingHelper.isSetFontProfile(this)) {
			this.fontProfile = parentStyle.getFontProfile();
		}
		if (!CascadingHelper.isSetTextManager(this)) {
			this.textManager = parentStyle.getTextManager();
		}
		return CascadingHelper.isComplete(this);
	}

	/**
	 * Fills all defined attributes of the given style in this style.
	 */
	void override(Style style) {
		if (CascadingHelper.isSetForeground(style)) {
			this.foregroundColor = style.getForegroundColor();
		}
		if (CascadingHelper.isSetBackground(style)) {
			this.background = style.getBackground();
		}
		if (CascadingHelper.isSetFontProfile(style)) {
			this.fontProfile = style.getFontProfile();
		}
		if (CascadingHelper.isSetTextManager(style)) {
			this.textManager = style.getTextManager();
		}
		if (CascadingHelper.isSetDimension(style)) {
			this.dimension = style.getDimension();
		}
		if (CascadingHelper.isSetPadding(style)) {
			this.padding = style.getPadding();
		}
		if (CascadingHelper.isSetBorder(style)) {
			this.border = style.getBorder();
		}
		if (CascadingHelper.isSetMargin(style)) {
			this.margin = style.getMargin();
		}
	}

	CascadingStyle copy() {
		CascadingStyle simpleStyle = new CascadingStyle();
		simpleStyle.foregroundColor = this.foregroundColor;
		simpleStyle.background = this.background;
		simpleStyle.fontProfile = this.fontProfile;
		simpleStyle.textManager = this.textManager;
		simpleStyle.dimension = this.dimension;
		simpleStyle.padding = this.padding;
		simpleStyle.border = this.border;
		simpleStyle.margin = this.margin;
		return simpleStyle;
	}

}
