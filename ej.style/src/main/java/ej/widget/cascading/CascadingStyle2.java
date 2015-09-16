/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.cascading;

import ej.widget.Style;
import ej.widget.background.Background;
import ej.widget.boxmodel.Border;
import ej.widget.boxmodel.Box;
import ej.widget.dimension.Dimension;
import ej.widget.font.FontProfile;

/*package*/class CascadingStyle2 implements Style {

	private final static int FOREGROUND_COLOR_SHIFT = 0;
	private final static int BACKGROUND_SHIFT = 1;
	private final static int FONT_PROFILE_SHIFT = 2;
	private final static int TEXT_ALIGN_SHIFT = 3;
	private final static int DIMENSION_SHIFT = 4;
	private final static int PADDING_SHIFT = 5;
	private final static int BORDER_SHIFT = 6;
	private final static int MARGIN_SHIFT = 7;
	private byte map; // TODO identify fields that are set

	private int foregroundColor;
	private Background background;
	private FontProfile fontProfile;
	private int textAlign;
	private Dimension dimension;
	private Box padding;
	private Border border;
	private Box margin;

	public CascadingStyle2() {
		// set default values
		this.foregroundColor = -1;
		this.textAlign = -1;
		// others are null: VM DONE
	}

	/**
	 * Fills all missing attributes of this style with those in the given style.
	 */
	public boolean merge(Style style) {
		if (notSet(FOREGROUND_COLOR_SHIFT)) {
			setForegroundColor(style.getForegroundColor());
		}
		if (notSet(BACKGROUND_SHIFT)) {
			setBackground(style.getBackground());
		}
		if (notSet(FONT_PROFILE_SHIFT)) {
			setFontProfile(style.getFontProfile());
		}
		if (notSet(TEXT_ALIGN_SHIFT)) {
			setTextAlign(style.getTextAlign());
		}
		if (notSet(DIMENSION_SHIFT)) {
			setDimension(style.getDimension());
		}
		if (notSet(PADDING_SHIFT)) {
			setPadding(style.getPadding());
		}
		if (notSet(BORDER_SHIFT)) {
			setBorder(style.getBorder());
		}
		if (notSet(MARGIN_SHIFT)) {
			setMargin(style.getMargin());
		}
		return isComplete();
	}

	/**
	 * Fills all defined attributes of the given style in this style.
	 */
	public void override(Style style) {
		if (CascadingHelper.isSetForeground(style)) {
			setForegroundColor(style.getForegroundColor());
		}
		if (CascadingHelper.isSetBackground(style)) {
			setBackground(style.getBackground());
		}
		if (CascadingHelper.isSetFontProfile(style)) {
			setFontProfile(style.getFontProfile());
		}
		if (CascadingHelper.isSetTextAlign(style)) {
			setTextAlign(style.getTextAlign());
		}
		if (CascadingHelper.isSetDimension(style)) {
			setDimension(style.getDimension());
		}
		if (CascadingHelper.isSetPadding(style)) {
			setPadding(style.getPadding());
		}
		if (CascadingHelper.isSetBorder(style)) {
			setBorder(style.getBorder());
		}
		if (CascadingHelper.isSetMargin(style)) {
			setMargin(style.getMargin());
		}
	}

	public CascadingStyle copy() {
		CascadingStyle simpleStyle = new CascadingStyle();
		simpleStyle.setForegroundColor(this.foregroundColor);
		simpleStyle.setBackground(this.background);
		simpleStyle.setFontProfile(this.fontProfile);
		simpleStyle.setTextAlign(this.textAlign);
		simpleStyle.setDimension(this.dimension);
		simpleStyle.setPadding(this.padding);
		simpleStyle.setBorder(this.border);
		simpleStyle.setMargin(this.margin);
		return simpleStyle;
	}

	private void mark(int field) {
		this.map |= 1 << field;
	}

	private boolean isSet(int field) {
		return ((this.map >>> field) & 0x1) != 0;
	}

	private boolean notSet(int field) {
		return ((this.map >>> field) & 0x1) == 0;
	}

	public boolean isComplete() {
		return this.map == 0xff;
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
	public Box getPadding() {
		return this.padding;
	}

	@Override
	public Border getBorder() {
		return this.border;
	}

	@Override
	public Box getMargin() {
		return this.margin;
	}

	/**
	 * Sets the foreground color.
	 *
	 * @param foregroundColor
	 *            the foreground color to set.
	 */
	public void setForegroundColor(int foregroundColor) {
		if (foregroundColor != -1) {
			mark(FOREGROUND_COLOR_SHIFT);
		}
		this.foregroundColor = foregroundColor;
	}

	/**
	 * Sets the background.
	 *
	 * @param background
	 *            the background to set.
	 */
	public void setBackground(Background background) {
		if (background != null) {
			mark(BACKGROUND_SHIFT);
		}
		this.background = background;
	}

	/**
	 * Sets the font profile.
	 *
	 * @param fontProfile
	 *            the font profile to set.
	 */
	public void setFontProfile(FontProfile fontProfile) {
		if (fontProfile != null) {
			mark(FONT_PROFILE_SHIFT);
		}
		this.fontProfile = fontProfile;
	}

	/**
	 * Sets the text alignment.
	 *
	 * @param textAlign
	 *            the text alignment to set.
	 */
	public void setTextAlign(int textAlign) {
		if (textAlign != -1) {
			mark(TEXT_ALIGN_SHIFT);
		}
		this.textAlign = textAlign;
	}

	/**
	 * Sets the dimension.
	 *
	 * @param dimension
	 *            the dimension to set.
	 */
	public void setDimension(Dimension dimension) {
		if (dimension != null) {
			mark(DIMENSION_SHIFT);
		}
		this.dimension = dimension;
	}

	/**
	 * Sets the padding.
	 *
	 * @param padding
	 *            the padding to set.
	 */
	public void setPadding(Box padding) {
		if (padding != null) {
			mark(PADDING_SHIFT);
		}
		this.padding = padding;
	}

	/**
	 * Sets the border.
	 *
	 * @param border
	 *            the border to set.
	 */
	public void setBorder(Border border) {
		if (border != null) {
			mark(BORDER_SHIFT);
		}
		this.border = border;
	}

	/**
	 * Sets the margin.
	 *
	 * @param margin
	 *            the margin to set.
	 */
	public void setMargin(Box margin) {
		if (margin != null) {
			mark(MARGIN_SHIFT);
		}
		this.margin = margin;
	}

}
