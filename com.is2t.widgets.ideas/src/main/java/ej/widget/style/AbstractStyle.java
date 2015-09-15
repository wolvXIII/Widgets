/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.style;

import ej.widget.Style;
import ej.widget.background.Background;
import ej.widget.boxmodel.Border;
import ej.widget.boxmodel.Box;
import ej.widget.dimension.Dimension;
import ej.widget.font.FontProfile;

/**
 *
 */
public abstract class AbstractStyle implements Style {

	protected int foregroundColor;
	protected Background background;
	protected FontProfile fontProfile;
	protected int textAlign;
	protected Dimension dimension;
	protected Box padding;
	protected Border border;
	protected Box margin;

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
	public void setPadding(Box padding) {
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
	public void setMargin(Box margin) {
		this.margin = margin;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Style) {
			Style other = (Style) obj;
			return this.foregroundColor == other.getForegroundColor() && this.background == other.getBackground()
					&& this.fontProfile == other.getFontProfile() && this.textAlign == other.getTextAlign()
					&& this.dimension == other.getDimension() && this.padding == other.getPadding()
					&& this.border == other.getBorder() && this.margin == other.getMargin();
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// how to return a constant hashcode since the fields are not final?
		return 0;
		// return this.foregroundColor + this.background.hashCode() - this.fontProfile.hashCode() + this.textAlign
		// - this.dimension.hashCode() + this.padding.hashCode() - this.border.hashCode() + this.margin.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Foreground: " + Integer.toHexString(getForegroundColor())).append('\n');
		sb.append("Background: " + getBackground().toString()).append('\n');
		sb.append("Font profile: " + getFontProfile().toString()).append('\n');
		sb.append("Text align: " + Integer.toHexString(getTextAlign())).append('\n');
		sb.append("Dimension: " + getDimension().toString()).append('\n');
		sb.append("Padding: " + getPadding().toString()).append('\n');
		sb.append("Border: " + getBorder().toString()).append('\n');
		sb.append("Margin: " + getMargin().toString()).append('\n');
		return sb.toString();
	}

}