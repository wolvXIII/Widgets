/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.implementation;

import com.is2t.widgets.Dimension;
import com.is2t.widgets.Style;
import com.is2t.widgets.Stylesheet;
import com.is2t.widgets.background.Background;
import com.is2t.widgets.boxmodel.Boxing;
import com.is2t.widgets.font.FontLoader;
import com.is2t.widgets.font.FontProfile;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.mwt.Widget;

public class StyledWidget extends Widget {

	private String text;

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

		// draw background
		Background background = style.getBackground();
		background.draw(g, thisWidth, thisHeight);

		Dimension remainingSize = new Dimension();
		remainingSize.setSize(thisWidth, thisHeight);
		// apply margin
		Boxing margin = style.getMargin();
		margin.apply(g, remainingSize);

		// draw border
		Boxing border = style.getBorder();
		border.apply(g, remainingSize);

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
		Style style = stylesheet.getStyle(this);
		return style;
	}

}
