/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.outline;

import ej.microui.display.GraphicsContext;
import ej.microui.display.shape.AntiAliasedShapes;
import ej.style.util.Rectangle;

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
	public Rectangle apply(GraphicsContext g, Rectangle rectangle) {
		g.setColor(this.color);
		int width = rectangle.getWidth();
		int height = rectangle.getHeight();
		int fade = this.size < 3 ? 0 : 1;
		int evenRectangleOffset = 1 - this.size & 1;
		int thickness = this.size - fade + evenRectangleOffset;
		int halfRectangle = this.size / 2 - evenRectangleOffset;
		int leftX = halfRectangle;
		int topY = halfRectangle;
		int rightX = leftX + width - this.size - 1 + evenRectangleOffset;
		int bottomY = topY + height - this.size - 1 + evenRectangleOffset;

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
		unwrap(rectangle);
		g.clipRect(0, 0, rectangle.getWidth(), rectangle.getHeight());
		return rectangle;
	}

}
