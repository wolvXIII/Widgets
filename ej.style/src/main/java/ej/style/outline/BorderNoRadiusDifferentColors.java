/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.outline;

import ej.microui.display.GraphicsContext;
import ej.style.util.Rectangle;

/**
 *
 */
public class BorderNoRadiusDifferentColors extends BorderNoRadiusSameColor {

	private int topColor;
	private int leftColor;
	private int bottomColor;
	private int rightColor;

	public void setTopColor(int topColor) {
		this.topColor = topColor;
	}

	public void setLeftColor(int leftColor) {
		this.leftColor = leftColor;
	}

	public void setBottomColor(int bottomColor) {
		this.bottomColor = bottomColor;
	}

	public void setRightColor(int rightColor) {
		this.rightColor = rightColor;
	}

	@Override
	public Rectangle apply(GraphicsContext g, Rectangle rectangle) {
		int width = rectangle.getWidth();
		int height = rectangle.getHeight();
		int topRectangle = this.topRectangle;
		int leftRectangle = this.leftRectangle;
		int bottomRectangle = this.bottomRectangle;
		int rightRectangle = this.rightRectangle;

		int topRectX = leftRectangle;
		int topRectY = 0;
		int horizontalRectWidth = width - leftRectangle - rightRectangle;
		int leftRectX = 0;
		int leftRectY = topRectangle;
		int verticalRectHeight = height - topRectangle - bottomRectangle;
		int bottomRectY = height - bottomRectangle;
		int rightRectX = width - rightRectangle;

		g.setColor(this.topColor);
		g.fillRect(topRectX, topRectY, horizontalRectWidth, topRectangle);
		g.fillPolygon(new int[] { rightRectX, topRectY, width - 2, topRectY, rightRectX, leftRectY - 1 });
		g.fillPolygon(new int[] { leftRectX, topRectY, topRectX - 1, topRectY, topRectX - 1, leftRectY - 1 });

		g.setColor(this.leftColor);
		g.fillRect(leftRectX, leftRectY, leftRectangle, verticalRectHeight);
		g.fillPolygon(new int[] { leftRectX, topRectY + 1, topRectX - 2, leftRectY - 1, leftRectX, leftRectY - 1 });
		g.fillPolygon(new int[] { leftRectX, bottomRectY, topRectX - 1, bottomRectY, leftRectX, height - 1 });

		g.setColor(this.bottomColor);
		g.fillRect(topRectX, bottomRectY, horizontalRectWidth, bottomRectangle);
		g.fillPolygon(new int[] { leftRectX + 1, height - 1, topRectX - 1, bottomRectY + 1, topRectX - 1, height - 1 });
		g.fillPolygon(new int[] { rightRectX, bottomRectY, width - 1, height - 1, rightRectX,
				height - 1 });

		g.setColor(this.rightColor);
		g.fillRect(rightRectX, leftRectY, rightRectangle, verticalRectHeight);
		g.fillPolygon(new int[] { rightRectX + 1, bottomRectY, width - 1, bottomRectY,
				width - 1, height - 2 });
		g.fillPolygon(new int[] { rightRectX, leftRectY - 1, width - 1, topRectY, width - 1, leftRectY - 1 });

		g.translate(leftRectangle, topRectangle);
		unwrap(rectangle);
		g.clipRect(0, 0, rectangle.getWidth(), rectangle.getHeight());
		return rectangle;
	}

}
