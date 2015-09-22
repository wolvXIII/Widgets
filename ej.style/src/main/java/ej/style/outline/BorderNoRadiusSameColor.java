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
public class BorderNoRadiusSameColor extends Border {

	protected int topSize;
	protected int leftSize;
	protected int bottomSize;
	protected int rightSize;


	public void setTopSize(int topSize) {
		this.topSize = topSize;
	}

	public void setLeftSize(int leftSize) {
		this.leftSize = leftSize;
	}

	public void setBottomSize(int bottomSize) {
		this.bottomSize = bottomSize;
	}

	public void setRightSize(int rightSize) {
		this.rightSize = rightSize;
	}
	@Override
	public Size wrap(Size dimension) {
		dimension.increment(this.leftSize + this.rightSize, this.topSize + this.bottomSize);
		return dimension;
	}

	@Override
	public Size unwrap(Size dimension) {
		dimension.decrement(this.leftSize + this.rightSize, this.topSize + this.bottomSize);
		return dimension;
	}

	@Override
	public Size apply(GraphicsContext g, Size dimension) {
		g.setColor(this.color);
		int width = dimension.getWidth();
		int height = dimension.getHeight();

		g.fillRect(0, 0, width, this.topSize);
		g.fillRect(0, 0, this.leftSize, height);
		g.fillRect(0, height - this.bottomSize, width, this.bottomSize);
		g.fillRect(width - this.rightSize, 0, this.rightSize, height);

		g.translate(this.leftSize, this.topSize);
		dimension.decrement(this.leftSize + this.rightSize, this.topSize + this.bottomSize);
		g.clipRect(0, 0, dimension.getWidth(), dimension.getHeight());
		return dimension;
	}

}
