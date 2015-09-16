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

	public CascadingStyle() {
		// set default values
		this.foregroundColor = -1;
		this.textAlign = -1;
		// others are null: VM DONE
	}

	/**
	 * Fills all missing attributes of this style with those in the given style.
	 */
	public boolean merge(Style style) {
		if (!CascadingHelper.isSetForeground(this)) {
			this.foregroundColor = style.getForegroundColor();
		}
		if (!CascadingHelper.isSetBackground(this)) {
			this.background = style.getBackground();
		}
		if (!CascadingHelper.isSetFontProfile(this)) {
			this.fontProfile = style.getFontProfile();
		}
		if (!CascadingHelper.isSetTextAlign(this)) {
			this.textAlign = style.getTextAlign();
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

	public boolean inheritMerge(Style parentStyle) {
		if (!CascadingHelper.isSetForeground(this)) {
			this.foregroundColor = parentStyle.getForegroundColor();
		}
		if (!CascadingHelper.isSetFontProfile(this)) {
			this.fontProfile = parentStyle.getFontProfile();
		}
		if (!CascadingHelper.isSetTextAlign(this)) {
			this.textAlign = parentStyle.getTextAlign();
		}
		return CascadingHelper.isComplete(this);
	}

	/**
	 * Fills all defined attributes of the given style in this style.
	 */
	public void override(Style style) {
		if (CascadingHelper.isSetForeground(style)) {
			this.foregroundColor = style.getForegroundColor();
		}
		if (CascadingHelper.isSetBackground(style)) {
			this.background = style.getBackground();
		}
		if (CascadingHelper.isSetFontProfile(style)) {
			this.fontProfile = style.getFontProfile();
		}
		if (CascadingHelper.isSetTextAlign(style)) {
			this.textAlign = style.getTextAlign();
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

	public CascadingStyle copy() {
		CascadingStyle simpleStyle = new CascadingStyle();
		simpleStyle.foregroundColor = this.foregroundColor;
		simpleStyle.background = this.background;
		simpleStyle.fontProfile = this.fontProfile;
		simpleStyle.textAlign = this.textAlign;
		simpleStyle.dimension = this.dimension;
		simpleStyle.padding = this.padding;
		simpleStyle.border = this.border;
		simpleStyle.margin = this.margin;
		return simpleStyle;
	}

}
