/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.cascading;

import java.util.List;

import ej.style.State;

class ClassSelector implements Selector {
	private final String classSelector;

	public ClassSelector(String classSelector) {
		this.classSelector = classSelector;
	}

	@Override
	public boolean fit(List<String> classSelectors, List<State> states) {
		return classSelectors.contains(this.classSelector);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ClassSelector) {
			ClassSelector other = (ClassSelector) obj;
			return this.classSelector.equals(other.classSelector);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.classSelector.hashCode();
	}
}
