/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.boxmodel;

import ej.microui.display.GraphicsContext;
import ej.style.util.Size;

/**
 *
 */
public interface Box {

	Size box(Size dimension);

	Size unbox(Size dimension);

	Size apply(GraphicsContext g, Size dimension);

}
