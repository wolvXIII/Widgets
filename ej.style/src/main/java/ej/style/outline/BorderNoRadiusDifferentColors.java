/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.outline;

import ej.microui.display.GraphicsContext;
import ej.style.util.Size;

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
	public Size apply(GraphicsContext g, Size dimension) {
		int width = dimension.getWidth();
		int height = dimension.getHeight();
		int topSize = this.topSize;
		int leftSize = this.leftSize;
		int bottomSize = this.bottomSize;
		int rightSize = this.rightSize;

		int topRectX = leftSize;
		int topRectY = 0;
		int horizontalRectWidth = width - leftSize - rightSize;
		int leftRectX = 0;
		int leftRectY = topSize;
		int verticalRectHeight = height - topSize - bottomSize;
		int bottomRectY = height - bottomSize;
		int rightRectX = width - rightSize;

		g.setColor(this.topColor);
		g.fillRect(topRectX, topRectY, horizontalRectWidth, topSize);
		g.fillPolygon(new int[] { rightRectX, topRectY, width - 2, topRectY, rightRectX, leftRectY - 1 });
		g.fillPolygon(new int[] { leftRectX, topRectY, topRectX - 1, topRectY, topRectX - 1, leftRectY - 1 });

		g.setColor(this.leftColor);
		g.fillRect(leftRectX, leftRectY, leftSize, verticalRectHeight);
		g.fillPolygon(new int[] { leftRectX, topRectY + 1, topRectX - 2, leftRectY - 1, leftRectX, leftRectY - 1 });
		g.fillPolygon(new int[] { leftRectX, bottomRectY, topRectX - 1, bottomRectY, leftRectX, height - 1 });

		g.setColor(this.bottomColor);
		g.fillRect(topRectX, bottomRectY, horizontalRectWidth, bottomSize);
		g.fillPolygon(new int[] { leftRectX + 1, height - 1, topRectX - 1, bottomRectY + 1, topRectX - 1, height - 1 });
		g.fillPolygon(new int[] { rightRectX, bottomRectY, width - 1, height - 1, rightRectX,
				height - 1 });

		g.setColor(this.rightColor);
		g.fillRect(rightRectX, leftRectY, rightSize, verticalRectHeight);
		g.fillPolygon(new int[] { rightRectX + 1, bottomRectY, width - 1, bottomRectY,
				width - 1, height - 2 });
		g.fillPolygon(new int[] { rightRectX, leftRectY - 1, width - 1, topRectY, width - 1, leftRectY - 1 });

		g.translate(leftSize, topSize);
		dimension.decrement(leftSize + rightSize, topSize + bottomSize);
		g.clipRect(0, 0, dimension.getWidth(), dimension.getHeight());
		return dimension;
	}

}
