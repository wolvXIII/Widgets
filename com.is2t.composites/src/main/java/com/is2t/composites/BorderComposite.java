/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.composites;

import ej.mwt.Composite;
import ej.mwt.MWT;
import ej.mwt.Widget;

/**
 * Lays out its children to fit in 3 regions:
 * <ul>
 * <li>horizontal mode: west, east and center (respectively {@link MWT#WEST}, {@link MWT#EAST}, {@link MWT#CENTER},</li>
 * <li>vertical mode: north, south and center (respectively {@link MWT#NORTH}, {@link MWT#SOUTH}, {@link MWT#CENTER},</li>
 * </ul>
 * Beware that a widget added on west in vertical mode will be on north (the same goes horizontally and for east and
 * south regions).
 */
public class BorderComposite extends Composite {

	private boolean horizontal;
	private Widget first;
	private Widget center;
	private Widget last;

	/**
	 * Sets the composite orientation: horizontal or vertical.
	 *
	 * @param horizontal
	 *            <code>true</code> to set the composite horizontal, <code>false</code> to set the composite vertical.
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	@Override
	public void add(Widget widget) {
		if (this.center != null) {
			super.remove(widget);
		}
		this.center = widget;
		super.add(widget);
	}

	public void add(Widget widget, int at) {
		switch (at) {
		case MWT.WEST:
			// case MWT.LEFT:
		case MWT.NORTH:
			// case MWT.TOP:
			if (this.first != null) {
				remove(this.first);
			}
			this.first = widget;
			super.add(widget);
			break;
		case MWT.EAST:
			// case MWT.RIGHT:
		case MWT.SOUTH:
			// case MWT.BOTTOM:
			if (this.last != null) {
				remove(this.last);
			}
			this.last = widget;
			super.add(widget);
			break;
		case MWT.CENTER:
			add(widget);
		}
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		boolean computeWidth = widthHint == MWT.NONE;
		boolean computeHeight = heightHint == MWT.NONE;

		// compute widgets expected width
		int firstWidth;
		int centerWidth;
		int lastWidth;
		if (computeWidth) {
			firstWidth = MWT.NONE;
			centerWidth = MWT.NONE;
			lastWidth = MWT.NONE;
		} else {
			if (this.horizontal) {
				firstWidth = MWT.NONE;
				lastWidth = MWT.NONE;
				centerWidth = MWT.NONE; // reset after other layouts later
			} else {
				firstWidth = widthHint;
				centerWidth = widthHint;
				lastWidth = widthHint;
			}
		}
		// compute widgets expected height
		int firstHeight;
		int centerHeight;
		int lastHeight;
		if (computeHeight) {
			firstHeight = MWT.NONE;
			centerHeight = MWT.NONE;
			lastHeight = MWT.NONE;
		} else {
			if (this.horizontal) {
				firstHeight = heightHint;
				centerHeight = heightHint;
				lastHeight = heightHint;
			} else {
				firstHeight = MWT.NONE;
				lastHeight = MWT.NONE;
				centerHeight = MWT.NONE; // reset after other layouts later
			}
		}

		// validate widgets
		this.first.validate(firstWidth, firstHeight);
		this.last.validate(lastWidth, lastHeight);

		// get widgets preferred widgets
		int firstPreferredWidth = this.first.getPreferredWidth();
		int firstPreferredHeight = this.first.getPreferredHeight();
		int lastPreferredWidth = this.last.getPreferredWidth();
		int lastPreferredHeight = this.last.getPreferredHeight();

		// center take remaining width
		if (!computeWidth && this.horizontal) {
			centerWidth = widthHint - firstPreferredWidth - lastPreferredWidth;
		}
		if (!computeHeight && this.horizontal) {
			centerHeight = heightHint - firstPreferredHeight - lastPreferredHeight;
		}
		this.center.validate(centerWidth, centerHeight);
		int centerPreferredWidth = this.center.getPreferredWidth();
		int centerPreferredHeight = this.center.getPreferredHeight();

		// compute composite preferred size if necessary
		if (computeWidth) {
			if (this.horizontal) {
				widthHint = firstPreferredWidth + centerPreferredWidth + lastPreferredWidth;
			} else {
				widthHint = Math.max(Math.max(firstPreferredWidth, lastPreferredWidth), centerWidth);
			}
		}
		if (computeHeight) {
			if (this.horizontal) {
				heightHint = Math.max(Math.max(firstPreferredHeight, lastPreferredHeight), centerHeight);
			} else {
				heightHint = firstPreferredHeight + centerPreferredHeight + lastPreferredHeight;
			}
		}

		// set composite preferred size
		setPreferredSize(widthHint, heightHint);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		// compute widgets bounds
		int firstX = 0;
		int firstY = 0;
		int firstWidth;
		int firstHeight;
		int lastX;
		int lastY;
		int lastWidth;
		int lastHeight;
		int centerX;
		int centerY;
		int centerWidth;
		int centerHeight;
		if (this.horizontal) {
			firstWidth = this.first.getPreferredWidth();
			firstHeight = height;
			lastWidth = this.last.getPreferredWidth();
			lastHeight = height;
			lastX = width - lastWidth;
			lastY = 0;
			centerX = firstWidth;
			centerY = 0;
			centerWidth = Math.max(0, width - firstWidth - lastWidth);
			centerHeight = height;
		} else {
			firstWidth = width;
			firstHeight = this.first.getPreferredHeight();
			lastWidth = width;
			lastHeight = this.last.getPreferredHeight();
			lastX = 0;
			lastY = width - lastHeight;
			centerX = 0;
			centerY = firstHeight;
			centerWidth = width;
			centerHeight = Math.max(0, height - firstHeight - lastHeight);
		}

		// set widgets bounds
		this.first.setBounds(firstX, firstY, firstWidth, firstHeight);
		this.last.setBounds(lastX, lastY, lastWidth, lastHeight);
		this.center.setBounds(centerX, centerY, centerWidth, centerHeight);

		super.setBounds(x, y, width, height);
	}

}
