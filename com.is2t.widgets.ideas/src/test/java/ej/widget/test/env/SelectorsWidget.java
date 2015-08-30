/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test.env;

import java.util.ArrayList;
import java.util.List;

import ej.widget.State;

public class SelectorsWidget extends SimpleWidget {

	private final List<String> classSelectors;
	private final List<State> states;

	public SelectorsWidget() {
		this.classSelectors = new ArrayList<>();
		this.states = new ArrayList<>();
	}

	public void addState(State state) {
		this.states.add(state);
	}

	public void removeState(State state) {
		this.states.remove(state);
	}

	public void addClassSelector(String classSelector) {
		this.classSelectors.add(classSelector);
	}

	public void removeClassSelector(String classSelector) {
		this.classSelectors.remove(classSelector);
	}

}
