/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import ej.microui.display.GraphicsContext;
import ej.microui.display.shape.AntiAliasedShapes;
import ej.style.Style;
import ej.style.util.Rectangle;
import ej.style.util.Size;

public class Radio extends ToggleView {

	private static final int DIAMETER = 28;
	private static final int THICKNESS = 2;
	private static final int FADE = 1;

	@Override
	protected void renderContent(GraphicsContext g, Style style, Rectangle remainingSize) {
		int remainingWidth = remainingSize.getWidth();
		int remainingHeight = remainingSize.getHeight();
		AntiAliasedShapes antiAliasedShapes = AntiAliasedShapes.Singleton;
		antiAliasedShapes.setFade(FADE);
		antiAliasedShapes.setThickness(THICKNESS);
		int foregroundColor = style.getForegroundColor();
		g.setColor(foregroundColor);

		int x = (remainingWidth - DIAMETER) / 2;
		int y = (remainingHeight - DIAMETER) / 2;
		antiAliasedShapes.drawCircle(g, x, y, DIAMETER);

		if (this.checked) {
			int checkedDiameter = DIAMETER / 3 + (1 - (DIAMETER & 1));
			int checkedX = (remainingWidth - checkedDiameter) / 2;
			int checkedY = (remainingHeight - checkedDiameter) / 2;
			g.fillCircle(checkedX, checkedY, checkedDiameter);
			antiAliasedShapes.setThickness(2);
			antiAliasedShapes.drawCircle(g, checkedX, checkedY, checkedDiameter);
		}
	}

	@Override
	protected Size getContentSize(Style style) {
		Size contentSize = new Size();
		int realDiameter = DIAMETER + THICKNESS + 2 * FADE + 1;
		contentSize.setSize(realDiameter, realDiameter);
		return contentSize;
	}
}
