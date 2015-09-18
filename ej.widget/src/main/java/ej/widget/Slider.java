/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import ej.microui.display.GraphicsContext;
import ej.microui.display.shape.AntiAliasedShapes;
import ej.microui.event.generator.Pointer;
import ej.style.Style;
import ej.style.util.Size;
import ej.widget.util.ColorsHelper;

public class Slider extends AbstractProgressBar {

	private static final int BAR_HEIGHT = 6;
	private static final int CURSOR_SIZE = 26;

	public Slider(BoundedRangeModel model) {
		super(model);
	}

	public Slider(int min, int max, int initialValue) {
		this(new DefaultBoundedRangeModel(min, max, initialValue));
	}

	// TODO: not ok with complex padding, border or margin.
	// TODO: take account the internal padding for the cursor
	protected float getPositionFactor(int pointerX) {
		Style style = getStyle();
		Size size = new Size();
		style.getMargin().box(size);
		style.getPadding().box(size);
		style.getBorder().box(size);
		int width = getWidth();

		int halfNoContentWidth = size.getWidth() / 2;
		if (pointerX < halfNoContentWidth) {
			return 0;
		} else if (pointerX > width - halfNoContentWidth) {
			return 1;
		} else {
			return (pointerX - halfNoContentWidth) / (float) (width - size.getWidth());
		}
	}

	@Override
	public boolean onPointerDragged(Pointer pointer, int pointerX, int pointerY, int event) {
		float positionFactor = getPositionFactor(getRelativeX(pointerX));
		int minimum = getMinimum();
		int newValue = (int) (minimum + (getMaximum() - minimum) * positionFactor);
		setValue(newValue);
		return true;
	}

	@Override
	public boolean onPointerReleased(Pointer pointer, int pointerX, int pointerY, int event) {
		return onPointerDragged(pointer, pointerX, pointerY, event);
	}

	@Override
	protected void renderContent(GraphicsContext g, Style style, Size remainingSize) {
		int remainingWidth = remainingSize.getWidth();
		int remainingHeight = remainingSize.getHeight();
		int foregroundColor = style.getForegroundColor();
		int fillColor = ColorsHelper.lightenColor(foregroundColor, 10);

		// Fills the range of values.
		int x = CURSOR_SIZE / 2;
		int y = (remainingHeight - BAR_HEIGHT) / 2;
		int barWidth = remainingWidth - CURSOR_SIZE;
		g.setColor(foregroundColor);
		g.fillRect(x, y, barWidth, BAR_HEIGHT);

		// Fills the complete part from left to right.
		int fillWidth = (int) (barWidth * getPercentComplete());
		g.setColor(fillColor);
		g.fillRect(x, y, fillWidth, BAR_HEIGHT);

		// Draws the cursor.
		y = remainingHeight / 2;
		AntiAliasedShapes antiAliasedShapes = AntiAliasedShapes.Singleton;
		antiAliasedShapes.setThickness(CURSOR_SIZE);
		antiAliasedShapes.drawPoint(g, x + fillWidth, y);
	}

	@Override
	protected Size getContentSize(Style style) {
		Size contentSize = new Size();
		contentSize.setHeight(Math.max(BAR_HEIGHT, CURSOR_SIZE));
		contentSize.setWidth(CURSOR_SIZE);
		return contentSize;
	}
}
