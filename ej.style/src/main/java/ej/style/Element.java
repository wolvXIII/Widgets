/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style;

import java.util.List;

/**
 * Represents an element.
 */
public interface Element {

	/**
	 * Gets the class selectors of this element.
	 *
	 * @return the class selectors
	 */
	List<String> getClassSelectors();

	/**
	 * Gets the states of this element.
	 *
	 * @return the states
	 */
	List<State> getStates();

	/**
	 * Gets the parent element.
	 *
	 * @return the parent element
	 */
	Object getParentElement();

}
