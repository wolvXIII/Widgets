/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import java.util.List;

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
	 *            the current state of the renderable.
	 * @return the style applied to the renderable.
	 */
	Style getStyle(Renderable renderable, List<String> classSelectors, List<State> states);

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

	void setStyle(Class<? extends Renderable> renderableType, String classSelector, Style style);

	void setStyle(Renderable renderable, String classSelector, Style style);

	void setStyle(Class<? extends Renderable> renderableType, List<String> classSelectors, List<State> states,
			Style style);

	void setStyle(Renderable renderable, List<String> classSelectors, List<State> states, Style style);

}
