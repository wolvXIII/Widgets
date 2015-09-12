/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.boxmodel;

import ej.microui.display.GraphicsContext;
import ej.widget.Dimension;

/**
 *
 */
public class NoBox implements Box {

	/**
	 * Singleton to use to avoid creating several instances.
	 */
	// assume that no boxing is stateless
	public static final NoBox NO_BOXING = new NoBox();

	@Override
	public Dimension box(Dimension dimension) {
		return dimension;
	}

	@Override
	public Dimension unbox(Dimension dimension) {
		return dimension;
	}

	@Override
	public Dimension apply(GraphicsContext g, Dimension dimension) {
		return dimension;
	}

}
