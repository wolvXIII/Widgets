/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.test.framework.element;

import java.util.ArrayList;
import java.util.List;

import ej.style.Element;
import ej.style.State;

public class SimpleElement implements Element {

	private final List<String> classSelectors;
	private final List<State> states;
	private final Element parent;

	public SimpleElement() {
		this(null);
	}

	public SimpleElement(Element parent) {
		this.parent = parent;
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

	@Override
	public List<String> getClassSelectors() {
		return this.classSelectors;
	}

	@Override
	public List<State> getStates() {
		return this.states;
	}

	@Override
	public Object getParentElement() {
		return this.parent;
	}

}
