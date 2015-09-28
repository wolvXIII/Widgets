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
public class BorderNoRadiusSameColor extends Border {

	protected int topRectangle;
	protected int leftRectangle;
	protected int bottomRectangle;
	protected int rightRectangle;


	public void setTopRectangle(int topRectangle) {
		this.topRectangle = topRectangle;
	}

	public void setLeftRectangle(int leftRectangle) {
		this.leftRectangle = leftRectangle;
	}

	public void setBottomRectangle(int bottomRectangle) {
		this.bottomRectangle = bottomRectangle;
	}

	public void setRightRectangle(int rightRectangle) {
		this.rightRectangle = rightRectangle;
	}
	@Override
	public Rectangle wrap(Rectangle rectangle) {
		rectangle.update(-this.leftRectangle, -this.topRectangle, this.leftRectangle + this.rightRectangle,
				this.topRectangle + this.bottomRectangle);
		return rectangle;
	}

	@Override
	public Rectangle unwrap(Rectangle rectangle) {
		rectangle.update(this.leftRectangle, this.topRectangle, -(this.leftRectangle + this.rightRectangle),
				-(this.topRectangle + this.bottomRectangle));
		return rectangle;
	}

	@Override
	public Rectangle apply(GraphicsContext g, Rectangle rectangle) {
		g.setColor(this.color);
		int width = rectangle.getWidth();
		int height = rectangle.getHeight();

		g.fillRect(0, 0, width, this.topRectangle);
		g.fillRect(0, 0, this.leftRectangle, height);
		g.fillRect(0, height - this.bottomRectangle, width, this.bottomRectangle);
		g.fillRect(width - this.rightRectangle, 0, this.rightRectangle, height);

		g.translate(this.leftRectangle, this.topRectangle);
		unwrap(rectangle);
		g.clipRect(0, 0, rectangle.getWidth(), rectangle.getHeight());
		return rectangle;
	}

}
