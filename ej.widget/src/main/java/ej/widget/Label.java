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
import ej.style.text.TextManager;
import ej.style.util.Rectangle;
import ej.style.util.Size;
import ej.widget.util.Styles;

/**
 * A Widget used to display text. It allows to manage several lines depending of the chosen {@link TextManager}. A label
 * does not react to the events.
 */
public class Label extends StyledWidget {

	private String text;

	/**
	 * Creates a Label with an empty text.
	 */
	public Label() {
		this(""); //$NON-NLS-1$
	}

	/**
	 * Creates a Label with the given text.
	 *
	 * @param text
	 *            the text to display, it cannot be null.
	 * @throws IllegalArgumentException
	 *             if the text is null.
	 */
	public Label(String text) {
		super();
		setTextNoRepaint(text);
	}

	/**
	 * Sets the text to display.
	 *
	 * @param text
	 *            the text to display, it cannot be null.
	 * @throws IllegalArgumentException
	 *             if the text is null.
	 */
	public void setText(String text) {
		setTextNoRepaint(text);
		repaint();
	}

	private void setTextNoRepaint(String text) {
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
	protected void renderContent(GraphicsContext g, Style style, Rectangle remainingSize) {
		DisplayFont font = Styles.getFont(style);
		style.getTextManager().drawText(g, this.text, font, style.getForegroundColor(), remainingSize);
	}

	@Override
	protected Size getContentSize(Style style) {
		DisplayFont font = Styles.getFont(style);
		return style.getTextManager().computeContentSize(this.text, font);
	}
}
