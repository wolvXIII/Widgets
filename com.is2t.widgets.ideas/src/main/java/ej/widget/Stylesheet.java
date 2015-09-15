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
	 * Gets the style for the given element.
	 *
	 * @param element
	 *            the element to get the style for.
	 * @return the style applied to the element.
	 */
	Style getStyle(Element element);

	void setStyle(Class<?> type, Style style);

	void setStyle(Object object, Style style);

	void setStyle(Class<?> type, State state, Style style);

	void setStyle(Object object, State state, Style style);

	void setStyle(Class<?> type, String classSelector, Style style);

	void setStyle(Object object, String classSelector, Style style);

	void setStyle(Class<?> type, List<String> classSelectors, List<State> states, Style style);

	void setStyle(Object object, List<String> classSelectors, List<State> states, Style style);

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
	void setStyle(Style style);

	void setStyle(State state, Style style);

	void setStyle(String classSelector, Style style);

	void setStyle(List<String> classSelectors, List<State> states, Style style);

}
