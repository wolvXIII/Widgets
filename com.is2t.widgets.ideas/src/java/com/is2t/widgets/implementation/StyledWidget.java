/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.implementation;

import com.is2t.widgets.background.Background;
import com.is2t.widgets.decorator.Decorator;
import com.is2t.widgets.laf.ColorProfile;

import ej.mwt.Widget;

public class StyledWidget extends Widget {

	private ColorProfile colorProfile;
	private int alignment;
	private Decorator decorator;
	private Background background;

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
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

	/**
	 * Gets the alignment.
	 *
	 * @return the alignment.
	 */
	public int getAlignment() {
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
	 * Gets the background.
	 * 
	 * @return the background.
	 */
	public Background getBackground() {
		return this.background;
	}

}
