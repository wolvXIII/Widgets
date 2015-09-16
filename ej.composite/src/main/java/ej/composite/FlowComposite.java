/*
 * Java
 *
 * Copyright 2009-2015 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.composite;

import java.util.Iterator;

import ej.microui.display.GraphicsContext;
import ej.mwt.Composite;
import ej.mwt.MWT;
import ej.mwt.Widget;

/**
 * A flow composite is a {@link Composite} that lays out its children in rows or columns.
 */
public class FlowComposite extends Composite {

	/**
	 * Lay out direction.
	 */
	protected boolean horizontal;

	/**
	 * Creates a new horizontal flow composite.
	 */
	public FlowComposite() {
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

	/**
	 * Lays out children in rows if horizontal, or in columns if vertical.
	 * <p>
	 * If the width (resp. height) of the row (resp. column) is too small for all the components, it creates several
	 * lines (resp. columns). The size of each child is set to the child's preferred size.
	 */
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
			return;
		}

		boolean computeWidth = widthHint == MWT.NONE;
		boolean computeHeight = heightHint == MWT.NONE;

		int widgetWidthHint = computeWidth ? MWT.NONE : widthHint;
		int widgetHeightHint = computeHeight ? MWT.NONE : heightHint;

		int currentX = 0;
		int currentY = 0;
		int currentLineHeight = 0;
		int currentColumnWidth = 0;

		System.out.println("FlowComposite.validate()");
		Iterator<Widget> iterator = iterator();
		while (iterator.hasNext()) {
			Widget widget = iterator.next();

			System.out.println("\t* widget: " + widget);
			System.out.println("\tsize hint: " + widgetWidthHint + " " + widgetHeightHint);
			widget.validate(widgetWidthHint, widgetHeightHint);

			int widgetPreferredWidth = widget.getPreferredWidth();
			int widgetPreferredHeight = widget.getPreferredHeight();
			System.out.println("\tpreferred size: " + widgetPreferredWidth + " " + widgetPreferredHeight);

			if(this.horizontal) {
				if (!computeWidth && currentX + widgetPreferredWidth > widthHint) {
					System.out.println("\tnew line");
					// create a new line
					currentX = 0;
					currentY += currentLineHeight;
					currentLineHeight = 0;
				}
				currentX += widgetPreferredWidth;
				currentLineHeight = Math.max(currentLineHeight, widgetPreferredHeight);
			} else {
				if (!computeHeight && currentY + widgetPreferredHeight > heightHint) {
					System.out.println("\tnew column");
					// create a new column
					currentY = 0;
					currentX += currentColumnWidth;
					currentColumnWidth = 0;
				}
				currentY += widgetPreferredHeight;
				currentColumnWidth = Math.max(currentColumnWidth, widgetPreferredWidth);
			}
		}

		if (computeWidth) {
			widthHint = currentX + currentColumnWidth;
		}
		if (computeHeight) {
			heightHint = currentY + currentLineHeight;
		}

		setPreferredSize(widthHint, heightHint);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);

		int currentX = 0;
		int currentY = 0;
		int currentLineHeight = 0;
		int currentColumnWidth = 0;

		System.out.println("FlowComposite.setBounds()");
		Iterator<Widget> iterator = iterator();
		while (iterator.hasNext()) {
			Widget widget = iterator.next();

			int widgetPreferredWidth = widget.getPreferredWidth();
			int widgetPreferredHeight = widget.getPreferredHeight();

			System.out.println("\t* widget: " + widget);
			System.out.println(
					"\tat " + currentX + " " + currentY + " " + widgetPreferredWidth + " " + widgetPreferredHeight);

			if (this.horizontal) {
				if (currentX + widgetPreferredWidth > width) {
					// create a new line
					currentX = 0;
					currentY += currentLineHeight;
					currentLineHeight = 0;
				}
				widget.setBounds(currentX, currentY, widgetPreferredWidth, widgetPreferredHeight);
				currentX += widgetPreferredWidth;
				currentLineHeight = Math.max(currentLineHeight, widgetPreferredHeight);
			} else {
				if (currentY + widgetPreferredHeight > height) {
					// create a new column
					currentY = 0;
					currentX += currentColumnWidth;
					currentColumnWidth = 0;
				}
				widget.setBounds(currentX, currentY, widgetPreferredWidth, widgetPreferredHeight);
				currentY += widgetPreferredHeight;
				currentColumnWidth = Math.max(currentColumnWidth, widgetPreferredWidth);
			}
		}
	}

	@Override
	public void render(GraphicsContext g) {
		// TODO
	}

}
