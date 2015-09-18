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
import ej.microui.event.controller.EventGeneratorsHandler;
import ej.microui.event.generator.Pointer;
import ej.mwt.Widget;
import ej.style.Element;
import ej.style.State;
import ej.style.Style;
import ej.style.Stylesheet;
import ej.style.util.Size;
import ej.widget.util.Styles;

/**
 * 
 */
public abstract class StyledWidget extends Widget implements Controller, Element, EventGeneratorsHandler {

	private Controller controller;
	private final List<String> classSelectors;
	private final List<State> states;

	protected StyledWidget() {
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

	/**
	 * Sets the controller used by the button to handle the events.
	 * 
	 * @param controller
	 *            the new controller to use. Cannot be null.
	 * @throws IllegalArgumentException
	 *             if the controller is null.
	 */
	public void setController(Controller controller) {
		if (controller == null) {
			throw new IllegalArgumentException("Cannot be null"); //$NON-NLS-1$
		}
		this.controller = controller;
	}

	@Override
	public boolean handleEvent(int event) {
		return DispatchHelper.dispatchEvent(event, this);
	}

	/**
	 * Gets the style of this widget.
	 * 
	 * @return the style of this widget.
	 */
	protected Style getStyle() {
		Stylesheet stylesheet = ServiceLoaderFactory.getServiceLoader().getService(Stylesheet.class);
		return stylesheet.getStyle(this);
	}

	@Override
	public void render(GraphicsContext g) {
		Style style = getStyle();
		Size remainingSize = new Size();
		remainingSize.setSize(getWidth(), getHeight());
		Styles.renderWithoutContent(g, remainingSize, style);
		renderContent(g, style, remainingSize);
	}

	/**
	 * Renders the content of the widget without the border, margin padding specified in the style.
	 * 
	 * @param g
	 *            the GraphicsContext where to render the content of the widget.
	 * @param style
	 *            the style to use.
	 * @param remainingSize
	 *            the remaining size to render the content.
	 */
	protected abstract void renderContent(GraphicsContext g, Style style, Size remainingSize);

	@Override
	public void validate(int widthHint, int heightHint) {
		Style style = getStyle();
		Size contentSize = getContentSize(style);
		Size preferredSize = Styles.computePreferredSize(widthHint, heightHint, style, contentSize);
		setPreferredSize(preferredSize.getWidth(), preferredSize.getHeight());

		// setPreferredSize(widthHint, heightHint);
	}

	/***
	 * Gets the content size of the widget without take account the border, margin padding specified in the style.
	 * 
	 * @param style
	 *            the style to use.
	 * 
	 * @return the content size of the widget.
	 */
	protected abstract Size getContentSize(Style style);

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

	/**
	 * Gets whether or not the widget is in the given state.
	 * 
	 * @param state
	 *            the state to check.
	 * @return true if the widget is in the given state otherwise false.
	 */
	public boolean isInState(State state) {
		return this.states.contains(state);
	}

	@Override
	public boolean handleCommand(int event) {
		return onCommand(Event.getData(event));
	}

	@Override
	public boolean handlePointer(int event) {
		return DispatchHelper.dispatchPointer(event, this.controller);
	}

	@Override
	public boolean handleButton(int event) {
		return false;
	}

	@Override
	public boolean handleKeyboard(int event) {
		return false;
	}

	@Override
	public boolean handleKeypad(int event) {
		return false;
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
}
