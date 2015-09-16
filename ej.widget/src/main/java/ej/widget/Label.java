/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;


import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.mwt.MWT;
import ej.style.Size;
import ej.style.Style;
import ej.widget.util.Styles;
import ej.widget.util.Texts;

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

	// TODO: draw ellipse if there is not enough space instead of cut text.
	// TODO: handle the justify case.
	@Override
	protected void renderContent(GraphicsContext g, Style style, Size remainingSize) {
		int remainingWidth = remainingSize.getWidth();
		DisplayFont font = Styles.getFont(style);
		int foregroundColor = style.getForegroundColor();
		g.setFont(font);
		g.setColor(foregroundColor);
		String[] lines = Texts.splitString(this.text, font, remainingWidth);
		int lineHeight = getLineHeight();
		int x;
		int y = 0;
		int horizontalAnchor;

		switch (style.getTextAlign()) {
		case MWT.LEFT:
			x = 0;
			horizontalAnchor = GraphicsContext.LEFT;
			break;

		case MWT.CENTER:
			x = remainingWidth / 2;
			horizontalAnchor = GraphicsContext.HCENTER;
			break;

		case MWT.RIGHT:
			x = remainingWidth;
			horizontalAnchor = GraphicsContext.RIGHT;
			break;

		default:
			x = remainingWidth;
			horizontalAnchor = GraphicsContext.RIGHT;
		}

		for (int i = 0; i < lines.length; i++) {
			g.drawString(lines[i], x, y, horizontalAnchor | GraphicsContext.TOP);
			y += lineHeight;
		}
	}

	@Override
	protected Size getContentSize(Style style) {
		Size textSize = new Size();
		DisplayFont font = Styles.getFont(style);
		int lineHeight = getLineHeight();

		String[] lines = Texts.splitStringInLines(this.text);
		int lineCount = lines.length;
		int textHeight = Math.max(lineCount, 1) * lineHeight;

		// Finds the largest line.
		int textWidth = 0;
		for (int i = 0; i < lineCount; i++) {
			textWidth = Math.max(textWidth, font.stringWidth(lines[i]));
		}
		textSize.setSize(textWidth, textHeight);

		return textSize;
	}

	private int getLineHeight() {
		return 10;
	}

}
