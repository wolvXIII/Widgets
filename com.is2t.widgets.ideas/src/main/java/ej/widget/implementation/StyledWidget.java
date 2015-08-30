/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.implementation;

import java.util.ArrayList;
import java.util.List;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.microui.event.Event;
import ej.microui.event.controller.DispatchHelper;
import ej.microui.event.controller.PointerEventHandler;
import ej.microui.event.generators.Pointer;
import ej.mwt.Widget;
import ej.widget.Dimension;
import ej.widget.State;
import ej.widget.Style;
import ej.widget.Styled;
import ej.widget.Stylesheet;
import ej.widget.background.Background;
import ej.widget.boxmodel.Boxing;
import ej.widget.font.FontLoader;
import ej.widget.font.FontProfile;

public class StyledWidget extends Widget implements Styled {

	private final List<String> classSelectors;
	private final List<State> states;
	private String text;

	public StyledWidget() {
		this.classSelectors = new ArrayList<>(1);
		this.states = new ArrayList<>(1);
	}

	/**
	 * Gets the text.
	 *
	 * @return the text.
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text
	 *            the text to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the class selectors.
	 *
	 * @return the class selectors.
	 */
	@Override
	public List<String> getClassSelectors() {
		return this.classSelectors;
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

	@Override
	public List<State> getStates() {
		return this.states;
	}

	public boolean isInState(State state) {
		return this.states.contains(state);
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		Style style = getStyle();

		// content size…
		DisplayFont font = getFont(style);
		int contentWidth = font.stringWidth(this.text);
		int contentHeight = font.getHeight();
		Dimension dimension = style.getDimension();

		Dimension totalSize = new Dimension();
		totalSize.setSize(Math.max(dimension.getWidth(), contentWidth), Math.max(dimension.getHeight(), contentHeight));

		// … plus padding size…
		Boxing padding = style.getPadding();
		padding.applySize(totalSize);

		// … plus border size…
		Boxing border = style.getBorder();
		border.applySize(totalSize);

		// … plus margin size…
		Boxing margin = style.getMargin();
		margin.applySize(totalSize);

		// … equals the preferred size
		setPreferredSize(totalSize.getWidth(), totalSize.getHeight());
	}

	@Override
	public void render(GraphicsContext g) {
		Style style = getStyle();

		int thisWidth = this.getWidth();
		int thisHeight = this.getHeight();

		Dimension remainingSize = new Dimension();
		remainingSize.setSize(thisWidth, thisHeight);
		// apply margin
		Boxing margin = style.getMargin();
		margin.apply(g, remainingSize);

		// draw border
		Boxing border = style.getBorder();
		border.apply(g, remainingSize);

		// draw background
		Background background = style.getBackground();
		background.draw(g, remainingSize.getWidth(), remainingSize.getHeight());

		// apply padding
		Boxing padding = style.getPadding();
		padding.apply(g, remainingSize);

		// draw text
		DisplayFont font = getFont(style);
		int foregroundColor = style.getForegroundColor();
		g.setFont(font);
		g.setColor(foregroundColor);
		g.drawString(this.text, 0, 0, GraphicsContext.LEFT | GraphicsContext.TOP);
	}

	private DisplayFont getFont(Style style) {
		FontProfile fontProfile = style.getFontProfile();
		FontLoader fontLoader = ServiceLoaderFactory.getServiceLoader().getService(FontLoader.class);
		DisplayFont font = fontLoader.getFont(fontProfile);
		return font;
	}

	private Style getStyle() {
		Stylesheet stylesheet = ServiceLoaderFactory.getServiceLoader().getService(Stylesheet.class);
		Style style = stylesheet.getStyle(this, this.classSelectors, this.states);
		return style;
	}

	@Override
	public boolean handleEvent(int event) {
		if (Event.getType(event) == Event.POINTER) {
			DispatchHelper.dispatchPointer(event, new PointerEventHandler() {
				@Override
				public boolean onPointerReleased(Pointer arg0, int arg1, int arg2, int arg3) {
					removeState(State.Active);
					repaint();
					return false;
				}

				@Override
				public boolean onPointerPressed(Pointer arg0, int arg1, int arg2, int arg3) {
					addState(State.Active);
					repaint();
					return false;
				}

				@Override
				public boolean onPointerMoved(Pointer arg0, int arg1, int arg2, int arg3) {
					return false;
				}

				@Override
				public boolean onPointerExited(Pointer arg0, int arg1, int arg2, int arg3) {
					removeState(State.Active);
					removeState(State.Hover);
					repaint();
					return false;
				}

				@Override
				public boolean onPointerEntered(Pointer arg0, int arg1, int arg2, int arg3) {
					addState(State.Hover);
					return false;
				}

				@Override
				public boolean onPointerDragged(Pointer arg0, int arg1, int arg2, int arg3) {
					return false;
				}
			});
		}
		return super.handleEvent(event);
	}

}
