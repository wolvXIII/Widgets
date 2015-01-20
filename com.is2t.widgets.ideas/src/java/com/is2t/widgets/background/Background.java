/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.background;

import com.is2t.widgets.laf.ColorProfile;

import ej.microui.io.GraphicsContext;

public interface Background {

	void draw(GraphicsContext g, ColorProfile colorProfile, int width,
			int height);

}
