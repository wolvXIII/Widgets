/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.cascading;

import com.is2t.widgets.Dimension;
import com.is2t.widgets.Style;
import com.is2t.widgets.background.Background;
import com.is2t.widgets.boxmodel.Border;
import com.is2t.widgets.boxmodel.Boxing;
import com.is2t.widgets.font.FontProfile;

/*package*/class CascadingStyle implements Style {

	private int foregroundColor;
	private Background background;
	private FontProfile fontProfile;
	private int textAlign;
	private Dimension dimension;
	private Boxing padding;
	private Border border;
	private Boxing margin;

	public CascadingStyle() {
		// set default values
		this.foregroundColor = -1;
		this.textAlign = -1;
		// others are null: VM DONE
	}

	/**
	 * Fills all missing attributes of this style with those in the given style.
	 */
	public void merge(Style style) {
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

	@Override
	public int getForegroundColor() {
		return this.foregroundColor;
	}

	@Override
	public Background getBackground() {
		return this.background;
	}

	@Override
	public FontProfile getFontProfile() {
		return this.fontProfile;
	}

	@Override
	public int getTextAlign() {
		return this.textAlign;
	}

	@Override
	public Dimension getDimension() {
		return this.dimension;
	}

	@Override
	public Boxing getPadding() {
		return this.padding;
	}

	@Override
	public Border getBorder() {
		return this.border;
	}

	@Override
	public Boxing getMargin() {
		return this.margin;
	}

	/**
	 * Sets the foreground color.
	 *
	 * @param foregroundColor
	 *            the foreground color to set.
	 */
	public void setForegroundColor(int foregroundColor) {
		this.foregroundColor = foregroundColor;
	}

	/**
	 * Sets the background.
	 *
	 * @param background
	 *            the background to set.
	 */
	public void setBackground(Background background) {
		this.background = background;
	}

	/**
	 * Sets the font profile.
	 *
	 * @param fontProfile
	 *            the font profile to set.
	 */
	public void setFontProfile(FontProfile fontProfile) {
		this.fontProfile = fontProfile;
	}

	/**
	 * Sets the text alignment.
	 *
	 * @param textAlign
	 *            the text alignment to set.
	 */
	public void setTextAlign(int textAlign) {
		this.textAlign = textAlign;
	}

	/**
	 * Sets the dimension.
	 *
	 * @param dimension
	 *            the dimension to set.
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	/**
	 * Sets the padding.
	 *
	 * @param padding
	 *            the padding to set.
	 */
	public void setPadding(Boxing padding) {
		this.padding = padding;
	}

	/**
	 * Sets the border.
	 *
	 * @param border
	 *            the border to set.
	 */
	public void setBorder(Border border) {
		this.border = border;
	}

	/**
	 * Sets the margin.
	 *
	 * @param margin
	 *            the margin to set.
	 */
	public void setMargin(Boxing margin) {
		this.margin = margin;
	}

}
