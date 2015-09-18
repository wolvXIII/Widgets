/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.dimension;

import ej.mwt.MWT;
import ej.style.util.Size;

/**
 * Dimension with constraint relative to the parent.
 */
public class RelativeDimension implements Dimension {

	private float widthPercent;
	private float heightPercent;

	/**
	 * Creates a relative dimension.
	 */
	public RelativeDimension() {
		this.widthPercent = -1;
		this.heightPercent = -1;
	}

	/**
	 * Sets the width proportion.
	 *
	 * @param widthPercent
	 *            the width proportion to set.
	 */
	public void setWidthProportion(float widthPercent) {
		this.widthPercent = widthPercent;
	}

	/**
	 * Sets the height proportion.
	 *
	 * @param heightPercent
	 *            the height proportion to set.
	 */
	public void setHeightProportion(float heightPercent) {
		this.heightPercent = heightPercent;
	}

	/**
	 * Sets the width and height proportions.
	 * 
	 * @param widthPercent
	 *            the width proportion to set.
	 * @param heightPercent
	 *            the height proportion to set.
	 */
	public void setSizeProportions(float widthPercent, float heightPercent) {
		this.widthPercent = widthPercent;
		this.heightPercent = heightPercent;
	}

	@Override
	public void apply(Size currentSize, int widthHint, int heightHint) {
		int width;
		if (this.widthPercent != -1 && widthHint != MWT.NONE) {
			width = (int) (widthHint * this.widthPercent);
		} else {
			// do not modify given width
			width = currentSize.getWidth();
		}
		int height;
		if (this.heightPercent != -1 && heightHint != MWT.NONE) {
			height = (int) (heightHint * this.heightPercent);
		} else {
			// do not modify given height
			height = currentSize.getHeight();
		}

		currentSize.setSize(width, height);
	}

}
