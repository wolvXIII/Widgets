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
import ej.widget.util.ColorsHelper;

public class Switch extends ToggleView {

	private static final int WIDTH = 30;
	private static final int THICKNESS = 36;
	private static final int FADE = 1;

	@Override
	protected void renderContent(GraphicsContext g, Style style, Rectangle remainingSize) {
		AntiAliasedShapes antiAliasedShapes = AntiAliasedShapes.Singleton;
		antiAliasedShapes.setFade(FADE);
		antiAliasedShapes.setThickness(THICKNESS);
		int foregroundColor = style.getForegroundColor();
		int checkColor = ColorsHelper.lightenColor(foregroundColor, 10);

		g.setColor(foregroundColor);
		int x1 = (remainingSize.getWidth() - WIDTH) / 2;
		int y = remainingSize.getHeight() / 2;
		int x2 = x1 + WIDTH;
		antiAliasedShapes.drawLine(g, x1, y, x2, y);

		antiAliasedShapes.setThickness(THICKNESS - 4);
		g.setColor(checkColor);
		int x = this.checked ? x2 : x1;
		antiAliasedShapes.drawPoint(g, x, y);
	}

	@Override
	protected Size getContentSize(Style style) {
		Size contentSize = new Size();
		int height = THICKNESS + 2 * FADE;
		contentSize.setSize(WIDTH + height, height);
		return contentSize;
	}
}
