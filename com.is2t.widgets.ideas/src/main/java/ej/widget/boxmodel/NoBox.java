/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.boxmodel;

import ej.microui.display.GraphicsContext;
import ej.widget.Size;

public class NoBox implements Box {

	/**
	 * NoBox singleton.
	 */
	// assume that it is stateless
	public static final NoBox NO_BOXING = new NoBox();

	private NoBox() {
	}

	@Override
	public Size box(Size dimension) {
		return dimension;
	}

	@Override
	public Size unbox(Size dimension) {
		return dimension;
	}

	@Override
	public Size apply(GraphicsContext g, Size dimension) {
		return dimension;
	}

}
