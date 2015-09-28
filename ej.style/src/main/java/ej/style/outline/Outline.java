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
 * Represents an outline that wraps a rectangle.
 */
public interface Outline {

	/**
	 * Adds the outline thickness to a rectangle.
	 *
	 * @param rectangle
	 *            the rectangle to wrap.
	 * @return the wrapped rectangle.
	 */
	Rectangle wrap(Rectangle rectangle);

	/**
	 * Removes the outline thickness to a rectangle.
	 *
	 * @param rectangle
	 *            the rectangle to unwrap.
	 * @return the unwrapped rectangle.
	 */
	Rectangle unwrap(Rectangle rectangle);

	/**
	 * Applies the outline on a graphics context.
	 *
	 * @param g
	 *            the graphics context.
	 * @param rectangle
	 *            the rectangle to unwrap.
	 * @return the unwrapped rectangle.
	 */
	Rectangle apply(GraphicsContext g, Rectangle rectangle);

}
