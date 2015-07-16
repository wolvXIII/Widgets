/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.background;

import ej.microui.display.GraphicsContext;

/**
 *
 */
public class TiledBackground extends ImageBackground {

	@Override
	public void draw(GraphicsContext g, int width, int height) {
		// TODO alignment management
		// TODO repeat management
		g.drawImage(getImage(), 0, 0, GraphicsContext.LEFT | GraphicsContext.TOP);
	}
}
