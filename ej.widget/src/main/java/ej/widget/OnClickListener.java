/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

/**
 * Defines an object which listens for click event.
 */
public interface OnClickListener {

	/**
	 * Invoked when the target of the listener has been clicked.
	 * 
	 * @param source
	 *            the target of the listener.
	 */
	void onClick(Object source);
}
