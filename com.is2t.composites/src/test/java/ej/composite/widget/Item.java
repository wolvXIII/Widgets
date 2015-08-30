/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.widget;

import ej.mwt.Widget;
import ej.mwt.rendering.Renderer;

/**
 *
 */
public class Item extends Widget {

	private final int color;
	private final ItemRenderer labelRenderer;
	private final int expectedWidth;
	private final int expectedHeight;

	public Item(int expectedWidth, int expectedHeight) {
		this.expectedWidth = expectedWidth;
		this.expectedHeight = expectedHeight;
		this.color = (int) (Math.random() * 0xffffff);
		this.labelRenderer = new ItemRenderer();
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
	public Renderer getRenderer() {
		return this.labelRenderer;
	}

}
