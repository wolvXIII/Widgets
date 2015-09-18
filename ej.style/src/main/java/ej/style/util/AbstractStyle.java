/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.util;

import ej.style.Style;
import ej.style.background.Background;
import ej.style.dimension.Dimension;
import ej.style.font.FontProfile;
import ej.style.outline.Border;
import ej.style.outline.Outline;
import ej.style.text.TextManager;

/**
 * Convenient abstract implementation of style.
 */
public abstract class AbstractStyle implements Style {

	/**
	 * Foreground color.
	 */
	protected int foregroundColor;
	/**
	 * Background.
	 */
	protected Background background;
	/**
	 * Font profile.
	 */
	protected FontProfile fontProfile;
	/**
	 * Text manager.
	 */
	protected TextManager textManager;
	/**
	 * Dimension.
	 */
	protected Dimension dimension;
	/**
	 * Padding.
	 */
	protected Outline padding;
	/**
	 * Border.
	 */
	protected Border border;
	/**
	 * Margin.
	 */
	protected Outline margin;

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
	public TextManager getTextManager() {
		return this.textManager;
	}

	@Override
	public Dimension getDimension() {
		return this.dimension;
	}

	@Override
	public Outline getPadding() {
		return this.padding;
	}

	@Override
	public Border getBorder() {
		return this.border;
	}

	@Override
	public Outline getMargin() {
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
	 * Sets the text manager.
	 *
	 * @param textManager
	 *            the text manager to set.
	 */
	public void setTextManager(TextManager textManager) {
		this.textManager = textManager;
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
	public void setPadding(Outline padding) {
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
	public void setMargin(Outline margin) {
		this.margin = margin;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Style) {
			Style other = (Style) obj;
			return this.foregroundColor == other.getForegroundColor() && this.background == other.getBackground()
					&& this.fontProfile == other.getFontProfile() && this.textManager == other.getTextManager()
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
		sb.append("Foreground: " + Integer.toHexString(getForegroundColor())).append('\n'); //$NON-NLS-1$
		sb.append("Background: " + getBackground().toString()).append('\n'); //$NON-NLS-1$
		sb.append("Font profile: " + getFontProfile().toString()).append('\n'); //$NON-NLS-1$
		sb.append("Text manager: " + getTextManager().toString()).append('\n'); //$NON-NLS-1$
		sb.append("Dimension: " + getDimension().toString()).append('\n'); //$NON-NLS-1$
		sb.append("Padding: " + getPadding().toString()).append('\n'); //$NON-NLS-1$
		sb.append("Border: " + getBorder().toString()).append('\n'); //$NON-NLS-1$
		sb.append("Margin: " + getMargin().toString()).append('\n'); //$NON-NLS-1$
		return sb.toString();
	}

}