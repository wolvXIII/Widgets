/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.text;

import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.style.Size;

public class TextManagerFull implements TextManager {

	// TODO manage text decoration & text indent & text tranform

	// Graphics context constants.
	private int alignement;

	@Override
	public void drawText(GraphicsContext g, String text, DisplayFont font, Size size) {
		// TODO
		g.setFont(font);
		g.drawString(text, 0, 0, 0);
	}

}
