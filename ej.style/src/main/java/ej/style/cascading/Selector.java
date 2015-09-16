/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.cascading;

import java.util.List;

import ej.style.State;

interface Selector {
	boolean fit(List<String> classSelectors, List<State> states);
}
