/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.dimension;

import ej.style.util.Size;

/**
 * Represents a dimension constraint for an element.
 */
public interface Dimension {

	/**
	 * Applies the dimension to the given size.
	 *
	 * @param currentSize
	 *            the size of the content.
	 * @param widthHint
	 *            the width hint.
	 * @param heightHint
	 *            the height hint.
	 */
	void apply(Size currentSize, int widthHint, int heightHint);

}
