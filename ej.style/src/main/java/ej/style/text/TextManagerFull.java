/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.text;

import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.style.util.Rectangle;
import ej.style.util.Size;

/**
 * Text manager implementation that manage text alignment, indentation, decoration and transform.
 */
public class TextManagerFull implements TextManager {

	// TODO manage text decoration & text indent & text tranform

	// Graphics context constants.
	private int alignment;
	private int lineHeight;


	/**
	 *
	 */
	public TextManagerFull() {
		this.lineHeight = 10;
	}

	/**
	 * Sets the horizontal alignment of the text.
	 *
	 * @param alignment
	 *            one of the value among GraphicsContext.LEFT, GraphicsContext.HCENTER or GraphicsContext.RIGHT.
	 */
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

	public void setLineHeight(int lineHeight) {
		this.lineHeight = lineHeight;
	}

	// TODO: draw ellipse if there is not enough space instead of cut text.
	// TODO: handle the justify case.
	@Override
	public void drawText(GraphicsContext g, String text, DisplayFont font, int color, Rectangle area) {
		g.setFont(font);
		g.setColor(color);
		int width = area.getWidth();
		String[] lines = Texts.splitString(text, font, width);
		// Can be computed once.
		int x = computeXTopLeftCorner(width);
		int y = 0;

		for (int i = 0; i < lines.length; i++) {
			g.drawString(lines[i], x, y, this.alignment | GraphicsContext.TOP);
			y += this.lineHeight;
		}
	}

	/**
	 * Computes the x coordinate of the left-top corner, depending of anchor value anchor can be HCENTER and other thing
	 * (or RIGHT and other thing etc). This method check too if the anchor is valid.
	 *
	 * @param x
	 *            the x coordinate
	 * @param width
	 *            the object width
	 * @param anchor
	 *            the choosen anchor
	 * @return the x coordinate to put the object in relation with the anchor, the object width and the given coordinate
	 *         x.
	 * @throws IllegalArgumentException
	 *             if the anchor is invalid
	 */
	private int computeXTopLeftCorner(int width) {
		int x = 0;
		int constraintCount = 0;
		int alignment = this.alignment;

		if ((alignment & GraphicsContext.HCENTER) == GraphicsContext.HCENTER) {
			x += (width >> 1);
			++constraintCount;
		}

		if ((alignment & GraphicsContext.RIGHT) == GraphicsContext.RIGHT) {
			x += (width - 1);
			++constraintCount;
		}
		if ((alignment & GraphicsContext.LEFT) == GraphicsContext.LEFT) {
			++constraintCount;
		}

		if (constraintCount > 1 /* 0 means LEFT */) {
			throw new IllegalArgumentException();
		}

		return x;
	}

	@Override
	public Size computeContentSize(String text, DisplayFont font) {
		Size contentSize = new Size();

		String[] lines = Texts.splitStringInLines(text);
		int lineCount = lines.length;
		int textHeight = Math.max(lineCount, 1) * this.lineHeight;

		// Finds the largest line.
		int textWidth = 0;
		for (int i = 0; i < lineCount; i++) {
			textWidth = Math.max(textWidth, font.stringWidth(lines[i]));
		}

		contentSize.setSize(textWidth, textHeight);
		return contentSize;
	}

}
