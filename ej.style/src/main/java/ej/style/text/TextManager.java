/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.text;

import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.style.util.Size;

/**
 * A text manager is responsible of the rendering of text content.
 */
public interface TextManager {

	/**
	 * Draws text on a graphics context.
	 *
	 * @param g
	 *            the graphics context to draw the text on.
	 * @param text
	 *            the text to render.
	 * @param font
	 *            the font to use.
	 * @param size
	 *            the size of the text area.
	 */
	void drawText(GraphicsContext g, String text, DisplayFont font, Size size);

}
