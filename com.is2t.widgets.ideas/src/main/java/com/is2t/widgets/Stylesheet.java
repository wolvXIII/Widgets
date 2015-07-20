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
// HTML / CSS matching:
// - renderable type is class selector
// - renderable merges element & id selector
// - state is a pseudo-class
// - remains combinator and pseudo-element and attribute selector
public interface Stylesheet {

	/**
	 * Gets the style for the given renderable.
	 *
	 * @param renderable
	 *            the renderable to get the style.
	 * @return the style applied to the renderable.
	 */
	Style getStyle(Renderable renderable);

	/**
	 * Gets the style for the given renderable in the given state.
	 *
	 * @param renderable
	 *            the renderable to get the style.
	 * @param state
	 *            the state of the renderable.
	 * @return the style applied to the renderable.
	 */
	Style getStyle(Renderable renderable, State state);

	/**
	 * Sets the default style.
	 * <p>
	 * It will be used as the root style of the cascading resolution.
	 * <p>
	 * The given style must be complete, i.e. all its attributes must be set.
	 *
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if the given style is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if the given style is incomplete.
	 */
	void setDefaultStyle(Style style);

	void setStyle(Class<? extends Renderable> renderableType, Style style);

	void setStyle(Renderable renderable, Style style);

	void setStyle(Class<? extends Renderable> renderableType, State state, Style style);

	void setStyle(Renderable renderable, State state, Style style);

}
