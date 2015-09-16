/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.dimension;

import ej.widget.Size;

public interface Dimension {

	void apply(Size currentSize, int widthHint, int heightHint);

}
