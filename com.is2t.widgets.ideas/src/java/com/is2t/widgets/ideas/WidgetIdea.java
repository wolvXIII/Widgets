/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.ideas;

import ej.mwt.Widget;

public class WidgetIdea extends Widget {

	private ColorProfile colorProfile;
	private Alignment alignment;
	private Decorator decorator;

	/**
	 * Sets the color profile.
	 *
	 * @param colorProfile
	 *            the color profile to set.
	 */
	public void setColorProfile(ColorProfile colorProfile) {
		this.colorProfile = colorProfile;
	}

	/**
	 * Gets the color profile.
	 *
	 * @return the color profile.
	 */
	public ColorProfile getColorProfile() {
		return this.colorProfile;
	}

	/**
	 * Sets the alignment.
	 *
	 * @param alignment
	 *            the alignment to set.
	 */
	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	/**
	 * Gets the alignment.
	 *
	 * @return the alignment.
	 */
	public Alignment getAlignment() {
		return this.alignment;
	}

	/**
	 * Sets the decorator.
	 * 
	 * @param decorator
	 *            the decorator to set.
	 */
	public void setDecorator(Decorator decorator) {
		this.decorator = decorator;
	}

	/**
	 * Gets the decorator.
	 * 
	 * @return the decorator.
	 */
	public Decorator getDecorator() {
		return this.decorator;
	}

}
