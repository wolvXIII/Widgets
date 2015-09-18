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
 * A outline that is empty.
 */
public class EmptyOutline implements Outline {

	/**
	 * Empty outline singleton.
	 */
	// assume that it is stateless
	public static final EmptyOutline EMPTY_OUTLINE = new EmptyOutline();

	private EmptyOutline() {
	}

	@Override
	public Size wrap(Size dimension) {
		return dimension;
	}

	@Override
	public Size unwrap(Size dimension) {
		return dimension;
	}

	@Override
	public Size apply(GraphicsContext g, Size dimension) {
		return dimension;
	}

}
