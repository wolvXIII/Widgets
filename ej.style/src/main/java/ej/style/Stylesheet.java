/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style;

import java.util.List;

/**
 * Represents a style sheet.
 */
// HTML / CSS matching:
// - renderable type is class selector
// - renderable merges element & id selector
// - state is a pseudo-class
// - remains combinator and pseudo-element and attribute selector
public interface Stylesheet {

	/**
	 * Gets the style for the given object.
	 *
	 * @param object
	 *            the object to get the style for.
	 * @return the style applied to the object.
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

	/**
	 * Sets the style to apply to a type of element.
	 *
	 * @param type
	 *            the element type.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
	void setStyle(Class<?> type, Style style);

	/**
	 * Sets the style to apply to an element.
	 *
	 * @param object
	 *            the element.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
	void setStyle(Object object, Style style);

	/**
	 * Sets the style to apply to a type of element in a specific state.
	 *
	 * @param type
	 *            the element type.
	 * @param state
	 *            the state.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
	void setStyle(Class<?> type, State state, Style style);

	/**
	 * Sets the style to apply to an element in a specific state.
	 *
	 * @param object
	 *            the element.
	 * @param state
	 *            the state.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
	void setStyle(Object object, State state, Style style);

	/**
	 * Sets the style to apply to a type of element with a specific class selector.
	 *
	 * @param type
	 *            the element type.
	 * @param classSelector
	 *            the class selector.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
	void setStyle(Class<?> type, String classSelector, Style style);

	/**
	 * Sets the style to apply to an element with a specific class selector.
	 *
	 * @param object
	 *            the element.
	 * @param classSelector
	 *            the class selector.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
	void setStyle(Object object, String classSelector, Style style);

	/**
	 * Sets the style to apply to a type of element with some class selectors and states.
	 *
	 * @param type
	 *            the element type.
	 * @param classSelectors
	 *            the class selectors.
	 * @param states
	 *            the states.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
	void setStyle(Class<?> type, List<String> classSelectors, List<State> states, Style style);

	/**
	 * Sets the style to apply to an element with some class selectors and states.
	 *
	 * @param object
	 *            the element.
	 * @param classSelectors
	 *            the class selectors.
	 * @param states
	 *            the states.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
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

	/**
	 * Sets the global style for the given state.
	 *
	 * @param state
	 *            the state.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
	void setStyle(State state, Style style);

	/**
	 * Sets the global style for the given class selector.
	 *
	 * @param classSelector
	 *            the class selector.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
	void setStyle(String classSelector, Style style);

	/**
	 * Sets the global style for the given selectors (class selectors + states).
	 *
	 * @param classSelectors
	 *            the class selectors.
	 * @param states
	 *            the states.
	 * @param style
	 *            the style.
	 * @throws NullPointerException
	 *             if a parameter is <code>null</code>.
	 */
	void setStyle(List<String> classSelectors, List<State> states, Style style);

}
