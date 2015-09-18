/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite;


import java.util.Iterator;

import ej.mwt.MWT;
import ej.mwt.Widget;
import ej.widget.StyledComposite;

/**
 * Lays out its children in a grid.
 * <p>
 * All columns have the same width and all rows have the same height.
 */
public class GridComposite extends StyledComposite {

	private boolean horizontal;
	private int count;

	/**
	 * Creates a new horizontal grid composite.
	 */
	public GridComposite() {
		this.horizontal = true;
	}

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
	public void add(Widget widget) throws NullPointerException, IllegalArgumentException {
		super.add(widget);
	}

	@Override
	public void remove(Widget widget) throws NullPointerException {
		super.remove(widget);
	}

	@Override
	public void removeAllWidgets() {
		super.removeAllWidgets();
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		if (!isVisible()) {
			// optim: do not validate its hierarchy
			setPreferredSize(0, 0);
			return;
		}

		int length = getWidgetsCount();
		if (length == 0) {
			// nothing to do
			setPreferredSize(widthHint, heightHint);
			return;
		}

		// compute widgets expected size
		boolean horizontalLocal = this.horizontal;
		int countLocal = this.count;
		int otherCount = (int) Math.ceil((float) length / countLocal);
		int columns;
		int rows;
		if (horizontalLocal) {
			columns = countLocal;
			rows = otherCount;
		} else {
			rows = countLocal;
			columns = otherCount;
		}

		boolean computeWidth = widthHint == MWT.NONE;
		boolean computeHeight = heightHint == MWT.NONE;

		int cellsWidth = computeWidth ? MWT.NONE : widthHint / columns;
		int cellsHeight = computeHeight ? MWT.NONE : heightHint / rows;
		int maxCellWidth = 0;
		int maxCellHeight = 0;

		Iterator<Widget> iterator = iterator();
		while (iterator.hasNext()) {
			Widget widget = iterator.next();
			widget.validate(cellsWidth, cellsHeight);

			// compute biggest size
			maxCellWidth = Math.max(maxCellWidth, widget.getPreferredWidth());
			maxCellHeight = Math.max(maxCellHeight, widget.getPreferredHeight());
		}

		// compute composite preferred size if necessary
		if (computeWidth) {
			widthHint = maxCellWidth * columns;
		}
		if (computeHeight) {
			heightHint = maxCellHeight * rows;
		}

		// set composite preferred size
		setPreferredSize(widthHint, heightHint);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);

		// TODO try to merge with validate
		int length = getWidgetsCount();
		if (length == 0) {
			return;
		}

		// compute widgets bounds
		boolean horizontalLocal = this.horizontal;
		int countLocal = this.count;
		int otherCount = (int) Math.ceil((float) length / countLocal);
		int columns;
		int rows;
		if (horizontalLocal) {
			columns = countLocal;
			rows = otherCount;
		} else {
			rows = countLocal;
			columns = otherCount;
		}
		int cellWidth = width / columns;
		int cellHeight = height / rows;

		// set widgets bounds
		int offset = 0;
		int currentX = 0;
		int currentY = 0;
		Iterator<Widget> iterator = iterator();
		while (iterator.hasNext()) {
			Widget widget = iterator.next();
			widget.setBounds(currentX, currentY, cellWidth, cellHeight);

			if (++offset == countLocal) {
				// end of line / column
				offset = 0;
				if (horizontalLocal) {
					currentX = 0;
					currentY += cellHeight;
				} else {
					currentY = 0;
					currentX += cellWidth;
				}
			} else {
				if (horizontalLocal) {
					currentX += cellWidth;
				} else {
					currentY += cellHeight;
				}
			}
		}
	}

}
