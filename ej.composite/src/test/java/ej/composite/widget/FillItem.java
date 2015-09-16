/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.widget;

import ej.mwt.MWT;

/**
 *
 */
public class FillItem extends Item {

	private final boolean fillWidth;

	public FillItem(boolean fillWidth, int expectedWidth, int expectedHeight) {
		super(expectedWidth, expectedHeight);
		this.fillWidth = fillWidth;
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		if (this.fillWidth) {
			if (widthHint == MWT.NONE) {
				super.validate(widthHint, heightHint);
			} else {
				setPreferredSize(widthHint, getExpectedHeight());
			}
		} else {
			if (heightHint == MWT.NONE) {
				super.validate(widthHint, heightHint);
			} else {
				setPreferredSize(getExpectedWidth(), heightHint);
			}
		}
	}

}
