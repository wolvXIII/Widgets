/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.ideas;

import ej.microui.io.GraphicsContext;

public interface Decorator {

	void setAlignment(Alignment alignment);

	Alignment getAlignment();

	int getWidth();

	int getHeight();

	void draw(GraphicsContext g);

}
