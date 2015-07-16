/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.boxmodel;

import com.is2t.widgets.Dimension;

import ej.microui.display.GraphicsContext;

/**
 *
 */
public class NoBoxing implements Boxing {

	/**
	 * Singleton to use to avoid creating several instances.
	 */
	// assume that no boxing is stateless
	public static final NoBoxing NO_BOXING = new NoBoxing();

	@Override
	public Dimension applySize(Dimension dimension) {
		return dimension;
	}

	@Override
	public Dimension apply(GraphicsContext g, Dimension dimension) {
		return dimension;
	}

}
