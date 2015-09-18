/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.style.Style;
import ej.style.util.Size;
import ej.widget.util.Styles;

/**
 * 
 */
public class Label extends StyledWidget {

	private String text;

	public Label() {
		super();
		this.text = "";
	}

	public Label(String text) {
		super();
		setText(text);
	}

	/**
	 * Sets the text to display.
	 * 
	 * @param text
	 *            the text to set.
	 */
	public void setText(String text) {
		if (text == null) {
			throw new IllegalArgumentException();
		}
		this.text = text;
	}

	/**
	 * Gets the displayed text.
	 * 
	 * @return the text.
	 */
	public String getText() {
		return this.text;
	}

	@Override
	protected void renderContent(GraphicsContext g, Style style, Size remainingSize) {
		DisplayFont font = Styles.getFont(style);
		style.getTextManager().drawText(g, this.text, font, style.getForegroundColor(), remainingSize);
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		super.validate(widthHint, heightHint);
	}

	@Override
	public void render(GraphicsContext g) {
		super.render(g);
	}

	@Override
	protected Size getContentSize(Style style) {
		DisplayFont font = Styles.getFont(style);
		return style.getTextManager().computeContentSize(this.text, font);
	}
}
