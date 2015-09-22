/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.outline;

import ej.microui.display.GraphicsContext;
import ej.microui.display.shape.AntiAliasedShapes;
import ej.style.util.Size;

/**
 *
 */
public class BorderWithRadiusSameColor extends Border {

	private int topLeftRadius;
	private int bottomLeftRadius;
	private int bottomRightRadius;
	private int topRightRadius;


	public void setTopLeftRadius(int topLeftRadius) {
		this.topLeftRadius = topLeftRadius;
	}

	public void setBottomLeftRadius(int bottomLeftRadius) {
		this.bottomLeftRadius = bottomLeftRadius;
	}

	public void setBottomRightRadius(int bottomRightRadius) {
		this.bottomRightRadius = bottomRightRadius;
	}

	public void setTopRightRadius(int topRightRadius) {
		this.topRightRadius = topRightRadius;
	}

	@Override
	public Size apply(GraphicsContext g, Size dimension) {
		g.setColor(this.color);
		int width = dimension.getWidth();
		int height = dimension.getHeight();
		int fade = this.size < 3 ? 0 : 1;
		int evenSizeOffset = 1 - this.size & 1;
		int thickness = this.size -  fade + evenSizeOffset;
		int halfSize = this.size / 2 - evenSizeOffset;
		int leftX = halfSize;
		int topY = halfSize;
		int rightX = leftX + width - this.size - 1 + evenSizeOffset;
		int bottomY = topY + height - this.size - 1 + evenSizeOffset;

		AntiAliasedShapes antiAliasedShapes = AntiAliasedShapes.Singleton;
		antiAliasedShapes.setThickness(thickness);
		antiAliasedShapes.setFade(fade);

		int bottomLeftdiameter = this.bottomLeftRadius * 2;
		int bottomRightDiameter = this.bottomRightRadius * 2;
		int topRightDiameter = this.topRightRadius * 2;
		antiAliasedShapes.drawCircleArc(g, leftX, topY, this.topLeftRadius * 2, 90, 90);
		antiAliasedShapes.drawCircleArc(g, leftX, bottomY - bottomLeftdiameter, bottomLeftdiameter, 180, 90);
		antiAliasedShapes.drawCircleArc(g, rightX - bottomRightDiameter, bottomY - bottomRightDiameter,
				bottomRightDiameter, 270, 90);
		antiAliasedShapes.drawCircleArc(g, rightX - topRightDiameter, topY, topRightDiameter, 0, 90);

		// TODO: Avoid overlap of arc and line.
		int bottomLineY = bottomY + 1;
		int rightLineX = rightX + 1;
		antiAliasedShapes.drawLine(g, leftX + this.topLeftRadius, topY, rightX - this.topRightRadius, topY);
		antiAliasedShapes.drawLine(g, leftX + this.bottomLeftRadius, bottomLineY, rightX - this.bottomRightRadius,
				bottomLineY);
		antiAliasedShapes.drawLine(g, leftX, topY + this.topLeftRadius, leftX, bottomY - this.bottomLeftRadius);
		antiAliasedShapes.drawLine(g, rightLineX, topY + this.topRightRadius, rightLineX, bottomY
				- this.bottomRightRadius);

		g.translate(this.size, this.size);
		dimension.increment(-this.size * 2, -this.size * 2);
		g.clipRect(0, 0, dimension.getWidth(), dimension.getHeight());
		return dimension;
	}

}
