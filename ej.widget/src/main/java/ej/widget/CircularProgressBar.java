/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import ej.microui.display.GraphicsContext;
import ej.microui.display.shape.AntiAliasedShapes;
import ej.style.Size;
import ej.style.Style;
import ej.widget.util.ColorsHelper;
import ej.widget.util.Styles;

public class CircularProgressBar extends AbstractProgressBar {

	private static final int START_ANGLE = 90;
	private static final int THICKNESS = 18;
	private static final int FADE = 2;
	private static final int DIAMETER = 150;

	public CircularProgressBar(int min, int max, int initialValue) {
		super(min, max, initialValue);
	}

	public CircularProgressBar(BoundedRangeModel model) {
		super(model);
	}

	@Override
	protected void renderContent(GraphicsContext g, Style style, Size remainingSize) {
		int remainingWidth = remainingSize.getWidth();
		int remainingHeight = remainingSize.getHeight();
		float percentComplete = getPercentComplete();
		int foregroundColor = style.getForegroundColor();
		int fillColor = ColorsHelper.lightenColor(foregroundColor, 10);

		// Draws the percent complete label.
		g.setColor(foregroundColor);
		g.setFont(Styles.getFont(style));
		String percentText = (int) (percentComplete * 100) + " %"; //$NON-NLS-1$
		g.drawString(percentText, remainingWidth / 2, remainingHeight / 2, GraphicsContext.HCENTER
				| GraphicsContext.VCENTER);

		// Fills the complete part, from 90° clockwise
		AntiAliasedShapes antiAliasedShapes = AntiAliasedShapes.Singleton;
		antiAliasedShapes.setFade(FADE);
		antiAliasedShapes.setThickness(THICKNESS);
		int realDiameter = DIAMETER - THICKNESS - 2 * FADE;
		int x = (remainingWidth - realDiameter) / 2;
		int y = (remainingHeight - realDiameter) / 2;
		antiAliasedShapes.drawCircle(g, x, y, realDiameter);
		g.setColor(fillColor);

		int startAngle = (int) ((1 - percentComplete) * 360 + START_ANGLE);
		int arcAngle = (int) (360 * percentComplete);
		antiAliasedShapes.drawCircleArc(g, x, y, realDiameter, startAngle, arcAngle);

	}

	@Override
	protected Size getContentSize(Style style) {
		Size contentSize = new Size();
		contentSize.setSize(DIAMETER, DIAMETER);
		return contentSize;
	}
}
