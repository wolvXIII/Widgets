/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;


import ej.microui.display.GraphicsContext;
import ej.microui.display.shape.AntiAliasedShapes;
import ej.mwt.MWT;
import ej.style.Style;
import ej.style.util.Size;
import ej.widget.util.ColorsHelper;

/**
 * 
 */
public class ProgressBar extends AbstractProgressBar {

	private static final int BAR_SIZE = 24;

	private BoundedRangeModel model;
	private boolean horizontal;

	public ProgressBar(BoundedRangeModel model) {
		super(model);
	}

	public ProgressBar(int min, int max, int initialValue) {
		this(new DefaultBoundedRangeModel(min, max, initialValue));
	}

	@Override
	protected void renderContent(GraphicsContext g, Style style, Size remainingSize) {
		int remainingWidth = remainingSize.getWidth();
		int remainingHeight = remainingSize.getHeight();
		int foregroundColor = style.getForegroundColor();
		int fillColor = ColorsHelper.lightenColor(foregroundColor, 10);
		g.setColor(foregroundColor);

		AntiAliasedShapes antiAliasedShapes = AntiAliasedShapes.Singleton;
		antiAliasedShapes.setThickness(BAR_SIZE);

		if (getOrientation() == MWT.HORIZONTAL) {
			// Fills the range of values.
			int x1 = BAR_SIZE / 2;
			int y = remainingHeight / 2;
			int x2 = remainingWidth - x1 - 1;
			antiAliasedShapes.drawLine(g, x1, y, x2, y);

			// Fills the complete part from left to right.
			g.setColor(fillColor);
			x2 = (int) ((x2 - x1) * getPercentComplete() + x1);
			antiAliasedShapes.drawLine(g, x1, y, x2, y);
		} else {
			// Fills the range of values.
			int x = remainingWidth / 2;
			int y1 = BAR_SIZE / 2;
			int y2 = remainingHeight - y1 - 1;
			antiAliasedShapes.drawLine(g, x, y1, x, y2);

			// Fills the complete part from bottom to top.
			g.setColor(fillColor);
			y1 = (int) ((y1 - y2) * getPercentComplete() + y2);
			antiAliasedShapes.drawLine(g, x, y1, x, y2);
		}
	}

	@Override
	protected Size getContentSize(Style style) {
		Size contentSize = new Size();

		if (getOrientation() == MWT.HORIZONTAL) {
			contentSize.setSize(0, BAR_SIZE);
		} else {
			contentSize.setSize(BAR_SIZE, 0);
		}

		return contentSize;
	}

	/**
	 * Gets the orientation property.
	 * 
	 * @return The value of the orientation property, one of the following constants defined in MWT: HORIZONTAL,
	 *         VERTICAL.
	 */
	public int getOrientation() {
		return this.horizontal ? MWT.HORIZONTAL : MWT.VERTICAL;
	}

	/**
	 * Sets the orientation property.
	 * 
	 * @param orientation
	 *            one of the following constants defined in MWT: HORIZONTAL, VERTICAL.
	 * 
	 * @throws IllegalArgumentException
	 *             if the orientation is not one of the constants defined in MWT: HORIZONTAL, VERTICAL.
	 */
	public void setOrientation(int orientation) {
		if (orientation != MWT.HORIZONTAL && orientation != MWT.VERTICAL) {
			throw new IllegalArgumentException("Unknown orientation"); //$NON-NLS-1$
		}
		this.horizontal = orientation == MWT.HORIZONTAL;
		repaint();
	}
}
