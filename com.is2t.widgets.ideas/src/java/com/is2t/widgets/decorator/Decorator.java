/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.decorator;

import com.is2t.widgets.laf.ColorProfile;

import ej.microui.io.GraphicsContext;

public interface Decorator {

	void setAlignment(int alignment);

	int getAlignment();

	int getWidth();

	int getHeight();

	void draw(GraphicsContext g, ColorProfile colorProfile);

}
