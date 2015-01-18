/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.ideas;

import ej.microui.io.DisplayFont;
import ej.microui.io.GraphicsContext;

public class PictoDecorator extends AbstractDecorator implements Decorator {

	private final char picto;
	private final DisplayFont font;

	public PictoDecorator(char picto, DisplayFont font) {
		this.picto = picto;
		this.font = font;
	}

	@Override
	public int getWidth() {
		return this.font.charWidth(this.picto);
	}

	@Override
	public int getHeight() {
		return this.font.getHeight();
	}

	@Override
	public void draw(GraphicsContext g) {
		g.setFont(this.font);
		g.drawChar(this.picto, 0, 0, GraphicsContext.LEFT | GraphicsContext.TOP);
	}

}
