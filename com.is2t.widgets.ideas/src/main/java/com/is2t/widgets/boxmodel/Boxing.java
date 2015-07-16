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
public interface Boxing {

	Dimension applySize(Dimension dimension);

	Dimension apply(GraphicsContext g, Dimension dimension);

}
