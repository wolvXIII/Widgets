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
 * Represents an outline that wraps a rectangle.
 */
public interface Outline {

	/**
	 * Adds the outline thickness to a dimension.
	 *
	 * @param dimension
	 *            the dimension to wrap.
	 * @return the wrapped dimension.
	 */
	Size wrap(Size dimension);

	/**
	 * Removes the outline thickness to a dimension.
	 *
	 * @param dimension
	 *            the dimension to unwrap.
	 * @return the unwrapped dimension.
	 */
	Size unwrap(Size dimension);

	/**
	 * Applies the outline on a graphics context.
	 *
	 * @param g
	 *            the graphics context.
	 * @param dimension
	 *            the dimension to unwrap.
	 * @return the unwrapped dimension.
	 */
	Size apply(GraphicsContext g, Size dimension);

}
