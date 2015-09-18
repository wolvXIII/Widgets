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
 * Text manager implementation that manage draws the text aligned on the top left.
 */
public class SimpleTextManager implements TextManager {

	@Override
	public void drawText(GraphicsContext g, String text, DisplayFont font, int color, Size size) {
		g.setFont(font);
		g.setColor(color);
		g.drawString(text, 0, 0, GraphicsContext.LEFT | GraphicsContext.TOP);
	}

	@Override
	public Size computeContentSize(String text, DisplayFont font) {
		// TODO Auto-generated method stub
		return null;
	}

}
