/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets;

import ej.mwt.Renderable;

/**
 *
 */
public interface Stylesheet {

	Style getStyle(Renderable renderable);

	void setStyle(Class<Renderable> renderableType, Style style);

	void setStyle(Renderable renderable, Style style);

	void addRule(Class<Renderable> renderableType, Object xxx);

	void addRule(Renderable renderable, Object xxx);

}
