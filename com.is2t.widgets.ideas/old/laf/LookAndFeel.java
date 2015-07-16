/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.laf;

public class LookAndFeel {

	private ColorProfile colorProfile;

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

}
