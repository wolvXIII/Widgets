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
import ej.style.util.Size;

/**
 * 
 */
public class Check extends StyledWidget implements OnStateChangeListener {

	private static final int SIZE = 36;

	private boolean checked;

	@Override
	protected void renderContent(GraphicsContext g, Style style, Size remainingSize) {
		int remainingWidth = remainingSize.getWidth();
		int remainingHeight = remainingSize.getHeight();

		AntiAliasedShapes antiAliasedShapes = AntiAliasedShapes.Singleton;
		antiAliasedShapes.setFade(0);
		int thickness = 4;
		antiAliasedShapes.setThickness(thickness);
		int foregroundColor = style.getForegroundColor();

		g.setColor(foregroundColor);
		int drawingSize = SIZE - thickness;

		int x1 = (remainingWidth - drawingSize) / 2;
		int y1 = (remainingHeight - drawingSize) / 2;
		int x2 = x1 + drawingSize - 1;
		int y2 = y1 + drawingSize - 1;

		antiAliasedShapes.drawLine(g, x1, y1, x2, y1);
		antiAliasedShapes.drawLine(g, x1, y2, x2, y2);
		antiAliasedShapes.drawLine(g, x1, y1, x1, y2);
		antiAliasedShapes.drawLine(g, x2, y1, x2, y2);

		// Draws check.
		// antiAliasedShapes.drawLine(g, x1, y1, x1, y2);
		// antiAliasedShapes.drawLine(g, x1, y1, x1, y2);
		// int[] xys = new int[6 * 2];
		// xys[0] = 2 + x1;
		// xys[1] = 14 + y1;
		// xys[2] = 11 + x1;
		// xys[3] = 23 + y1;
		// xys[4] = 26 + x1;
		// xys[5] = 8 + y1;
		// xys[6] = 23 + x1;
		// xys[7] = 5 + y1;
		// xys[8] = 11 + x1;
		// xys[9] = 17 + y1;
		// xys[10] = 5 + x1;
		// xys[11] = 11 + y1;
		//
		// g.fillPolygon(xys);

		// g.setColor(Colors.RED);
		// antiAliasedShapes.setThickness(thickness - 1);
		int x0 = x1 + 3;
		int y0 = y1 + 2;

		antiAliasedShapes.setFade(1);
		antiAliasedShapes.setThickness(thickness - 1);
		antiAliasedShapes.drawLine(g, x0 + 3, y0 + 12, x0 + 10, y0 + 20);
		antiAliasedShapes.drawLine(g, x0 + 10, y0 + 20, x0 + 22, y0 + 7);

		// // g.drawRect((remainingWidth - CONTENT_SIZE) / 2 - 1,
		// // (remainingHeight - CONTENT_SIZE) / 2 - 1, CONTENT_SIZE + 1,
		// // CONTENT_SIZE + 1);
		// g.fillRect(x1 + thickness / 2 + 1, y1 + thickness / 2 + 1,
		// CONTENT_SIZE
		// - thickness * 2 - 1, CONTENT_SIZE - thickness * 2 - 1);
		// System.out.println("Check.renderContent() "
		// + (CONTENT_SIZE - thickness * 2 - 1));
	}

	@Override
	protected Size getContentSize(Style style) {
		Size contentSize = new Size();
		contentSize.setSize(SIZE, SIZE);
		return contentSize;
	}

	@Override
	public void onStateChange(Object source, boolean before, boolean after) {
		this.checked = after;
		repaint();
	}

}
