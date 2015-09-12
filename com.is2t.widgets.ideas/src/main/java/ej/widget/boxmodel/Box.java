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
public interface Box {

	Dimension box(Dimension dimension);

	Dimension unbox(Dimension dimension);

	Dimension apply(GraphicsContext g, Dimension dimension);

}
