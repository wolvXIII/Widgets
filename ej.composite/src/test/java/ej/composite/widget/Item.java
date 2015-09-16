/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.widget;

import ej.microui.display.GraphicsContext;
import ej.mwt.Widget;

/**
 *
 */
public class Item extends Widget {

	private final int color;
	private final int expectedWidth;
	private final int expectedHeight;

	public Item(int expectedWidth, int expectedHeight) {
		this.expectedWidth = expectedWidth;
		this.expectedHeight = expectedHeight;
		this.color = (int) (Math.random() * 0xffffff);
	}

	/**
	 * Gets the expectedWidth.
	 *
	 * @return the expectedWidth.
	 */
	public int getExpectedWidth() {
		return this.expectedWidth;
	}

	/**
	 * Gets the expectedHeight.
	 *
	 * @return the expectedHeight.
	 */
	public int getExpectedHeight() {
		return this.expectedHeight;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color.
	 */
	public int getColor() {
		return this.color;
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		setPreferredSize(this.expectedWidth, this.expectedHeight);
	}

	@Override
	public void render(GraphicsContext g) {
		int renderableWidth = getWidth();
		int renderableHeight = getHeight();
		g.setColor(getColor());
		g.fillRect(0, 0, renderableWidth, renderableHeight);
	}

}
