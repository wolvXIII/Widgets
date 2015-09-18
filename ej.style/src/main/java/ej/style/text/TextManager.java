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

public interface TextManager {

	void drawText(GraphicsContext g, String text, DisplayFont font, int color, Size size);

	Size computeContentSize(String text, DisplayFont font);

}