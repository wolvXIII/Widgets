/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import java.util.ArrayList;
import java.util.List;


import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.microui.display.GraphicsContext;
import ej.microui.event.Event;
import ej.microui.event.controller.DispatchHelper;
import ej.microui.event.generator.Pointer;
import ej.mwt.Composite;
import ej.style.Element;
import ej.style.Size;
import ej.style.State;
import ej.style.Style;
import ej.style.Stylesheet;
import ej.widget.util.Styles;

/**
 * 
 */
public abstract class StyledComposite extends Composite implements Controller, Element {

	private final Controller controller;
	private final List<String> classSelectors;
	private final List<State> states;

	public StyledComposite() {
		this.controller = this;
		this.classSelectors = new ArrayList<>();
		this.states = new ArrayList<>();
	}

	@Override
	public Object getParentElement() {
		if (getParent() != null) {
			return getParent();
		} else {
			return getPanel();
		}
	}

	@Override
	public boolean handleEvent(int event) {
		if (Event.getType(event) == Event.POINTER) {
			DispatchHelper.dispatchPointer(event, this.controller);
		}
		return super.handleEvent(event);
	}

	@Override
	public boolean onCommand(int command) {
		return false;
	}

	@Override
	public boolean onPointerDragged(Pointer pointer, int pointerX, int pointerY, int event) {
		return false;
	}

	@Override
	public boolean onPointerEntered(Pointer pointer, int pointerX, int pointerY, int event) {
		addState(State.Hover);
		return false;
	}

	@Override
	public boolean onPointerExited(Pointer pointer, int pointerX, int pointerY, int event) {
		removeState(State.Active);
		removeState(State.Hover);
		repaint();
		return false;
	}

	@Override
	public boolean onPointerMoved(Pointer pointer, int pointerX, int pointerY, int event) {
		return false;
	}

	@Override
	public boolean onPointerPressed(Pointer pointer, int pointerX, int pointerY, int event) {
		addState(State.Active);
		repaint();
		return false;
	}

	@Override
	public boolean onPointerReleased(Pointer pointer, int pointerX, int pointerY, int event) {
		removeState(State.Active);
		repaint();
		return false;
	}

	protected Style getStyle() {
		Stylesheet stylesheet = ServiceLoaderFactory.getServiceLoader().getService(Stylesheet.class);
		return stylesheet.getStyle(this);
	}

	@Override
	public List<String> getClassSelectors() {
		return this.classSelectors;
	}

	@Override
	public List<State> getStates() {
		return this.states;
	}

	/**
	 * Adds a class selector.
	 * 
	 * @param classSelector
	 *            the class selector to add.
	 */
	public void addClassSelector(String classSelector) {
		this.classSelectors.add(classSelector);
	}

	/**
	 * Removes a class selector.
	 * 
	 * @param classSelector
	 *            the class selector to remove.
	 */
	public void removeClassSelector(String classSelector) {
		this.classSelectors.remove(classSelector);
	}

	/**
	 * Adds a state.
	 * 
	 * @param state
	 *            the state to add.
	 */
	protected void addState(State state) {
		this.states.add(state);
	}

	/**
	 * Removes a state.
	 * 
	 * @param state
	 *            the state to remove.
	 */
	protected void removeState(State state) {
		this.states.remove(state);
	}

	public boolean isInState(State state) {
		return this.states.contains(state);
	}

	@Override
	public void render(GraphicsContext g) {
		Style style = getStyle();
		Size remainingSize = new Size();
		remainingSize.setSize(getWidth(), getHeight());
		Styles.renderWithoutContent(g, remainingSize, style);
		renderContent(g, style, remainingSize);
	}

	protected void renderContent(GraphicsContext g, Style style, Size remainingSize) {
		// Nothing to do by default.
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		setPreferredSize(widthHint, heightHint);
	}
}
