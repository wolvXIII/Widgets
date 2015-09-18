/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.dimension;

import ej.style.util.Size;

public interface Dimension {

	void apply(Size currentSize, int widthHint, int heightHint);

}
