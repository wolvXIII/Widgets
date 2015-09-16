/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import java.util.ListIterator;

/**
 * 
 */
public interface SpinnerModel {

	String getValueAsString(int index);

	int getCurrentIndex();

	void setCurrentIndex(int index);

	ListIterator<String> listIterator(int index);
}
