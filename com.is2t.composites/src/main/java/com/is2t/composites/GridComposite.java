/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.composites;

import ej.mwt.Composite;
import ej.mwt.Widget;

/**
 *
 */
public class GridComposite extends Composite {

	private boolean horizontal;
	private int count;

	/**
	 * Sets the composite orientation: horizontal or vertical.
	 *
	 * @param horizontal
	 *            <code>true</code> to set the composite horizontal, <code>false</code> to set the composite vertical.
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * Sets the number of widget to set on a line or a column (for horizontal or vertical orientations respectively).
	 *
	 * @param count
	 *            the number of widgets to set.
	 */
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		if (!isVisible()) {
			// optim: do not validate its hierarchy
			setPreferredSize(0, 0);
			return;
		}

		Widget[] contents = getWidgets();
		int length = contents.length;
		if (length == 0) {
			// nothing to do
			return;
		}

	}

}
