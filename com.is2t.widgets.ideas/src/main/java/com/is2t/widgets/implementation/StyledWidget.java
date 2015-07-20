/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.implementation;

import com.is2t.widgets.Dimension;
import com.is2t.widgets.State;
import com.is2t.widgets.Style;
import com.is2t.widgets.Stylesheet;
import com.is2t.widgets.background.Background;
import com.is2t.widgets.boxmodel.Boxing;
import com.is2t.widgets.font.FontLoader;
import com.is2t.widgets.font.FontProfile;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.microui.event.Event;
import ej.microui.event.controller.DispatchHelper;
import ej.microui.event.controller.PointerEventHandler;
import ej.microui.event.generators.Pointer;
import ej.mwt.Widget;

public class StyledWidget extends Widget {

	private String text;
	private State state;

	public StyledWidget() {
		this.state = State.None;
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
		Style style = stylesheet.getStyle(this, this.state);
		return style;
	}

	@Override
	public boolean handleEvent(int event) {
		if (Event.getType(event) == Event.POINTER) {
			DispatchHelper.dispatchPointer(event, new PointerEventHandler() {
				@Override
				public boolean onPointerReleased(Pointer arg0, int arg1, int arg2, int arg3) {
					StyledWidget.this.state = State.None;
					repaint();
					return false;
				}

				@Override
				public boolean onPointerPressed(Pointer arg0, int arg1, int arg2, int arg3) {
					StyledWidget.this.state = State.Active;
					repaint();
					return false;
				}

				@Override
				public boolean onPointerMoved(Pointer arg0, int arg1, int arg2, int arg3) {
					return false;
				}

				@Override
				public boolean onPointerExited(Pointer arg0, int arg1, int arg2, int arg3) {
					StyledWidget.this.state = State.None;
					repaint();
					return false;
				}

				@Override
				public boolean onPointerEntered(Pointer arg0, int arg1, int arg2, int arg3) {
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
