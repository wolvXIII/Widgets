/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import java.util.List;

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
	Style getStyle(Object object);

	/**
	 * Gets the style for the given renderable in the given state.
	 *
	 * @param renderable
	 *            the renderable to get the style.
	 * @param state
	 *            the current state of the renderable.
	 * @return the style applied to the renderable.
	 */
	Style getStyle(Object object, List<String> classSelectors, List<State> states);

	// /**
	// * Sets the default style.
	// * <p>
	// * It will be used as the root style of the cascading resolution.
	// * <p>
	// * The given style must be complete, i.e. all its attributes must be set.
	// *
	// * @param style
	// * the style.
	// * @throws NullPointerException
	// * if the given style is <code>null</code>.
	// * @throws IllegalArgumentException
	// * if the given style is incomplete.
	// */
	// void setDefaultStyle(Style style);

	void setStyle(Class<?> renderableType, Style style);

	void setStyle(Object object, Style style);

	void setStyle(Class<?> renderableType, State state, Style style);

	void setStyle(Object object, State state, Style style);

	void setStyle(Class<?> renderableType, String classSelector, Style style);

	void setStyle(Object object, String classSelector, Style style);

	void setStyle(Class<?> renderableType, List<String> classSelectors, List<State> states, Style style);

	void setStyle(Object object, List<String> classSelectors, List<State> states, Style style);

	void setStyle(Style style);

	void setStyle(State state, Style style);

	void setStyle(String classSelector, Style style);

	void setStyle(List<String> classSelectors, List<State> states, Style style);

}
