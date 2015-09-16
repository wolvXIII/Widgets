/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

/**
 * Defines an object which listens for change event.
 */
public interface OnStateChangeListener {

	/**
	 * Invoked when the target of the listener has changed its state.
	 * 
	 * @param source
	 *            the target of the listener.
	 */
	void onStateChange(Object source, boolean before, boolean after);
}
