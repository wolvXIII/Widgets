/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.cascading;

import java.util.List;

import ej.style.State;

class StateSelector implements Selector {
	private final State state;

	public StateSelector(State state) {
		this.state = state;
	}

	@Override
	public boolean fit(List<String> classSelectors, List<State> states) {
		return states.contains(this.state);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StateSelector) {
			StateSelector other = (StateSelector) obj;
			return this.state.equals(other.state);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.state.hashCode();
	}
}
