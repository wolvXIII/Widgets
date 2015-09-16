/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.cascading;

import java.util.List;

import ej.widget.State;

class FullSelector implements Selector {
	private final List<String> classSelectors;
	private final List<State> states;

	public FullSelector(List<String> classSelectors, List<State> states) {
		this.classSelectors = classSelectors;
		this.states = states;
	}

	@Override
	public boolean fit(List<String> classSelectors, List<State> states) {
		// check that all the classes & states of this selector are available in the given classes & states
		for (String classSelector : this.classSelectors) {
			if (!classSelectors.contains(classSelector)) {
				return false;
			}
		}
		for (State state : this.states) {
			if (!states.contains(state)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FullSelector) {
			FullSelector other = (FullSelector) obj;
			// FIXME list comparison works?
			return this.classSelectors.equals(other.classSelectors) && this.states.equals(other.states);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.classSelectors.hashCode() + this.states.hashCode();
	}
}
